package org.openhab.designerx.model.internal.sitemap.node;

import java.util.Collection;
import java.util.List;

import org.openhab.designerx.model.Atom;
import org.openhab.designerx.model.ModelConstants;
import org.openhab.designerx.model.Node;
import org.openhab.designerx.model.Properties;
import org.openhab.designerx.model.Property;
import org.openhab.designerx.model.internal.sitemap.node.atom.AtomSitemap;
import org.openhab.designerx.model.internal.util.Util;

import com.google.common.collect.Lists;

public class NodeImpl implements Node {
	
	private static final String SPACE = ModelConstants.SPACE_MARK;
	private static final String LINE_SEPARATOR = ModelConstants.LINE_SEPARATOR;
	private static final String TAB = AtomSitemap.DEFAULT_INDENTATION;

	private Atom atom;

	private List<Node> children = Lists.newArrayList();
	
	public static NodeImpl parse(List<String> list) {
		//
		List<String> lines = Lists.newArrayList();
		lines.addAll(list);
		//
		format(lines);
		checkAfterFormat(lines);
		NodeImpl node = new NodeImpl();
		parseNode(node, lines, 0);
		return node;
	}
	
	@Override
	public String getType() {
		return atom.getType();
	}

	@Override
	public Properties getProperties() {
		return atom.getProperties();
	}

	@Override
	public boolean addProperty(Property property) {
		return atom.addProperty(property);
	}

	@Override
	public List<Node> getChildren() {
		return children;
	}

	@Override
	public boolean addChild(Node child) {
		return children.add(child);
	}

	@Override
	public boolean addProperties(Collection<? extends Property> properties) {
		return atom.addProperties(properties);
	}

	@Override
	public boolean addChildren(Collection<? extends Node> children) {
		return this.children.addAll(children);
	}

	@Override
	public String toXtext(String indentation) {
		StringBuilder sb = new StringBuilder();
		sb.append(indentation);
		sb.append(atom.toXtext());
		// children
		if (!children.isEmpty()) {
			sb.append(SPACE);
			sb.append("{");
			sb.append(LINE_SEPARATOR);
			for (Node child : children) {
				sb.append(child.toXtext(indentation + TAB));
				sb.append(LINE_SEPARATOR);
			}
			sb.append(indentation);
			sb.append("}");
		}
		return sb.toString();
	}

	@Override
	public String toXtext() {
		return toXtext("");
	}
	
	public Atom getAtom() {
		return atom;
	}

	public void setAtom(Atom atom) {
		this.atom = atom;
	}
	
	private static void checkBraces(List<String> lines) {
		// check if '{'s and '}'s have the same count
		int count = 0;
		for (String line : lines) {
			count += Util.count(line, "{");
			count -= Util.count(line, "}");
		}
		if (count != 0) {
			throw new RuntimeException("the number of '{'s is not equal to '}'s");
		}
	}
	
	private static void checkBeforeFormat(List<String> lines) {
		final int size = lines.size();
		if (lines.get(size - 1).trim().startsWith("{")) {
			throw new RuntimeException("should NOT start with a '{' in the first line: '" + lines.get(0).trim() + "'");
		}
		checkBraces(lines);
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (line.isEmpty()) {
				continue;
			}
			final int openBraceCount = Util.count(line, "{");
			if (openBraceCount > 1) {
				throw new RuntimeException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = Util.count(line, "}");
			if (closeBraceCount > 1) {
				throw new RuntimeException("more than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(1, line.length() - 1).trim();
				if (sub.isEmpty()) {
					throw new RuntimeException("no content found in '" + line + "'");
				}
			}
		}
	}
	
	private static void checkAfterFormat(List<String> formatted) {
		checkBraces(formatted);
		final int size = formatted.size();
		// check the formatted lines
		for (int i = 0; i < size; ++i) {
			String line = formatted.get(i).trim();
			if (line.isEmpty()) {
				throw new RuntimeException("an empty line has bee found");
			}
			final int openBraceCount = Util.count(line, "{");
			if (openBraceCount > 1) {
				throw new RuntimeException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = Util.count(line, "}");
			if (closeBraceCount > 1) {
				throw new RuntimeException("more than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				throw new RuntimeException("'{' and '}' should not be in the same line in '" + line + "'");
			}
			if (line.startsWith("{") && !line.endsWith("}")) {
				String sub = line.substring(1, line.length()).trim();
				if (sub.isEmpty()) {
					throw new RuntimeException("no content found in '" + line + "'");
				}
			}
			if (!line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(0, line.length() - 1).trim();
				if (!sub.isEmpty()) {
					throw new RuntimeException("content found before '}' in '" + line + "'");
				}
			}
		}
	}
	
	public static void format(List<String> lines) {
		Util.trim(lines);
		checkBeforeFormat(lines);
		List<String> formatted = Lists.newArrayList();
		final int size = lines.size();
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (line.isEmpty()) {
				continue;
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(1, line.length() - 1).trim();
				String last = formatted.get(formatted.size() - 1);
				if (!last.endsWith("{")) {
					formatted.set(formatted.size() - 1, last + " {");
				}
				formatted.add(sub);
				formatted.add("}");
				continue;
			}
			if (line.startsWith("{") && !line.endsWith("}")) {
				String sub = line.substring(1, line.length()).trim();
				String last = formatted.get(formatted.size() - 1);
				if (!last.endsWith("{")) {
					formatted.set(formatted.size() - 1, last + " {");
				}
				if (!sub.isEmpty()) {
					formatted.add(sub);
				}
				continue;
			}
			if (!line.startsWith("{")  && line.endsWith("}")) {
				String sub = line.substring(0, line.length() - 1).trim();
				if (!sub.isEmpty()) {
					formatted.add(sub);
				}
				formatted.add("}");
				continue;
			}
			if (!line.startsWith("{")  && !line.endsWith("}")) {
				formatted.add(line);
				continue;
			}
		}
		lines.clear();
		lines.addAll(formatted);
	}
	
	public static int parseNode(NodeImpl root, List<String> lines, final int start) {
		int i = start;
		String line = lines.get(start);
		// parse its atom
		Atom atom = AtomBuilder.build(line);
		root.setAtom(atom);
		if (!line.endsWith("{")) {
			return i;
		}
		// parse its children nodes
		i += 1;
		int nodeEndLine = -1;
		final int size = lines.size();
		while (i >= 0 && i >= start && i < size) {
			line = lines.get(i);
			if (line.endsWith("}")) {
				nodeEndLine = i;
				break;
			} else {
				NodeImpl child = new NodeImpl();
				i = parseNode(child, lines, i);
				root.addChild(child);
				i += 1;
			}
		}
		return nodeEndLine;
	}
	
}

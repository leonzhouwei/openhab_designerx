package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

final class ChildfulElementXtdex {
	private static final String DEFAULT_INDENTATION = "    ";
	
	static boolean isChildfulElement(ChildfulElementXtextKeeper keeper) {
		boolean result = false;
		if (FrameXtdex.isFrame(keeper)) {
			result = true;
		} else if (GroupXtdex.isGroup(keeper)) {
			result = true;
		} else if (ImageXtdex.isImage(keeper)) {
			result = true;
		} else if (TextXtdex.isText(keeper)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static Element parse(ChildfulElementXtextKeeper keeper) throws ModelXtdexException {
		Element result = null;
		if (isChildfulElement(keeper)) {
			ImmutableList<String> xtext = keeper.getXtext();
			result = parse(xtext);
		}
		return result;
	}
	
	private static Element parse(ImmutableList<String> xtext) throws ModelXtdexException {
		String line = xtext.get(0).trim();
		Element root = parseIgnoringChildren(new ChildfulElementXtextKeeper(new ChildlessElementXtextKeeper(line).getXtext()));
		if (root == null) {
			return null;
		}
		int i = 1;
		final int size = xtext.size();
		while (i > 0 && i < size - 1) {
			String s = xtext.get(i);
			ChildlessElementXtextKeeper childlessKeeper = new ChildlessElementXtextKeeper(s);
			if (ChildlessElementXtdex.isChildlessElement(childlessKeeper)) {
				Element child = ChildlessElementXtdex.parse(childlessKeeper);
				root.addChild(child);
				i += 1;
				continue;
			}
			if (s.endsWith("{")) {
				final int end = endIndexOf(xtext, i);
				ImmutableList<String> list = xtext.subList(i, end + 1);
				Element child = parse(list);
				root.addChild(child);
				i = end + 1;
				continue;
			}
			ChildfulElementXtextKeeper childfulKeeper = new ChildfulElementXtextKeeper(childlessKeeper.getXtext());
			if (isChildfulElement(childfulKeeper)) {
				// it is an element that can have children but do not have
				Element child = parseIgnoringChildren(childfulKeeper);
				root.addChild(child);
				i += 1;
				continue;
			}
			break;
		}
		return root;
	}
	
	static <T extends Element> boolean isChildfulElement(T e) {
		boolean result = false;
		if (FrameXtdex.isFrame(e)) {
			result = true;
		} else if (GroupXtdex.isGroup(e)) {
			result = true;
		} else if (ImageXtdex.isImage(e)) {
			result = true;
		} else if (TextXtdex.isText(e)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static String toXtext(Element e, String indentation) {
		StringBuilder sb = new StringBuilder();
		if (e instanceof Frame) {
			sb.append(indentation + FrameXtdex.toXtextIgnoringChildren((Frame) e));
		} else if (e instanceof Group) {
			sb.append(indentation + GroupXtdex.toXtextIgnoringChildren((Group) e));
		} else if (e instanceof Image) {
			sb.append(indentation + ImageXtdex.toXtextIgnoringChildren((Image) e));
		} else if (e instanceof Text) {
			sb.append(indentation + TextXtdex.toXtextIgnoringChildren((Text) e));
		} else if (e.canHaveChildren()) {
			sb.append(indentation + ElementXtextualizer.toXtextIgnoringChildren(e));
		} else {
			return null;
		}
		if (!e.getChildren().isEmpty()) {
			sb.append(" {");
			sb.append(ModelXtdexConstants.LINE_SEPARATOR);
			List<Element> children = e.getChildren();
			for (Element v : children) {
				if (ChildlessElementXtdex.isChildlessElement(v)) {
					String s = ChildlessElementXtdex.toXtext(v);
					sb.append(indentation + DEFAULT_INDENTATION + s);
					sb.append(ModelXtdexConstants.LINE_SEPARATOR);
				} else if (ChildfulElementXtdex.isChildfulElement(v)) {
					String s = toXtext(v, indentation + DEFAULT_INDENTATION);
					sb.append(s);
					sb.append(ModelXtdexConstants.LINE_SEPARATOR);
				} else {
					// no operations
				}
			}
			sb.append(indentation + "}");
		}
		return sb.toString();
	}
	
	static Element parseIgnoringChildren(ChildfulElementXtextKeeper keeper) throws ModelXtdexException {
		Element result = null;
		ChildlessElementXtextKeeper childlessKeeper = new ChildlessElementXtextKeeper(keeper.getXtext().get(0));
		if (FrameXtdex.isFrame(keeper)) {
			result = FrameXtdex.parseIgnoringChildren(childlessKeeper);
		} else if (GroupXtdex.isGroup(keeper)) {
			result = GroupXtdex.parseIgnoringChildren(childlessKeeper);
		} else if (ImageXtdex.isImage(keeper)) {
			result = ImageXtdex.parseIgnoringChildren(childlessKeeper);
		} else if (TextXtdex.isText(keeper)) {
			result = TextXtdex.parseIgnoringChildren(childlessKeeper);
		} else {
			result = null;
		}
		return result;
	}
	
	static int endIndexOf(ImmutableList<String> list, final int start) {
		if (!list.get(start).trim().endsWith("{")) {
			return start;
		}
		int end = -1;
		int unpairedOpenBraceCount = 1;
		final int size = list.size();
		for (int i = start + 1; i < size && unpairedOpenBraceCount != 0; ++i) {
			String s = list.get(i).trim();
			if (s.compareTo("}") == 0) {
				end = i;
				unpairedOpenBraceCount -= 1;
			}
			if (s.endsWith("{")) {
				unpairedOpenBraceCount += 1;
			}
		}
		return end;
	}
	
	private ChildfulElementXtdex() {}

}

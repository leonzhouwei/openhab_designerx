package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.internal.util.Util;
import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public final class NestableElementXtextKeeper {
	
	private ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
	
	public NestableElementXtextKeeper(List<String> list) throws ModelXtextException {
		List<String> lines = Lists.newArrayList();
		lines.addAll(list);
		checkBraces(lines);
		checkBeforeFormat(lines);
		format(lines);
		checkAfterFormat(lines);
		builder.addAll(lines);
	}
	
	public ImmutableList<String> getXtext() {
		return builder.build();
	}
	
	private static void checkBraces(List<String> lines) throws ModelXtextException {
		// check if '{'s and '}'s have the same count
		int count = 0;
		for (String line : lines) {
			count += Util.count(line, "{");
			count -= Util.count(line, "}");
		}
		if (count != 0) {
			throw new ModelXtextException("the number of '{'s is not equal to '}'s");
		}
	}
	
	private static void checkBeforeFormat(List<String> lines) throws ModelXtextException {
		final int size = lines.size();
		if (lines.get(size - 1).trim().startsWith("{")) {
			throw new ModelXtextException("should NOT start with a '{' in the first line: '" + lines.get(0).trim() + "'");
		}
		checkBraces(lines);
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (line.isEmpty()) {
				continue;
			}
			final int openBraceCount = Util.count(line, "{");
			if (openBraceCount > 1) {
				throw new ModelXtextException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = Util.count(line, "}");
			if (closeBraceCount > 1) {
				throw new ModelXtextException("more than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(1, line.length() - 1).trim();
				if (sub.isEmpty()) {
					throw new ModelXtextException("no content found in '" + line + "'");
				}
			}
		}
	}
	
	private static void checkAfterFormat(List<String> formatted) throws ModelXtextException {
		checkBraces(formatted);
		final int size = formatted.size();
		// check the formatted lines
		for (int i = 0; i < size; ++i) {
			String line = formatted.get(i).trim();
			if (line.isEmpty()) {
				throw new ModelXtextException("an empty line has bee found");
			}
			final int openBraceCount = Util.count(line, "{");
			if (openBraceCount > 1) {
				throw new ModelXtextException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = Util.count(line, "}");
			if (closeBraceCount > 1) {
				throw new ModelXtextException("more than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				throw new ModelXtextException("'{' and '}' should not be in the same line in '" + line + "'");
			}
			if (line.startsWith("{") && !line.endsWith("}")) {
				String sub = line.substring(1, line.length()).trim();
				if (sub.isEmpty()) {
					throw new ModelXtextException("no content found in '" + line + "'");
				}
			}
			if (!line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(0, line.length() - 1).trim();
				if (!sub.isEmpty()) {
					throw new ModelXtextException("content found before '}' in '" + line + "'");
				}
			}
		}
	}
	
	public static void format(List<String> lines) throws ModelXtextException {
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

}

package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.xtext.ModelXtextException;
import org.openhab.designerx.util.StringHelper;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public final class NestableElementXtextKeeper {
	
	private ImmutableList<String> xtext;
	
	public NestableElementXtextKeeper(List<String> list) throws ModelXtextException {
		List<String> lines = Lists.newArrayList();
		lines.addAll(list);
		checkBraces(lines);
		checkBeforeFormat(lines);
		format(lines);
		checkAfterFormat(lines);
		ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
		xtext = builder.addAll(lines).build();
	}
	
	public ImmutableList<String> getXtext() {
		return xtext;
	}
	
	public void checkBraces(List<String> lines) throws ModelXtextException {
		// check if '{'s and '}'s have the same count
		int open = 0;
		int close = 0;
		for (String line : lines) {
			open += StringHelper.count(line, "{");
			close += StringHelper.count(line, "}");
		}
		if (open != close) {
			throw new ModelXtextException("the number of '{'s(" + open + ") is not equal to that of '}'s(" + close + ")");
		}
	}
	
	public void checkBeforeFormat(List<String> lines) throws ModelXtextException {
		final int size = lines.size();
		checkBraces(lines);
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (line.isEmpty()) {
				continue;
			}
			final int openBraceCount = StringHelper.count(line, "{");
			if (openBraceCount > 1) {
				throw new ModelXtextException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = StringHelper.count(line, "}");
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
	
	public void checkAfterFormat(List<String> formatted) throws ModelXtextException {
		checkBraces(formatted);
		final int size = formatted.size();
		// check the formatted lines
		for (int i = 0; i < size; ++i) {
			String line = formatted.get(i).trim();
			if (line.isEmpty()) {
				throw new ModelXtextException("an empty line has bee found");
			}
			final int openBraceCount = StringHelper.count(line, "{");
			if (openBraceCount > 1) {
				throw new ModelXtextException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = StringHelper.count(line, "}");
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
	
	public void format(List<String> lines) throws ModelXtextException {
		StringHelper.trim(lines);
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

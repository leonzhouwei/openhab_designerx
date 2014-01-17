package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.util.StringHelper;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

final class ChildlessElementXtextKeeper {
	private ImmutableList<String> xtext;
	
	ChildlessElementXtextKeeper(String string) throws ModelXtdexException {
		String[] split = string.split(ModelXtdexConstants.LINE_SEPARATOR);
		List<String> lines = Lists.newArrayList();
		for (String s : split) {
			lines.add(s);
		}
		checkBraces(lines);
		checkBeforeFormat(lines);
		format(lines);
		checkAfterFormat(lines);
		ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
		xtext = builder.addAll(lines).build();
	}
	
	ChildlessElementXtextKeeper(List<String> list) throws ModelXtdexException {
		List<String> lines = Lists.newArrayList();
		lines.addAll(list);
		checkBraces(lines);
		checkBeforeFormat(lines);
		format(lines);
		checkAfterFormat(lines);
		ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
		xtext = builder.addAll(lines).build();
	}
	
	ImmutableList<String> getXtext() {
		return xtext;
	}
	
	void checkBraces(List<String> lines) throws ModelXtdexException {
		// check if '{'s and '}'s have the same count
		int open = 0;
		int close = 0;
		for (String line : lines) {
			open += StringHelper.count(line, "{");
			close += StringHelper.count(line, "}");
		}
		if (open != close) {
			throw new ModelXtdexException("the number of '{'s(" + open + ") is not equal to that of '}'s(" + close + ")");
		}
	}
	
	void checkBeforeFormat(List<String> lines) throws ModelXtdexException {
		final int size = lines.size();
		checkBraces(lines);
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (line.isEmpty()) {
				continue;
			}
			final int openBraceCount = StringHelper.count(line, "{");
			if (openBraceCount > 1) {
				throw new ModelXtdexException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = StringHelper.count(line, "}");
			if (closeBraceCount > 1) {
				throw new ModelXtdexException("more than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(1, line.length() - 1).trim();
				if (sub.isEmpty()) {
					throw new ModelXtdexException("no content found in '" + line + "'");
				}
			}
		}
	}
	
	void checkAfterFormat(List<String> formatted) throws ModelXtdexException {
		checkBraces(formatted);
		final int size = formatted.size();
		// check the formatted lines
		for (int i = 0; i < size; ++i) {
			String line = formatted.get(i).trim();
			if (line.isEmpty()) {
				throw new ModelXtdexException("an empty line has bee found");
			}
			final int openBraceCount = StringHelper.count(line, "{");
			if (openBraceCount > 1) {
				throw new ModelXtdexException("more than 1 '{' found in '" + line + "'");
			}
			final int closeBraceCount = StringHelper.count(line, "}");
			if (closeBraceCount > 1) {
				throw new ModelXtdexException("more than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{") && line.endsWith("}")) {
				throw new ModelXtdexException("'{' and '}' should not be in the same line in '" + line + "'");
			}
			if (line.startsWith("{") && !line.endsWith("}")) {
				String sub = line.substring(1, line.length()).trim();
				if (sub.isEmpty()) {
					throw new ModelXtdexException("no content found in '" + line + "'");
				}
			}
			if (!line.startsWith("{") && line.endsWith("}")) {
				String sub = line.substring(0, line.length() - 1).trim();
				if (!sub.isEmpty()) {
					throw new ModelXtdexException("content found before '}' in '" + line + "'");
				}
			}
		}
	}
	
	void format(List<String> lines) throws ModelXtdexException {
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

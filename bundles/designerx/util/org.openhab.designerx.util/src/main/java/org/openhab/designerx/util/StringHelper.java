package org.openhab.designerx.util;

import java.util.List;

import com.google.common.collect.Lists;

public final class StringHelper {

	public static void printSeparateLine() {
		System.out
				.println("--------------------------------------------------------------------------------");
	}

	public static int count(String source, String target) {
		int count = 0;
		int index = -1;
		while ((index = source.indexOf(target)) >= 0) {
			count += 1;
			if (index > source.length() - 1) {
				break;
			}
			source = source.substring(index + 1, source.length());
		}
		return count;
	}

	public static void trim(List<String> list) {
		List<String> trimmed = Lists.newArrayList();
		for (String string : list) {
			string = string.trim();
			if (!string.isEmpty()) {
				trimmed.add(string);
			}
		}
		list.clear();
		list.addAll(trimmed);
	}

	private StringHelper() {}

	public static void printTestStartLine() {
		printStartLine("TEST");
	}
	
	public static void printTestEndLine() {
		printEndLine("TEST");
	}
	
	public static void printStartLine(String info) {
		System.out.println("==== " + info + " START ====");
	}
	
	public static void printEndLine(String info) {
		System.out.println("===== " + info + " END =====");
	}
	
}

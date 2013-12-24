package org.openhab.designerx.model.internal.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

public class Util {

	public static List<File> listRegularFileNames(File directory,
			String fileExtension) {
		return org.openhab.designerx.model.Util.listRegularFileNames(directory, fileExtension);
	}

	public static List<String> baseNames(List<File> files, String fileExtension) {
		return org.openhab.designerx.model.Util.baseNames(files, fileExtension);
	}

	public static List<String> readAllTrimEmptyLines(File file)
			throws IOException {
		return org.openhab.designerx.model.Util.readAllTrimEmptyLines(file);
	}

	public static void printSeparateLine() {
		org.openhab.designerx.model.Util.printSeparateLine();
	}

	public static int count(String source, String target) {
		return org.openhab.designerx.model.Util.count(source, target);
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
	
}

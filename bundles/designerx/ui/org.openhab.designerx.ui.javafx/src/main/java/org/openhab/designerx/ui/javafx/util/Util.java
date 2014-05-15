package org.openhab.designerx.ui.javafx.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Util {
	
	public static List<File> listRegularFileNames(File directory, String fileExtension) {
		File[] array = directory.listFiles();
		List<File> files = new ArrayList<File>();
		for (File file : array) {
			if (file.getName().endsWith(fileExtension)) {
				files.add(file);
			}
		}
		return files;
	}
	
	public static List<String> baseNames(List<File> files, String fileExtension) {
		List<String> baseNames = new ArrayList<String>();
		for (File file : files) {
			String name = file.getName();
			int index = name.indexOf(fileExtension);
			String baseName = name.substring(0, index);
			baseNames.add(baseName);
		}
		return baseNames;
	}
	
}

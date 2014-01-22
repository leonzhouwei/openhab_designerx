package org.openhab.designerx.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.io.Closer;

public final class IOUtils {

	public static List<String> readAll(File file) throws IOException {
		List<String> result = Lists.newArrayList();
		Closer closer = Closer.create();
		try {
			InputStream in = closer.register(new FileInputStream(file));
			BufferedReader br = new BufferedReader(new InputStreamReader(in, UtilConstants.UTF8));
			String line = null;
			while ((line=br.readLine()) != null) {
				result.add(line);
			}
		} catch (Throwable e) { // must catch Throwable
			throw closer.rethrow(e);
		} finally {
			closer.close();
		}
		return result;
	}
	
	public static void append(File file, String line) throws IOException {
		Closer closer = Closer.create();
		try {
			OutputStream in = closer.register(new FileOutputStream(file, true));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(in, UtilConstants.UTF8));
			bw.append(UtilConstants.LINE_SEPARATOR);
			bw.append(line);
			bw.flush();
			bw.close();
		} catch (Throwable e) { // must catch Throwable
			throw closer.rethrow(e);
		} finally {
			closer.close();
		}
	}
	
	public static void write(File file, String string) throws IOException {
		Closer closer = Closer.create();
		try {
			OutputStream in = closer.register(new FileOutputStream(file));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(in, UtilConstants.UTF8));
			bw.write(string);
			bw.flush();
			bw.close();
		} catch (Throwable e) { // must catch Throwable
			throw closer.rethrow(e);
		} finally {
			closer.close();
		}
	}
	
	public static List<String> listBaseNamesWithoutExtension(List<File> files, String fileExtension) {
		List<String> baseNames = Lists.newArrayList();
		for (File file : files) {
			String name = file.getName();
			int index = name.indexOf(fileExtension);
			String baseName = name.substring(0, index);
			baseNames.add(baseName);
		}
		return baseNames;
	}
	
	public static List<File> listRegularFileNames(File directory, String fileExtension) {
		File[] array = directory.listFiles();
		List<File> files = Lists.newArrayList();
		for (File file : array) {
			if (file.getName().endsWith(fileExtension)) {
				files.add(file);
			}
		}
		return files;
	}

	private IOUtils() {}

}

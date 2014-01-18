package org.openhab.designerx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

	private IOUtils() {}

}

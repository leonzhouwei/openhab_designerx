package org.openhab.designerx.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

class IOUtilsTest {
	
	public static void main(String[] args) throws IOException {
		testAppend();
		testReadAll();
		testWrite();
	}

	static void testReadAll() throws IOException {
		File file = new File("demo.items");
		List<String> lines = IOUtils.readAll(file);
		for (String s : lines) {
			System.out.println(s);
		}
	}

	static void testAppend() throws IOException {
		File file = new File("to_be_appended.items");
		IOUtils.append(file, "lalala");
	}

	static void testWrite() throws IOException {
		File file = new File("to_be_overwritten.items");
		IOUtils.write(file, "hohoho");
	}

}

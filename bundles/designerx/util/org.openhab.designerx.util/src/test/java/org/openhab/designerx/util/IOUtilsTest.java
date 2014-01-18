package org.openhab.designerx.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class IOUtilsTest {

	@Test
	public void testReadAll() throws IOException {
		File file = new File("demo.items");
		List<String> lines = IOUtils.readAll(file);
		for (String s : lines) {
			System.out.println(s);
		}
	}

	@Test
	public void testAppend() throws IOException {
		File file = new File("to_be_appended.items");
		IOUtils.append(file, "lalala");
	}

	@Test
	public void testWrite() throws IOException {
		File file = new File("to_be_overwritten.items");
		IOUtils.write(file, "hohoho");
	}

}

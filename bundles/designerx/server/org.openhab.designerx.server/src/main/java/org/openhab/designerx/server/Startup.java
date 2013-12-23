package org.openhab.designerx.server;

import java.io.File;

public class Startup {
	
	public static void main(String[] args) {
		File cwd = new File(System.getProperty("user.dir"));
		System.out.println(cwd.getPath());
		File openhabFolder = cwd.getParentFile().getParentFile().getParentFile().getParentFile();
		System.out.println(openhabFolder.getPath());
		File[] files = openhabFolder.listFiles();
		for (File file : files) {
			System.out.println(file.getName() + " (" + file.getPath() + ")");
		}
	}

}

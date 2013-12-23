package org.openhab.designerx.config.internal;

import java.io.File;
import java.util.Arrays;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.ConfigConstants;

public class ConfigImpl implements Config {

	private boolean loaded = false;
	private String home;
	private String sitemapFolderPath;

	public ConfigImpl() {
		if (loaded) {
			return;
		}
		System.out
				.println("--------------------------------------------------------------------------------");
		System.out.println("looking for the openHAB home folder...");
		loaded = true;
		File homeFolder = null;
		homeFolder = lookForHomeFolderInUserMode();
		if (homeFolder == null) {
			homeFolder = lookForHomeFolderInDevMode();
		}
		if (homeFolder == null) {
			System.err.println("could not find the openHAB home folder");
		}
		listAsc(homeFolder);
	}

	@Override
	public String getSitemapFolderPath() {
		synchronized (this) {
			return sitemapFolderPath;
		}
	}

	private File lookForHomeFolderInUserMode() {
		File home = null;
		// try to find the 'openhab-runtime-*' folder under the
		// parent of the current working directory, according to
		// openhab-runtime-*
		//     |-- addons
		//     |-- configurations
		//     ...
		File cwd = new File(ConfigConstants.USER_DIR);
		File parent = cwd.getParentFile();
		File[] files = parent.listFiles();
		for (File f : files) {
			String name = f.getName();
			if (f.exists() && f.isFile()
					&& name.startsWith(ConfigConstants.OPENHAB_RUNTIME)) {
				home = f;
				break;
			}
		}
		return home;
	}

	private File lookForHomeFolderInDevMode() {
		File home = null;
		// try to find the 'distribution' folder, according to
		// openhab
		//     |-- bundles
		//         |-- designerx
		//         |-- config
		//             |-- org.openhab.designerx.config
		//             ...
		//     |-- distribution
		//         |-- openhabhome
		//             |-- addons
		//             |-- configurations
		//             ...
		File cwd = new File(ConfigConstants.USER_DIR);
		File temp = cwd.getParentFile().getParentFile().getParentFile()
				.getParentFile();
		if (temp.getName().startsWith(ConfigConstants.OPENHAB)) {
			home = new File(temp.getPath() + ConfigConstants.FILE_SEPARATOR + ConfigConstants.DISTRIBUTION + ConfigConstants.FILE_SEPARATOR + ConfigConstants.OPENHABHOME);
		}
		return home;
	}

	private void listAsc(File folder) {
		String[] names = folder.list();
		Arrays.sort(names);
		for (String name : names) {
			if (name.startsWith(".")) {
				continue;
			}
			System.out.println(name);
		}
	}

}

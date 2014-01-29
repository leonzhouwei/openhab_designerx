package org.openhab.designerx.config.impl;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.ConfigConstants;
import org.openhab.designerx.config.ConfigException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

final class RealConfigImpl implements Config {
	private static final String[] HOME_FOLDER_CHILDREN_NAMES = {
		ConfigConstants.ADDONS,
		ConfigConstants.CONFIGURATIONS,
		ConfigConstants.CONTEXTS,
		ConfigConstants.ETC,
		ConfigConstants.LOGS,
		ConfigConstants.SERVER,
		ConfigConstants.SOUNDS,
		ConfigConstants.WEBAPPS,
		ConfigConstants.WORKSPACE
	};
	private static final String[] CONFIG_FOLDER_CHILDREN_NAMES = {
		ConfigConstants.ITEMS,
		ConfigConstants.PERSISTENCE,
		ConfigConstants.RULES,
		ConfigConstants.SCRIPTS,
		ConfigConstants.SITEMAPS,
		ConfigConstants.TRANSFORM
	};
	
	private static final RealConfigImpl instance = new RealConfigImpl();
	
	private String openHABHomeFolderPath;
	private String sitemapsFolderPath;
	private String itemsFolderPath;
	
	public static RealConfigImpl getInstance() {
		return instance;
	}

	public void load() {}
	
	@Override
	public String getOpenHABHomeFolderPath() {
		return openHABHomeFolderPath;
	}

	@Override
	public String getSitemapsFolderPath() {
		return sitemapsFolderPath;
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
		List<String> names = Lists.newArrayList();
		Map<String, File> map = Maps.newHashMap();
		File[] files = folder.listFiles();
		for (File f : files) {
			String name = f.getName();
			names.add(name);
			map.put(name, f);
		}
		Collections.sort(names);
		for (String name : names) {
			if (name.startsWith(".")) {
				continue;
			}
			System.out.print(name);
			if (map.get(name).isDirectory()) {
				System.out.print(ConfigConstants.FILE_SEPARATOR);
			}
			System.out.println();
		}
	}
	
	private void verifyHomeFolder(File homeFolder) {
		Set<String> set = Sets.newHashSet();
		File[] files = homeFolder.listFiles();
		for (File f : files) {
			set.add(f.getName());
		}
		for (String name : HOME_FOLDER_CHILDREN_NAMES) {
			if (!set.contains(name)) {
				throw new ConfigException("'" + name + "' folder not found in '" + homeFolder.getPath() + "'");
			}
		}
	}
	
	private void verifyConfigFolder(File configFolder) {
		Set<String> set = Sets.newHashSet();
		File[] files = configFolder.listFiles();
		for (File f : files) {
			set.add(f.getName());
		}
		for (String name : CONFIG_FOLDER_CHILDREN_NAMES) {
			if (!set.contains(name)) {
				throw new ConfigException("'" + name + "' folder not found in '" + configFolder.getPath() + "'");
			}
		}
	}

	@Override
	public String getItemsFolderPath() {
		return itemsFolderPath;
	}
	
	private RealConfigImpl() {
		System.out.println(ConfigConstants.STRIKETHROUGH_80);
		File homeFolder = null;
		homeFolder = lookForHomeFolderInUserMode();
		if (homeFolder == null) {
			homeFolder = lookForHomeFolderInDevMode();
		}
		if (homeFolder == null) {
			System.err.println("could not find the openHAB home folder!");
		}
		verifyHomeFolder(homeFolder);
		File configFolder = new File(homeFolder.getPath() + ConfigConstants.FILE_SEPARATOR + ConfigConstants.CONFIGURATIONS);
		verifyConfigFolder(configFolder);
		System.out.println("listing the files in the openHAB home flder ('" + homeFolder.getPath() + "')");
		listAsc(homeFolder);
		openHABHomeFolderPath = homeFolder.getPath();
		sitemapsFolderPath = configFolder.getPath() + ConfigConstants.FILE_SEPARATOR + ConfigConstants.SITEMAPS;
		itemsFolderPath = configFolder.getPath() + ConfigConstants.FILE_SEPARATOR + ConfigConstants.ITEMS;
	}
	
	@Override
	public File getOpenHABHomeFolder() {
		return new File(openHABHomeFolderPath);
	}

	@Override
	public File getSitemapsFolder() {
		return new File(sitemapsFolderPath);
	}
	
	@Override
	public File getItemsFolder() {
		return new File(itemsFolderPath);
	}
	
}

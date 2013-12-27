package org.openhab.designerx.model.internal.sitemap.impl;

import java.util.Collection;
import java.util.Set;

import org.openhab.designerx.model.Atom;
import org.openhab.designerx.model.Constants;
import org.openhab.designerx.model.Properties;
import org.openhab.designerx.model.Property;
import org.openhab.designerx.model.internal.sitemap.node.atom.properties.PropertiesImpl;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Frame [label="<labelname>"] [icon="<icon>"] [item="<item">]
 * 
 * @author zhouwei
 *
 */
public class Frame implements Atom {

	public static final String TYPE = "Frame";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"icon=", 
		"item=",
		"label="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"label",
		"icon",
		"item"
	};
	
	private Properties properties = new PropertiesImpl();
	
	public static Frame parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keywordSet = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keywordSet.add(key);
		}
		Frame instance = new Frame();
		instance.addProperties(PropertiesImpl.parse(line, TYPE, keywordSet).getAll());
		return instance;
	}

	@Override
	public String toXtext() {
		StringBuilder sb = new StringBuilder();
		sb.append(TYPE);
		if (!properties.isEmpty()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(properties.toXtext(ORDERED_PROPERTY_NAMES));
		}
		return sb.toString();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	@Override
	public boolean addProperty(Property property) {
		return properties.add(property);
	}

	@Override
	public boolean addProperties(Collection<? extends Property> properties) {
		return this.properties.addAll(properties);
	}

}

package org.openhab.designerx.model.internal.sitemap.node.atom;

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
 * Group [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public class Group implements Atom {

	public static final String TYPE = "Group";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"icon=", 
		"item=",
		"label="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"label",
		"icon"
	};
	
	private Properties properties = new PropertiesImpl();
	
	public static Group parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keywordSet = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keywordSet.add(key);
		}
		Group instance = new Group();
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

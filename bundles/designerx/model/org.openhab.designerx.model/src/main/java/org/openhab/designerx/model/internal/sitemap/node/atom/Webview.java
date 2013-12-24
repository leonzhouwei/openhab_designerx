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
 * Webview item="<itemname>" [label="<labelname>"] [icon="<iconname>"] url="<url>" [height="<heightvalue"]
 * 
 * @author zhouwei
 *
 */
public class Webview implements Atom {

	public static final String TYPE = "Webview";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"height=",
		"icon=",
		"item=",
		"label=",
		"url="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"label",
		"icon",
		"url",
		"height"
	};
	
	private Properties properties = new PropertiesImpl();
	
	public static Webview parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keywordSet = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keywordSet.add(key);
		}
		Webview instance = new Webview();
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

package org.openhab.designerx.model.items.impl;

import java.util.List;

import org.openhab.designerx.model.Constants;
import org.openhab.designerx.model.items.Item;

import com.google.common.collect.Lists;

final class ItemImpl implements Item {
	private String type; // mandatory
	private String name; // mandatory
	private String labelText; // optional
	private String iconName; // optional
	private List<String> groups = Lists.newArrayList(); // optional
	private String bindingConfig; // optional

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLabelText() {
		return labelText;
	}

	@Override
	public String getIconName() {
		return iconName;
	}

	@Override
	public List<String> getGroups() {
		return groups;
	}

	@Override
	public String getBindingConfig() {
		return bindingConfig;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	@Override
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@Override
	public void addGroups(String[] groups) {
		for (String group : groups) {
			addGroup(group);
		}
	}

	@Override
	public void addGroup(String group) {
		groups.add(group);
	}

	@Override
	public void setBindingConfig(String bindingConfig) {
		this.bindingConfig = bindingConfig;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(Constants.SPACE_MARK);
		sb.append(name);
		sb.append(Constants.SPACE_MARK);
		if (labelText != null) {
			sb.append("\"");
			sb.append(labelText);
			sb.append("\"");
			sb.append(Constants.SPACE_MARK);
		}
		if (iconName != null) {
			sb.append("<");
			sb.append(iconName);
			sb.append(">");
			sb.append(Constants.SPACE_MARK);
		}
		if (!groups.isEmpty()) {
			sb.append("(");
			for (String group : groups) {
				sb.append(group);
				sb.append(Constants.COMMA_MARK);
				sb.append(Constants.SPACE_MARK);	
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
		}
		if (bindingConfig != null) {
			sb.append("{");
			sb.append(bindingConfig);
			sb.append(Constants.SPACE_MARK);
			sb.append("}");
		}
		return sb.toString();
	}
	
}

package org.openhab.designerx.model.items.producer.impl;

import java.util.List;

import org.openhab.designerx.model.items.GroupItem;

final class GroupItemImpl implements GroupItem {
	private ItemImpl item = new ItemImpl(GroupItem.TYPE_NAME);
	private String extraType;

	@Override
	public String getTypeName() {
		return item.getTypeName();
	}

	@Override
	public void setName(String name) {
		item.setName(name);
	}

	@Override
	public String getName() {
		return item.getName();
	}

	@Override
	public void setLabelText(String labelText) {
		item.setLabelText(labelText);
	}

	@Override
	public String getLabelText() {
		return item.getLabelText();
	}

	@Override
	public void setIconName(String iconName) {
		item.setIconName(iconName);
	}

	@Override
	public String getIconName() {
		return item.getIconName();
	}

	@Override
	public List<String> getGroups() {
		return item.getGroups();
	}

	@Override
	public void addGroups(List<String> groups) {
		item.addGroups(groups);
	}

	@Override
	public void addGroup(String group) {
		item.addGroup(group);
	}

	@Override
	public String getBindingConfig() {
		return item.getBindingConfig();
	}

	@Override
	public void setBindingConfig(String bindingConfig) {
		item.setBindingConfig(bindingConfig);
	}

	@Override
	public void setExtraTypeName(String extraType) {
		this.extraType = extraType;
	}

	@Override
	public String getExtraTypeName() {
		return extraType;
	}

}

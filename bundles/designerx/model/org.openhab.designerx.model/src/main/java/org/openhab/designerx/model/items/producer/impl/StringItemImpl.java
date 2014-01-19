package org.openhab.designerx.model.items.producer.impl;

import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.StringItem;

final class StringItemImpl implements StringItem {
	private ItemImpl item;
	
	public StringItemImpl(String name) throws ModelException {
		item = new ItemImpl(StringItem.TYPE_NAME, name);
	}

	@Override
	public String getTypeName() {
		return item.getTypeName();
	}

	@Override
	public void setName(String name) throws ModelException {
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

}

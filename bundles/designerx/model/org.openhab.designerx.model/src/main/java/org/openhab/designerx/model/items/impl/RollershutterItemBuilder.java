package org.openhab.designerx.model.items.impl;

import java.util.List;

import org.openhab.designerx.model.items.RollershutterItem;

public final class RollershutterItemBuilder {
	private String name;
	
	public RollershutterItemBuilder(String name) {
		this.name = name;
	}
	
	public RollershutterItem build() {
		RollershutterItemImpl instance = new RollershutterItemImpl();
		instance.setName(name);
		return instance;
	}
	
	private class RollershutterItemImpl implements RollershutterItem {
		private static final String TYPE_NAME = "Rollershutter";
		private ItemImpl item = new ItemImpl();
		
		@Override
		public String getTypeName() {
			return TYPE_NAME;
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
	}

}

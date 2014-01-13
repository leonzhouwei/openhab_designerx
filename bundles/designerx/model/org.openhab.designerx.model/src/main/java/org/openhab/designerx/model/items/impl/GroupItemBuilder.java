package org.openhab.designerx.model.items.impl;

import java.util.List;

import org.openhab.designerx.model.items.GroupItem;

public final class GroupItemBuilder {
	
	private static final String TARGET_TYPE_NAME = "Group";
	private String name;
	
	public GroupItemBuilder(String name) {
		this.name = name;
	}
	
	public GroupItem build() {
		GroupItemImpl instance = new GroupItemImpl();
		instance.setType(TARGET_TYPE_NAME);
		instance.setName(name);
		return instance;
	}
	
	private class GroupItemImpl implements GroupItem {
		private ItemImpl item = new ItemImpl();
		
		public void setType(String type) {
			item.setType(type);
		}

		@Override
		public String getType() {
			return item.getType();
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
		public void addGroups(String[] groups) {
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

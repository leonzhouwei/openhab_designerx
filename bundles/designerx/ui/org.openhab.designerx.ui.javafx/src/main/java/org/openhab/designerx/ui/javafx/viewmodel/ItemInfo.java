package org.openhab.designerx.ui.javafx.viewmodel;

import org.openhab.designerx.model.items.Item;

import javafx.beans.property.SimpleStringProperty;

public final class ItemInfo {

	private SimpleStringProperty type = new SimpleStringProperty("");
	private SimpleStringProperty name = new SimpleStringProperty("");
	private SimpleStringProperty label = new SimpleStringProperty("");
	private SimpleStringProperty icon = new SimpleStringProperty("");
	private SimpleStringProperty groups = new SimpleStringProperty("");
	private SimpleStringProperty command = new SimpleStringProperty("");

	public ItemInfo(SimpleStringProperty type,
			SimpleStringProperty name, SimpleStringProperty label,
			SimpleStringProperty icon, SimpleStringProperty group,
			SimpleStringProperty command) {
		this.type = type;
		this.name = name;
		this.label = label;
		this.icon = icon;
		this.groups = group;
		this.command = command;
	}

	public ItemInfo(Item item) {
		String type = item.getTypeName();
		this.type = new SimpleStringProperty(type);
		
		String name = item.getName();
		this.name = new SimpleStringProperty(name);
		
		String label = item.getLabelText();
		if (label != null) {
			this.label = new SimpleStringProperty(label);
		}
		
		String icon = item.getIconName();
		if (icon != null) {
			this.icon = new SimpleStringProperty(icon);
		}
		
		if (!item.getGroups().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (String group : item.getGroups()) {
				sb.append(group);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			this.groups = new SimpleStringProperty(sb.toString());
		}
		
		String command = item.getBindingConfig();
		if (command != null) {
			this.command = new SimpleStringProperty(command);
		}
	}

	public SimpleStringProperty typeProperty() {
		return type;
	}

	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public SimpleStringProperty labelProperty() {
		return label;
	}

	public void setLabel(String label) {
		this.label = new SimpleStringProperty(label);
	}

	public SimpleStringProperty iconProperty() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = new SimpleStringProperty(icon);
	}

	public SimpleStringProperty groupsProperty() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = new SimpleStringProperty(groups);
	}

	public SimpleStringProperty commandProperty() {
		return command;
	}

	public void setCommand(String command) {
		this.command = new SimpleStringProperty(command);
	}

}

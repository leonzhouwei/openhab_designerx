package org.openhab.designerx.model.items.producer.impl;

import java.util.List;

import org.openhab.designerx.model.ModelConstants;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

final class ItemImpl implements Item {
	private static ImmutableSet<String> validTypeNames = ImmutableSet.<String>builder()
			.add(ColorItem.TYPE_NAME)
			.add(ContactItem.TYPE_NAME)
			.add(DateTimeItem.TYPE_NAME)
			.add(DimmerItem.TYPE_NAME)
			.add(GroupItem.TYPE_NAME)
			.add(NumberItem.TYPE_NAME)
			.add(RollershutterItem.TYPE_NAME)
			.add(StringItem.TYPE_NAME)
			.add(SwitchItem.TYPE_NAME)
			.build();
	
	private String typeName; // mandatory
	private String name; // mandatory
	private String labelText; // optional
	private String iconName; // optional
	private List<String> groups = Lists.newArrayList(); // optional
	private String bindingConfig; // optional
	
	public ItemImpl(String typeName, String name) throws ModelException {
		if (typeName == null) {
			throw new ModelException("item type name can not be null");
		}
		if (!validTypeNames.contains(typeName)) {
			throw new ModelException("'" + typeName + "' is not a valid item type name");
		}
		setName(name);
	}

	@Override
	public String getTypeName() {
		return typeName;
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

	@Override
	public void setName(String name) throws ModelException {
		if (name == null || name.trim().isEmpty()) {
			throw new ModelException("item name can not be null or empty");
		}
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
	public void addGroups(List<String> groups) {
		groups.addAll(groups);
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
		sb.append(typeName);
		sb.append(ModelConstants.SPACE_MARK);
		sb.append(name);
		sb.append(ModelConstants.SPACE_MARK);
		if (labelText != null) {
			sb.append("\"");
			sb.append(labelText);
			sb.append("\"");
			sb.append(ModelConstants.SPACE_MARK);
		}
		if (iconName != null) {
			sb.append("<");
			sb.append(iconName);
			sb.append(">");
			sb.append(ModelConstants.SPACE_MARK);
		}
		if (!groups.isEmpty()) {
			sb.append("(");
			for (String group : groups) {
				sb.append(group);
				sb.append(ModelConstants.COMMA_MARK);
				sb.append(ModelConstants.SPACE_MARK);	
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
		}
		if (bindingConfig != null) {
			sb.append("{");
			sb.append(bindingConfig);
			sb.append(ModelConstants.SPACE_MARK);
			sb.append("}");
		}
		return sb.toString();
	}
	
}

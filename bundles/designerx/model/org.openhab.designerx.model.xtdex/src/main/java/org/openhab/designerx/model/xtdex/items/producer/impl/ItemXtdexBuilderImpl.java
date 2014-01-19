package org.openhab.designerx.model.xtdex.items.producer.impl;

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
import org.openhab.designerx.model.items.producer.ItemFactory;
import org.openhab.designerx.model.items.producer.impl.ItemFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemXtdexBuilder;

public final class ItemXtdexBuilderImpl implements ItemXtdexBuilder {

	@Override
	public ItemXtdex build() {
		return new ItemXtdexImpl();
	}
	
	private class ItemXtdexImpl implements ItemXtdex {
		private static final String SPACE_REGEX = "\\s*";
		private static final String POST = "\\b.*";
		private static final String COLOR_REGEX = SPACE_REGEX + ColorItem.TYPE_NAME + POST;
		private static final String CONTACT_REGEX = SPACE_REGEX + ContactItem.TYPE_NAME + POST;
		private static final String DATETIME_REGEX = SPACE_REGEX + DateTimeItem.TYPE_NAME + POST;
		private static final String DIMMER_REGEX = SPACE_REGEX + DimmerItem.TYPE_NAME + POST;
		private static final String GROUP_REGEX = SPACE_REGEX + GroupItem.TYPE_NAME + POST;
		private static final String NUMBER_REGEX = SPACE_REGEX + NumberItem.TYPE_NAME + POST;
		private static final String ROLLERSHUTTER_REGEX = SPACE_REGEX + RollershutterItem.TYPE_NAME + POST;
		private static final String STRING_REGEX = SPACE_REGEX + StringItem.TYPE_NAME + POST;
		private static final String SWITCH_REGEX = SPACE_REGEX + SwitchItem.TYPE_NAME + POST;
		private static final String ACTIVE_GROUPS_REGEX = "\\s*Group\\s*:\\s*.*?\\s*:\\s*.*?\\(.*?\\)\\s.*";
		
		private ItemFactory itemFactory = new ItemFactoryImpl();
		
		@Override
		public ColorItem parseColorItem(String xtext) throws ModelException {
			if (!xtext.matches(COLOR_REGEX)) {
				return null;
			}
			ColorItem instance = (ColorItem) createItem(xtext);
			return instance;
		}

		@Override
		public ContactItem parseContactItem(String xtext) throws ModelException {
			if (!xtext.matches(CONTACT_REGEX)) {
				return null;
			}
			ContactItem instance = (ContactItem) createItem(xtext);
			return instance;
		}

		@Override
		public DateTimeItem parseDateTimeItem(String xtext) throws ModelException {
			if (!xtext.matches(DATETIME_REGEX)) {
				return null;
			}
			DateTimeItem instance = (DateTimeItem) createItem(xtext);
			return instance;
		}

		@Override
		public DimmerItem parseDimmerItem(String xtext) throws ModelException {
			if (!xtext.matches(DIMMER_REGEX)) {
				return null;
			}
			DimmerItem instance = (DimmerItem) createItem(xtext);
			return instance;
		}

		@Override
		public GroupItem parseGroupItem(String xtext) throws ModelException {
			if (!xtext.matches(GROUP_REGEX)) {
				return null;
			}
			GroupItem instance = (GroupItem) createItem(xtext);
			return instance;
		}

		@Override
		public NumberItem parseNumberItem(String xtext) throws ModelException {
			if (!xtext.matches(NUMBER_REGEX)) {
				return null;
			}
			NumberItem instance = (NumberItem) createItem(xtext);
			return instance;
		}

		@Override
		public RollershutterItem parseRollershutterItem(String xtext) throws ModelException {
			if (!xtext.matches(ROLLERSHUTTER_REGEX)) {
				return null;
			}
			RollershutterItem instance = (RollershutterItem) createItem(xtext);
			return instance;
		}

		@Override
		public StringItem parseStringItem(String xtext) throws ModelException {
			if (!xtext.matches(STRING_REGEX)) {
				return null;
			}
			StringItem instance = (StringItem) createItem(xtext);
			return instance;
		}

		@Override
		public SwitchItem parseSwitchItem(String xtext) throws ModelException {
			if (!xtext.matches(SWITCH_REGEX)) {
				return null;
			}
			SwitchItem instance = (SwitchItem) createItem(xtext);
			return instance;
		}

		public Item createItem(String line) throws ModelException {
			line = line.trim();
			String type = null;
			if (line.matches(ACTIVE_GROUPS_REGEX)) {
				String[] temp = line.split("Group\\s*:\\s*.*?\\s*:\\s*.*?\\(.*?\\)");
				String post = temp[1];
				final int index = line.indexOf(post);
				type = line.substring(0, index).trim();
				line = post.trim();
			} else {
				// parse the type
				String[] forType = line.split("\\s");
				if (forType.length > 0) {
					for (String s : forType) {
						type = s;
						if (!s.trim().isEmpty()) {
							final int index = line.indexOf(s);
							line = line
									.substring(index + s.length(), line.length())
									.trim();
							break;
						}
					}
				}
			}
			// parse the name
			String name = null;
			if (!line.isEmpty()) {
				String[] array = line.split("\\b");
				if (array.length > 0) {
					for (String s : array) {
						if (!s.trim().isEmpty()) {
							name = s;
							final int index = line.indexOf(s);
							line = line
									.substring(index + s.length(), line.length())
									.trim();
							break;
						}
					}
				}
			}
			// create the item
			Item item = createItem(type, name);
			// parse the label text
			if (line.startsWith("\"")) {
				final int start = line.indexOf("\"");
				final int end = line.indexOf("\"", start + 1);
				item.setLabelText(line.substring(start + 1, end));
				line = line.substring(end + 1, line.length()).trim();
			}
			// parse the icon name
			if (line.startsWith("<")) {
				final int start = line.indexOf("<");
				final int end = line.indexOf(">");
				item.setIconName(line.substring(start + 1, end));
				line = line.substring(end + 1, line.length()).trim();
			}
			// parse the group(s)
			if (line.startsWith("(")) {
				final int start = line.indexOf("(");
				final int end = line.indexOf(")");
				String s = line.substring(start + 1, end);
				String[] groups = { s };
				if (s.contains(",")) {
					groups = s.split(",");
				}
				for (String group : groups) {
					item.addGroup(group.trim());
				}
				line = line.substring(end + 1, line.length()).trim();
			}
			// parse the binding config
			if (line.startsWith("{")) {
				final int start = line.indexOf("{");
				final int end = line.indexOf("}");
				item.setBindingConfig(line.substring(start + 1, end).trim());
			}
			return item;
		}
		
		@Override
		public <T extends Item> String toXtext(T item) {
			StringBuilder sb = new StringBuilder();
			sb.append(item.getTypeName());
			sb.append(ModelConstants.SPACE_MARK);
			sb.append(item.getName());
			sb.append(ModelConstants.SPACE_MARK);
			String labelText = item.getLabelText();
			if (labelText != null) {
				sb.append("\"");
				sb.append(labelText);
				sb.append("\"");
				sb.append(ModelConstants.SPACE_MARK);
			}
			String iconName = item.getIconName();
			if (iconName != null) {
				sb.append("<");
				sb.append(iconName);
				sb.append(">");
				sb.append(ModelConstants.SPACE_MARK);
			}
			List<String> groups = item.getGroups();
			if (!groups.isEmpty()) {
				sb.append("(");
				for (String group : groups) {
					sb.append(group);
					sb.append(ModelConstants.COMMA_MARK);
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append(")");
				sb.append(ModelConstants.SPACE_MARK);
			}
			String bindingConfig = item.getBindingConfig();
			if (bindingConfig != null) {
				sb.append("{");
				sb.append(bindingConfig);
				sb.append("}");
			}
			return sb.toString().trim();
		}
		
		@Override
		public Item parseItem(String xtext) throws ModelException {
			Item item = null;
			item = parseColorItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseContactItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseDateTimeItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseDimmerItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseGroupItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseNumberItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseRollershutterItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseStringItem(xtext);
			if (item != null) {
				return item;
			}
			item = parseSwitchItem(xtext);
			if (item != null) {
				return item;
			}
			return null;
		}

		private Item createItem(String type, String name) throws ModelException {
			Item item = null;
			type = type.trim();
			name = name.trim();
			if (type.matches("Group\\s*?:.*")) {
				GroupItem groupItem = itemFactory.createGroupItem(name);
				item = groupItem;
				final int index = type.indexOf(ModelXtdexConstants.COLON_MARK);
				groupItem.setExtraTypeName(type.substring(index+1).trim());
			} else if (type.compareTo(ColorItem.TYPE_NAME) == 0) {
				item = itemFactory.createColorItem(name);
			} else if (type.compareTo(ContactItem.TYPE_NAME) == 0) {
				item = itemFactory.createContactItem(name);
			} else if (type.compareTo(DateTimeItem.TYPE_NAME) == 0) {
				item = itemFactory.createDateTimeItem(name);
			} else if (type.compareTo(DimmerItem.TYPE_NAME) == 0) {
				item = itemFactory.createDimmerItem(name);
			} else if (type.compareTo(GroupItem.TYPE_NAME) == 0) {
				item = itemFactory.createGroupItem(name);
			} else if (type.compareTo(NumberItem.TYPE_NAME) == 0) {
				item = itemFactory.createNumberItem(name);
			} else if (type.compareTo(RollershutterItem.TYPE_NAME) == 0) {
				item = itemFactory.createRollershutterItem(name);
			} else if (type.compareTo(StringItem.TYPE_NAME) == 0) {
				item = itemFactory.createStringItem(name);
			} else if (type.compareTo(SwitchItem.TYPE_NAME) == 0) {
				item = itemFactory.createSwitchItem(name);
			} else {
				item = null;
			}
			return item;
		}
	}


}

package org.openhab.designerx.model.xtdex.items.impl;

import java.util.List;

import org.openhab.designerx.model.Constants;
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
import org.openhab.designerx.model.xtdex.items.ItemXtdex;

public final class ItemXtdexImpl implements ItemXtdex {
	
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

	private ItemFactory itemFactory = new ItemFactoryImpl();
	
	@Override
	public ColorItem parseColorItemFromXext(String xtext) {
		if (!xtext.matches(COLOR_REGEX)) {
			return null;
		}
		ColorItem instance = itemFactory.createColorItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(ColorItem item) {
		return innerToXtext(item);
	}

	@Override
	public ContactItem parseContactItemFromXext(String xtext) {
		if (!xtext.matches(CONTACT_REGEX)) {
			return null;
		}
		ContactItem instance = itemFactory.createContactItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(ContactItem item) {
		return innerToXtext(item);
	}

	@Override
	public DateTimeItem parseDateTimeItemFromXext(String xtext) {
		if (!xtext.matches(DATETIME_REGEX)) {
			return null;
		}
		DateTimeItem instance = itemFactory.createDateTimeItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(DateTimeItem item) {
		return innerToXtext(item);
	}

	@Override
	public DimmerItem parseDimmerItemFromXext(String xtext) {
		if (!xtext.matches(DIMMER_REGEX)) {
			return null;
		}
		DimmerItem instance = itemFactory.createDimmerItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(DimmerItem item) {
		return innerToXtext(item);
	}

	@Override
	public GroupItem parseGroupItemFromXext(String xtext) {
		if (!xtext.matches(GROUP_REGEX)) {
			return null;
		}
		GroupItem instance = itemFactory.createGroupItem();
		String ret = extractAndFill(instance, xtext);
		if (ret != null && ret.trim().length() > GroupItem.TYPE_NAME.length()) {
			String extraType = ret.replace(GroupItem.TYPE_NAME, "").trim();
			instance.setExtraTypeName(extraType);
		}
		return instance;
	}

	@Override
	public String toXtext(GroupItem item) {
		String result = innerToXtext(item);
		String extra = item.getExtraTypeName();
		if (extra != null) {
			result = result.replace(GroupItem.TYPE_NAME, GroupItem.TYPE_NAME + extra);
		}
		return result;
	}

	@Override
	public NumberItem parseNumberItemFromXext(String xtext) {
		if (!xtext.matches(NUMBER_REGEX)) {
			return null;
		}
		NumberItem instance = itemFactory.createNumberItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(NumberItem item) {
		return innerToXtext(item);
	}

	@Override
	public RollershutterItem parseRollershutterItemFromXext(String xtext) {
		if (!xtext.matches(ROLLERSHUTTER_REGEX)) {
			return null;
		}
		RollershutterItem instance = itemFactory.createRollershutterItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(RollershutterItem item) {
		return innerToXtext(item);
	}

	@Override
	public StringItem parseStringItemFromXext(String xtext) {
		if (!xtext.matches(STRING_REGEX)) {
			return null;
		}
		StringItem instance = itemFactory.createStringItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(StringItem item) {
		return innerToXtext(item);
	}

	@Override
	public SwitchItem parseSwitchItemFromXext(String xtext) {
		if (!xtext.matches(SWITCH_REGEX)) {
			return null;
		}
		SwitchItem instance = itemFactory.createSwitchItem();
		extractAndFill(instance, xtext);
		return instance;
	}

	@Override
	public String toXtext(SwitchItem item) {
		return innerToXtext(item);
	}
	
	private <T extends Item> String extractAndFill(T item, String line) {
		String result = null;
		line = line.trim();
		if (line.startsWith("Group:")) {
			String[] temp = line.split("\\s");
			String type = null;
			if (!temp[0].contains("(")) {
				type = temp[0];
			} else {
				final int endIndex = line.indexOf(")");
				type = line.substring(0, endIndex + 1);
			}
			result = type;
			line = line.substring(type.length(), line.length()).trim();
		} else {
			// parse the type
			String[] forType = line.split("\\s");
			if (forType.length > 0) {
				for (String s : forType) {
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
		if (!line.isEmpty()) {
			String[] array = line.split("\\b");
			if (array.length > 0) {
				for (String s : array) {
					if (!s.trim().isEmpty()) {
						item.setName(s);
						final int index = line.indexOf(s);
						line = line
								.substring(index + s.length(), line.length())
								.trim();
						break;
					}
				}
			}
		}
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
				item.addGroup(group);
			}
			line = line.substring(end + 1, line.length()).trim();
		}
		// parse the binding config
		if (line.startsWith("{")) {
			final int start = line.indexOf("{");
			final int end = line.indexOf("}");
			item.setBindingConfig(line.substring(start + 1, end));
		}
		return result;
	}
	
	private <T extends Item> String innerToXtext(T item) {
		StringBuilder sb = new StringBuilder();
		sb.append(item.getTypeName());
		sb.append(Constants.SPACE_MARK);
		sb.append(item.getName());
		sb.append(Constants.SPACE_MARK);
		String labelText = item.getLabelText();
		if (labelText != null) {
			sb.append("\"");
			sb.append(labelText);
			sb.append("\"");
			sb.append(Constants.SPACE_MARK);
		}
		String iconName = item.getIconName();
		if (iconName != null) {
			sb.append("<");
			sb.append(iconName);
			sb.append(">");
			sb.append(Constants.SPACE_MARK);
		}
		List<String> groups = item.getGroups();
		if (!groups.isEmpty()) {
			sb.append("(");
			for (String group : groups) {
				sb.append(group);
				sb.append(Constants.COMMA_MARK);
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
		}
		String bindingConfig = item.getBindingConfig();
		if (bindingConfig != null) {
			sb.append("{");
			sb.append(bindingConfig);
			sb.append("}");
		}
		return sb.toString().trim();
	}

}

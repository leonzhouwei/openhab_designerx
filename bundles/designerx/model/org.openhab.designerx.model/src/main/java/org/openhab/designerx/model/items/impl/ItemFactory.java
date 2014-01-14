package org.openhab.designerx.model.items.impl;

import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;

public final class ItemFactory {

	public static ColorItem createColorItem() {
		ColorItem item = new ColorItemImpl();
		return item;
	}

	public static ContactItem createContactItem() {
		ContactItem item = new ContactItemImpl();
		return item;
	}

	public static DateTimeItem createDateTimeItem() {
		DateTimeItem item = new DateTimeItemImpl();
		return item;
	}

	public static DimmerItem createDimmerItem() {
		DimmerItem item = new DimmerItemImpl();
		return item;
	}

	public static GroupItem createGroupItem() {
		GroupItem item = new GroupItemImpl();
		return item;
	}

	public static NumberItem createNumberItem() {
		NumberItem item = new NumberItemImpl();
		return item;
	}

	public static RollershutterItem createRollershutterItem() {
		RollershutterItem item = new RollershutterItemImpl();
		return item;
	}

	public static StringItem createStringItem() {
		StringItem item = new StringItemImpl();
		return item;
	}

	public static SwitchItem createSwitchItem() {
		SwitchItem item = new SwitchItemImpl();
		return item;
	}
	
	private ItemFactory() {}

}

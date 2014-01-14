package org.openhab.designerx.model.items.factory.impl;

import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;
import org.openhab.designerx.model.items.factory.ItemFactory;

public final class ItemFactoryImpl implements ItemFactory {

	@Override
	public ColorItem createColorItem() {
		ColorItem item = new ColorItemImpl();
		return item;
	}

	@Override
	public ContactItem createContactItem() {
		ContactItem item = new ContactItemImpl();
		return item;
	}

	@Override
	public DateTimeItem createDateTimeItem() {
		DateTimeItem item = new DateTimeItemImpl();
		return item;
	}

	@Override
	public DimmerItem createDimmerItem() {
		DimmerItem item = new DimmerItemImpl();
		return item;
	}

	@Override
	public GroupItem createGroupItem() {
		GroupItem item = new GroupItemImpl();
		return item;
	}

	@Override
	public NumberItem createNumberItem() {
		NumberItem item = new NumberItemImpl();
		return item;
	}

	@Override
	public RollershutterItem createRollershutterItem() {
		RollershutterItem item = new RollershutterItemImpl();
		return item;
	}

	@Override
	public StringItem createStringItem() {
		StringItem item = new StringItemImpl();
		return item;
	}

	@Override
	public SwitchItem createSwitchItem() {
		SwitchItem item = new SwitchItemImpl();
		return item;
	}

}

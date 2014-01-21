package org.openhab.designerx.model.items.impl;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.ItemFactory;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;

public final class ItemFactoryImpl implements ItemFactory {

	@Override
	public ColorItem createColorItem(String name) throws ModelException {
		ColorItem item = new ColorItemImpl(name);
		return item;
	}

	@Override
	public ContactItem createContactItem(String name) throws ModelException {
		ContactItem item = new ContactItemImpl(name);
		return item;
	}

	@Override
	public DateTimeItem createDateTimeItem(String name) throws ModelException {
		DateTimeItem item = new DateTimeItemImpl(name);
		return item;
	}

	@Override
	public DimmerItem createDimmerItem(String name) throws ModelException {
		DimmerItem item = new DimmerItemImpl(name);
		return item;
	}

	@Override
	public GroupItem createGroupItem(String name) throws ModelException {
		GroupItem item = new GroupItemImpl(name);
		return item;
	}

	@Override
	public NumberItem createNumberItem(String name) throws ModelException {
		NumberItem item = new NumberItemImpl(name);
		return item;
	}

	@Override
	public RollershutterItem createRollershutterItem(String name) throws ModelException {
		RollershutterItem item = new RollershutterItemImpl(name);
		return item;
	}

	@Override
	public StringItem createStringItem(String name) throws ModelException {
		StringItem item = new StringItemImpl(name);
		return item;
	}

	@Override
	public SwitchItem createSwitchItem(String name) throws ModelException {
		SwitchItem item = new SwitchItemImpl(name);
		return item;
	}

}

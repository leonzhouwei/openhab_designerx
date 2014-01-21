package org.openhab.designerx.model.xtdex.items.impl;

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
import org.openhab.designerx.model.xtdex.items.ItemXtdex;

public final class ItemXtdexImpl implements ItemXtdex {
	private static final ItemXtdex xtdex = new RealItemXtdexImpl();

	@Override
	public ColorItem parseColorItem(String xtext) throws ModelException {
		return xtdex.parseColorItem(xtext);
	}

	@Override
	public ContactItem parseContactItem(String xtext) throws ModelException {
		return xtdex.parseContactItem(xtext);
	}

	@Override
	public DateTimeItem parseDateTimeItem(String xtext) throws ModelException {
		return xtdex.parseDateTimeItem(xtext);
	}

	@Override
	public DimmerItem parseDimmerItem(String xtext) throws ModelException {
		return xtdex.parseDimmerItem(xtext);
	}

	@Override
	public GroupItem parseGroupItem(String xtext) throws ModelException {
		return xtdex.parseGroupItem(xtext);
	}

	@Override
	public NumberItem parseNumberItem(String xtext) throws ModelException {
		return xtdex.parseNumberItem(xtext);
	}

	@Override
	public RollershutterItem parseRollershutterItem(String xtext)
			throws ModelException {
		return xtdex.parseRollershutterItem(xtext);
	}

	@Override
	public StringItem parseStringItem(String xtext) throws ModelException {
		return xtdex.parseStringItem(xtext);
	}

	@Override
	public SwitchItem parseSwitchItem(String xtext) throws ModelException {
		return xtdex.parseSwitchItem(xtext);
	}

	@Override
	public <T extends Item> String toXtext(T item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public Item parseItem(String xtext) throws ModelException {
		return xtdex.parseItem(xtext);
	}

	@Override
	public String toXtext(ColorItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(ContactItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(DateTimeItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(DimmerItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(GroupItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(NumberItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(RollershutterItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(StringItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

	@Override
	public String toXtext(SwitchItem item) throws ModelException {
		return xtdex.toXtext(item);
	}

}

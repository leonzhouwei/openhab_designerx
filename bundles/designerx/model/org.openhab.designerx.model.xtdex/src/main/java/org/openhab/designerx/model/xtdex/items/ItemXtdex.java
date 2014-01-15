package org.openhab.designerx.model.xtdex.items;

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

public interface ItemXtdex {
	
	public ColorItem parseColorItem(String xtext);
	
	public ContactItem parseContactItem(String xtext);
	
	public DateTimeItem parseDateTimeItem(String xtext);
	
	public DimmerItem parseDimmerItem(String xtext);
	
	public GroupItem parseGroupItem(String xtext);
	
	public NumberItem parseNumberItem(String xtext);
	
	public RollershutterItem parseRollershutterItem(String xtext);
	
	public StringItem parseStringItem(String xtext);
	
	public SwitchItem parseSwitchItem(String xtext);
	
	public <T extends Item> String toXtext(T item);
	
	public Item parseItem(String xtext);

}

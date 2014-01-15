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
	
	public ColorItem parseColorItemFromXext(String xtext);
	
	public ContactItem parseContactItemFromXext(String xtext);
	
	public DateTimeItem parseDateTimeItemFromXext(String xtext);
	
	public DimmerItem parseDimmerItemFromXext(String xtext);
	
	public GroupItem parseGroupItemFromXext(String xtext);
	
	public NumberItem parseNumberItemFromXext(String xtext);
	
	public RollershutterItem parseRollershutterItemFromXext(String xtext);
	
	public StringItem parseStringItemFromXext(String xtext);
	
	public SwitchItem parseSwitchItemFromXext(String xtext);
	
	public <T extends Item> String toXtext(T item);

}

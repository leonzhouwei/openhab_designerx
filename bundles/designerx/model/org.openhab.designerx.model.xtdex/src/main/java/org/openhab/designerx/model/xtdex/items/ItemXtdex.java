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
	
	public Item parseItemFromXext(String xtext);
	
	public String toXtext(Item item);
	
	public ColorItem parseColorItemFromXext(String xtext);
	
	public String toXtext(ColorItem item);
	
	public ContactItem parseContactItemFromXext(String xtext);
	
	public String toXtext(ContactItem item);
	
	public DateTimeItem parseDateTimeItemFromXext(String xtext);
	
	public String toXtext(DateTimeItem item);
	
	public DimmerItem parseDimmerItemFromXext(String xtext);
	
	public String toXtext(DimmerItem item);
	
	public GroupItem parseGroupItemFromXext(String xtext);
	
	public String toXtext(GroupItem item);
	
	public NumberItem parseNumberItemFromXext(String xtext);
	
	public String toXtext(NumberItem item);
	
	public RollershutterItem parseRollershutterItemFromXext(String xtext);
	
	public String toXtext(RollershutterItem item);
	
	public StringItem parseStringItemFromXext(String xtext);
	
	public String toXtext(StringItem item);
	
	public SwitchItem parseSwitchItemFromXext(String xtext);
	
	public String toXtext(SwitchItem item);

}

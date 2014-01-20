package org.openhab.designerx.model.xtdex.items;

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

public interface ItemXtdex {
	
	public ColorItem parseColorItem(String xtext) throws ModelException;
	
	public ContactItem parseContactItem(String xtext) throws ModelException;
	
	public DateTimeItem parseDateTimeItem(String xtext) throws ModelException;
	
	public DimmerItem parseDimmerItem(String xtext) throws ModelException;
	
	public GroupItem parseGroupItem(String xtext) throws ModelException;
	
	public NumberItem parseNumberItem(String xtext) throws ModelException;
	
	public RollershutterItem parseRollershutterItem(String xtext) throws ModelException;
	
	public StringItem parseStringItem(String xtext) throws ModelException;
	
	public SwitchItem parseSwitchItem(String xtext) throws ModelException;
	
	public <T extends Item> String toXtext(T item) throws ModelException;
	
	public Item parseItem(String xtext) throws ModelException;
	
	public String toXtext(ColorItem item) throws ModelException;
	
	public String toXtext(ContactItem item) throws ModelException;
	
	public String toXtext(DateTimeItem item) throws ModelException;
	
	public String toXtext(DimmerItem item) throws ModelException;
	
	public String toXtext(GroupItem item) throws ModelException;
	
	public String toXtext(NumberItem item) throws ModelException;
	
	public String toXtext(RollershutterItem item) throws ModelException;
	
	public String toXtext(StringItem item) throws ModelException;
	
	public String toXtext(SwitchItem item) throws ModelException;

}

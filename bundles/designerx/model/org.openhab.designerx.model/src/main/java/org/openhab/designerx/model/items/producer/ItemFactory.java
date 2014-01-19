package org.openhab.designerx.model.items.producer;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;

public interface ItemFactory {

	public ColorItem createColorItem(String name) throws ModelException;

	public ContactItem createContactItem(String name) throws ModelException;

	public DateTimeItem createDateTimeItem(String name) throws ModelException;

	public DimmerItem createDimmerItem(String name) throws ModelException;

	public GroupItem createGroupItem(String name) throws ModelException;

	public NumberItem createNumberItem(String name) throws ModelException;

	public RollershutterItem createRollershutterItem(String name) throws ModelException;

	public StringItem createStringItem(String name) throws ModelException;

	public SwitchItem createSwitchItem(String name) throws ModelException;
	
}

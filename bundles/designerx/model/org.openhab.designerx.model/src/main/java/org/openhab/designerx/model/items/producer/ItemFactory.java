package org.openhab.designerx.model.items.producer;

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

	public ColorItem createColorItem();

	public ContactItem createContactItem();

	public DateTimeItem createDateTimeItem();

	public DimmerItem createDimmerItem();

	public GroupItem createGroupItem();

	public NumberItem createNumberItem();

	public RollershutterItem createRollershutterItem();

	public StringItem createStringItem();

	public SwitchItem createSwitchItem();
	
}

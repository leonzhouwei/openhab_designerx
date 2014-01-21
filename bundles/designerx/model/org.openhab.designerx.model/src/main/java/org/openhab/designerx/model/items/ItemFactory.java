package org.openhab.designerx.model.items;

import org.openhab.designerx.model.ModelException;

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

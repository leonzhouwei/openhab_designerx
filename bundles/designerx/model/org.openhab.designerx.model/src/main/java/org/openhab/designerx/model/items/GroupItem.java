package org.openhab.designerx.model.items;

public interface GroupItem extends Item {
	
	public final String TYPE_NAME = "Group";
	
	public void setExtraTypeName(String extra);
	
	public String getExtraTypeName();

}

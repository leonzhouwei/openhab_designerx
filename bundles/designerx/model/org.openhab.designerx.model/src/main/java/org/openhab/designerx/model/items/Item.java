package org.openhab.designerx.model.items;

import java.util.List;

public interface Item {
	
	public String getTypeName();
	
	public void setName(String name);

	public String getName();
	
	public void setLabelText(String labelText);

	public String getLabelText();
	
	public void setIconName(String iconName);

	public String getIconName();
	
	public List<String> getGroups();

	public void addGroups(List<String> groups);

	public void addGroup(String group);

	public String getBindingConfig();
	
	public void setBindingConfig(String bindingConfig);

}

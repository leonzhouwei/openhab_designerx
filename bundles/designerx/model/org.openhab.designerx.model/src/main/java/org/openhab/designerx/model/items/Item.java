package org.openhab.designerx.model.items;

import java.util.List;

import org.openhab.designerx.model.ModelException;

public interface Item {
	
	public String getTypeName();
	
	public void setName(String name) throws ModelException;

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

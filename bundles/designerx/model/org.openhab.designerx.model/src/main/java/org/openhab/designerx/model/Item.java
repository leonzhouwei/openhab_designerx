package org.openhab.designerx.model;

import java.util.List;

public interface Item {

	public String getType();

	public String getName();

	public String getLabelText();

	public String getIconName();

	public List<String> getGroups();

	public String getBindingConfig();

	public void addGroups(String[] groups);

	public void addGroup(String group);

}

package org.openhab.designerx.model.sitemap;

public interface Mapping {
	
	public String getCmd();

	public void setCmd(String cmd);

	public String getLabel();

	public void setLabel(String label);
	
	public boolean equalsLogically(Mapping another);

}

package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.sitemap.Mapping;

final class MappingImpl implements Mapping {
	private String cmd;
	private String label;
	
	@Override
	public String getCmd() {
		return cmd;
	}

	@Override
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}
	
}

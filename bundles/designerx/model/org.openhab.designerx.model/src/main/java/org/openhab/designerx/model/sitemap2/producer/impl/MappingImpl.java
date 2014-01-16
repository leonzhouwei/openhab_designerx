package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.Mapping;

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

package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.util.Comparer;

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

	@Override
	public boolean equalsLogically(Mapping another) {
		if (!(another instanceof Mapping)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		final String anotherCmd = another.getCmd();
		if (Comparer.notEqual(cmd, anotherCmd)) {
			return false;
		}
		final String anotherLabel = another.getLabel();
		if (Comparer.notEqual(label, anotherLabel)) {
			return false;
		}
		return true;
	}
	
}

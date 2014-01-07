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

	@Override
	public boolean equalsLogically(Mapping another) {
		if (!(another instanceof Mapping)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		final String anotherCmd = another.getCmd();
		if (cmd == null && anotherCmd != null ||
			cmd != null && anotherCmd == null ||
			cmd != null && anotherCmd != null && cmd.compareTo(anotherCmd) != 0) {
			return false;
		}
		final String anotherLabel = another.getLabel();
		if (label == null && anotherLabel != null ||
			label != null && anotherLabel == null ||
			label != null && anotherLabel != null && label.compareTo(anotherLabel) != 0) {
			return false;
		}
		return true;
	}
	
}

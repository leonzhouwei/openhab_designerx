package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.Mapping;
import org.openhab.designerx.model.sitemap2.producer.MappingBuilder;

final class MappingBuilderImpl implements MappingBuilder {
	
	@Override
	public Mapping build() {
		return new MappingImpl();
	}
	
	private class MappingImpl implements Mapping {
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

}

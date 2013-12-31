package org.openhab.designerx.model.atomxtextconvert;

import com.google.common.collect.ImmutableSet;

final class Constants {
	
	public static final ImmutableSet<String> COMMON_ELEMENT_KEYWORDS = ImmutableSet.<String> builder()
			.add("item=")
			.add("label=")
			.add("icon=")
			.add("labelColor=")
			.add("valueColor=")
			.add("visibility=")
			.build();
	
	private Constants() {}

}

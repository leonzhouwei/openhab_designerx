package org.openhab.designerx.model.sitemap.childlesselement.xtext;

final class Extractor {
	
	public static String extract(String xtext, String keyword, String regex) {
		if (!xtext.contains(keyword)) {
			return null;
		}
		xtext = xtext.trim();
		String[] split = xtext.split(regex);
		String value = null;
		if (split.length == 2) {
			String post = split[1];
			final int i = xtext.indexOf(keyword);
			final int j = xtext.indexOf(post);
			value = xtext.substring(i + keyword.length(), j).trim();
		} else {
			final int i = xtext.indexOf(keyword);
			value = xtext.substring(i + keyword.length()).trim();
		}
		return value;
	}
	
	private Extractor() {}
	
}

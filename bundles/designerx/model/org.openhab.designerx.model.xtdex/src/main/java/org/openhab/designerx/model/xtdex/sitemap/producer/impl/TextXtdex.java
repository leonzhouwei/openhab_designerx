package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Text item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [valuecolor=xxxx]
 * 
 * @author zhouwei
 *
 */
final class TextXtdex {
	private static final String MATCH_REGEX = "\\s*" + Text.TYPE_NAME + "\\b.*";
	
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isText(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static Text parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Text.TYPE_NAME)) {
			return null;
		}
		Text instance = factory.createText();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		return instance;
	}

	static String toXtextIgnoringChildren(Text e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		return sb.toString().trim();
	}

	private TextXtdex() {}

}

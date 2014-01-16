package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Text;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

/**
 * 
 * Syntax:
 * Text item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [valuecolor=xxxx]
 * 
 * @author zhouwei
 *
 */
public final class TextXtdex {
	private static final String MATCH_REGEX = "\\s*" + Text.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	public static Text fromXtext(NestableElementXtextKeeper keeper) throws ModelXtdexException {
		ImmutableList<String> xtext = keeper.getXtext();
		String firstLine = xtext.get(0);
		if (!firstLine.startsWith(Text.TYPE_NAME)) {
			return null;
		}
		Text instance = factory.createText();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, new NonNestableElementXtextKeeper(firstLine));
		// set the specific parameters
		return instance;
	}
	
	private TextXtdex() {}
	
	public static boolean isText(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static Element parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
		Element e = null;
		
		return e;
	}
	
}

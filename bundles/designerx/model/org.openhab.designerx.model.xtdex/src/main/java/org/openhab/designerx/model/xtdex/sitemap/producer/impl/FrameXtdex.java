package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Frame;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

/**
 * 
 * Syntax:
 * Frame [label="<labelname>"] [icon="<icon>"] [item="<item">]
 * 
 * @author zhouwei
 *
 */
public final class FrameXtdex {
	private static final String MATCH_REGEX = "\\s*" + Frame.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	public static Frame fromXtext(NestableElementXtextKeeper keeper) throws ModelXtdexException {
		ImmutableList<String> xtext = keeper.getXtext();
		String firstLine = xtext.get(0);
		if (!firstLine.startsWith(Frame.TYPE_NAME)) {
			return null;
		}
//		Frame instance = factory.createFrame();
//		// set the elementary parameters
//		ElementXtdexImpl.fillWithoutChildren(instance, new NonNestableElementXtextKeeper(firstLine));
//		return instance;
		return (Frame) ElementXtdexImpl.parseChildlfulElement(xtext, 0, xtext.size() - 1);
	}
	
	private FrameXtdex() {}
	
	public static boolean isFrame(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static Element parseIgnoringChildren(NonNestableElementXtextKeeper keeper) throws ModelXtdexException {
		String firstLine = keeper.getXtext();
		if (!firstLine.startsWith(Frame.TYPE_NAME)) {
			return null;
		}
		Frame instance = factory.createFrame();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, new NonNestableElementXtextKeeper(firstLine));
		return instance;
	}
	
	static String toXtextIgnoringChildren(Frame e) {
		StringBuilder sb = new StringBuilder();
		sb.append(ElementXtdexImpl.toXtextIgnoringChildren(e, ""));
		return sb.toString();
	}

}

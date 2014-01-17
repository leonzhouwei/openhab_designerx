package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Frame [label="<labelname>"] [icon="<icon>"] [item="<item">]
 * 
 * @author zhouwei
 *
 */
final class FrameXtdex {
	private static final String MATCH_REGEX = "\\s*" + Frame.TYPE_NAME + "\\b.*";
	
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	static boolean isFrame(ChildfulElementXtextKeeper keeper) {
		String xtext = keeper.getXtext().get(0);
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static <T extends Element> boolean isFrame(T e) {
		boolean result = false;
		if (e instanceof Frame) {
			result = true;
		}
		return result;
	}

	static Frame parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.matches(MATCH_REGEX)) {
			return null;
		}
		Frame instance = factory.createFrame();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		return instance;
	}

	static String toXtextIgnoringChildren(Frame e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		return sb.toString().trim();
	}

	private FrameXtdex() {}

}

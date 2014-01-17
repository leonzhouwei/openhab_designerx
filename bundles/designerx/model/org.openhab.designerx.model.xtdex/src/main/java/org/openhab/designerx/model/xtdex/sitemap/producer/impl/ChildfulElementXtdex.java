package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

final class ChildfulElementXtdex {
	
	static boolean isChildfulElement(ChildfulElementXtextKeeper keeper) {
		boolean result = false;
		if (FrameXtdex.isFrame(keeper)) {
			result = true;
		} else if (GroupXtdex.isGroup(keeper)) {
			result = true;
		} else if (ImageXtdex.isImage(keeper)) {
			result = true;
		} else if (TextXtdex.isText(keeper)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static Element parse(ChildfulElementXtextKeeper keeper) throws ModelXtdexException {
		Element result = null;
		if (isChildfulElement(keeper)) {
			ImmutableList<String> xtext = keeper.getXtext();
			result = parse(xtext);
		}
		return result;
	}
	
	private static Element parse(ImmutableList<String> xtext) throws ModelXtdexException {
		String line = xtext.get(0).trim();
		Element root = parseIgnoringChildren(new ChildfulElementXtextKeeper(new ChildlessElementXtextKeeper(line).getXtext()));
		if (root == null) {
			return null;
		}
		int i = 1;
		final int size = xtext.size();
		while (i > 0 && i < size - 1) {
			String s = xtext.get(i);
			ChildlessElementXtextKeeper childlessKeeper = new ChildlessElementXtextKeeper(s);
			if (ChildlessElementXtdex.isChildlessElement(childlessKeeper)) {
				Element child = ChildlessElementXtdex.parse(childlessKeeper);
				root.addChild(child);
				i += 1;
				continue;
			}
			if (s.endsWith("{")) {
				final int end = endIndexOf(xtext, i);
				ImmutableList<String> list = xtext.subList(i, end + 1);
				Element child = parse(list);
				root.addChild(child);
				i = end + 1;
				continue;
			}
			ChildfulElementXtextKeeper childfulKeeper = new ChildfulElementXtextKeeper(childlessKeeper.getXtext());
			if (isChildfulElement(childfulKeeper)) {
				// it is an element that can have children but do not have
				Element child = parseIgnoringChildren(childfulKeeper);
				root.addChild(child);
				i += 1;
				continue;
			}
			break;
		}
		return root;
	}
	
	static <T extends Element> boolean isChildfulElement(T e) {
		boolean result = false;
		if (FrameXtdex.isFrame(e)) {
			result = true;
		} else if (GroupXtdex.isGroup(e)) {
			result = true;
		} else if (ImageXtdex.isImage(e)) {
			result = true;
		} else if (TextXtdex.isText(e)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static <T extends Element> String toXtext(T e) {
		String result = null;
		if (isChildfulElement(e)) {
			
		}
		return result;
	}
	
	static Element parseIgnoringChildren(ChildfulElementXtextKeeper keeper) throws ModelXtdexException {
		Element result = null;
		ChildlessElementXtextKeeper childlessKeeper = new ChildlessElementXtextKeeper(keeper.getXtext().get(0));
		if (FrameXtdex.isFrame(keeper)) {
			result = FrameXtdex.parseIgnoringChildren(childlessKeeper);
		} else if (GroupXtdex.isGroup(keeper)) {
			result = GroupXtdex.parseIgnoringChildren(childlessKeeper);
		} else if (ImageXtdex.isImage(keeper)) {
			result = ImageXtdex.parseIgnoringChildren(childlessKeeper);
		} else if (TextXtdex.isText(keeper)) {
			result = TextXtdex.parseIgnoringChildren(childlessKeeper);
		} else {
			result = null;
		}
		return result;
	}
	
	private static int endIndexOf(ImmutableList<String> list, final int start) {
		if (!list.get(start).trim().endsWith("{")) {
			return start;
		}
		int end = -1;
		int unpairedOpenBraceCount = 1;
		final int size = list.size();
		for (int i = start + 1; i < size && unpairedOpenBraceCount != 0; ++i) {
			String s = list.get(i).trim();
			if (s.compareTo("}") == 0) {
				end = i;
				unpairedOpenBraceCount -= 1;
			}
			if (s.endsWith("{")) {
				unpairedOpenBraceCount += 1;
			}
		}
		return end;
	}
	
	private ChildfulElementXtdex() {}

}

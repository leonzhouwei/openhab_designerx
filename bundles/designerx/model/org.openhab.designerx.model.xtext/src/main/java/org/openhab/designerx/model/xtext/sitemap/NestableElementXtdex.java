package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.Text;

import com.google.common.collect.ImmutableSet;

final class NestableElementXtdex {
	
	private static ImmutableSet<String> validTypeNames = ImmutableSet.<String>builder()
			.add(FrameXtdex.TARGET_TYPE_NAME)
			.add(GroupXtdex.TARGET_TYPE_NAME)
			.add(ImageXtdex.TARGET_TYPE_NAME)
			.add(TextXtdex.TARGET_TYPE_NAME)
			.build();
	
	private static final String DEFAULT_INDENTATION = "    ";
	
	static NestableElement fromXtext(NestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static NestableElement fromXtextWithoutChildren(String xtext) {
		xtext = xtext.trim();
		if (xtext.startsWith(FrameXtdex.TARGET_TYPE_NAME)) {
			return FrameXtdex.fromXtextWithoutChildren(xtext);
		}
		if (xtext.startsWith(GroupXtdex.TARGET_TYPE_NAME)) {
			return GroupXtdex.fromXtextWithoutChildren(xtext);
		}
		if (xtext.startsWith(ImageXtdex.TARGET_TYPE_NAME)) {
			return ImageXtdex.fromXtextWithoutChildren(xtext);
		}
		if (xtext.startsWith(TextXtdex.TARGET_TYPE_NAME)) {
			return TextXtdex.fromXtextWithoutChildren(xtext);
		}
		return null;
	}
	
	static boolean isNestableElement(String xtext) {
		boolean result = false;
		xtext = xtext.trim();
		for (String type : validTypeNames) {
			if (xtext.startsWith(type)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	static NestableElement fromXtext(List<String> xtext) {
		String line = xtext.get(0).trim();
		if (!isNestableElement(line)) {
			return null;
		}
		NestableElement root = fromXtextWithoutChildren(line);
		int i = 1;
		final int size = xtext.size();
		while (i > 0 && i < size) {
			String s = xtext.get(i).trim();
			if (NonNestableElementXtdex.isNonNestableElement(s)) {
				Element child = NonNestableElementXtdex.fromXtext(s);
				root.appendChild(child);
				i += 1;
				continue;
			}
			if (s.endsWith("{")) {
				final int end = endIndexOf(xtext, i);
				List<String> list = xtext.subList(i, end + 1);
				NestableElement child = fromXtext(list);
				root.appendChild(child);
				i = end + 1;
				continue;
			}
			if (NestableElementXtdex.isNestableElement(s)) {
				NestableElement child = fromXtextWithoutChildren(s);
				root.appendChild(child);
				i += 1;
				continue;
			}
			break;
		}
		return root;
	}
	
	static int endIndexOf(List<String> list, final int start) {
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
	
	static String toXtext(NestableElement e, String indentation) {
		StringBuilder sb = new StringBuilder();
		if (e instanceof Frame) {
			sb.append(indentation + FrameXtdex.toXtextWithoutChildren((Frame) e));
		} else if (e instanceof Group) {
			sb.append(indentation + GroupXtdex.toXtextWithoutChildren((Group) e));
		} else if (e instanceof Image) {
			sb.append(indentation + ImageXtdex.toXtextWithoutChildren((Image) e));
		} else if (e instanceof Text) {
			sb.append(indentation + TextXtdex.toXtextWithoutChildren((Text) e));
		}
		if (!e.getChildren().isEmpty()) {
			sb.append(" {");
			sb.append(Constants.LINE_SEPARATOR);
			List<Element> children = e.getChildren();
			for (Element v : children) {
				if (v instanceof NonNestableElement) {
					String s = NonNestableElementXtdex.toXtext((NonNestableElement) v);
					sb.append(indentation + DEFAULT_INDENTATION + s);
					sb.append(Constants.LINE_SEPARATOR);
				} else if (v instanceof NestableElement) {
					String s = toXtext((NestableElement) v, indentation + DEFAULT_INDENTATION);
					sb.append(s);
					sb.append(Constants.LINE_SEPARATOR);
				}
			}
			sb.append(indentation + "}");
		}
		return sb.toString();
	}

}

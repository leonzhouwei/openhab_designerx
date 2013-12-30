package org.openhab.designerx.model.sitemap.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class Separator {

	public static Map<String, String> separate(String string, ImmutableSet<String> keywords) {
		string = string.trim();
		Map<String, String> result = Maps.newHashMap();
		for (String key : keywords) {
			result.put(key, null);
		}
		final int keyCount = keywords.size();
		if (keyCount == 1) {
			String key = keywords.iterator().next();
			String[] array = string.split(key);
			result.put(key, array[1].trim());
			return result;
		}
		// parse effective key-startIndex pairs from @string
		Map<Integer, String> effectiveIndexKeyPairs = Maps.newHashMap();
		Iterator<String> iterator = keywords.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int index = string.indexOf(key);
			if (index != -1) {
				effectiveIndexKeyPairs.put(index, key.trim());
			}
		}
		if (effectiveIndexKeyPairs.isEmpty()) {
			return result;
		}
		List<Integer> orderedIndexes = Lists.newArrayList();
		orderedIndexes.addAll(effectiveIndexKeyPairs.keySet());
		Collections.sort(orderedIndexes);
		
		// extract keys and related values pairs before the last pair
		final int size = orderedIndexes.size();
		for (int i = 0; i < size - 1; ++i) {
			final int start = orderedIndexes.get(i) + effectiveIndexKeyPairs.get(orderedIndexes.get(i)).length();
			final String key = effectiveIndexKeyPairs.get(orderedIndexes.get(i));
			final String value = string.substring(start, orderedIndexes.get(i + 1));
			result.put(key, value.trim());
		}
		// extract the last pair
		final int start = orderedIndexes.get(size - 1) + effectiveIndexKeyPairs.get(orderedIndexes.get(size - 1)).length();
		final String key = effectiveIndexKeyPairs.get(orderedIndexes.get(size - 1));
		final String value = string.substring(start, string.length());
		result.put(key, value.trim());
		// remove properties that did NOT appear in the text line
		Set<String> set = result.keySet();
		List<String> list = Lists.newArrayList();
		list.addAll(set);
		for (String s : list) {
			String v = result.get(s);
			if (v == null) {
				result.remove(s);
			}
		}
		return result;
	}
	
	private Separator() {}
	
}

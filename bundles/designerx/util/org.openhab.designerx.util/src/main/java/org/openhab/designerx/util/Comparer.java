package org.openhab.designerx.util;

public final class Comparer {
	
	public static <T extends Comparable<T>> boolean equal(T one, T another) {
		if (one == another || (one != null && another != null && one.compareTo(another) == 0)) {
			return true;
		}
		return false;
	}
	
	public static <T extends Comparable<T>> boolean notEqual(T one, T another) {
		return !equal(one, another);
	}
	
	private Comparer() {}

}

package org.openhab.designerx.util;

public final class IdGenerator {
	public class NoAvailableIdExeption extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1635643964411083392L;
	}
	
	private long nextId = 1; // [1, Long.MAX_VALUE]

	public synchronized long newId() throws NoAvailableIdExeption {
		if (nextId == Long.MAX_VALUE) {
			throw new NoAvailableIdExeption();
		}
		long ret = nextId;
		nextId += 1;
		return ret;
	}
	
}

package org.openhab.designerx.domainobject;

public final class DomainObjectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8278549791573599372L;
	
	public DomainObjectException(String msg) {
		super(msg);
	}
	
	public DomainObjectException(Exception e) {
		DomainObjectException doe = new DomainObjectException(e.getMessage());
		doe.initCause(e);
	}

}

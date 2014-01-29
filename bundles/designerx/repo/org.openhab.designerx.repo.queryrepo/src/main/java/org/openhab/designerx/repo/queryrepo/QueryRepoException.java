package org.openhab.designerx.repo.queryrepo;

public final class QueryRepoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5291255114327647954L;
	
	public QueryRepoException(String msg) {
		super(msg);
	}
	
	public <T extends Exception> QueryRepoException(T e) {
		super(e);
	}

}

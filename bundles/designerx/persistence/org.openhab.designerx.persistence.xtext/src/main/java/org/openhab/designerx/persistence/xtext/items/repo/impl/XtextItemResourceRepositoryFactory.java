package org.openhab.designerx.persistence.xtext.items.repo.impl;

import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;

public final class XtextItemResourceRepositoryFactory {
	private static final XtextItemResourceRepository repo = XtextItemResourceRepositoryImpl.getInstance();
	
	public static XtextItemResourceRepository create() {
		return repo;
	}
	
	private XtextItemResourceRepositoryFactory() {}
}

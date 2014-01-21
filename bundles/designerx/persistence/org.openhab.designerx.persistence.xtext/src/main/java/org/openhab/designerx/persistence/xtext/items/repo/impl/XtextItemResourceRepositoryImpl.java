package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.File;

import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;

final class XtextItemResourceRepositoryImpl implements XtextItemResourceRepository {
	private static final XtextItemResourceRepository instance = new XtextItemResourceRepositoryImpl();
	
	static XtextItemResourceRepository getInstance() {
		return instance;
	}

	@Override
	public XtextItemResource find(String name) {
		return new XtextItemResourceImpl(name);
	}
	
	@Override
	public XtextItemResource find(File file) {
		return new XtextItemResourceImpl(file);
	}
	
	private XtextItemResourceRepositoryImpl() {}

}

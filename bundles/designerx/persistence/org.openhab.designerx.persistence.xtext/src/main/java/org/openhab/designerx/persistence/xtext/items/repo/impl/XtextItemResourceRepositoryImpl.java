package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.util.Set;

import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;

public final class XtextItemResourceRepositoryImpl implements XtextItemResourceRepository {
	private static final XtextItemResourceRepository real = RealXtextItemResourceRepositoryImpl.getInstance();
	
	private static final XtextItemResourceRepositoryImpl instance = new XtextItemResourceRepositoryImpl();
	
	public static XtextItemResourceRepository getInstance() {
		return instance;
	}
	
	@Override
	public XtextItemResource find(String name) {
		return real.find(name);
	}

	@Override
	public Set<String> nameSet() {
		return real.nameSet();
	}

	private XtextItemResourceRepositoryImpl() {}
}

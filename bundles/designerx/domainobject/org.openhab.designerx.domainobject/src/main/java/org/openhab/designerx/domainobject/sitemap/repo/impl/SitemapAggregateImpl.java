package org.openhab.designerx.domainobject.sitemap.repo.impl;

import org.openhab.designerx.domainobject.DomainObjectConstansts;
import org.openhab.designerx.domainobject.DomainObjectException;
import org.openhab.designerx.domainobject.sitemap.SitemapAggregate;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.impl.XtextSitemapRepositoryFactory;

final class SitemapAggregateImpl implements SitemapAggregate {
	private final long id;
	private Sitemap data;
	private XtextSitemap persist;
	
	SitemapAggregateImpl(long id, String name) throws DomainObjectException {
		if (id < 0) {
			throw new DomainObjectException("id '" + id + "' is minus");
		}
		this.id = id;
		persist = XtextSitemapRepositoryFactory.create().find(name);
		try {
			data = persist.get();
		} catch (Exception e) {
			throw new DomainObjectException(e);
		}
	}
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public <T extends Element> void add(T e) throws DomainObjectException {
		try {
			data.appendChild(e);
			persist.save(data);
		} catch (Exception excpetion) {
			throw new DomainObjectException(excpetion);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append(DomainObjectConstansts.LINE_SEPARATOR);
		SitemapXtdex xtdex = new SitemapXtdexImpl();
		sb.append(xtdex.toXtext(data));
		return sb.toString();
	}

}

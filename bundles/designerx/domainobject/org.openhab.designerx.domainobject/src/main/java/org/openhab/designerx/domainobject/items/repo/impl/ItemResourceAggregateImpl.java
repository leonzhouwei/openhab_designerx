package org.openhab.designerx.domainobject.items.repo.impl;

import org.openhab.designerx.domainobject.DomainObjectConstansts;
import org.openhab.designerx.domainobject.DomainObjectException;
import org.openhab.designerx.domainobject.items.ItemResourceAggregate;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.impl.XtextItemResourceRepositoryFactory;

final class ItemResourceAggregateImpl implements ItemResourceAggregate {
	private final long id;
	private ItemResource data;
	private XtextItemResource persist;
	
	ItemResourceAggregateImpl(long id, String name) throws DomainObjectException {
		if (id < 0) {
			throw new DomainObjectException("id '" + id + "' is minus");
		}
		this.id = id;
		persist = XtextItemResourceRepositoryFactory.create().find(name);
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
	public <T extends Item> void add(T item) {
		data.append(item);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append(DomainObjectConstansts.LINE_SEPARATOR);
		sb.append("items:");
		sb.append(DomainObjectConstansts.LINE_SEPARATOR);
		ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
		try {
			sb.append(xtdex.toXtext(data));
		} catch (ModelException e) {
			// no operatiosn
		}
		return sb.toString();
	}

}

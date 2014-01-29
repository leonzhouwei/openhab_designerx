package org.openhab.designerx.bizlogic.cqrs.eventbus.impl;

import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Subscriber;

final class RealEventBusImpl implements EventBus {
	
	private static final RealEventBusImpl instance = new RealEventBusImpl();
	
	RealEventBusImpl getInstance() {
		return instance;
	}

	@Override
	public void addPublisher(Publisher pub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSubscriber(Subscriber sub) {
		// TODO Auto-generated method stub
		
	}

	private RealEventBusImpl() {}
}

package org.openhab.designerx.bizlogic.cqrs.eventbus.impl;

import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Subscriber;

public final class EventBusImpl implements EventBus {
	private static final EventBus real = RealEventBusImpl.getInstance();
	
	private static final EventBusImpl instance = new EventBusImpl();
	
	public static EventBus getInstance() {
		return instance;
	}
	
	@Override
	public <T extends Subscriber> void addSubscriber(T subscriber) {
		real.addSubscriber(subscriber);
	}

	@Override
	public Publisher newPublisher() {
		return real.newPublisher();
	}
	
	private EventBusImpl() {}
}

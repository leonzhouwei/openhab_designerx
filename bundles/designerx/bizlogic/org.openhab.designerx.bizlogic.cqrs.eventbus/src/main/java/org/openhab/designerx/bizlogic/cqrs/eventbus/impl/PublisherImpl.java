package org.openhab.designerx.bizlogic.cqrs.eventbus.impl;

import org.openhab.designerx.bizlogic.cqrs.eventbus.Event;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;

final class PublisherImpl implements Publisher {
	private RealEventBusImpl bus = RealEventBusImpl.getInstance();
	
	@Override
	public <T extends Event> void publish(T event) {
		bus.send(event);
	}

}

package org.openhab.designerx.bizlogic.cqrs.eventbus.impl;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.openhab.designerx.bizlogic.cqrs.eventbus.Event;
import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Subscriber;

import com.google.common.collect.Queues;

final class RealEventBusImpl implements EventBus {
	private static final ConcurrentLinkedQueue<Subscriber> subs = Queues.newConcurrentLinkedQueue();
	
	private static final RealEventBusImpl instance = new RealEventBusImpl();
	
	static RealEventBusImpl getInstance() {
		return instance;
	}

	@Override
	public <T extends Subscriber> void addSubscriber(T subscriber) {
		subs.add(subscriber);
	}
	
	void send(Event event) {
		Iterator<Subscriber> it = subs.iterator();
		while (it.hasNext()) {
			try {
				Subscriber s = it.next();
				s.eventHandler().handle(event);
			} catch (Exception e) {
				// TODO
			}
		}
	}
	
	private RealEventBusImpl() {}

	@Override
	public Publisher newPublisher() {
		return new PublisherImpl();
	}
}

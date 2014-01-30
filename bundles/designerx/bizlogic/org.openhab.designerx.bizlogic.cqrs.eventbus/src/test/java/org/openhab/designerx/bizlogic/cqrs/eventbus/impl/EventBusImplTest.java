package org.openhab.designerx.bizlogic.cqrs.eventbus.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Event;
import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Subscriber;

public class EventBusImplTest {
	private static final EventBus bus = EventBusImpl.getInstance();
	
	private class HelloEvent implements Event {
		private final String msg;
		
		public HelloEvent(String msg) {
			this.msg = msg;
		}
		
		@Override
		public String toString() {
			return msg;
		}
	}
	
	@Test
	public void test() {
		final String expected = "hello";
		bus.addSubscriber(new Subscriber() {
			@Override
			public <T extends Event> void receive(T event) {
				final String actual = event.toString();
				assertThat(actual, Matchers.equalTo(expected));
			}
		});
		HelloEvent he = new HelloEvent(expected);
		Publisher pub = bus.newPublisher();
		pub.publish(he);
	}

}

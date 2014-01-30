package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface EventBus {
	
	public <T extends Subscriber> void addSubscriber(T subscriber);
	
	public Publisher newPublisher();

}

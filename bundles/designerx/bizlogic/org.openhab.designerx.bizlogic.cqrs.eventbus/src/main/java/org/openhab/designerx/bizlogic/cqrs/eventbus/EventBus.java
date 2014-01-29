package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface EventBus {
	
	public void addPublisher(Publisher pub);
	
	public void addSubscriber(Subscriber sub);

}

package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface Subscriber {
	
	public <T extends Event> void receive(T event);

}

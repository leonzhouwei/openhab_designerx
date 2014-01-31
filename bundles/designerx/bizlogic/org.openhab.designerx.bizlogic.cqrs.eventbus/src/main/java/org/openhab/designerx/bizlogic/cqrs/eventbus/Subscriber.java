package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface Subscriber {
	
	public EventHandler eventHandler();
	
}

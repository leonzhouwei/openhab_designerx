package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface Publisher {
	
	public <T extends Event> void publish(T event);

}

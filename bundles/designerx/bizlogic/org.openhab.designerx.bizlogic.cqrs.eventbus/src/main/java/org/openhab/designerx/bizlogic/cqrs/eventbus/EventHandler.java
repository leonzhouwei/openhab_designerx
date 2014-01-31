package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface EventHandler {
	
	public <T extends Event> void handle(T event);

}

package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface ItemResourceUpdatedEvent extends Event {
	
	public String itemResourceName();
	
	public String itemResourceXtext();

}

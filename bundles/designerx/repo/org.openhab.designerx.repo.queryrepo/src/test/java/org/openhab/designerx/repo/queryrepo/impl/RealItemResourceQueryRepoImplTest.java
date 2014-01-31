package org.openhab.designerx.repo.queryrepo.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.ItemResourceUpdatedEvent;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;
import org.openhab.designerx.bizlogic.cqrs.eventbus.impl.EventBusImpl;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;

public class RealItemResourceQueryRepoImplTest {
	private static final RealItemResourceQueryRepoImpl repo = RealItemResourceQueryRepoImpl.getInstance();
	private static final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	private static final EventBus eventBus = EventBusImpl.getInstance();

	@Test
	public void testUpdate() {
		final String itemResourceName = "test";
		final String expected = "Number test_text_updated";
		//
		Publisher pub = eventBus.newPublisher();
		pub.publish(new ItemResourceUpdatedEvent() {
			@Override
			public String itemResourceName() {
				return itemResourceName;
			}
			
			@Override
			public String itemResourceXtext() {
				ItemResource ir = null;
				try {
					ir = xtdex.fromXtext(itemResourceName, expected);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return xtdex.toXtext(ir);
			}
		});
		//
		String actual = xtdex.toXtext(repo.getReplicaByName("test")).trim();
		assertThat(actual, Matchers.equalTo(expected));
	}

}

package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public class ElementFillerTest {
	private static ElementFactory factory = new ElementFactoryImpl();
	
//	@Test
	public void testFillWithoutChildren_1() throws ModelXtdexException {
		final String expected = "Chart item=Weather_Chart";
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

//	@Test
	public void testFillWithoutChildren_2() throws ModelXtdexException {
		final String expected = "Chart item=Weather_Chart valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]";
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testFillWithoutChildren_3() throws ModelXtdexException {
		final String expected = "Chart item=Weather_Chart visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"]";
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}

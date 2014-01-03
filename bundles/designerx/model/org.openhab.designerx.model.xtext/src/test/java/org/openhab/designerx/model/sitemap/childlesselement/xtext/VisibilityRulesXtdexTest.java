package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.VisibilityRuleBuilder;

import com.google.common.collect.Lists;

public class VisibilityRulesXtdexTest {

	@Test
	public void testFromXtext() {
		final String expected = "visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"]";
		List<VisibilityRule> list = Lists.newArrayList();
		VisibilityRule e = null;
		e = new VisibilityRuleBuilder().build();
		e.setItem("Weather_Chart_Period");
		e.setCondition("==0");
		list.add(e);
		e = new VisibilityRuleBuilder().build();
		e.setItem("Weather_Chart_Period");
		e.setCondition("==\"Uninitialized\"");
		list.add(e);
		final String actual = VisibilityRulesXtdex.toXtext(list, Constants.VISIBILITY);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testToXtext_1() {
		final String expected = "visibility=[Weather_Chart_Period==0]";
		List<VisibilityRule> list = Lists.newArrayList();
		VisibilityRule e = null;
		e = new VisibilityRuleBuilder().build();
		e.setItem("Weather_Chart_Period");
		e.setCondition("==0");
		list.add(e);
		final String actual = VisibilityRulesXtdex.toXtext(list, Constants.VISIBILITY);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testToXtext_2() {
		final String expected = "visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"]";
		List<VisibilityRule> list = Lists.newArrayList();
		VisibilityRule e = null;
		e = new VisibilityRuleBuilder().build();
		e.setItem("Weather_Chart_Period");
		e.setCondition("==0");
		list.add(e);
		e = new VisibilityRuleBuilder().build();
		e.setItem("Weather_Chart_Period");
		e.setCondition("==\"Uninitialized\"");
		list.add(e);
		final String actual = VisibilityRulesXtdex.toXtext(list, Constants.VISIBILITY);
		assertThat(actual, Matchers.equalTo(expected));
	}

}

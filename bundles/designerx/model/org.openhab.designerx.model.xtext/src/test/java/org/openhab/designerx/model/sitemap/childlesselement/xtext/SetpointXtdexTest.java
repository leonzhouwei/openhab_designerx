package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.impl.SetpointBuilder;

public class SetpointXtdexTest {

	@Test
	public void testFromXtext() {
		final String item = "Temperature_Setpoint";
		final BigDecimal min = new BigDecimal("16");
		final BigDecimal max = new BigDecimal("28");
		final BigDecimal step = new BigDecimal("0.5");
		final String xtext = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		final Setpoint expected = new SetpointBuilder().build();
		expected.setItem(item);
		expected.setMinValue(min);
		expected.setMaxValue(max);
		expected.setStep(step);
		final Setpoint actual = SetpointXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}

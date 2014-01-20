package org.openhab.designerx.model.xtdex.items;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.xtdex.items.producer.ItemXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemXtdexBuilderImpl;

public class ItemXtdexTest {
	private static final ItemXtdexBuilder builder = new ItemXtdexBuilderImpl();
	private static final ItemXtdex xtdex = builder.build();

	@Test
	public void testParseColorItem() throws ModelException {
		final String xtext = "Color RGBLight \"RGB Light\" <slider>";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseContactItem() throws ModelException {
		final String xtext = "Contact Window_GF_Frontdoor \"Frontdoor [MAP(en.map):%s]\" (GF_Corridor,Windows)";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseDateTimeItem() throws ModelException {
		final String xtext = "DateTime Date \"Date [%1$tA, %1$td.%1$tm.%1$tY]\" <calendar> {ntp=\"Europe/Berlin:de_DE\"}";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseDimmerItem() throws ModelException {
		final String xtext = "Dimmer DimmedLight \"Dimmer [%d %%]\" <slider>";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseGroupItem_1() throws ModelException {
		final String xtext = "Group GF_Living \"Living Room\" <video> (gGF)";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParseGroupItem_2() throws ModelException {
		final String xtext = "Group:Switch:OR(ON, OFF) Heating \"No. of Active Heatings [(%d)]\" <heating> (All)";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

//	@Test
	public void testParseNumberItem() throws ModelException {
		final String xtext = "";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

//	@Test
	public void testParseRollershutterItem() throws ModelException {
		final String xtext = "";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

//	@Test
	public void testParseStringItem() throws ModelException {
		final String xtext = "";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

//	@Test
	public void testParseSwitchItem() throws ModelException {
		final String xtext = "";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

}

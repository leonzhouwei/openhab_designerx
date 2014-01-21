package org.openhab.designerx.model.xtdex.items.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemXtdexImpl;

public class ItemXtdexImplTest {
	private static final ItemXtdex xtdex = new ItemXtdexImpl();

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

	@Test
	public void testParseNumberItem() throws ModelException {
		final String xtext = "Number Temperature_GF_Corridor \"Temperature [%.1f °C]\" <temperature> (Temperature,GF_Corridor)";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseRollershutterItem() throws ModelException {
		final String xtext = "Rollershutter DemoShutter \"Roller Shutter\"";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseStringItem() throws ModelException {
		final String xtext = "String UnknownDevices \"Unknown Devices in Range: [%s]\" {bluetooth=\"?\"}";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseSwitchItem() throws ModelException {
		final String xtext = "Switch Light_GF_Corridor_Ceiling \"Ceiling\" (GF_Corridor,Lights)";
		Item item = xtdex.parseItem(xtext);
		final String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(xtext));
	}

}

package org.openhab.designerx.model.xtdex.items.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;

public class ItemXtdexImplTest {
	
	private static final ItemXtdex xtdex = new ItemXtdexImpl();
	
	@Test
	public void testParseColorItemFromXext() {
		final String expected = "Color RGBLight \"RGB Light\" <slider>";
		ColorItem item = xtdex.parseColorItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseContactItemFromXext() {
		final String expected = "Contact contact";
		ContactItem item = xtdex.parseContactItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseDateTimeItemFromXext_1() {
		final String expected = "DateTime Weather_LastUpdate \"Last Update [%1$ta %1$tR]\" <clock>";
		DateTimeItem item = xtdex.parseDateTimeItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testParseDateTimeItemFromXext_2() {
		final String expected = "DateTime Date \"Date [%1$tA, %1$td.%1$tm.%1$tY]\" <calendar> {ntp=\"Europe/Berlin:de_DE\"}";
		DateTimeItem item = xtdex.parseDateTimeItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseDimmerItemFromXext() {
		final String expected = "Dimmer Light_GF_Living_Table \"Table\" (GF_Living,Lights)";
		DimmerItem item = xtdex.parseDimmerItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseGroupItemFromXext_1() {
		final String expected = "Group All";
		GroupItem item = xtdex.parseGroupItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testParseGroupItemFromXext_2() {
		final String expected = "Group:Switch:OR(ON, OFF) Lights \"All Lights [(%d)]\" (All)";
		GroupItem item = xtdex.parseGroupItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseNumberItemFromXext() {
		final String expected = "Number Temperature_GF_Corridor \"Temperature [%.1f °C]\" <temperature> (Temperature,GF_Corridor)";
		NumberItem item = xtdex.parseNumberItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseRollershutterItemFromXext() {
		final String expected = "Rollershutter DemoShutter \"Roller Shutter\"";
		RollershutterItem item = xtdex.parseRollershutterItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseStringItemFromXext() {
		final String expected = "String UnknownDevices \"Unknown Devices in Range: [%s]\" {bluetooth=\"?\"}";
		StringItem item = xtdex.parseStringItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testParseSwitchItemFromXext() {
		final String expected = "Switch Light_GF_Corridor_Ceiling \"Ceiling\" (GF_Corridor,Lights)";
		SwitchItem item = xtdex.parseSwitchItemFromXext(expected);
		String actual = xtdex.toXtext(item);
		assertThat(actual, Matchers.equalTo(expected));
	}

}

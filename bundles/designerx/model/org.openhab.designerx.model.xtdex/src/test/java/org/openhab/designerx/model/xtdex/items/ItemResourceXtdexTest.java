package org.openhab.designerx.model.xtdex.items;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.producer.ItemResourceXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemResourceXtdexBuilderImpl;

import com.google.common.collect.Lists;

public class ItemResourceXtdexTest {
	private static final ItemResourceXtdexBuilder builder = new ItemResourceXtdexBuilderImpl();
	private static final ItemResourceXtdex xtdex = builder.build();
	
	@Test
	public void testFromXtextListOfString_1() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("Group All");
		list.add("Group gGF 		(All)");
		list.add("Group gFF 		(All)");
		list.add("Group gC 		(All)");
		list.add("Group Outdoor 	(All)");
		list.add("Group Shutters 	(All)");
		list.add("Group Weather 	(All)");
		list.add("Group Status 	(All)");

		list.add("Group GF_Living 	\"Living Room\" 	<video> 	(gGF)");
		list.add("Group GF_Kitchen 	\"Kitchen\" 		<kitchen> 	(gGF)");
		list.add("Group GF_Toilet 	\"Toilet\" 		<bath> 		(gGF)");
		list.add("Group GF_Corridor 	\"Corridor\" 		<corridor> 	(gGF)");

		list.add("Group FF_Bath 		\"Bathroom\" 		<bath> 		(gFF)");
		list.add("Group FF_Office 	\"Office\" 		<office> 	(gFF)");
		list.add("Group FF_Child 		\"Child's Room\" 	<boy1> 		(gFF)");
		list.add("Group FF_Bed 		\"Bedroom\" 		<bedroom> 	(gFF)");
		list.add("Group FF_Corridor 	\"Corridor\" 		<corridor> 	(gFF)");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_2() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* active groups */");
		list.add("Group:Switch:OR(ON, OFF) 		Lights 		\"All Lights [(%d)]\" 								(All)");
		list.add("Group:Switch:OR(ON, OFF) 		Heating 	\"No. of Active Heatings [(%d)]\" 	<heating> 		(All)");
		list.add("Group:Number:AVG 				Temperature	\"Avg. Room Temperature [%.1f °C]\" 	<temperature>	(Status)");
		list.add("Group:Contact:OR(OPEN, CLOSED) 	Windows 	\"Open windows [(%d)]\"				<contact>		(All)");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_3() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* Lights */");
		list.add("Dimmer Light_GF_Living_Table 		\"Table\" 		(GF_Living, Lights)");
		list.add("Switch Light_GF_Corridor_Ceiling 	\"Ceiling\" 		(GF_Corridor, Lights)");
		list.add("Switch Light_GF_Kitchen_Ceiling 	\"Ceiling\" 		(GF_Kitchen, Lights)");
		list.add("Switch Light_GF_Kitchen_Table 		\"Table\" 		(GF_Kitchen, Lights)");
		list.add("Switch Light_GF_Corridor_Wardrobe 	\"Wardrobe\"	 	(GF_Corridor, Lights)");
		list.add("Switch Light_GF_Toilet_Ceiling 		\"Ceiling\" 		(GF_Toilet, Lights)");
		list.add("Switch Light_GF_Toilet_Mirror 		\"Mirror\" 		(GF_Toilet, Lights)");
		
		list.add("Switch Light_FF_Bath_Ceiling 		\"Ceiling\" 		(FF_Bath, Lights)");
		list.add("Switch Light_FF_Bath_Mirror 		\"Mirror\" 		(FF_Bath, Lights)");
		list.add("Switch Light_FF_Corridor_Ceiling 	\"Corridor\" 		(FF_Corridor, Lights)");
		list.add("Switch Light_FF_Office_Ceiling 		\"Ceiling\" 		(FF_Office, Lights)");
		list.add("Switch Light_FF_Child_Ceiling 		\"Ceiling\" 		(FF_Child, Lights)");
		list.add("Switch Light_FF_Bed_Ceiling 		\"Ceiling\" 		(FF_Bed, Lights)");

		list.add("Switch Light_C_Corridor_Ceiling 	\"Ceiling\" 		(gC, Lights)");
		list.add("Switch Light_C_Staircase 			\"Staircase\" 	(gC, Lights)");
		list.add("Switch Light_C_Washing_Ceiling 		\"Washing\" 		(gC, Lights)");
		list.add("Switch Light_C_Workshop 			\"Workshop\" 		(gC, Lights)");

		list.add("Switch Light_Outdoor_Garage 		\"Garage\" 		(Outdoor, Lights)");
		list.add("Switch Light_Outdoor_Terrace 		\"Terrace\" 		(Outdoor, Lights)");
		list.add("Switch Light_Outdoor_Frontdoor 		\"Frontdoor\"		(Outdoor, Lights)");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_4() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* Heating */");
		list.add("Switch Heating_GF_Corridor 	\"GF Corridor\" 	<heating>	(GF_Corridor, Heating)");
		list.add("Switch Heating_GF_Toilet 	\"Toilet\"	 	<heating>	(GF_Toilet, Heating)");
		list.add("Switch Heating_GF_Living 	\"Livingroom\" 	<heating>	(GF_Living, Heating)");
		list.add("Switch Heating_GF_Kitchen 	\"Kitchen\" 		<heating>	(GF_Kitchen, Heating)");

		list.add("Switch Heating_FF_Bath 		\"Bath\" 			<heating>	(FF_Bath, Heating)");
		list.add("Switch Heating_FF_Office 	\"Office\" 		<heating>	(FF_Office, Heating)");
		list.add("Switch Heating_FF_Child 	\"Child's Room\" 	<heating>	(FF_Child, Heating)");
		list.add("Switch Heating_FF_Bed 		\"Bedroom\" 		<heating>	(FF_Bed, Heating)");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_5() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* Rollershutters */");
		list.add("Switch Shutter_all (Shutters)");

		list.add("Rollershutter Shutter_GF_Toilet 		\"Toilet\"		(GF_Toilet, Shutters)");
		list.add("Rollershutter Shutter_GF_Kitchen 		\"Kitchen\"		(GF_Kitchen, Shutters)");
		list.add("Rollershutter Shutter_GF_Living 		\"Livingroom\"	(GF_Living, Shutters)");

		list.add("Rollershutter Shutter_FF_Bed 			\"Bedroom\"		(FF_Bed, Shutters)");
		list.add("Rollershutter Shutter_FF_Bath 			\"Bath\"			(FF_Bath, Shutters)");
		list.add("Rollershutter Shutter_FF_Office_Window	\"Office Window\"	(FF_Office, Shutters)");
		list.add("Rollershutter Shutter_FF_Office_Door 	\"Office Door\"	(FF_Office, Shutters)");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_6() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* Indoor Temperatures */");
		list.add("Number Temperature_GF_Corridor 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Corridor)");
		list.add("Number Temperature_GF_Toilet 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Toilet)");
		list.add("Number Temperature_GF_Living 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Living)");
		list.add("Number Temperature_GF_Kitchen 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Kitchen)");
		list.add("Number Temperature_FF_Bath 		\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Bath)");
		list.add("Number Temperature_FF_Office 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Office)");
		list.add("Number Temperature_FF_Child 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Child)");
		list.add("Number Temperature_FF_Bed 		\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Bed)");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_7() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* Windows */");
		list.add("Contact Window_GF_Frontdoor 	\"Frontdoor [MAP(en.map):%s]\"		(GF_Corridor, Windows)");
		list.add("Contact Window_GF_Kitchen 		\"Kitchen [MAP(en.map):%s]\"			(GF_Kitchen, Windows)");
		list.add("Contact Window_GF_Living 		\"Terrace door [MAP(en.map):%s]\"		(GF_Living, Windows)");
		list.add("Contact Window_GF_Toilet 		\"Toilet [MAP(en.map):%s]\"			(GF_Toilet, Windows)");

		list.add("Contact Window_FF_Bath 			\"Bath [MAP(en.map):%s]\"				(FF_Bath, Windows)");
		list.add("Contact Window_FF_Bed 			\"Bedroom [MAP(en.map):%s]\"			(FF_Bed, Windows)");
		list.add("Contact Window_FF_Office_Window \"Office Window [MAP(en.map):%s]\"	(FF_Office, Windows)");
		list.add("Contact Window_FF_Office_Door 	\"Balcony Door [MAP(en.map):%s]\"		(FF_Office, Windows)");

		list.add("Contact Garage_Door 			\"Garage Door [MAP(en.map):%s]\"		(Outdoor, Windows)");

		list.add("Group Weather_Chart													(Weather)");
		list.add("Number Weather_Temperature 		\"Outside Temperature [%.1f °C]\"	<temperature> (Weather_Chart) { http=\"<[http://weather.yahooapis.com/forecastrss?w=638242&u=c:60000:XSLT(yahoo_weather_temperature.xsl)]\" }");
		list.add("Number Weather_Temp_Max 		\"Todays Maximum [%.1f °C]\"	<temperature> (Weather_Chart)");
		list.add("Number Weather_Temp_Min 		\"Todays Minimum [%.1f °C]\"	<temperature> (Weather_Chart)");
		list.add("Number Weather_Chart_Period		\"Chart Period\"");
		list.add("DateTime Weather_LastUpdate		\"Last Update [%1$ta %1$tR]\"	<clock>");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_8() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* NTP binding demo item */");
		list.add("DateTime		Date			\"Date [%1$tA, %1$td.%1$tm.%1$tY]\"	<calendar>	{ ntp=\"Europe/Berlin:de_DE\" }");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testFromXtextListOfString_9() throws ModelXtdexException, ModelException {
		List<String> list = Lists.newArrayList();
		list.add("/* Demo items */");
		list.add("Switch DemoSwitch				\"Switch\"");
		list.add("Dimmer DimmedLight				\"Dimmer [%d %%]\"		<slider>");
		list.add("Color  RGBLight					\"RGB Light\"				<slider>");
		list.add("Rollershutter DemoShutter	 	\"Roller Shutter\"");
		list.add("Dimmer DemoBlinds			 	\"Blinds [%d %%]\"		<rollershutter>");
		list.add("Number Scene_General			\"Scene\"					<sofa>");
		list.add("Number Radio_Station			\"Radio\"					<network>");
		list.add("Dimmer Volume 					\"Volume [%.1f %%]\"");
		list.add("Number Temperature_Setpoint		\"Temperature [%.1f °C]\" <temperature>");

		list.add("String UnknownDevices    \"Unknown Devices in Range: [%s]\" { bluetooth=\"?\" }");
		list.add("Number NoOfPairedDevices \"Paired Devices in Range: [%d]\"  { bluetooth=\"!\" }");
		ItemResource ir = xtdex.fromXtext(list);
		System.out.println(xtdex.toXtext(ir));
	}

}

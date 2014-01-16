package org.openhab.designerx.model.xtdex.items.producer.impl;

import org.junit.Test;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemResourceXtdexImpl;

public class ItemResourceXtdexImplTest {
	private static final ItemResourceXtdexImpl xtdex = new ItemResourceXtdexImpl();

	@Test
	public void testFromXtext() {
		StringBuilder sb = new StringBuilder();
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group All");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group gGF 		(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group gFF 		(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group gC 		(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group Outdoor 	(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group Shutters 	(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group Weather 	(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group Status 	(All)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group GF_Living 	\"Living Room\" 	<video> 	(gGF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group GF_Kitchen 	\"Kitchen\" 		<kitchen> 	(gGF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group GF_Toilet 	\"Toilet\" 		<bath> 		(gGF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group GF_Corridor 	\"Corridor\" 		<corridor> 	(gGF)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group FF_Bath 		\"Bathroom\" 		<bath> 		(gFF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group FF_Office 	\"Office\" 		<office> 	(gFF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group FF_Child 		\"Child's Room\" 	<boy1> 		(gFF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group FF_Bed 		\"Bedroom\" 		<bedroom> 	(gFF)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group FF_Corridor 	\"Corridor\" 		<corridor> 	(gFF)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* active groups */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group:Switch:OR(ON, OFF) 		Lights 		\"All Lights [(%d)]\" 								(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group:Switch:OR(ON, OFF) 		Heating 	\"No. of Active Heatings [(%d)]\" 	<heating> 		(All)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group:Number:AVG 				Temperature	\"Avg. Room Temperature [%.1f °C]\" 	<temperature>	(Status)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group:Contact:OR(OPEN, CLOSED) 	Windows 	\"Open windows [(%d)]\"				<contact>		(All)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* Lights */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Dimmer Light_GF_Living_Table 		\"Table\" 		(GF_Living, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_GF_Corridor_Ceiling 	\"Ceiling\" 		(GF_Corridor, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_GF_Kitchen_Ceiling 	\"Ceiling\" 		(GF_Kitchen, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_GF_Kitchen_Table 		\"Table\" 		(GF_Kitchen, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_GF_Corridor_Wardrobe 	\"Wardrobe\"	 	(GF_Corridor, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_GF_Toilet_Ceiling 		\"Ceiling\" 		(GF_Toilet, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_GF_Toilet_Mirror 		\"Mirror\" 		(GF_Toilet, Lights)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_FF_Bath_Ceiling 		\"Ceiling\" 		(FF_Bath, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_FF_Bath_Mirror 		\"Mirror\" 		(FF_Bath, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_FF_Corridor_Ceiling 	\"Corridor\" 		(FF_Corridor, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_FF_Office_Ceiling 		\"Ceiling\" 		(FF_Office, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_FF_Child_Ceiling 		\"Ceiling\" 		(FF_Child, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_FF_Bed_Ceiling 		\"Ceiling\" 		(FF_Bed, Lights)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_C_Corridor_Ceiling 	\"Ceiling\" 		(gC, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_C_Staircase 			\"Staircase\" 	(gC, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_C_Washing_Ceiling 		\"Washing\" 		(gC, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_C_Workshop 			\"Workshop\" 		(gC, Lights)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_Outdoor_Garage 		\"Garage\" 		(Outdoor, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_Outdoor_Terrace 		\"Terrace\" 		(Outdoor, Lights)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Light_Outdoor_Frontdoor 		\"Frontdoor\"		(Outdoor, Lights)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* Heating */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_GF_Corridor 	\"GF Corridor\" 	<heating>	(GF_Corridor, Heating)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_GF_Toilet 	\"Toilet\"	 	<heating>	(GF_Toilet, Heating)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_GF_Living 	\"Livingroom\" 	<heating>	(GF_Living, Heating)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_GF_Kitchen 	\"Kitchen\" 		<heating>	(GF_Kitchen, Heating)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_FF_Bath 		\"Bath\" 			<heating>	(FF_Bath, Heating)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_FF_Office 	\"Office\" 		<heating>	(FF_Office, Heating)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_FF_Child 	\"Child's Room\" 	<heating>	(FF_Child, Heating)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Heating_FF_Bed 		\"Bedroom\" 		<heating>	(FF_Bed, Heating)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* Rollershutters */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch Shutter_all (Shutters)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_GF_Toilet 		\"Toilet\"		(GF_Toilet, Shutters)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_GF_Kitchen 		\"Kitchen\"		(GF_Kitchen, Shutters)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_GF_Living 		\"Livingroom\"	(GF_Living, Shutters)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_FF_Bed 			\"Bedroom\"		(FF_Bed, Shutters)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_FF_Bath 			\"Bath\"			(FF_Bath, Shutters)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_FF_Office_Window	\"Office Window\"	(FF_Office, Shutters)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter Shutter_FF_Office_Door 	\"Office Door\"	(FF_Office, Shutters)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* Indoor Temperatures */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_GF_Corridor 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Corridor)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_GF_Toilet 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Toilet)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_GF_Living 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Living)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_GF_Kitchen 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, GF_Kitchen)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_FF_Bath 		\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Bath)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_FF_Office 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Office)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_FF_Child 	\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Child)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_FF_Bed 		\"Temperature [%.1f °C]\"	<temperature>	(Temperature, FF_Bed)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* Windows */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_GF_Frontdoor 	\"Frontdoor [MAP(en.map):%s]\"		(GF_Corridor, Windows)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_GF_Kitchen 		\"Kitchen [MAP(en.map):%s]\"			(GF_Kitchen, Windows)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_GF_Living 		\"Terrace door [MAP(en.map):%s]\"		(GF_Living, Windows)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_GF_Toilet 		\"Toilet [MAP(en.map):%s]\"			(GF_Toilet, Windows)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_FF_Bath 			\"Bath [MAP(en.map):%s]\"				(FF_Bath, Windows)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_FF_Bed 			\"Bedroom [MAP(en.map):%s]\"			(FF_Bed, Windows)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_FF_Office_Window \"Office Window [MAP(en.map):%s]\"	(FF_Office, Windows)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Window_FF_Office_Door 	\"Balcony Door [MAP(en.map):%s]\"		(FF_Office, Windows)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Contact Garage_Door 			\"Garage Door [MAP(en.map):%s]\"		(Outdoor, Windows)");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Group Weather_Chart													(Weather)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Weather_Temperature 		\"Outside Temperature [%.1f °C]\"	<temperature> (Weather_Chart) { http=\"<[http://weather.yahooapis.com/forecastrss?w=638242&u=c:60000:XSLT(yahoo_weather_temperature.xsl)]\" }");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Weather_Temp_Max 		\"Todays Maximum [%.1f °C]\"	<temperature> (Weather_Chart)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Weather_Temp_Min 		\"Todays Minimum [%.1f °C]\"	<temperature> (Weather_Chart)");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Weather_Chart_Period		\"Chart Period\"");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "DateTime Weather_LastUpdate		\"Last Update [%1$ta %1$tR]\"	<clock>");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* NTP binding demo item */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "DateTime		Date			\"Date [%1$tA, %1$td.%1$tm.%1$tY]\"	<calendar>	{ ntp=\"Europe/Berlin:de_DE\" }");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "/* Demo items */");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Switch DemoSwitch				\"Switch\"");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Dimmer DimmedLight				\"Dimmer [%d %%]\"		<slider>");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Color  RGBLight					\"RGB Light\"				<slider>");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Rollershutter DemoShutter	 	\"Roller Shutter\"");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Dimmer DemoBlinds			 	\"Blinds [%d %%]\"		<rollershutter>");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Scene_General			\"Scene\"					<sofa>");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Radio_Station			\"Radio\"					<network>");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Dimmer Volume 					\"Volume [%.1f %%]\"");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number Temperature_Setpoint		\"Temperature [%.1f °C]\" <temperature>");

		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "String UnknownDevices    \"Unknown Devices in Range: [%s]\" { bluetooth=\"?\" }");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR + "Number NoOfPairedDevices \"Paired Devices in Range: [%d]\"  { bluetooth=\"!\" }");
		final String expected = sb.toString();
		ItemResource ir = xtdex.fromXtext(expected);
		final String actual = xtdex.toXtext(ir);
		System.out.println(actual);
	}

}

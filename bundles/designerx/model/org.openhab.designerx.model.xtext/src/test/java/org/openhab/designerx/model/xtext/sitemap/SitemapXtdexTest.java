package org.openhab.designerx.model.xtext.sitemap;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;

public class SitemapXtdexTest {

	@Test
	public void testFromXtext_1() throws ModelXtextException {
		ImmutableList<String> il = ImmutableList.<String>builder()
				.add("sitemap demo label=\"Main Menu\" {")
				.add("    Frame {")
				.add("        Group item=gFF label=\"First Floor\" icon=\"firstfloor\"")
				.add("        Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"")
				.add("        Group item=gC label=\"Cellar\" icon=\"cellar\"")
				.add("        Group item=Outdoor icon=\"garden\"")
				.add("    }")
				.add("}")
				.build();
		SitemapXtextKeeper keeper = new SitemapXtextKeeper(il);
		Sitemap sitemap = SitemapXtdex.fromXtext(keeper);
		System.out.println(SitemapXtdex.toXtext(sitemap));
	}
	
	@Test
	public void testFromXtext_2() throws ModelXtextException {
		ImmutableList<String> il = ImmutableList.<String>builder()
				.add("sitemap demo label=\"Main Menu\" {")
				.add("    Frame label=\"Weather\" {")
				.add("        Text item=Weather_Temperature valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"] {")
				.add("            Frame {")
				.add("                Text item=Weather_Temp_Max valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]")
				.add("                Text item=Weather_Temp_Min valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]")
				.add("                Text item=Weather_LastUpdate visibility=[Weather_LastUpdate>30] valuecolor=[Weather_LastUpdate>120=\"orange\", Weather_LastUpdate>300=\"red\"]")
				.add("            }")
				.add("            Frame {")
				.add("                Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]")
				.add("                Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]")
				.add("                Chart item=Weather_Chart period=D refresh=3600 visibility=[Weather_Chart_Period==1]")
				.add("                Chart item=Weather_Chart period=W refresh=3600 visibility=[Weather_Chart_Period==2]")
				.add("            }")
				.add("        }")
				.add("    }")
				.add("}")
				.build();
		SitemapXtextKeeper keeper = new SitemapXtextKeeper(il);
		Sitemap sitemap = SitemapXtdex.fromXtext(keeper);
		System.out.println(SitemapXtdex.toXtext(sitemap));
	}
	
	@Test
	public void testFromXtext_3() throws ModelXtextException {
		ImmutableList<String> il = ImmutableList.<String>builder()
				.add("sitemap demo label=\"Main Menu\" {")
				.add("    Frame label=\"Demo\" {")
				.add("		    Text label=\"Group Demo\" icon=\"firstfloor\" {")
				.add("			    Switch item=Lights mappings=[OFF=\"All Off\"]")
				.add("			    Group item=Heating")
				.add("		    	Group item=Windows")
				.add("		    	Text item=Temperature")
				.add("		    }")
				.add("		    Text label=\"Widget Overview\" icon=\"chart\" {")
				.add("		    	Frame label=\"Binary Widgets\" {")
				.add("		    		Switch item=DemoSwitch label=\"Toggle Switch\"")
				.add("		    		Switch item=DemoSwitch label=\"Button Switch\" mappings=[ON=\"On\"]")
				.add("		    	}")
				.add("		    	Frame label=\"Discrete Widgets\" {")
				.add("		    		Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off, 1=TV, 2=Dinner, 3=Reading]")
				.add("		    		Switch item=Scene_General label=\"Scene\" mappings=[1=TV, 2=Dinner, 3=Reading]")
				.add("		    		Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5")
			    .add("		    	}")
				.add("		    	Frame label=\"Percent-based Widgets\" {")
				.add("		    		Slider item=DimmedLight switchSupport")
				.add("		    		Colorpicker item=RGBLight icon=\"slider\"")
				.add("		    		Switch item=DemoShutter")
				.add("		    		Slider item=DemoBlinds")
				.add("			    }")
				.add("		    }")
				.add("		    Text label=\"Multimedia\" icon=\"video\" {")
				.add("		    	Frame label=\"Radio Control\" {")
				.add("		    		Selection item=Radio_Station mappings=[0=off, 1=HR3, 2=SWR3, 3=FFH]")
				.add("		    		Slider item=Volume")
				.add("		    	}")
				.add("		    	Frame label=\"Multimedia Widgets\" {")
				.add("		    		Image url=\"http://localhost:8080/images/splash-ipad-h.png\" label=\"openHAB\" {")
				.add("		    			Text label=\"http://www.openHAB.org\" icon=\"icon\"")
				.add("		    		}")
				.add("			    	Video url=\"http://demo.openhab.org/Hue.m4v\"")
				.add("			    	Webview url=\"http://heise-online.mobi/\" height=8")
				.add("			    }")
				.add("		    }")
				.add("    }")
				.add("}")
				.build();
		SitemapXtextKeeper keeper = new SitemapXtextKeeper(il);
		Sitemap sitemap = SitemapXtdex.fromXtext(keeper);
		System.out.println(SitemapXtdex.toXtext(sitemap));
	}

}

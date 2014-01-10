package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.NestableElement;

import com.google.common.collect.Lists;

public class NestableElementXtdexTest {

	@Test
	public void testFromXtextString() {
	}

	@Test
	public void testIsNestableElement() {
	}

	@Test
	public void testEndIndexOf() {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
		list.add("    Text");
		list.add("    Frame {");
		list.add("        Setpoint");
		list.add("    }");
		list.add("}");
		assertThat(NestableElementXtdex.endIndexOf(list, 0), Matchers.equalTo(5));
		assertThat(NestableElementXtdex.endIndexOf(list, 2), Matchers.equalTo(4));
	}
	
	@Test
	public void testFromXtext_1() {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
		list.add("    Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		list.add("    Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		list.add("    Group item=gC label=\"Cellar\" icon=\"cellar\"");
		list.add("    Group item=Outdoor icon=\"garden\"");
		list.add("}");
		NestableElement root = NestableElementXtdex.fromXtext(list);
		System.out.println(NestableElementXtdex.toXtext(root, ""));
	}
	
	@Test
	public void testFromXtext_2() {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
		list.add("    Text label=\"Group Demo\" icon=\"firstfloor\" {");
		list.add("        Switch item=Lights mappings=[OFF=\"All Off\"]");
		list.add("        Group item=Heating");
		list.add("        Group item=Windows");
		list.add("        Text item=Temperature");
		list.add("    }");
		list.add("}");
		NestableElement root = NestableElementXtdex.fromXtext(list);
		System.out.println(NestableElementXtdex.toXtext(root, ""));
	}
	
	@Test
	public void testFromXtext_3() {
		List<String> list = Lists.newArrayList();
		list.add("Frame label=\"Weather\" {");
		list.add("    Text item=Weather_Temperature valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"] {");
		list.add("        Frame {");
		list.add("            Text item=Weather_Temp_Max valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		list.add("            Text item=Weather_Temp_Min valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		list.add("            Text item=Weather_LastUpdate visibility=[Weather_LastUpdate>30] valuecolor=[Weather_LastUpdate>120=\"orange\", Weather_LastUpdate>300=\"red\"]");
		list.add("        }");
		list.add("        Frame {");
		list.add("            Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]");
		list.add("            Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]");
		list.add("            Chart item=Weather_Chart period=D refresh=3600 visibility=[Weather_Chart_Period==1]");
		list.add("            Chart item=Weather_Chart period=W refresh=3600 visibility=[Weather_Chart_Period==2]");
		list.add("        }");
		list.add("    }");
		list.add("}");
		NestableElement root = NestableElementXtdex.fromXtext(list);
		System.out.println(NestableElementXtdex.toXtext(root, ""));
	}

}

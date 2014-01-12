package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.Lists;

public class SitemapXtextKeeperTest {

	@Test
	public void test_1() throws ModelXtextException {
		List<String> list = Lists.newArrayList();
		list.add("sitemap demo label=\"1\" {");
		list.add("    Frame {");
		list.add("        Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		list.add("        Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		list.add("        Group item=gC label=\"Cellar\" icon=\"cellar\"");
		list.add("        Group item=Outdoor icon=\"garden\" ");
		list.add("    }");
		list.add("}");
		SitemapXtextKeeper keeper = new SitemapXtextKeeper(list);
		for (String s : keeper.getXtext()) {
			System.out.println(s);
		}
	}
	
	@Test
	public void test_2() throws ModelXtextException {
		List<String> list = Lists.newArrayList();
		list.add("sitemap demo label=\"2\"");
		list.add("{");
		list.add("    Frame");
		list.add("    {");
		list.add("        Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		list.add("        Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		list.add("        Group item=gC label=\"Cellar\" icon=\"cellar\"");
		list.add("        Group item=Outdoor icon=\"garden\" ");
		list.add("    }");
		list.add("}");
		SitemapXtextKeeper keeper = new SitemapXtextKeeper(list);
		for (String s : keeper.getXtext()) {
			System.out.println(s);
		}
	}
	
	@Test
	public void test_3() throws ModelXtextException {
		List<String> list = Lists.newArrayList();
		list.add("sitemap demo label=\"3\"");
		SitemapXtextKeeper keeper = new SitemapXtextKeeper(list);
		for (String s : keeper.getXtext()) {
			System.out.println(s);
		}
	}

}

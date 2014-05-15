package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.util.StringHelper;

import com.google.common.collect.Lists;

public class XtextSitemaplTest {
	private RealXtextSitemapRepositoryImpl repo = RealXtextSitemapRepositoryImpl.getInstance();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();

	@Test
	public void testFind() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		XtextSitemap persist = repo.find("my_home");
		Sitemap sitemap = persist.sitemapReplica();
		String xtext = xtdex.toXtext(sitemap);
		System.out.println(xtext);
	}
		
//	@Test
	public void testFindOrCreate() throws Exception {
		final String name = "my_home";
		XtextSitemap xs = repo.findOrCreate(name);
		List<String> list = Lists.newArrayList();
		list.add("sitemap my_home {");
		list.add("    Frame {");
		list.add("        Group item=gFF label=\"First Floor\" icon=\"1stfloor\"");
		list.add("        Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		list.add("        Group item=gC label=\"Cellar\" icon=\"cellar\"");
		list.add("        Group item=Outdoor icon=\"gardeon\"");
		list.add("    }");
		list.add("    Frame label=\"Weather\" {");
		list.add("        Text item=Weather_Temperature label=\"Weather\"{");
		list.add("            Frame item=Weather_Temp_Max");
		list.add("            Frame item=Weather_Temp_Min");
		list.add("        }");
		list.add("    }");
		list.add("    Frame label=\"Date\" {");
		list.add("        Text item=Date");
		list.add("    }");
		list.add("}");
		Sitemap sitemap = xtdex.parse(list);
		xs.save(sitemap);
	}
	
}

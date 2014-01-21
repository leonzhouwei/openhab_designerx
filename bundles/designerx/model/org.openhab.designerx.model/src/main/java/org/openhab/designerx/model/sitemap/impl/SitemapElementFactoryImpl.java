package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Property;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.Webview;

public final class SitemapElementFactoryImpl implements SitemapElementFactory {

	@Override
	public Chart createChart() {
		return new ChartImpl();
	}

	@Override
	public Colorpicker createColorpicker() {
		return new ColorpickerImpl();
	}

	@Override
	public Frame createFrame() {
		return new FrameImpl();
	}

	@Override
	public Group createGroup() {
		return new GroupImpl();
	}

	@Override
	public Image createImage() {
		return new ImageImpl();
	}

	@Override
	public List createList() {
		return new ListImpl();
	}

	@Override
	public Selection createSelection() {
		return new SelectionImpl();
	}

	@Override
	public Setpoint createSetpoint() {
		return new SetpointImpl();
	}

	@Override
	public Slider createSlider() {
		return new SliderImpl();
	}

	@Override
	public Switch createSwitch() {
		return new SwitchImpl();
	}

	@Override
	public Text createText() {
		return new TextImpl();
	}

	@Override
	public Video createVideo() {
		return new VideoImpl();
	}

	@Override
	public Webview createWebview() {
		return new WebviewImpl();
	}

	@Override
	public ColorArray createColorArray() {
		return new ColorArrayImpl();
	}

	@Override
	public Mapping createMapping() {
		return new MappingImpl();
	}

	@Override
	public Property createProperty() {
		return new PropertyImpl();
	}

	@Override
	public VisibilityRule createVisibilityRule() {
		return new VisibilityRuleImpl();
	}

}

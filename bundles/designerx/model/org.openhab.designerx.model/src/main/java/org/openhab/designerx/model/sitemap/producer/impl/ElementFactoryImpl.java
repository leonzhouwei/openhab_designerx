package org.openhab.designerx.model.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;

public final class ElementFactoryImpl implements ElementFactory {

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

}

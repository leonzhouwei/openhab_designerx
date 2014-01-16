package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.Chart;
import org.openhab.designerx.model.sitemap2.Colorpicker;
import org.openhab.designerx.model.sitemap2.Frame;
import org.openhab.designerx.model.sitemap2.Group;
import org.openhab.designerx.model.sitemap2.Image;
import org.openhab.designerx.model.sitemap2.List;
import org.openhab.designerx.model.sitemap2.Selection;
import org.openhab.designerx.model.sitemap2.Setpoint;
import org.openhab.designerx.model.sitemap2.Slider;
import org.openhab.designerx.model.sitemap2.Switch;
import org.openhab.designerx.model.sitemap2.Text;
import org.openhab.designerx.model.sitemap2.Video;
import org.openhab.designerx.model.sitemap2.Webview;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;

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
	public Webview createWebviewWebview() {
		return new WebviewImpl();
	}

}

package org.openhab.designerx.model.sitemap;

import java.math.BigDecimal;

public interface Setpoint extends Element {
	
	public final String TYPE_NAME = "Setpoint";
	 
	public BigDecimal getMinValue();

	public void setMinValue(BigDecimal minValue);

	public BigDecimal getMaxValue();

	public void setMaxValue(BigDecimal maxValue);

	public BigDecimal getStep();

	public void setStep(BigDecimal step);
	
}

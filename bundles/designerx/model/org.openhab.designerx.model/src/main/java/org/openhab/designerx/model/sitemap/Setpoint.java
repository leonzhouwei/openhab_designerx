package org.openhab.designerx.model.sitemap;

import java.math.BigDecimal;

public interface Setpoint extends NonNestableElement {
	 
	public BigDecimal getMinValue();

	public void setMinValue(BigDecimal value);

	public BigDecimal getMaxValue();

	public void setMaxValue(BigDecimal value);

	public BigDecimal getStep();

	public void setStep(BigDecimal value);

}

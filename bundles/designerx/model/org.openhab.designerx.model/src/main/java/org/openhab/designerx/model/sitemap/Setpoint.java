package org.openhab.designerx.model.sitemap;

import java.math.BigDecimal;

public interface Setpoint extends NonNestableElement {
	 
	BigDecimal getMinValue();

	void setMinValue(BigDecimal value);

	BigDecimal getMaxValue();

	void setMaxValue(BigDecimal value);

	BigDecimal getStep();

	void setStep(BigDecimal value);

}

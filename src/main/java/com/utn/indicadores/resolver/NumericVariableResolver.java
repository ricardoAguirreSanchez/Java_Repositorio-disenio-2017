package com.utn.indicadores.resolver;

import java.math.BigDecimal;

/**
 * Created by nicolas on 22/05/17.
 */
public interface NumericVariableResolver {
    public Double getRoi();
    public Double getGrossBooking();
    public Double getProfit();
    public Double getCost();
}

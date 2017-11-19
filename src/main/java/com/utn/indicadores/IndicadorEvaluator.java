package com.utn.indicadores;

import com.utn.model.CuentaValores;
import com.utn.indicadores.model.NumericVariable;
import org.springframework.stereotype.Component;


public class IndicadorEvaluator extends IndicadorBaseVisitor<Double> {

    private CuentaValores cuenta;

    public IndicadorEvaluator(CuentaValores cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public Double visitPlus(IndicadorParser.PlusContext ctx) {
        return visit(ctx.plusOrMinus()) + visit(ctx.multOrDiv());
    }

    @Override
    public Double visitMinus(IndicadorParser.MinusContext ctx) {
        return visit(ctx.plusOrMinus()) - visit(ctx.multOrDiv());
    }

    @Override
    public Double visitMultiplication(IndicadorParser.MultiplicationContext ctx) {
        return visit(ctx.multOrDiv()) * visit(ctx.pow());
    }

    @Override
    public Double visitDivision(IndicadorParser.DivisionContext ctx) {
        return visit(ctx.multOrDiv()) / visit(ctx.pow());
    }

    @Override
    public Double visitPower(IndicadorParser.PowerContext ctx) {
        if (ctx.pow() != null)
            return Math.pow(visit(ctx.unaryMinus()), visit(ctx.pow()));
        return visit(ctx.unaryMinus());
    }

    @Override
    public Double visitChangeSign(IndicadorParser.ChangeSignContext ctx) {
        return -1*visit(ctx.unaryMinus());
    }

    @Override
    public Double visitBraces(IndicadorParser.BracesContext ctx) {
        return visit(ctx.plusOrMinus());
    }

    @Override
    public Double visitConstantPI(IndicadorParser.ConstantPIContext ctx) {
        return Math.PI;
    }

    @Override
    public Double visitConstantE(IndicadorParser.ConstantEContext ctx) {
        return Math.E;
    }

    @Override
    public Double visitInt(IndicadorParser.IntContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitDouble(IndicadorParser.DoubleContext ctx) {
        return Double.parseDouble(ctx.DOUBLE().getText());
    }

    @Override
    public Double visitNumericVariable(IndicadorParser.NumericVariableContext ctx) {

        Double value = null;

        if(NumericVariable.valueOf(ctx.numeric_variable().getText()).equals(NumericVariable.ROI)){
            value =  cuenta.getRoi();
        }
        if(NumericVariable.valueOf(ctx.numeric_variable().getText()).equals(NumericVariable.GROSS_BOOKING)){
            value =  cuenta.getGrossBooking();
        }
        if(NumericVariable.valueOf(ctx.numeric_variable().getText()).equals(NumericVariable.PROFIT)){
            value =  cuenta.getProfit();
        }
        if(NumericVariable.valueOf(ctx.numeric_variable().getText()).equals(NumericVariable.COST)){
            value =  cuenta.getCost();
        }
        return value;
    }

    @Override
    public Double visitCalculate(IndicadorParser.CalculateContext ctx) {
        return visit(ctx.plusOrMinus());
    }


}
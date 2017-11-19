package com.utn.indicadores;

import com.utn.indicadores.model.ExceptionThrowingErrorHandler;
import com.utn.model.CuentaValores;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Component;

/**
 * Created by nicolas on 22/05/17.
 */
@Component
public class IndicadorCompiler {

    public boolean isIndicadorValido(String inputString) {

        ANTLRInputStream input = new ANTLRInputStream(inputString);
        IndicadorLexer lexer = new IndicadorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);

        parser.removeErrorListeners();
        parser.setErrorHandler(new ExceptionThrowingErrorHandler());

        try {
            ParserRuleContext ruleContext = parser.math_expression();
            return ruleContext.exception == null;
        } catch (RuntimeException e) {
            return false;
        }
    }
    public Double evaluarIndicador(String inputString, CuentaValores valores) {
        IndicadorEvaluator evaluator = new IndicadorEvaluator(valores);
        ANTLRInputStream input = new ANTLRInputStream(inputString);
        IndicadorLexer lexer = new IndicadorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);
        ParseTree tree = parser.input();

        return evaluator.visit(tree);

    }
}

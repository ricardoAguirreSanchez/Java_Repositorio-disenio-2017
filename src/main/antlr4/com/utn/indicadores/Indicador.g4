grammar Indicador;
INT    : [0-9]+;
DOUBLE : [0-9]+'.'[0-9]+;
PI     : 'pi';
E      : 'e';
POW    : '^';
NL     : '\n';
WS     : [ \t\r]+ -> skip;

PLUS  : '+';
EQUAL : '=';
MINUS : '-';
MULT  : '*';
DIV   : '/';
LPAR  : '(';
RPAR  : ')';

ROI                : 'ROI';
GROSS_BOOKING      : 'GROSS_BOOKING';
PROFIT : 'PROFIT';
COST : 'COST';



math_expression : single_expression EOF ;

single_expression : expression;

expression
 : input  # InputValue
 | plusOrMinus  # PlusExpressionOrMinusExpression
 | multOrDiv    # MultiplicationOrDivision
 | pow                # PowExpression
 | unaryMinus #UnaryMinusExpression
 | atom #AtomExpression
 ;


input
    : plusOrMinus NL? EOF # Calculate
    ;




plusOrMinus
    : plusOrMinus PLUS multOrDiv  # Plus
    | plusOrMinus MINUS multOrDiv # Minus
    | multOrDiv                   # ToMultOrDiv
    ;

multOrDiv
    : multOrDiv MULT pow # Multiplication
    | multOrDiv DIV pow  # Division
    | pow                # ToPow
    ;

pow
    : unaryMinus (POW pow)? # Power
    ;

unaryMinus
    : MINUS unaryMinus # ChangeSign
    | atom             # ToAtom
    ;

atom
    : PI                    # ConstantPI
    | E                     # ConstantE
    | DOUBLE                # Double
    | INT                   # Int
    | LPAR plusOrMinus RPAR # Braces
    | numeric_variable #NumericVariable
;

numeric_variable: ROI | GROSS_BOOKING | PROFIT | COST;

grammar dgl1;

factoryDeclaration
    :   'factory' identifier?
    ;

fillerDeclaration
    :   'filler' identifier?
    ;

identifier
    :   Identifier
    ;

Identifier
    : LangLetter LangLetterOrDigit*
    ;

fragment
LangLetter
    :   [a-zA-Z_]
    ;

LangLetterOrDigit
    :   [a-zA-Z0-9]
    ;



LBRACE : '{';
RBRACE : '}';

WS
    :  [ \t\r\n\u000C]+ -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
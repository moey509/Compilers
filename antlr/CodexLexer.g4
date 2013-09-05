lexer grammar CodexLexer;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '#' .*? [\r\n] -> skip; // skips characters following comment symbol

NEGATIVE : '!';
TIMES: '*';
DIVIDE: '/';
MODULO: '%';
PLUS: '+';
MINUS: '-';
THROUGH: ('..'|'<.'|'.<')
ONWARD: ('...'|'..<')
INCREMENT: '++';
LESSTHAN: '<';
LESSTHANOREQ: '<=';
GREATERTHAN: '>';
GREATERTHANOREQ: '>=';
EQUALS: '==';
NOTEQUALS: '!=';
AND: '&';
OR: '|';




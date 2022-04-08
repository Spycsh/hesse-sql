grammar g;

prule
    : stat+
    ;

stat
    : OP target
    | END
    ;

END
    : ';'
    ;

target
    : identifier
    | region
    | condition
    ;

identifier
    : CHAR
    ;

CHAR
    : [a-z0-9]+
    ;

region
    : LEFT_BRACKET CHAR COMMA CHAR RIGHT_BRACKET
    ;

condition
    : condition CONJUNCTION conditionStat
    | conditionStat
    ;

conditionStat
    : identifier RELATION CHAR
    ;

CONJUNCTION
    : (' and '|' or ')      // here should have space
    ;

RELATION
    : ('>'|'<'|'='|'!=')
    ;

OP
    : ('SELECT'|'CALL'|'FROM'|'TO'|'IN'|'HAVING')
    ;

COMMA
    : ','
    | ', '
    ;

LEFT_BRACKET
    : '['
    | '('
    ;

RIGHT_BRACKET
    : ']'
    | ')'
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

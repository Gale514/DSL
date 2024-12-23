grammar CustomerServiceDSL;

script          : statement+ ;
statement       : stateDefinition | transitionRule | conditionalTransition | autoTransition ;
stateDefinition : 'state' ID '{' response '}' ;
transitionRule  : 'on' keyword 'in' ID 'goto' ID ;
conditionalTransition : 'on' keyword 'in' ID 'if' condition 'goto' ID ;
autoTransition  : 'auto_goto' ID 'in' ID ;
response        : 'response' ':' STRING ;

condition       : ID '==' STRING ;

keyword         : ID ;
ID              : [a-zA-Z_][a-zA-Z_0-9]* ;
STRING          : '"' (~["\r\n])* '"' ;

WS              : [ \t\r\n]+ -> skip ;
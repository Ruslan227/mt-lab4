grammar Input;

initStart : constructors NEW_LINE rules EOF;

constructors : className NEW_LINE constructors
             | ;

className : NON_TERMINAL OPEN arguments CLOSE ;

arguments :
          | argument ARGUMENT_DELIMITER arguments
          | argument ;

argument : TYPE VAR_NAME ;

rules : targetRule NEW_LINE rules
      | ;

targetRule : NON_TERMINAL code ARROW rightPart
           | NON_TERMINAL ARROW rightPart ;

rightPart : NON_TERMINAL rightPart
          | TERMINAL rightPart
          | NON_TERMINAL
          | TERMINAL
          | EPS ;

// terminal : ~(WS) ; // (~(WS) | EPS) ;

code : CODE_OPEN pureCode CODE_CLOSE ;

pureCode : command1 pureCode
         | command2 pureCode
         | command1
         | command2 ;

command1 : VAR_NAME EQ (VAR_NAME | NON_TERMINAL_FIELD) END_COMMAND ;

command2 : TERMINAL END_COMMAND ;

/*
Set<String> terminals
Set<String> non-terminals

Map<String, Set<List<String>>> non-terminal, rightParts

Set<String> non-terminals with eps rules   after all parsing we will search

String start-non-terminal

*/

EQ : '=' ;
END_COMMAND : ';' ;
CODE_OPEN : '{' ;
CODE_CLOSE : '}' ;
OPEN : '(' ;
CLOSE : ')' ;
TYPE : ('int' | 'double' | 'String') ; // ('int' | 'do')
ARGUMENT_DELIMITER: ',' ;
EPS : 'eps' ;
NEW_LINE : '\n' ;
NON_TERMINAL_FIELD : NON_TERMINAL INDEX FIELD ;
fragment INDEX : '[' NUMBER+ ']' ;
fragment FIELD : '.' VAR_NAME ;
VAR_NAME : LOWER_CASE_LETTERS NUMBER* ;
NON_TERMINAL : UPPER_CASE_LETTERS NUMBER*;
ARROW : '->' ;
fragment NUMBER : [0-9] ;
UPPER_CASE_LETTERS : [A-Z]+ ;
fragment LOWER_CASE_LETTERS : [a-z]+ ;
WS : [ \t\r]+ -> skip ;
TERMINAL : '±' T+ '±'; //  ~[ \t\r];
fragment T : ~[±] ;

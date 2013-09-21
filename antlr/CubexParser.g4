parser grammar CubexParser;
options { tokenVocab = CubexLexer; }

type returns [CubexType cub]
	: TYPEPARAM { 
	| TYPE
	|
	|
	|

iface returns [CubexInterface cub]
	: INTERFACE name=(VARFUN | TYPE) LANGLE kcon=*bigtheta* RANGLE  EXTENDS t=type LBRACE *listfunctions* RBRACE

class returns [CubexClass cub] 
	: CLASS name=(VARFUN | TYPE) LANGLE kcon=*bigtheta* RANGLE LPAREN tcon=*RO* RPAREN EXTENDS t=type LBRACE *weird things* RBRACE

expr returns [CubexExpression cub]
	: VARFUN { $cub = new CubexVariable($VARFUN.text) }
	| name=(VARFUN | TYPE) LANGLE tes=exprs RANGLE LPAREN pes=exprs RPAREN { $cub = new CubexFunctionCall($name.text, $tes.cub, $pes.cub) }
	| name=(VARFUN | TYPE) LPAREN pes=exprs RPAREN { $cub = new CubexFunctionCall($name.text, $pes.cub) }
	| ex=expr DOT VARFUN LANGLE tes=exprs RANGLE LPAREN pes=exprs RPAREN { $cub = new CubexFunctionCall($name.text, $tes.cub, $pes.cub) }
	| ex=expr DOT VARFUN LPAREN pes=exprs RPAREN { $cub = new CubexFunctionCall($name.text, $pes.cub) }
	| LBRACKET es=exprs RBRACKET {$cub = new CubexIterable($es.cub); }
	| ex=expr PLPL ex2=expr { $cub = new CubexAppend($ex.cub, $ex2.cub); }
	| TRUE { $cub = new CubexBoolean(true) }
	| FALSE { $cub = new CubexBoolean(false) }
	| INTEGER { $cub = new CubexInteger($INTEGER.int); }
	| STRING { $cub = new CubexString($STRING.text); }
	| op=(DASH | BANG) e=expr 
	  { $cub = $op.type == DASH ? new CubexNegative($e.cub) : new CubexNegate($e.cub);}
	| l=expr op=(STAR | SLASH | PERCENT) r=expr
		{ $cub = $op.type == STAR
            ? new CubexMultiply($l.cub, $r.cub)
            : $op.type == SLASH
            ? new CubexDivide($l.cub, $r.cub)
            : new CubexMod($l.cub, $r.cub); }
	| l=expr (PLUS | DASH) r=expr
		{ $cub = $op.type == PLUS
             ? new CubexAdd($l.cub, $r.cub)
             : new CubexSubtract($l.cub, $r.cub); }
	| l=expr
		(op=LANGLE | op=LANGLE eq=EQUAL | op=RANGLE | op=RANGLE eq=EQUAL)
		r=expr
		{ CubexExpression l = $op.type == LANGLE ? $l.cub : $r.cub;
          CubexExpression r = $op.type == LANGLE ? $r.cub : $l.cub;
          $cub = $eq == null ? new CubexLessStrict(l, r) : new CubexLessEqual(l, r); }
	| l=expr (op=EQUAL EQUAL | op=BANG EQUAL) r=expr
		{ $cub = new CubexEquals($l.cub, $r.cub);
		  if ($op.type == BANG) $cub = new CubexNegate($cub); }
    | l=expr AMPERSAND r=expr { $cub = new CubexAnd($l.cub, $r.cub); } 
    | l=expr PIPE r=expr  { $cub = new CubexOr($l.cub, $r.cub); };
    | l=expr op=(THROUGH | LDOT | DOTL | LL) r=expr 
		{ $cub = $op.type == THROUGH
				 ? new CubexThrough($l.cub, $r.cub, true, true)
				 : $op.type == LDOT
				 ? new CubexThrough($l.cub, $r.cub, false, true)
				 : $op.type == DOTL
				 ? new CubexThrough($l.cub, $r.cub, true, false)
				 : $op.type == LL
				 ? new CubexThrough($l.cub, $r.cub, false, false)} 
	| l=expr op=(ONW | LDOTDOT)
		{ $cub = $op.type == ONW
		         ? new CubexOnwards($l.cub, true)
				 : new CubexOnwards($l.cub, false)}
exprs returns [List<CubexExpression> cub]


	
statement returns [CubexExpression cub]
  : LBRACE statement (statement)* RBRACE
  | CLASSID GET expr SEMICOLON
  | IF LPAREN expr RPAREN statement ELSE statement
  | WHILE LPAREN expr RPAREN statement
  | FOR LPAREN VARFUN IN expr RPAREN statement
  | RETURN expr;
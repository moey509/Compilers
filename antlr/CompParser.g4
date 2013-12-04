parser grammar CompParser;
options { tokenVocab = CubexLexer; }

@header {
package parser;
import java.util.*;
import parsingTokens.*;
import parsingTokens.expressions.*;
import parsingTokens.context.*;
import parsingTokens.operations.*;
import parsingTokens.program.*;
import parsingTokens.statements.*;
import parsingTokens.typeGrammar.*;
import parsingTokens.comprehension.*;
}
@parser::members {
  CubexProgram programAST; 
}

kcont returns [CubexList<String> cub] : { $cub = new CubexList<String>(); }
                                        (t=TYPEPARAM { $cub.add($t.text); }
                                          (COMMA t=TYPEPARAM { $cub.add($t.text); })*
                                        )?
;

ttuple returns [CubexTypeTuple cub] : VARFUN COLON t=type { $cub = new CubexTypeTuple($VARFUN.text, $t.cub); }
;

tcont returns [CubexList<CubexTypeTuple> cub] : { $cub = new CubexList<CubexTypeTuple>(); }
                                                (t=ttuple { $cub.add($t.cub); }
                                                 (COMMA t=ttuple { $cub.add($t.cub); })*
                                                )?
;

type returns [CubexTypeGrammar cub]
  : TYPEPARAM { $cub = new CubexTypeName($TYPEPARAM.text); }
  | {CubexList<CubexTypeGrammar> typeslist = new CubexList<CubexTypeGrammar>();} 
    CLASSID (LANGLE (t=types { typeslist = $t.cub; } ) RANGLE)? { $cub = new CubexTypeClass($CLASSID.text, typeslist); }
  | t1=type AMPERSAND t2=type { $cub = new CubexTypeIntersection($t1.cub, $t2.cub); }
  | THING { $cub = new CubexTypeName($THING.text); }
  | NOTHING { $cub = new CubexTypeName($NOTHING.text); }
;

types returns [CubexList<CubexTypeGrammar> cub] : { $cub = new CubexList<CubexTypeGrammar>(); }
                                                  (t=type { $cub.add($t.cub); }
                                                  (COMMA t=type { $cub.add($t.cub); })*
                                                  )?
;

tscheme returns [CubexTypeScheme cub] 
  : {CubexList<String> kcontlist = new CubexList<String>();} 
    (LANGLE k=kcont { kcontlist = $k.cub; }  RANGLE)? LPAREN tcont RPAREN COLON type { 
    $cub = new CubexTypeScheme(kcontlist, $tcont.cub, $type.cub); }
;

comp returns [Comp cub]
  : e=expr { $cub = new CompPair($e.cub, null); }
  | e=expr COMMA c=comp { $cub = new CompPair($e.cub, $c.cub); }
  | IF LPAREN e=expr RPAREN c=comp { $cub = new CompIf($e.cub, $c.cub); }
  | FOR LPAREN VARFUN IN e=expr RPAREN c=comp { $cub = new CompFor($VARFUN.text, $e.cub, $c.cub); }
;

expr returns [CubexExpression cub]
  : VARFUN { $cub = new CubexExpression($VARFUN.text); }
  | LPAREN e=expr RPAREN  { $cub = $e.cub; }
  | {CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();} 
    name=(VARFUN | CLASSID) (LANGLE tes=types { teslist = $tes.cub; }  RANGLE)? LPAREN pes=exprs RPAREN 
    { $cub = new CubexFunctionCall($name.text, teslist, $pes.cub); }
  |  ex=expr DOT VARFUN {CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();} (LANGLE tes=types { teslist = $tes.cub; }  RANGLE)? LPAREN pes=exprs RPAREN 
    { $cub = new CubexFunctionApp($ex.cub, $VARFUN.text, teslist, $pes.cub); }
  | LBRACKET c=comp RBRACKET {$cub = new CubexIterableComp($c.cub); }
  | LBRACKET RBRACKET {$cub = new CubexIterableComp(null); }
  | TRUE { $cub = new CubexBoolean(true); }
  | FALSE { $cub = new CubexBoolean(false); }
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
  | l=expr op=(PLUS | DASH) r=expr
    { $cub = $op.type == PLUS
           ? new CubexAdd($l.cub, $r.cub)
           : new CubexSubtract($l.cub, $r.cub); 
    }
  | l=expr ((op=(THROUGH | LDOT | DOTL | LL ) r=expr) |
            (op=(ONW | LDOTDOT)))
    { $cub = $op.type == THROUGH
           ? new CubexThrough($l.cub, $r.cub, true, true)
           : $op.type == LDOT
           ? new CubexThrough($l.cub, $r.cub, false, true)
           : $op.type == DOTL
           ? new CubexThrough($l.cub, $r.cub, true, false)
           : $op.type == LL
           ? new CubexThrough($l.cub, $r.cub, false, false)
           : $op.type == ONW
           ? new CubexOnwards($l.cub, true)
           : new CubexOnwards($l.cub, false)
           ;
    } 
  | ex=expr PLPL ex2=expr { $cub = new CubexAppend($ex.cub, $ex2.cub); }
  | left=expr
    (op=LANGLE | op=LEQ | op=RANGLE | op=GEQ)
    right=expr
    { CubexExpression l = ($op.type == LANGLE || $op.type == LEQ) ? $left.cub : $right.cub;
      CubexExpression r = ($op.type == LANGLE || $op.type == LEQ) ? $right.cub : $left.cub;
      $cub = (($op.type == LEQ || $op.type == GEQ)) ? new CubexLessNotStrict(l, r) : new CubexLessStrict(l, r);
    }
  | l=expr op=(EQEQ | NEQ) r=expr
    { $cub = new CubexEquals($l.cub, $r.cub);
      if ($op.type == NEQ) $cub = new CubexNegate($cub); 
    }
  | l=expr op=AMPERSAND r=expr { $cub = new CubexAnd($l.cub, $r.cub); } 
  | l=expr op=PIPE r=expr { $cub = new CubexOr($l.cub, $r.cub); }
;
exprs returns [CubexList<CubexExpression> cub] 
  : { $cub = new CubexList<CubexExpression>(); }
    (e=expr { $cub.add($e.cub); }
    (COMMA e=expr { $cub.add($e.cub); })*
    )?
;

funcoption returns [CubexFunctionDef cub]
  : { CubexStatement state = null; }
    FUN VARFUN t=tscheme (s=statement {state=$s.cub;} | SEMICOLON) {$cub = new CubexFunctionDef($VARFUN.text, $t.cub, state);}
;

func returns [CubexFunctionDef cub]
  : FUN VARFUN t=tscheme s=statement { $cub = new CubexFunctionDef($VARFUN.text, $t.cub, $s.cub); }
;

funcs returns [CubexList<CubexFunctionDef> cub]
  : { $cub = new CubexList<CubexFunctionDef>(); }
    (f=func { $cub.add($f.cub); } )+
;

statement returns [CubexStatement cub]
  : LBRACE s=statementsopt RBRACE { $cub = new CubexListStatement($s.cub); }
  | c=VARFUN GET e=expr SEMICOLON { $cub = new CubexBind($c.text, $e.cub); }
  | IF LPAREN e=expr RPAREN s1=statement ELSE s2=statement { $cub = new CubexIf($e.cub, $s1.cub, $s2.cub); }
  | IF LPAREN e=expr RPAREN s1=statement { $cub = new CubexIf($e.cub, $s1.cub, null); }
  | WHILE LPAREN e=expr RPAREN s2=statement { $cub = new CubexWhile($e.cub, $s2.cub); }
  | FOR LPAREN VARFUN IN e=expr RPAREN s2=statement { $cub = new CubexFor($VARFUN.text, $e.cub, $s2.cub); }
  | (RETURN| EQUAL) e=expr SEMICOLON { $cub = new CubexReturn($e.cub); }
;

statements returns [CubexList<CubexStatement> cub]
  : { $cub = new CubexList<CubexStatement>(); }
    (s=statement { $cub.add($s.cub); } )+
;

statementsopt returns [CubexList<CubexStatement> cub]
  : { $cub = new CubexList<CubexStatement>(); }
    (s = statement { $cub.add($s.cub); })*
;

iface returns [CubexInterface cub]
  : { CubexList<CubexFunctionDef> list = new CubexList<CubexFunctionDef>(); 
      CubexList<String> klist = new CubexList<String>();
      CubexTypeGrammar typegrammar = new CubexTypeName("Thing");
    }
    INTERFACE name=(VARFUN | CLASSID) (LANGLE k=kcont RANGLE { klist = $k.cub; }  )?
    ((EXTENDS t=type) { typegrammar = $t.cub; } )?
    LBRACE (f=funcoption { list.add($f.cub); })* RBRACE
    { $cub = new CubexInterface($name.text, klist, typegrammar, list); }
;
  
classgrammar returns [CubexClassGrammar cub]
  : { CubexList<CubexFunctionDef> list = new CubexList<CubexFunctionDef>(); 
      CubexList<String> klist = new CubexList<String>();
      CubexTypeGrammar typegrammar = new CubexTypeName("Thing");
      CubexList<CubexExpression> elist = new CubexList<CubexExpression>();
    }
    CLASS name=(VARFUN | CLASSID) (LANGLE k=kcont RANGLE { klist = $k.cub; }  )? LPAREN t=tcont RPAREN 
    ((EXTENDS ty=type) { typegrammar = $ty.cub; } )? LBRACE s=statementsopt 
    ((SUPER LPAREN e=exprs RPAREN SEMICOLON) { elist = $e.cub; } )? (f=func { list.add($f.cub); })* RBRACE
    { $cub = new CubexClassGrammar($name.text, klist, $t.cub, typegrammar, $s.cub, elist, list); }
;
  
program returns [CubexProgram cub]
  : s=statement { $cub = new CubexProgram(new CubexProgramStatement($s.cub), null); }
  | s2=statements p=program { $cub = new CubexProgram(new CubexProgramStatementList($s2.cub), $p.cub); }
  | f=funcs p=program { $cub = new CubexProgram(new CubexProgramFunctionList($f.cub), $p.cub); }
  | i=iface p=program { $cub = new CubexProgram(new CubexProgramInterface($i.cub), $p.cub); }
  | c=classgrammar p=program { $cub = new CubexProgram(new CubexProgramClass($c.cub), $p.cub); }
;

fullprogram : p=program { programAST = $p.cub; };

parser grammar CubexParser;
options { tokenVocab = CubexLexer; }

@header {
import java.util.*;
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

expr returns [CubexExpression cub]
  : VARFUN { $cub = new CubexExpression($VARFUN.text); }
  | {CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();} 
    name=(VARFUN | CLASSID) (LANGLE tes=types { teslist = $tes.cub; }  RANGLE)? LPAREN pes=exprs RPAREN 
    { $cub = new CubexFunctionCall($name.text, teslist, $pes.cub); }
  |  ex=expr DOT VARFUN {CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();} (LANGLE tes=types { teslist = $tes.cub; }  RANGLE)? LPAREN pes=exprs RPAREN 
    { $cub = new CubexFunctionApp($ex.cub, $VARFUN.text, teslist, $pes.cub); }
  | LBRACKET es=exprs RBRACKET {$cub = new CubexIterable($es.cub); }
  | ex=expr PLPL ex2=expr { $cub = new CubexAppend($ex.cub, $ex2.cub); }
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
  | l=expr (PLUS | DASH) r=expr
    { $cub = $op.type == PLUS
             ? new CubexAdd($l.cub, $r.cub)
             : new CubexSubtract($l.cub, $r.cub); }
  | left=expr
    (op=LANGLE | op=LANGLE eq=EQUAL | op=RANGLE | op=RANGLE eq=EQUAL)
    right=expr
    { CubexExpression l = $op.type == LANGLE ? $left.cub : $right.cub;
          CubexExpression r = $op.type == LANGLE ? $right.cub : $left.cub;
          $cub = $eq == null ? new CubexLessStrict(l, r) : new CubexLessNotStrict(l, r); }
  | l=expr (op=EQUAL EQUAL | op=BANG EQUAL) r=expr
    { $cub = new CubexEquals($l.cub, $r.cub);
      if ($op.type == BANG) $cub = new CubexNegate($cub); }
    | l=expr AMPERSAND r=expr { $cub = new CubexAnd($l.cub, $r.cub); } 
    | l=expr PIPE r=expr  { $cub = new CubexOr($l.cub, $r.cub); }
    | l=expr op=(THROUGH | LDOT | DOTL | LL) r=expr 
    { $cub = $op.type == THROUGH
         ? new CubexThrough($l.cub, $r.cub, true, true)
         : $op.type == LDOT
         ? new CubexThrough($l.cub, $r.cub, false, true)
         : $op.type == DOTL
         ? new CubexThrough($l.cub, $r.cub, true, false)
         : new CubexThrough($l.cub, $r.cub, false, false);
    } 
  | l=expr op=(ONW | LDOTDOT)
    { $cub = $op.type == ONW
             ? new CubexOnwards($l.cub, true)
             : new CubexOnwards($l.cub, false);}
;
exprs returns [CubexList<CubexExpression> cub] 
  : { $cub = new CubexList<CubexExpression>(); }
    (e=expr { $cub.add($e.cub); }
    (COMMA e=expr { $cub.add($e.cub); })*
    )?
;

funcoption returns [CubexFunctionDef cub]
  : FUN VARFUN t=tscheme (s=statement | SEMICOLON) {$cub = new CubexFunctionDef($VARFUN.text, $t.cub, $s.cub);}
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

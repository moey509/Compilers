package parser;
// Generated from CubexParser.g4 by ANTLR 4.1

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import parsingTokens.CubexInterface;
import parsingTokens.CubexListStatement;
import parsingTokens.context.CubexClassGrammar;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.expressions.CubexAppend;
import parsingTokens.expressions.CubexBoolean;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.expressions.CubexFunctionCall;
import parsingTokens.expressions.CubexFunctionDef;
import parsingTokens.expressions.CubexInteger;
import parsingTokens.expressions.CubexIterable;
import parsingTokens.expressions.CubexLessNotStrict;
import parsingTokens.expressions.CubexLessStrict;
import parsingTokens.expressions.CubexOnwards;
import parsingTokens.expressions.CubexString;
import parsingTokens.expressions.CubexThrough;
import parsingTokens.operations.CubexAdd;
import parsingTokens.operations.CubexAnd;
import parsingTokens.operations.CubexDivide;
import parsingTokens.operations.CubexEquals;
import parsingTokens.operations.CubexMod;
import parsingTokens.operations.CubexMultiply;
import parsingTokens.operations.CubexNegate;
import parsingTokens.operations.CubexNegative;
import parsingTokens.operations.CubexOr;
import parsingTokens.operations.CubexSubtract;
import parsingTokens.program.CubexProgram;
import parsingTokens.program.CubexProgramClass;
import parsingTokens.program.CubexProgramFunctionList;
import parsingTokens.program.CubexProgramInterface;
import parsingTokens.program.CubexProgramStatement;
import parsingTokens.program.CubexProgramStatementList;
import parsingTokens.statements.CubexBind;
import parsingTokens.statements.CubexFor;
import parsingTokens.statements.CubexIf;
import parsingTokens.statements.CubexList;
import parsingTokens.statements.CubexReturn;
import parsingTokens.statements.CubexStatement;
import parsingTokens.statements.CubexWhile;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeIntersection;
import parsingTokens.typeGrammar.CubexTypeName;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CubexParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=11, STAR=43, WHILE=3, ONW=22, LL=25, LANGLE=49, LBRACE=41, THING=15, 
		FOR=8, LDOTDOT=26, DOTL=24, LPAREN=37, IF=4, LBRACKET=32, RPAREN=38, SLASH=44, 
		IN=9, COMMA=39, EQUAL=36, RETURN=2, NOTHING=16, PIPE=53, GET=35, PLUS=47, 
		TYPEPARAM=19, SUPER=12, GEQ=28, RANGLE=50, RBRACKET=33, COMMENT=56, DOT=31, 
		LDOT=23, EQEQ=29, INTEGER=20, PLPL=46, RBRACE=42, PERCENT=45, DASH=48, 
		ELSE=5, AMPERSAND=52, BANG=51, SEMICOLON=40, TRUE=6, COLON=34, WS=54, 
		NEQ=30, CLASSID=18, THROUGH=21, INTERFACE=10, VARFUN=17, FUN=13, FALSE=7, 
		EXTENDS=14, NESTEDCOMMENT=55, STRING=1, LEQ=27;
	public static final String[] tokenNames = {
		"<INVALID>", "STRING", "'return'", "'while'", "'if'", "'else'", "'true'", 
		"'false'", "'for'", "'in'", "'interface'", "'class'", "'super'", "'fun'", 
		"'extends'", "'Thing'", "'Nothing'", "VARFUN", "CLASSID", "TYPEPARAM", 
		"INTEGER", "'..'", "'...'", "'<.'", "'.<'", "'<<'", "'<..'", "'<='", "'>='", 
		"'=='", "'!='", "'.'", "'['", "']'", "':'", "':='", "'='", "'('", "')'", 
		"','", "';'", "'{'", "'}'", "'*'", "'/'", "'%'", "'++'", "'+'", "'-'", 
		"'<'", "'>'", "'!'", "'&'", "'|'", "WS", "NESTEDCOMMENT", "COMMENT"
	};
	public static final int
		RULE_kcont = 0, RULE_ttuple = 1, RULE_tcont = 2, RULE_type = 3, RULE_types = 4, 
		RULE_tscheme = 5, RULE_expr = 6, RULE_exprs = 7, RULE_funcoption = 8, 
		RULE_func = 9, RULE_funcs = 10, RULE_statement = 11, RULE_statements = 12, 
		RULE_statementsopt = 13, RULE_iface = 14, RULE_classgrammar = 15, RULE_program = 16, 
		RULE_fullprogram = 17;
	public static final String[] ruleNames = {
		"kcont", "ttuple", "tcont", "type", "types", "tscheme", "expr", "exprs", 
		"funcoption", "func", "funcs", "statement", "statements", "statementsopt", 
		"iface", "classgrammar", "program", "fullprogram"
	};

	@Override
	public String getGrammarFileName() { return "CubexParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	  CubexProgram programAST; 

	public CubexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class KcontContext extends ParserRuleContext {
		public CubexList<String> cub;
		public Token t;
		public TerminalNode TYPEPARAM(int i) {
			return getToken(CubexParser.TYPEPARAM, i);
		}
		public List<TerminalNode> TYPEPARAM() { return getTokens(CubexParser.TYPEPARAM); }
		public List<TerminalNode> COMMA() { return getTokens(CubexParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CubexParser.COMMA, i);
		}
		public KcontContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kcont; }
	}

	public final KcontContext kcont() throws RecognitionException {
		KcontContext _localctx = new KcontContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_kcont);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((KcontContext)_localctx).cub =  new CubexList<String>(); 
			setState(47);
			_la = _input.LA(1);
			if (_la==TYPEPARAM) {
				{
				setState(37); ((KcontContext)_localctx).t = match(TYPEPARAM);
				 _localctx.cub.add((((KcontContext)_localctx).t!=null?((KcontContext)_localctx).t.getText():null)); 
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(39); match(COMMA);
					setState(40); ((KcontContext)_localctx).t = match(TYPEPARAM);
					 _localctx.cub.add((((KcontContext)_localctx).t!=null?((KcontContext)_localctx).t.getText():null)); 
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TtupleContext extends ParserRuleContext {
		public CubexTypeTuple cub;
		public Token VARFUN;
		public TypeContext t;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CubexParser.COLON, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public TtupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ttuple; }
	}

	public final TtupleContext ttuple() throws RecognitionException {
		TtupleContext _localctx = new TtupleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ttuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); ((TtupleContext)_localctx).VARFUN = match(VARFUN);
			setState(50); match(COLON);
			setState(51); ((TtupleContext)_localctx).t = type(0);
			 ((TtupleContext)_localctx).cub =  new CubexTypeTuple((((TtupleContext)_localctx).VARFUN!=null?((TtupleContext)_localctx).VARFUN.getText():null), ((TtupleContext)_localctx).t.cub); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TcontContext extends ParserRuleContext {
		public CubexList<CubexTypeTuple> cub;
		public TtupleContext t;
		public List<TtupleContext> ttuple() {
			return getRuleContexts(TtupleContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(CubexParser.COMMA); }
		public TtupleContext ttuple(int i) {
			return getRuleContext(TtupleContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(CubexParser.COMMA, i);
		}
		public TcontContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tcont; }
	}

	public final TcontContext tcont() throws RecognitionException {
		TcontContext _localctx = new TcontContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tcont);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TcontContext)_localctx).cub =  new CubexList<CubexTypeTuple>(); 
			setState(66);
			_la = _input.LA(1);
			if (_la==VARFUN) {
				{
				setState(55); ((TcontContext)_localctx).t = ttuple();
				 _localctx.cub.add(((TcontContext)_localctx).t.cub); 
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(57); match(COMMA);
					setState(58); ((TcontContext)_localctx).t = ttuple();
					 _localctx.cub.add(((TcontContext)_localctx).t.cub); 
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public int _p;
		public CubexTypeGrammar cub;
		public TypeContext t1;
		public Token TYPEPARAM;
		public Token CLASSID;
		public TypesContext t;
		public Token THING;
		public Token NOTHING;
		public TypeContext t2;
		public TerminalNode AMPERSAND() { return getToken(CubexParser.AMPERSAND, 0); }
		public TerminalNode TYPEPARAM() { return getToken(CubexParser.TYPEPARAM, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode CLASSID() { return getToken(CubexParser.CLASSID, 0); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode THING() { return getToken(CubexParser.THING, 0); }
		public TerminalNode LANGLE() { return getToken(CubexParser.LANGLE, 0); }
		public TerminalNode NOTHING() { return getToken(CubexParser.NOTHING, 0); }
		public TerminalNode RANGLE() { return getToken(CubexParser.RANGLE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState, _p);
		TypeContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			switch (_input.LA(1)) {
			case TYPEPARAM:
				{
				setState(69); ((TypeContext)_localctx).TYPEPARAM = match(TYPEPARAM);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).TYPEPARAM!=null?((TypeContext)_localctx).TYPEPARAM.getText():null)); 
				}
				break;
			case CLASSID:
				{
				CubexList<CubexTypeGrammar> typeslist = new CubexList<CubexTypeGrammar>();
				setState(72); ((TypeContext)_localctx).CLASSID = match(CLASSID);
				setState(79);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(73); match(LANGLE);
					{
					setState(74); ((TypeContext)_localctx).t = types();
					 typeslist = ((TypeContext)_localctx).t.cub; 
					}
					setState(77); match(RANGLE);
					}
					break;
				}
				 ((TypeContext)_localctx).cub =  new CubexTypeClass((((TypeContext)_localctx).CLASSID!=null?((TypeContext)_localctx).CLASSID.getText():null), typeslist); 
				}
				break;
			case THING:
				{
				setState(82); ((TypeContext)_localctx).THING = match(THING);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).THING!=null?((TypeContext)_localctx).THING.getText():null)); 
				}
				break;
			case NOTHING:
				{
				setState(84); ((TypeContext)_localctx).NOTHING = match(NOTHING);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).NOTHING!=null?((TypeContext)_localctx).NOTHING.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState, _p);
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(88);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(89); match(AMPERSAND);
					setState(90); ((TypeContext)_localctx).t2 = type(4);
					 ((TypeContext)_localctx).cub =  new CubexTypeIntersection(((TypeContext)_localctx).t1.cub, ((TypeContext)_localctx).t2.cub); 
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public CubexList<CubexTypeGrammar> cub;
		public TypeContext t;
		public List<TerminalNode> COMMA() { return getTokens(CubexParser.COMMA); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(CubexParser.COMMA, i);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TypesContext)_localctx).cub =  new CubexList<CubexTypeGrammar>(); 
			setState(110);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THING) | (1L << NOTHING) | (1L << CLASSID) | (1L << TYPEPARAM))) != 0)) {
				{
				setState(99); ((TypesContext)_localctx).t = type(0);
				 _localctx.cub.add(((TypesContext)_localctx).t.cub); 
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(101); match(COMMA);
					setState(102); ((TypesContext)_localctx).t = type(0);
					 _localctx.cub.add(((TypesContext)_localctx).t.cub); 
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TschemeContext extends ParserRuleContext {
		public CubexTypeScheme cub;
		public KcontContext k;
		public TcontContext tcont;
		public TypeContext type;
		public TcontContext tcont() {
			return getRuleContext(TcontContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CubexParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LANGLE() { return getToken(CubexParser.LANGLE, 0); }
		public TerminalNode LPAREN() { return getToken(CubexParser.LPAREN, 0); }
		public KcontContext kcont() {
			return getRuleContext(KcontContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CubexParser.COLON, 0); }
		public TerminalNode RANGLE() { return getToken(CubexParser.RANGLE, 0); }
		public TschemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tscheme; }
	}

	public final TschemeContext tscheme() throws RecognitionException {
		TschemeContext _localctx = new TschemeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tscheme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			CubexList<String> kcontlist = new CubexList<String>();
			setState(118);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(113); match(LANGLE);
				setState(114); ((TschemeContext)_localctx).k = kcont();
				 kcontlist = ((TschemeContext)_localctx).k.cub; 
				setState(116); match(RANGLE);
				}
			}

			setState(120); match(LPAREN);
			setState(121); ((TschemeContext)_localctx).tcont = tcont();
			setState(122); match(RPAREN);
			setState(123); match(COLON);
			setState(124); ((TschemeContext)_localctx).type = type(0);
			 
			    ((TschemeContext)_localctx).cub =  new CubexTypeScheme(kcontlist, ((TschemeContext)_localctx).tcont.cub, ((TschemeContext)_localctx).type.cub); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public CubexExpression cub;
		public ExprContext ex;
		public ExprContext l;
		public ExprContext left;
		public Token op;
		public ExprContext e;
		public Token VARFUN;
		public Token name;
		public TypesContext tes;
		public ExprsContext pes;
		public ExprsContext es;
		public Token INTEGER;
		public Token STRING;
		public ExprContext r;
		public ExprContext ex2;
		public ExprContext right;
		public TerminalNode TRUE() { return getToken(CubexParser.TRUE, 0); }
		public TerminalNode LANGLE() { return getToken(CubexParser.LANGLE, 0); }
		public TerminalNode STAR() { return getToken(CubexParser.STAR, 0); }
		public TerminalNode PLPL() { return getToken(CubexParser.PLPL, 0); }
		public TerminalNode LDOT() { return getToken(CubexParser.LDOT, 0); }
		public TerminalNode RBRACKET() { return getToken(CubexParser.RBRACKET, 0); }
		public TerminalNode AMPERSAND() { return getToken(CubexParser.AMPERSAND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLASSID() { return getToken(CubexParser.CLASSID, 0); }
		public TerminalNode PLUS() { return getToken(CubexParser.PLUS, 0); }
		public TerminalNode ONW() { return getToken(CubexParser.ONW, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(CubexParser.PIPE, 0); }
		public TerminalNode GEQ() { return getToken(CubexParser.GEQ, 0); }
		public TerminalNode EQEQ() { return getToken(CubexParser.EQEQ, 0); }
		public TerminalNode PERCENT() { return getToken(CubexParser.PERCENT, 0); }
		public TerminalNode BANG() { return getToken(CubexParser.BANG, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode DASH() { return getToken(CubexParser.DASH, 0); }
		public TerminalNode LPAREN() { return getToken(CubexParser.LPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(CubexParser.LBRACKET, 0); }
		public TerminalNode RANGLE() { return getToken(CubexParser.RANGLE, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public TerminalNode NEQ() { return getToken(CubexParser.NEQ, 0); }
		public TerminalNode LL() { return getToken(CubexParser.LL, 0); }
		public TerminalNode DOT() { return getToken(CubexParser.DOT, 0); }
		public TerminalNode LDOTDOT() { return getToken(CubexParser.LDOTDOT, 0); }
		public TerminalNode THROUGH() { return getToken(CubexParser.THROUGH, 0); }
		public TerminalNode RPAREN() { return getToken(CubexParser.RPAREN, 0); }
		public TerminalNode LEQ() { return getToken(CubexParser.LEQ, 0); }
		public TerminalNode DOTL() { return getToken(CubexParser.DOTL, 0); }
		public TerminalNode INTEGER() { return getToken(CubexParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(CubexParser.STRING, 0); }
		public TerminalNode SLASH() { return getToken(CubexParser.SLASH, 0); }
		public TerminalNode FALSE() { return getToken(CubexParser.FALSE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(128);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DASH || _la==BANG) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(129); ((ExprContext)_localctx).e = expr(9);
				 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DASH ? new CubexNegative(((ExprContext)_localctx).e.cub) : new CubexNegate(((ExprContext)_localctx).e.cub);
				}
				break;

			case 2:
				{
				setState(132); ((ExprContext)_localctx).VARFUN = match(VARFUN);
				 ((ExprContext)_localctx).cub =  new CubexExpression((((ExprContext)_localctx).VARFUN!=null?((ExprContext)_localctx).VARFUN.getText():null)); 
				}
				break;

			case 3:
				{
				setState(134); match(LPAREN);
				setState(135); ((ExprContext)_localctx).e = expr(0);
				setState(136); match(RPAREN);
				 ((ExprContext)_localctx).cub =  ((ExprContext)_localctx).e.cub; 
				}
				break;

			case 4:
				{
				CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();
				setState(140);
				((ExprContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VARFUN || _la==CLASSID) ) {
					((ExprContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(146);
				_la = _input.LA(1);
				if (_la==LANGLE) {
					{
					setState(141); match(LANGLE);
					setState(142); ((ExprContext)_localctx).tes = types();
					 teslist = ((ExprContext)_localctx).tes.cub; 
					setState(144); match(RANGLE);
					}
				}

				setState(148); match(LPAREN);
				setState(149); ((ExprContext)_localctx).pes = exprs();
				setState(150); match(RPAREN);
				 ((ExprContext)_localctx).cub =  new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), teslist, ((ExprContext)_localctx).pes.cub); 
				}
				break;

			case 5:
				{
				setState(153); match(LBRACKET);
				setState(154); ((ExprContext)_localctx).es = exprs();
				setState(155); match(RBRACKET);
				((ExprContext)_localctx).cub =  new CubexIterable(((ExprContext)_localctx).es.cub); 
				}
				break;

			case 6:
				{
				setState(158); match(TRUE);
				 ((ExprContext)_localctx).cub =  new CubexBoolean(true); 
				}
				break;

			case 7:
				{
				setState(160); match(FALSE);
				 ((ExprContext)_localctx).cub =  new CubexBoolean(false); 
				}
				break;

			case 8:
				{
				setState(162); ((ExprContext)_localctx).INTEGER = match(INTEGER);
				 ((ExprContext)_localctx).cub =  new CubexInteger((((ExprContext)_localctx).INTEGER!=null?Integer.valueOf(((ExprContext)_localctx).INTEGER.getText()):0)); 
				}
				break;

			case 9:
				{
				setState(164); ((ExprContext)_localctx).STRING = match(STRING);
				 ((ExprContext)_localctx).cub =  new CubexString((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(169);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << SLASH) | (1L << PERCENT))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(170); ((ExprContext)_localctx).r = expr(9);
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == STAR
						                     ? new CubexMultiply(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                     : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == SLASH
						                     ? new CubexDivide(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                     : new CubexMod(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(174);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==DASH) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(175); ((ExprContext)_localctx).r = expr(8);
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == PLUS
						                     ? new CubexAdd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                     : new CubexSubtract(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						              
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(179); match(PLPL);
						setState(180); ((ExprContext)_localctx).ex2 = expr(6);
						 ((ExprContext)_localctx).cub =  new CubexAppend(((ExprContext)_localctx).ex.cub, ((ExprContext)_localctx).ex2.cub); 
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(188);
						switch (_input.LA(1)) {
						case LANGLE:
							{
							setState(184); ((ExprContext)_localctx).op = match(LANGLE);
							}
							break;
						case LEQ:
							{
							setState(185); ((ExprContext)_localctx).op = match(LEQ);
							}
							break;
						case RANGLE:
							{
							setState(186); ((ExprContext)_localctx).op = match(RANGLE);
							}
							break;
						case GEQ:
							{
							setState(187); ((ExprContext)_localctx).op = match(GEQ);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(190); ((ExprContext)_localctx).right = expr(5);
						 CubexExpression l = ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LANGLE || (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LEQ) ? ((ExprContext)_localctx).left.cub : ((ExprContext)_localctx).right.cub;
						                CubexExpression r = ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LANGLE || (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LEQ) ? ((ExprContext)_localctx).right.cub : ((ExprContext)_localctx).left.cub;
						                ((ExprContext)_localctx).cub =  (((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LEQ || (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == GEQ)) ? new CubexLessNotStrict(l, r) : new CubexLessStrict(l, r);
						              
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(194);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQEQ || _la==NEQ) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(195); ((ExprContext)_localctx).r = expr(4);
						 ((ExprContext)_localctx).cub =  new CubexEquals(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub);
						                if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == NEQ) ((ExprContext)_localctx).cub =  new CubexNegate(_localctx.cub); 
						              
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(199); ((ExprContext)_localctx).op = match(AMPERSAND);
						setState(200); ((ExprContext)_localctx).r = expr(3);
						 ((ExprContext)_localctx).cub =  new CubexAnd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(204); ((ExprContext)_localctx).op = match(PIPE);
						setState(205); ((ExprContext)_localctx).r = expr(2);
						 ((ExprContext)_localctx).cub =  new CubexOr(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(209); match(DOT);
						setState(210); ((ExprContext)_localctx).VARFUN = match(VARFUN);
						CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();
						setState(217);
						_la = _input.LA(1);
						if (_la==LANGLE) {
							{
							setState(212); match(LANGLE);
							setState(213); ((ExprContext)_localctx).tes = types();
							 teslist = ((ExprContext)_localctx).tes.cub; 
							setState(215); match(RANGLE);
							}
						}

						setState(219); match(LPAREN);
						setState(220); ((ExprContext)_localctx).pes = exprs();
						setState(221); match(RPAREN);
						 ((ExprContext)_localctx).cub =  new CubexFunctionApp(((ExprContext)_localctx).ex.cub, (((ExprContext)_localctx).VARFUN!=null?((ExprContext)_localctx).VARFUN.getText():null), teslist, ((ExprContext)_localctx).pes.cub); 
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(228);
						switch (_input.LA(1)) {
						case THROUGH:
						case LDOT:
						case DOTL:
						case LL:
							{
							{
							setState(225);
							((ExprContext)_localctx).op = _input.LT(1);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THROUGH) | (1L << LDOT) | (1L << DOTL) | (1L << LL))) != 0)) ) {
								((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
							}
							consume();
							setState(226); ((ExprContext)_localctx).r = expr(0);
							}
							}
							break;
						case ONW:
						case LDOTDOT:
							{
							{
							setState(227);
							((ExprContext)_localctx).op = _input.LT(1);
							_la = _input.LA(1);
							if ( !(_la==ONW || _la==LDOTDOT) ) {
								((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
							}
							consume();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == THROUGH
						                     ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, true, true)
						                     : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LDOT
						                     ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, false, true)
						                     : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DOTL
						                     ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, true, false)
						                     : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LL
						                     ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, false, false)
						                     : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == ONW
						                     ? new CubexOnwards(((ExprContext)_localctx).l.cub, true)
						                     : new CubexOnwards(((ExprContext)_localctx).l.cub, false)
						                     ;
						              
						}
						break;
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public CubexList<CubexExpression> cub;
		public ExprContext e;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(CubexParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(CubexParser.COMMA, i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExprsContext)_localctx).cub =  new CubexList<CubexExpression>(); 
			setState(248);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << TRUE) | (1L << FALSE) | (1L << VARFUN) | (1L << CLASSID) | (1L << INTEGER) | (1L << LBRACKET) | (1L << LPAREN) | (1L << DASH) | (1L << BANG))) != 0)) {
				{
				setState(237); ((ExprsContext)_localctx).e = expr(0);
				 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(239); match(COMMA);
					setState(240); ((ExprsContext)_localctx).e = expr(0);
					 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncoptionContext extends ParserRuleContext {
		public CubexFunctionDef cub;
		public Token VARFUN;
		public TschemeContext t;
		public StatementContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CubexParser.SEMICOLON, 0); }
		public TerminalNode FUN() { return getToken(CubexParser.FUN, 0); }
		public TschemeContext tscheme() {
			return getRuleContext(TschemeContext.class,0);
		}
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public FuncoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcoption; }
	}

	public final FuncoptionContext funcoption() throws RecognitionException {
		FuncoptionContext _localctx = new FuncoptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcoption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 CubexStatement state = null; 
			setState(251); match(FUN);
			setState(252); ((FuncoptionContext)_localctx).VARFUN = match(VARFUN);
			setState(253); ((FuncoptionContext)_localctx).t = tscheme();
			setState(258);
			switch (_input.LA(1)) {
			case RETURN:
			case WHILE:
			case IF:
			case FOR:
			case VARFUN:
			case EQUAL:
			case LBRACE:
				{
				setState(254); ((FuncoptionContext)_localctx).s = statement();
				state=((FuncoptionContext)_localctx).s.cub;
				}
				break;
			case SEMICOLON:
				{
				setState(257); match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((FuncoptionContext)_localctx).cub =  new CubexFunctionDef((((FuncoptionContext)_localctx).VARFUN!=null?((FuncoptionContext)_localctx).VARFUN.getText():null), ((FuncoptionContext)_localctx).t.cub, state);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public CubexFunctionDef cub;
		public Token VARFUN;
		public TschemeContext t;
		public StatementContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode FUN() { return getToken(CubexParser.FUN, 0); }
		public TschemeContext tscheme() {
			return getRuleContext(TschemeContext.class,0);
		}
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(FUN);
			setState(263); ((FuncContext)_localctx).VARFUN = match(VARFUN);
			setState(264); ((FuncContext)_localctx).t = tscheme();
			setState(265); ((FuncContext)_localctx).s = statement();
			 ((FuncContext)_localctx).cub =  new CubexFunctionDef((((FuncContext)_localctx).VARFUN!=null?((FuncContext)_localctx).VARFUN.getText():null), ((FuncContext)_localctx).t.cub, ((FuncContext)_localctx).s.cub); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncsContext extends ParserRuleContext {
		public CubexList<CubexFunctionDef> cub;
		public FuncContext f;
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public FuncsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcs; }
	}

	public final FuncsContext funcs() throws RecognitionException {
		FuncsContext _localctx = new FuncsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((FuncsContext)_localctx).cub =  new CubexList<CubexFunctionDef>(); 
			setState(272); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(269); ((FuncsContext)_localctx).f = func();
					 _localctx.cub.add(((FuncsContext)_localctx).f.cub); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(274); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public CubexStatement cub;
		public StatementsoptContext s;
		public Token c;
		public ExprContext e;
		public StatementContext s1;
		public StatementContext s2;
		public Token VARFUN;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode LBRACE() { return getToken(CubexParser.LBRACE, 0); }
		public TerminalNode GET() { return getToken(CubexParser.GET, 0); }
		public TerminalNode SEMICOLON() { return getToken(CubexParser.SEMICOLON, 0); }
		public TerminalNode EQUAL() { return getToken(CubexParser.EQUAL, 0); }
		public TerminalNode RBRACE() { return getToken(CubexParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(CubexParser.LPAREN, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public TerminalNode IN() { return getToken(CubexParser.IN, 0); }
		public TerminalNode WHILE() { return getToken(CubexParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(CubexParser.IF, 0); }
		public StatementsoptContext statementsopt() {
			return getRuleContext(StatementsoptContext.class,0);
		}
		public TerminalNode FOR() { return getToken(CubexParser.FOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(CubexParser.ELSE, 0); }
		public TerminalNode RPAREN() { return getToken(CubexParser.RPAREN, 0); }
		public TerminalNode RETURN() { return getToken(CubexParser.RETURN, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			setState(324);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276); match(LBRACE);
				setState(277); ((StatementContext)_localctx).s = statementsopt();
				setState(278); match(RBRACE);
				 ((StatementContext)_localctx).cub =  new CubexListStatement(((StatementContext)_localctx).s.cub); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281); ((StatementContext)_localctx).c = match(VARFUN);
				setState(282); match(GET);
				setState(283); ((StatementContext)_localctx).e = expr(0);
				setState(284); match(SEMICOLON);
				 ((StatementContext)_localctx).cub =  new CubexBind((((StatementContext)_localctx).c!=null?((StatementContext)_localctx).c.getText():null), ((StatementContext)_localctx).e.cub); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(287); match(IF);
				setState(288); match(LPAREN);
				setState(289); ((StatementContext)_localctx).e = expr(0);
				setState(290); match(RPAREN);
				setState(291); ((StatementContext)_localctx).s1 = statement();
				setState(292); match(ELSE);
				setState(293); ((StatementContext)_localctx).s2 = statement();
				 ((StatementContext)_localctx).cub =  new CubexIf(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s1.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(296); match(IF);
				setState(297); match(LPAREN);
				setState(298); ((StatementContext)_localctx).e = expr(0);
				setState(299); match(RPAREN);
				setState(300); ((StatementContext)_localctx).s1 = statement();
				 ((StatementContext)_localctx).cub =  new CubexIf(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s1.cub, null); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(303); match(WHILE);
				setState(304); match(LPAREN);
				setState(305); ((StatementContext)_localctx).e = expr(0);
				setState(306); match(RPAREN);
				setState(307); ((StatementContext)_localctx).s2 = statement();
				 ((StatementContext)_localctx).cub =  new CubexWhile(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(310); match(FOR);
				setState(311); match(LPAREN);
				setState(312); ((StatementContext)_localctx).VARFUN = match(VARFUN);
				setState(313); match(IN);
				setState(314); ((StatementContext)_localctx).e = expr(0);
				setState(315); match(RPAREN);
				setState(316); ((StatementContext)_localctx).s2 = statement();
				 ((StatementContext)_localctx).cub =  new CubexFor((((StatementContext)_localctx).VARFUN!=null?((StatementContext)_localctx).VARFUN.getText():null), ((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==RETURN || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(320); ((StatementContext)_localctx).e = expr(0);
				setState(321); match(SEMICOLON);
				 ((StatementContext)_localctx).cub =  new CubexReturn(((StatementContext)_localctx).e.cub); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public CubexList<CubexStatement> cub;
		public StatementContext s;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementsContext)_localctx).cub =  new CubexList<CubexStatement>(); 
			setState(330); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(327); ((StatementsContext)_localctx).s = statement();
					 _localctx.cub.add(((StatementsContext)_localctx).s.cub); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(332); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsoptContext extends ParserRuleContext {
		public CubexList<CubexStatement> cub;
		public StatementContext s;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsoptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementsopt; }
	}

	public final StatementsoptContext statementsopt() throws RecognitionException {
		StatementsoptContext _localctx = new StatementsoptContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statementsopt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementsoptContext)_localctx).cub =  new CubexList<CubexStatement>(); 
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << FOR) | (1L << VARFUN) | (1L << EQUAL) | (1L << LBRACE))) != 0)) {
				{
				{
				setState(335); ((StatementsoptContext)_localctx).s = statement();
				 _localctx.cub.add(((StatementsoptContext)_localctx).s.cub); 
				}
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfaceContext extends ParserRuleContext {
		public CubexInterface cub;
		public Token name;
		public KcontContext k;
		public TypeContext t;
		public FuncoptionContext f;
		public TerminalNode LBRACE() { return getToken(CubexParser.LBRACE, 0); }
		public List<FuncoptionContext> funcoption() {
			return getRuleContexts(FuncoptionContext.class);
		}
		public TerminalNode CLASSID() { return getToken(CubexParser.CLASSID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncoptionContext funcoption(int i) {
			return getRuleContext(FuncoptionContext.class,i);
		}
		public TerminalNode LANGLE() { return getToken(CubexParser.LANGLE, 0); }
		public TerminalNode INTERFACE() { return getToken(CubexParser.INTERFACE, 0); }
		public TerminalNode RBRACE() { return getToken(CubexParser.RBRACE, 0); }
		public KcontContext kcont() {
			return getRuleContext(KcontContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(CubexParser.EXTENDS, 0); }
		public TerminalNode RANGLE() { return getToken(CubexParser.RANGLE, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public IfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iface; }
	}

	public final IfaceContext iface() throws RecognitionException {
		IfaceContext _localctx = new IfaceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_iface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 CubexList<CubexFunctionDef> list = new CubexList<CubexFunctionDef>(); 
			      CubexList<String> klist = new CubexList<String>();
			      CubexTypeGrammar typegrammar = new CubexTypeName("Thing");
			    
			setState(344); match(INTERFACE);
			setState(345);
			((IfaceContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((IfaceContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(351);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(346); match(LANGLE);
				setState(347); ((IfaceContext)_localctx).k = kcont();
				setState(348); match(RANGLE);
				 klist = ((IfaceContext)_localctx).k.cub; 
				}
			}

			setState(358);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				{
				setState(353); match(EXTENDS);
				setState(354); ((IfaceContext)_localctx).t = type(0);
				}
				 typegrammar = ((IfaceContext)_localctx).t.cub; 
				}
			}

			setState(360); match(LBRACE);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(361); ((IfaceContext)_localctx).f = funcoption();
				 list.add(((IfaceContext)_localctx).f.cub); 
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(369); match(RBRACE);
			 ((IfaceContext)_localctx).cub =  new CubexInterface((((IfaceContext)_localctx).name!=null?((IfaceContext)_localctx).name.getText():null), klist, typegrammar, list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassgrammarContext extends ParserRuleContext {
		public CubexClassGrammar cub;
		public Token name;
		public KcontContext k;
		public TcontContext t;
		public TypeContext ty;
		public StatementsoptContext s;
		public ExprsContext e;
		public FuncContext f;
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(CubexParser.LBRACE, 0); }
		public TcontContext tcont() {
			return getRuleContext(TcontContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CubexParser.SEMICOLON, 0); }
		public TerminalNode SUPER() { return getToken(CubexParser.SUPER, 0); }
		public TerminalNode RPAREN(int i) {
			return getToken(CubexParser.RPAREN, i);
		}
		public TerminalNode LANGLE() { return getToken(CubexParser.LANGLE, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(CubexParser.LPAREN); }
		public TerminalNode RBRACE() { return getToken(CubexParser.RBRACE, 0); }
		public TerminalNode RANGLE() { return getToken(CubexParser.RANGLE, 0); }
		public TerminalNode CLASS() { return getToken(CubexParser.CLASS, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public TerminalNode LPAREN(int i) {
			return getToken(CubexParser.LPAREN, i);
		}
		public StatementsoptContext statementsopt() {
			return getRuleContext(StatementsoptContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(CubexParser.RPAREN); }
		public TerminalNode CLASSID() { return getToken(CubexParser.CLASSID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public KcontContext kcont() {
			return getRuleContext(KcontContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(CubexParser.EXTENDS, 0); }
		public ClassgrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classgrammar; }
	}

	public final ClassgrammarContext classgrammar() throws RecognitionException {
		ClassgrammarContext _localctx = new ClassgrammarContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classgrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 CubexList<CubexFunctionDef> list = new CubexList<CubexFunctionDef>(); 
			      CubexList<String> klist = new CubexList<String>();
			      CubexTypeGrammar typegrammar = new CubexTypeName("Thing");
			      CubexList<CubexExpression> elist = new CubexList<CubexExpression>();
			    
			setState(373); match(CLASS);
			setState(374);
			((ClassgrammarContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((ClassgrammarContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(380);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(375); match(LANGLE);
				setState(376); ((ClassgrammarContext)_localctx).k = kcont();
				setState(377); match(RANGLE);
				 klist = ((ClassgrammarContext)_localctx).k.cub; 
				}
			}

			setState(382); match(LPAREN);
			setState(383); ((ClassgrammarContext)_localctx).t = tcont();
			setState(384); match(RPAREN);
			setState(390);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				{
				setState(385); match(EXTENDS);
				setState(386); ((ClassgrammarContext)_localctx).ty = type(0);
				}
				 typegrammar = ((ClassgrammarContext)_localctx).ty.cub; 
				}
			}

			setState(392); match(LBRACE);
			setState(393); ((ClassgrammarContext)_localctx).s = statementsopt();
			setState(402);
			_la = _input.LA(1);
			if (_la==SUPER) {
				{
				{
				setState(394); match(SUPER);
				setState(395); match(LPAREN);
				setState(396); ((ClassgrammarContext)_localctx).e = exprs();
				setState(397); match(RPAREN);
				setState(398); match(SEMICOLON);
				}
				 elist = ((ClassgrammarContext)_localctx).e.cub; 
				}
			}

			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(404); ((ClassgrammarContext)_localctx).f = func();
				 list.add(((ClassgrammarContext)_localctx).f.cub); 
				}
				}
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(412); match(RBRACE);
			 ((ClassgrammarContext)_localctx).cub =  new CubexClassGrammar((((ClassgrammarContext)_localctx).name!=null?((ClassgrammarContext)_localctx).name.getText():null), klist, ((ClassgrammarContext)_localctx).t.cub, typegrammar, ((ClassgrammarContext)_localctx).s.cub, elist, list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public CubexProgram cub;
		public StatementContext s;
		public StatementsContext s2;
		public ProgramContext p;
		public FuncsContext f;
		public IfaceContext i;
		public ClassgrammarContext c;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfaceContext iface() {
			return getRuleContext(IfaceContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ClassgrammarContext classgrammar() {
			return getRuleContext(ClassgrammarContext.class,0);
		}
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_program);
		try {
			setState(434);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(415); ((ProgramContext)_localctx).s = statement();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramStatement(((ProgramContext)_localctx).s.cub), null); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(418); ((ProgramContext)_localctx).s2 = statements();
				setState(419); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramStatementList(((ProgramContext)_localctx).s2.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(422); ((ProgramContext)_localctx).f = funcs();
				setState(423); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramFunctionList(((ProgramContext)_localctx).f.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426); ((ProgramContext)_localctx).i = iface();
				setState(427); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramInterface(((ProgramContext)_localctx).i.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(430); ((ProgramContext)_localctx).c = classgrammar();
				setState(431); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramClass(((ProgramContext)_localctx).c.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullprogramContext extends ParserRuleContext {
		public ProgramContext p;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public FullprogramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullprogram; }
	}

	public final FullprogramContext fullprogram() throws RecognitionException {
		FullprogramContext _localctx = new FullprogramContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fullprogram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436); ((FullprogramContext)_localctx).p = program();
			 programAST = ((FullprogramContext)_localctx).p.cub; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return type_sempred((TypeContext)_localctx, predIndex);

		case 6: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 8 >= _localctx._p;

		case 2: return 7 >= _localctx._p;

		case 3: return 5 >= _localctx._p;

		case 4: return 4 >= _localctx._p;

		case 5: return 3 >= _localctx._p;

		case 6: return 2 >= _localctx._p;

		case 7: return 1 >= _localctx._p;

		case 8: return 15 >= _localctx._p;

		case 9: return 6 >= _localctx._p;
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 3 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3:\u01ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\5\2\62\n"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C"+
		"\13\4\5\4E\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5R\n\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5Y\n\5\3\5\3\5\3\5\3\5\3\5\7\5`\n\5\f\5\16\5c\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\5\6q\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7y\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0095"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u00a9\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00bf\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00dc\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00e7"+
		"\n\b\3\b\7\b\u00ea\n\b\f\b\16\b\u00ed\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\t\u00f6\n\t\f\t\16\t\u00f9\13\t\5\t\u00fb\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u0105\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\6\f\u0113\n\f\r\f\16\f\u0114\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u0147\n\r\3\16\3\16\3\16\3\16\6\16\u014d\n\16"+
		"\r\16\16\16\u014e\3\17\3\17\3\17\3\17\7\17\u0155\n\17\f\17\16\17\u0158"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0162\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u0169\n\20\3\20\3\20\3\20\3\20\7\20\u016f\n\20"+
		"\f\20\16\20\u0172\13\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u017f\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0189\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0195"+
		"\n\21\3\21\3\21\3\21\7\21\u019a\n\21\f\21\16\21\u019d\13\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01b5\n\22\3\23\3\23\3\23\3\23\2\24"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\n\4\2\62\62\65\65\3\2\23"+
		"\24\3\2-/\3\2\61\62\3\2\37 \4\2\27\27\31\33\4\2\30\30\34\34\4\2\4\4&&"+
		"\u01e1\2&\3\2\2\2\4\63\3\2\2\2\68\3\2\2\2\bX\3\2\2\2\nd\3\2\2\2\fr\3\2"+
		"\2\2\16\u00a8\3\2\2\2\20\u00ee\3\2\2\2\22\u00fc\3\2\2\2\24\u0108\3\2\2"+
		"\2\26\u010e\3\2\2\2\30\u0146\3\2\2\2\32\u0148\3\2\2\2\34\u0150\3\2\2\2"+
		"\36\u0159\3\2\2\2 \u0176\3\2\2\2\"\u01b4\3\2\2\2$\u01b6\3\2\2\2&\61\b"+
		"\2\1\2\'(\7\25\2\2(.\b\2\1\2)*\7)\2\2*+\7\25\2\2+-\b\2\1\2,)\3\2\2\2-"+
		"\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61\'\3\2\2\2\61"+
		"\62\3\2\2\2\62\3\3\2\2\2\63\64\7\23\2\2\64\65\7$\2\2\65\66\5\b\5\2\66"+
		"\67\b\3\1\2\67\5\3\2\2\28D\b\4\1\29:\5\4\3\2:A\b\4\1\2;<\7)\2\2<=\5\4"+
		"\3\2=>\b\4\1\2>@\3\2\2\2?;\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2"+
		"\2\2CA\3\2\2\2D9\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FG\b\5\1\2GH\7\25\2\2HY\b"+
		"\5\1\2IJ\b\5\1\2JQ\7\24\2\2KL\7\63\2\2LM\5\n\6\2MN\b\5\1\2NO\3\2\2\2O"+
		"P\7\64\2\2PR\3\2\2\2QK\3\2\2\2QR\3\2\2\2RS\3\2\2\2SY\b\5\1\2TU\7\21\2"+
		"\2UY\b\5\1\2VW\7\22\2\2WY\b\5\1\2XF\3\2\2\2XI\3\2\2\2XT\3\2\2\2XV\3\2"+
		"\2\2Ya\3\2\2\2Z[\6\5\2\3[\\\7\66\2\2\\]\5\b\5\2]^\b\5\1\2^`\3\2\2\2_Z"+
		"\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\t\3\2\2\2ca\3\2\2\2dp\b\6\1\2"+
		"ef\5\b\5\2fm\b\6\1\2gh\7)\2\2hi\5\b\5\2ij\b\6\1\2jl\3\2\2\2kg\3\2\2\2"+
		"lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2pe\3\2\2\2pq\3\2\2\2"+
		"q\13\3\2\2\2rx\b\7\1\2st\7\63\2\2tu\5\2\2\2uv\b\7\1\2vw\7\64\2\2wy\3\2"+
		"\2\2xs\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\'\2\2{|\5\6\4\2|}\7(\2\2}~\7$\2"+
		"\2~\177\5\b\5\2\177\u0080\b\7\1\2\u0080\r\3\2\2\2\u0081\u0082\b\b\1\2"+
		"\u0082\u0083\t\2\2\2\u0083\u0084\5\16\b\2\u0084\u0085\b\b\1\2\u0085\u00a9"+
		"\3\2\2\2\u0086\u0087\7\23\2\2\u0087\u00a9\b\b\1\2\u0088\u0089\7\'\2\2"+
		"\u0089\u008a\5\16\b\2\u008a\u008b\7(\2\2\u008b\u008c\b\b\1\2\u008c\u00a9"+
		"\3\2\2\2\u008d\u008e\b\b\1\2\u008e\u0094\t\3\2\2\u008f\u0090\7\63\2\2"+
		"\u0090\u0091\5\n\6\2\u0091\u0092\b\b\1\2\u0092\u0093\7\64\2\2\u0093\u0095"+
		"\3\2\2\2\u0094\u008f\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\7\'\2\2\u0097\u0098\5\20\t\2\u0098\u0099\7(\2\2\u0099\u009a\b\b"+
		"\1\2\u009a\u00a9\3\2\2\2\u009b\u009c\7\"\2\2\u009c\u009d\5\20\t\2\u009d"+
		"\u009e\7#\2\2\u009e\u009f\b\b\1\2\u009f\u00a9\3\2\2\2\u00a0\u00a1\7\b"+
		"\2\2\u00a1\u00a9\b\b\1\2\u00a2\u00a3\7\t\2\2\u00a3\u00a9\b\b\1\2\u00a4"+
		"\u00a5\7\26\2\2\u00a5\u00a9\b\b\1\2\u00a6\u00a7\7\3\2\2\u00a7\u00a9\b"+
		"\b\1\2\u00a8\u0081\3\2\2\2\u00a8\u0086\3\2\2\2\u00a8\u0088\3\2\2\2\u00a8"+
		"\u008d\3\2\2\2\u00a8\u009b\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a2\3\2"+
		"\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00eb\3\2\2\2\u00aa"+
		"\u00ab\6\b\3\3\u00ab\u00ac\t\4\2\2\u00ac\u00ad\5\16\b\2\u00ad\u00ae\b"+
		"\b\1\2\u00ae\u00ea\3\2\2\2\u00af\u00b0\6\b\4\3\u00b0\u00b1\t\5\2\2\u00b1"+
		"\u00b2\5\16\b\2\u00b2\u00b3\b\b\1\2\u00b3\u00ea\3\2\2\2\u00b4\u00b5\6"+
		"\b\5\3\u00b5\u00b6\7\60\2\2\u00b6\u00b7\5\16\b\2\u00b7\u00b8\b\b\1\2\u00b8"+
		"\u00ea\3\2\2\2\u00b9\u00be\6\b\6\3\u00ba\u00bf\7\63\2\2\u00bb\u00bf\7"+
		"\35\2\2\u00bc\u00bf\7\64\2\2\u00bd\u00bf\7\36\2\2\u00be\u00ba\3\2\2\2"+
		"\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\u00c1\5\16\b\2\u00c1\u00c2\b\b\1\2\u00c2\u00ea\3\2\2\2"+
		"\u00c3\u00c4\6\b\7\3\u00c4\u00c5\t\6\2\2\u00c5\u00c6\5\16\b\2\u00c6\u00c7"+
		"\b\b\1\2\u00c7\u00ea\3\2\2\2\u00c8\u00c9\6\b\b\3\u00c9\u00ca\7\66\2\2"+
		"\u00ca\u00cb\5\16\b\2\u00cb\u00cc\b\b\1\2\u00cc\u00ea\3\2\2\2\u00cd\u00ce"+
		"\6\b\t\3\u00ce\u00cf\7\67\2\2\u00cf\u00d0\5\16\b\2\u00d0\u00d1\b\b\1\2"+
		"\u00d1\u00ea\3\2\2\2\u00d2\u00d3\6\b\n\3\u00d3\u00d4\7!\2\2\u00d4\u00d5"+
		"\7\23\2\2\u00d5\u00db\b\b\1\2\u00d6\u00d7\7\63\2\2\u00d7\u00d8\5\n\6\2"+
		"\u00d8\u00d9\b\b\1\2\u00d9\u00da\7\64\2\2\u00da\u00dc\3\2\2\2\u00db\u00d6"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\7\'\2\2\u00de"+
		"\u00df\5\20\t\2\u00df\u00e0\7(\2\2\u00e0\u00e1\b\b\1\2\u00e1\u00ea\3\2"+
		"\2\2\u00e2\u00e6\6\b\13\3\u00e3\u00e4\t\7\2\2\u00e4\u00e7\5\16\b\2\u00e5"+
		"\u00e7\t\b\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00ea\b\b\1\2\u00e9\u00aa\3\2\2\2\u00e9\u00af\3\2\2\2\u00e9"+
		"\u00b4\3\2\2\2\u00e9\u00b9\3\2\2\2\u00e9\u00c3\3\2\2\2\u00e9\u00c8\3\2"+
		"\2\2\u00e9\u00cd\3\2\2\2\u00e9\u00d2\3\2\2\2\u00e9\u00e2\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\17\3\2\2"+
		"\2\u00ed\u00eb\3\2\2\2\u00ee\u00fa\b\t\1\2\u00ef\u00f0\5\16\b\2\u00f0"+
		"\u00f7\b\t\1\2\u00f1\u00f2\7)\2\2\u00f2\u00f3\5\16\b\2\u00f3\u00f4\b\t"+
		"\1\2\u00f4\u00f6\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u00ef\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\21\3\2\2\2\u00fc\u00fd"+
		"\b\n\1\2\u00fd\u00fe\7\17\2\2\u00fe\u00ff\7\23\2\2\u00ff\u0104\5\f\7\2"+
		"\u0100\u0101\5\30\r\2\u0101\u0102\b\n\1\2\u0102\u0105\3\2\2\2\u0103\u0105"+
		"\7*\2\2\u0104\u0100\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0107\b\n\1\2\u0107\23\3\2\2\2\u0108\u0109\7\17\2\2\u0109\u010a\7\23"+
		"\2\2\u010a\u010b\5\f\7\2\u010b\u010c\5\30\r\2\u010c\u010d\b\13\1\2\u010d"+
		"\25\3\2\2\2\u010e\u0112\b\f\1\2\u010f\u0110\5\24\13\2\u0110\u0111\b\f"+
		"\1\2\u0111\u0113\3\2\2\2\u0112\u010f\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\27\3\2\2\2\u0116\u0117\7+\2\2"+
		"\u0117\u0118\5\34\17\2\u0118\u0119\7,\2\2\u0119\u011a\b\r\1\2\u011a\u0147"+
		"\3\2\2\2\u011b\u011c\7\23\2\2\u011c\u011d\7%\2\2\u011d\u011e\5\16\b\2"+
		"\u011e\u011f\7*\2\2\u011f\u0120\b\r\1\2\u0120\u0147\3\2\2\2\u0121\u0122"+
		"\7\6\2\2\u0122\u0123\7\'\2\2\u0123\u0124\5\16\b\2\u0124\u0125\7(\2\2\u0125"+
		"\u0126\5\30\r\2\u0126\u0127\7\7\2\2\u0127\u0128\5\30\r\2\u0128\u0129\b"+
		"\r\1\2\u0129\u0147\3\2\2\2\u012a\u012b\7\6\2\2\u012b\u012c\7\'\2\2\u012c"+
		"\u012d\5\16\b\2\u012d\u012e\7(\2\2\u012e\u012f\5\30\r\2\u012f\u0130\b"+
		"\r\1\2\u0130\u0147\3\2\2\2\u0131\u0132\7\5\2\2\u0132\u0133\7\'\2\2\u0133"+
		"\u0134\5\16\b\2\u0134\u0135\7(\2\2\u0135\u0136\5\30\r\2\u0136\u0137\b"+
		"\r\1\2\u0137\u0147\3\2\2\2\u0138\u0139\7\n\2\2\u0139\u013a\7\'\2\2\u013a"+
		"\u013b\7\23\2\2\u013b\u013c\7\13\2\2\u013c\u013d\5\16\b\2\u013d\u013e"+
		"\7(\2\2\u013e\u013f\5\30\r\2\u013f\u0140\b\r\1\2\u0140\u0147\3\2\2\2\u0141"+
		"\u0142\t\t\2\2\u0142\u0143\5\16\b\2\u0143\u0144\7*\2\2\u0144\u0145\b\r"+
		"\1\2\u0145\u0147\3\2\2\2\u0146\u0116\3\2\2\2\u0146\u011b\3\2\2\2\u0146"+
		"\u0121\3\2\2\2\u0146\u012a\3\2\2\2\u0146\u0131\3\2\2\2\u0146\u0138\3\2"+
		"\2\2\u0146\u0141\3\2\2\2\u0147\31\3\2\2\2\u0148\u014c\b\16\1\2\u0149\u014a"+
		"\5\30\r\2\u014a\u014b\b\16\1\2\u014b\u014d\3\2\2\2\u014c\u0149\3\2\2\2"+
		"\u014d\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\33"+
		"\3\2\2\2\u0150\u0156\b\17\1\2\u0151\u0152\5\30\r\2\u0152\u0153\b\17\1"+
		"\2\u0153\u0155\3\2\2\2\u0154\u0151\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0156\u0157\3\2\2\2\u0157\35\3\2\2\2\u0158\u0156\3\2\2\2\u0159"+
		"\u015a\b\20\1\2\u015a\u015b\7\f\2\2\u015b\u0161\t\3\2\2\u015c\u015d\7"+
		"\63\2\2\u015d\u015e\5\2\2\2\u015e\u015f\7\64\2\2\u015f\u0160\b\20\1\2"+
		"\u0160\u0162\3\2\2\2\u0161\u015c\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0168"+
		"\3\2\2\2\u0163\u0164\7\20\2\2\u0164\u0165\5\b\5\2\u0165\u0166\3\2\2\2"+
		"\u0166\u0167\b\20\1\2\u0167\u0169\3\2\2\2\u0168\u0163\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0170\7+\2\2\u016b\u016c\5\22\n\2\u016c"+
		"\u016d\b\20\1\2\u016d\u016f\3\2\2\2\u016e\u016b\3\2\2\2\u016f\u0172\3"+
		"\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0174\7,\2\2\u0174\u0175\b\20\1\2\u0175\37\3\2\2"+
		"\2\u0176\u0177\b\21\1\2\u0177\u0178\7\r\2\2\u0178\u017e\t\3\2\2\u0179"+
		"\u017a\7\63\2\2\u017a\u017b\5\2\2\2\u017b\u017c\7\64\2\2\u017c\u017d\b"+
		"\21\1\2\u017d\u017f\3\2\2\2\u017e\u0179\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0181\7\'\2\2\u0181\u0182\5\6\4\2\u0182\u0188\7("+
		"\2\2\u0183\u0184\7\20\2\2\u0184\u0185\5\b\5\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0187\b\21\1\2\u0187\u0189\3\2\2\2\u0188\u0183\3\2\2\2\u0188\u0189\3"+
		"\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\7+\2\2\u018b\u0194\5\34\17\2\u018c"+
		"\u018d\7\16\2\2\u018d\u018e\7\'\2\2\u018e\u018f\5\20\t\2\u018f\u0190\7"+
		"(\2\2\u0190\u0191\7*\2\2\u0191\u0192\3\2\2\2\u0192\u0193\b\21\1\2\u0193"+
		"\u0195\3\2\2\2\u0194\u018c\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u019b\3\2"+
		"\2\2\u0196\u0197\5\24\13\2\u0197\u0198\b\21\1\2\u0198\u019a\3\2\2\2\u0199"+
		"\u0196\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2"+
		"\2\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u019f\7,\2\2\u019f"+
		"\u01a0\b\21\1\2\u01a0!\3\2\2\2\u01a1\u01a2\5\30\r\2\u01a2\u01a3\b\22\1"+
		"\2\u01a3\u01b5\3\2\2\2\u01a4\u01a5\5\32\16\2\u01a5\u01a6\5\"\22\2\u01a6"+
		"\u01a7\b\22\1\2\u01a7\u01b5\3\2\2\2\u01a8\u01a9\5\26\f\2\u01a9\u01aa\5"+
		"\"\22\2\u01aa\u01ab\b\22\1\2\u01ab\u01b5\3\2\2\2\u01ac\u01ad\5\36\20\2"+
		"\u01ad\u01ae\5\"\22\2\u01ae\u01af\b\22\1\2\u01af\u01b5\3\2\2\2\u01b0\u01b1"+
		"\5 \21\2\u01b1\u01b2\5\"\22\2\u01b2\u01b3\b\22\1\2\u01b3\u01b5\3\2\2\2"+
		"\u01b4\u01a1\3\2\2\2\u01b4\u01a4\3\2\2\2\u01b4\u01a8\3\2\2\2\u01b4\u01ac"+
		"\3\2\2\2\u01b4\u01b0\3\2\2\2\u01b5#\3\2\2\2\u01b6\u01b7\5\"\22\2\u01b7"+
		"\u01b8\b\23\1\2\u01b8%\3\2\2\2\".\61ADQXampx\u0094\u00a8\u00be\u00db\u00e6"+
		"\u00e9\u00eb\u00f7\u00fa\u0104\u0114\u0146\u014e\u0156\u0161\u0168\u0170"+
		"\u017e\u0188\u0194\u019b\u01b4";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
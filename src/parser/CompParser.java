// Generated from CompParser.g4 by ANTLR 4.1

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CompParser extends Parser {
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
		RULE_tscheme = 5, RULE_comp = 6, RULE_expr = 7, RULE_exprs = 8, RULE_funcoption = 9, 
		RULE_func = 10, RULE_funcs = 11, RULE_statement = 12, RULE_statements = 13, 
		RULE_statementsopt = 14, RULE_iface = 15, RULE_classgrammar = 16, RULE_program = 17, 
		RULE_fullprogram = 18;
	public static final String[] ruleNames = {
		"kcont", "ttuple", "tcont", "type", "types", "tscheme", "comp", "expr", 
		"exprs", "funcoption", "func", "funcs", "statement", "statements", "statementsopt", 
		"iface", "classgrammar", "program", "fullprogram"
	};

	@Override
	public String getGrammarFileName() { return "CompParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	  public CubexProgram programAST; 

	public CompParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class KcontContext extends ParserRuleContext {
		public CubexList<String> cub;
		public Token t;
		public TerminalNode TYPEPARAM(int i) {
			return getToken(CompParser.TYPEPARAM, i);
		}
		public List<TerminalNode> TYPEPARAM() { return getTokens(CompParser.TYPEPARAM); }
		public List<TerminalNode> COMMA() { return getTokens(CompParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CompParser.COMMA, i);
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
			setState(49);
			_la = _input.LA(1);
			if (_la==TYPEPARAM) {
				{
				setState(39); ((KcontContext)_localctx).t = match(TYPEPARAM);
				 _localctx.cub.add((((KcontContext)_localctx).t!=null?((KcontContext)_localctx).t.getText():null)); 
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(41); match(COMMA);
					setState(42); ((KcontContext)_localctx).t = match(TYPEPARAM);
					 _localctx.cub.add((((KcontContext)_localctx).t!=null?((KcontContext)_localctx).t.getText():null)); 
					}
					}
					setState(48);
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
		public TerminalNode COLON() { return getToken(CompParser.COLON, 0); }
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
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
			setState(51); ((TtupleContext)_localctx).VARFUN = match(VARFUN);
			setState(52); match(COLON);
			setState(53); ((TtupleContext)_localctx).t = type(0);
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
		public List<TerminalNode> COMMA() { return getTokens(CompParser.COMMA); }
		public TtupleContext ttuple(int i) {
			return getRuleContext(TtupleContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(CompParser.COMMA, i);
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
			setState(68);
			_la = _input.LA(1);
			if (_la==VARFUN) {
				{
				setState(57); ((TcontContext)_localctx).t = ttuple();
				 _localctx.cub.add(((TcontContext)_localctx).t.cub); 
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(59); match(COMMA);
					setState(60); ((TcontContext)_localctx).t = ttuple();
					 _localctx.cub.add(((TcontContext)_localctx).t.cub); 
					}
					}
					setState(67);
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
		public TerminalNode AMPERSAND() { return getToken(CompParser.AMPERSAND, 0); }
		public TerminalNode TYPEPARAM() { return getToken(CompParser.TYPEPARAM, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode CLASSID() { return getToken(CompParser.CLASSID, 0); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode THING() { return getToken(CompParser.THING, 0); }
		public TerminalNode LANGLE() { return getToken(CompParser.LANGLE, 0); }
		public TerminalNode NOTHING() { return getToken(CompParser.NOTHING, 0); }
		public TerminalNode RANGLE() { return getToken(CompParser.RANGLE, 0); }
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
			setState(88);
			switch (_input.LA(1)) {
			case TYPEPARAM:
				{
				setState(71); ((TypeContext)_localctx).TYPEPARAM = match(TYPEPARAM);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).TYPEPARAM!=null?((TypeContext)_localctx).TYPEPARAM.getText():null)); 
				}
				break;
			case CLASSID:
				{
				CubexList<CubexTypeGrammar> typeslist = new CubexList<CubexTypeGrammar>();
				setState(74); ((TypeContext)_localctx).CLASSID = match(CLASSID);
				setState(81);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(75); match(LANGLE);
					{
					setState(76); ((TypeContext)_localctx).t = types();
					 typeslist = ((TypeContext)_localctx).t.cub; 
					}
					setState(79); match(RANGLE);
					}
					break;
				}
				 ((TypeContext)_localctx).cub =  new CubexTypeClass((((TypeContext)_localctx).CLASSID!=null?((TypeContext)_localctx).CLASSID.getText():null), typeslist); 
				}
				break;
			case THING:
				{
				setState(84); ((TypeContext)_localctx).THING = match(THING);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).THING!=null?((TypeContext)_localctx).THING.getText():null)); 
				}
				break;
			case NOTHING:
				{
				setState(86); ((TypeContext)_localctx).NOTHING = match(NOTHING);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).NOTHING!=null?((TypeContext)_localctx).NOTHING.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
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
					setState(90);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(91); match(AMPERSAND);
					setState(92); ((TypeContext)_localctx).t2 = type(4);
					 ((TypeContext)_localctx).cub =  new CubexTypeIntersection(((TypeContext)_localctx).t1.cub, ((TypeContext)_localctx).t2.cub); 
					}
					} 
				}
				setState(99);
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
		public List<TerminalNode> COMMA() { return getTokens(CompParser.COMMA); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(CompParser.COMMA, i);
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
			setState(112);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THING) | (1L << NOTHING) | (1L << CLASSID) | (1L << TYPEPARAM))) != 0)) {
				{
				setState(101); ((TypesContext)_localctx).t = type(0);
				 _localctx.cub.add(((TypesContext)_localctx).t.cub); 
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(103); match(COMMA);
					setState(104); ((TypesContext)_localctx).t = type(0);
					 _localctx.cub.add(((TypesContext)_localctx).t.cub); 
					}
					}
					setState(111);
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
		public TerminalNode RPAREN() { return getToken(CompParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LANGLE() { return getToken(CompParser.LANGLE, 0); }
		public TerminalNode LPAREN() { return getToken(CompParser.LPAREN, 0); }
		public KcontContext kcont() {
			return getRuleContext(KcontContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CompParser.COLON, 0); }
		public TerminalNode RANGLE() { return getToken(CompParser.RANGLE, 0); }
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
			setState(120);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(115); match(LANGLE);
				setState(116); ((TschemeContext)_localctx).k = kcont();
				 kcontlist = ((TschemeContext)_localctx).k.cub; 
				setState(118); match(RANGLE);
				}
			}

			setState(122); match(LPAREN);
			setState(123); ((TschemeContext)_localctx).tcont = tcont();
			setState(124); match(RPAREN);
			setState(125); match(COLON);
			setState(126); ((TschemeContext)_localctx).type = type(0);
			 
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

	public static class CompContext extends ParserRuleContext {
		public Comp cub;
		public ExprContext e;
		public CompContext c;
		public Token VARFUN;
		public TerminalNode IN() { return getToken(CompParser.IN, 0); }
		public TerminalNode IF() { return getToken(CompParser.IF, 0); }
		public TerminalNode FOR() { return getToken(CompParser.FOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CompParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(CompParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(CompParser.LPAREN, 0); }
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comp);
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129); ((CompContext)_localctx).e = expr(0);
				 ((CompContext)_localctx).cub =  new CompPair(((CompContext)_localctx).e.cub, null); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132); ((CompContext)_localctx).e = expr(0);
				setState(133); match(COMMA);
				setState(134); ((CompContext)_localctx).c = comp();
				 ((CompContext)_localctx).cub =  new CompPair(((CompContext)_localctx).e.cub, ((CompContext)_localctx).c.cub); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(137); match(IF);
				setState(138); match(LPAREN);
				setState(139); ((CompContext)_localctx).e = expr(0);
				setState(140); match(RPAREN);
				setState(141); ((CompContext)_localctx).c = comp();
				 ((CompContext)_localctx).cub =  new CompIf(((CompContext)_localctx).e.cub, ((CompContext)_localctx).c.cub); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144); match(FOR);
				setState(145); match(LPAREN);
				setState(146); ((CompContext)_localctx).VARFUN = match(VARFUN);
				setState(147); match(IN);
				setState(148); ((CompContext)_localctx).e = expr(0);
				setState(149); match(RPAREN);
				setState(150); ((CompContext)_localctx).c = comp();
				 ((CompContext)_localctx).cub =  new CompFor((((CompContext)_localctx).VARFUN!=null?((CompContext)_localctx).VARFUN.getText():null), ((CompContext)_localctx).e.cub, ((CompContext)_localctx).c.cub); 
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
		public CompContext c;
		public Token INTEGER;
		public Token STRING;
		public ExprContext r;
		public ExprContext ex2;
		public ExprContext right;
		public TerminalNode TRUE() { return getToken(CompParser.TRUE, 0); }
		public TerminalNode LANGLE() { return getToken(CompParser.LANGLE, 0); }
		public TerminalNode STAR() { return getToken(CompParser.STAR, 0); }
		public TerminalNode PLPL() { return getToken(CompParser.PLPL, 0); }
		public TerminalNode LDOT() { return getToken(CompParser.LDOT, 0); }
		public TerminalNode RBRACKET() { return getToken(CompParser.RBRACKET, 0); }
		public TerminalNode AMPERSAND() { return getToken(CompParser.AMPERSAND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLASSID() { return getToken(CompParser.CLASSID, 0); }
		public TerminalNode PLUS() { return getToken(CompParser.PLUS, 0); }
		public TerminalNode ONW() { return getToken(CompParser.ONW, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(CompParser.PIPE, 0); }
		public TerminalNode GEQ() { return getToken(CompParser.GEQ, 0); }
		public TerminalNode EQEQ() { return getToken(CompParser.EQEQ, 0); }
		public TerminalNode PERCENT() { return getToken(CompParser.PERCENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode BANG() { return getToken(CompParser.BANG, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode DASH() { return getToken(CompParser.DASH, 0); }
		public TerminalNode LPAREN() { return getToken(CompParser.LPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(CompParser.LBRACKET, 0); }
		public TerminalNode RANGLE() { return getToken(CompParser.RANGLE, 0); }
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public TerminalNode NEQ() { return getToken(CompParser.NEQ, 0); }
		public TerminalNode LL() { return getToken(CompParser.LL, 0); }
		public TerminalNode DOT() { return getToken(CompParser.DOT, 0); }
		public TerminalNode LDOTDOT() { return getToken(CompParser.LDOTDOT, 0); }
		public TerminalNode THROUGH() { return getToken(CompParser.THROUGH, 0); }
		public TerminalNode RPAREN() { return getToken(CompParser.RPAREN, 0); }
		public TerminalNode LEQ() { return getToken(CompParser.LEQ, 0); }
		public TerminalNode DOTL() { return getToken(CompParser.DOTL, 0); }
		public TerminalNode INTEGER() { return getToken(CompParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(CompParser.STRING, 0); }
		public TerminalNode SLASH() { return getToken(CompParser.SLASH, 0); }
		public TerminalNode FALSE() { return getToken(CompParser.FALSE, 0); }
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
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(156);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DASH || _la==BANG) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(157); ((ExprContext)_localctx).e = expr(9);
				 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DASH ? new CubexNegative(((ExprContext)_localctx).e.cub) : new CubexNegate(((ExprContext)_localctx).e.cub);
				}
				break;

			case 2:
				{
				setState(160); ((ExprContext)_localctx).VARFUN = match(VARFUN);
				 ((ExprContext)_localctx).cub =  new CubexExpression((((ExprContext)_localctx).VARFUN!=null?((ExprContext)_localctx).VARFUN.getText():null)); 
				}
				break;

			case 3:
				{
				setState(162); match(LPAREN);
				setState(163); ((ExprContext)_localctx).e = expr(0);
				setState(164); match(RPAREN);
				 ((ExprContext)_localctx).cub =  ((ExprContext)_localctx).e.cub; 
				}
				break;

			case 4:
				{
				CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();
				setState(168);
				((ExprContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VARFUN || _la==CLASSID) ) {
					((ExprContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(174);
				_la = _input.LA(1);
				if (_la==LANGLE) {
					{
					setState(169); match(LANGLE);
					setState(170); ((ExprContext)_localctx).tes = types();
					 teslist = ((ExprContext)_localctx).tes.cub; 
					setState(172); match(RANGLE);
					}
				}

				setState(176); match(LPAREN);
				setState(177); ((ExprContext)_localctx).pes = exprs();
				setState(178); match(RPAREN);
				 ((ExprContext)_localctx).cub =  new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), teslist, ((ExprContext)_localctx).pes.cub); 
				}
				break;

			case 5:
				{
				setState(181); match(LBRACKET);
				setState(182); ((ExprContext)_localctx).c = comp();
				setState(183); match(RBRACKET);
				((ExprContext)_localctx).cub =  new CubexIterableComp(((ExprContext)_localctx).c.cub); 
				}
				break;

			case 6:
				{
				setState(186); match(LBRACKET);
				setState(187); match(RBRACKET);
				((ExprContext)_localctx).cub =  new CubexIterableComp(null); 
				}
				break;

			case 7:
				{
				setState(189); match(TRUE);
				 ((ExprContext)_localctx).cub =  new CubexBoolean(true); 
				}
				break;

			case 8:
				{
				setState(191); match(FALSE);
				 ((ExprContext)_localctx).cub =  new CubexBoolean(false); 
				}
				break;

			case 9:
				{
				setState(193); ((ExprContext)_localctx).INTEGER = match(INTEGER);
				 ((ExprContext)_localctx).cub =  new CubexInteger((((ExprContext)_localctx).INTEGER!=null?Integer.valueOf(((ExprContext)_localctx).INTEGER.getText()):0)); 
				}
				break;

			case 10:
				{
				setState(195); ((ExprContext)_localctx).STRING = match(STRING);
				 ((ExprContext)_localctx).cub =  new CubexString((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(262);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(200);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << SLASH) | (1L << PERCENT))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(201); ((ExprContext)_localctx).r = expr(9);
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
						setState(204);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(205);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==DASH) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(206); ((ExprContext)_localctx).r = expr(8);
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
						setState(209);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(210); match(PLPL);
						setState(211); ((ExprContext)_localctx).ex2 = expr(6);
						 ((ExprContext)_localctx).cub =  new CubexAppend(((ExprContext)_localctx).ex.cub, ((ExprContext)_localctx).ex2.cub); 
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(219);
						switch (_input.LA(1)) {
						case LANGLE:
							{
							setState(215); ((ExprContext)_localctx).op = match(LANGLE);
							}
							break;
						case LEQ:
							{
							setState(216); ((ExprContext)_localctx).op = match(LEQ);
							}
							break;
						case RANGLE:
							{
							setState(217); ((ExprContext)_localctx).op = match(RANGLE);
							}
							break;
						case GEQ:
							{
							setState(218); ((ExprContext)_localctx).op = match(GEQ);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(221); ((ExprContext)_localctx).right = expr(5);
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
						setState(224);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(225);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQEQ || _la==NEQ) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(226); ((ExprContext)_localctx).r = expr(4);
						 ((ExprContext)_localctx).cub =  new CubexEquals(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub);
						                if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == NEQ) ((ExprContext)_localctx).cub =  new CubexNegate(_localctx.cub); 
						              
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(230); ((ExprContext)_localctx).op = match(AMPERSAND);
						setState(231); ((ExprContext)_localctx).r = expr(3);
						 ((ExprContext)_localctx).cub =  new CubexAnd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(235); ((ExprContext)_localctx).op = match(PIPE);
						setState(236); ((ExprContext)_localctx).r = expr(2);
						 ((ExprContext)_localctx).cub =  new CubexOr(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(240); match(DOT);
						setState(241); ((ExprContext)_localctx).VARFUN = match(VARFUN);
						CubexList<CubexTypeGrammar> teslist = new CubexList<CubexTypeGrammar>();
						setState(248);
						_la = _input.LA(1);
						if (_la==LANGLE) {
							{
							setState(243); match(LANGLE);
							setState(244); ((ExprContext)_localctx).tes = types();
							 teslist = ((ExprContext)_localctx).tes.cub; 
							setState(246); match(RANGLE);
							}
						}

						setState(250); match(LPAREN);
						setState(251); ((ExprContext)_localctx).pes = exprs();
						setState(252); match(RPAREN);
						 ((ExprContext)_localctx).cub =  new CubexFunctionApp(((ExprContext)_localctx).ex.cub, (((ExprContext)_localctx).VARFUN!=null?((ExprContext)_localctx).VARFUN.getText():null), teslist, ((ExprContext)_localctx).pes.cub); 
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(259);
						switch (_input.LA(1)) {
						case THROUGH:
						case LDOT:
						case DOTL:
						case LL:
							{
							{
							setState(256);
							((ExprContext)_localctx).op = _input.LT(1);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THROUGH) | (1L << LDOT) | (1L << DOTL) | (1L << LL))) != 0)) ) {
								((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
							}
							consume();
							setState(257); ((ExprContext)_localctx).r = expr(0);
							}
							}
							break;
						case ONW:
						case LDOTDOT:
							{
							{
							setState(258);
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
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public List<TerminalNode> COMMA() { return getTokens(CompParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(CompParser.COMMA, i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExprsContext)_localctx).cub =  new CubexList<CubexExpression>(); 
			setState(279);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << TRUE) | (1L << FALSE) | (1L << VARFUN) | (1L << CLASSID) | (1L << INTEGER) | (1L << LBRACKET) | (1L << LPAREN) | (1L << DASH) | (1L << BANG))) != 0)) {
				{
				setState(268); ((ExprsContext)_localctx).e = expr(0);
				 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(270); match(COMMA);
					setState(271); ((ExprsContext)_localctx).e = expr(0);
					 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
					}
					}
					setState(278);
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
		public TerminalNode SEMICOLON() { return getToken(CompParser.SEMICOLON, 0); }
		public TerminalNode FUN() { return getToken(CompParser.FUN, 0); }
		public TschemeContext tscheme() {
			return getRuleContext(TschemeContext.class,0);
		}
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public FuncoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcoption; }
	}

	public final FuncoptionContext funcoption() throws RecognitionException {
		FuncoptionContext _localctx = new FuncoptionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcoption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 CubexStatement state = null; 
			setState(282); match(FUN);
			setState(283); ((FuncoptionContext)_localctx).VARFUN = match(VARFUN);
			setState(284); ((FuncoptionContext)_localctx).t = tscheme();
			setState(289);
			switch (_input.LA(1)) {
			case RETURN:
			case WHILE:
			case IF:
			case FOR:
			case VARFUN:
			case EQUAL:
			case LBRACE:
				{
				setState(285); ((FuncoptionContext)_localctx).s = statement();
				state=((FuncoptionContext)_localctx).s.cub;
				}
				break;
			case SEMICOLON:
				{
				setState(288); match(SEMICOLON);
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
		public TerminalNode FUN() { return getToken(CompParser.FUN, 0); }
		public TschemeContext tscheme() {
			return getRuleContext(TschemeContext.class,0);
		}
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(FUN);
			setState(294); ((FuncContext)_localctx).VARFUN = match(VARFUN);
			setState(295); ((FuncContext)_localctx).t = tscheme();
			setState(296); ((FuncContext)_localctx).s = statement();
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
		enterRule(_localctx, 22, RULE_funcs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((FuncsContext)_localctx).cub =  new CubexList<CubexFunctionDef>(); 
			setState(303); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(300); ((FuncsContext)_localctx).f = func();
					 _localctx.cub.add(((FuncsContext)_localctx).f.cub); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(305); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public TerminalNode LBRACE() { return getToken(CompParser.LBRACE, 0); }
		public TerminalNode GET() { return getToken(CompParser.GET, 0); }
		public TerminalNode SEMICOLON() { return getToken(CompParser.SEMICOLON, 0); }
		public TerminalNode EQUAL() { return getToken(CompParser.EQUAL, 0); }
		public TerminalNode RBRACE() { return getToken(CompParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(CompParser.LPAREN, 0); }
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public TerminalNode IN() { return getToken(CompParser.IN, 0); }
		public TerminalNode WHILE() { return getToken(CompParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(CompParser.IF, 0); }
		public StatementsoptContext statementsopt() {
			return getRuleContext(StatementsoptContext.class,0);
		}
		public TerminalNode FOR() { return getToken(CompParser.FOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(CompParser.ELSE, 0); }
		public TerminalNode RPAREN() { return getToken(CompParser.RPAREN, 0); }
		public TerminalNode RETURN() { return getToken(CompParser.RETURN, 0); }
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
		enterRule(_localctx, 24, RULE_statement);
		int _la;
		try {
			setState(355);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307); match(LBRACE);
				setState(308); ((StatementContext)_localctx).s = statementsopt();
				setState(309); match(RBRACE);
				 ((StatementContext)_localctx).cub =  new CubexListStatement(((StatementContext)_localctx).s.cub); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312); ((StatementContext)_localctx).c = match(VARFUN);
				setState(313); match(GET);
				setState(314); ((StatementContext)_localctx).e = expr(0);
				setState(315); match(SEMICOLON);
				 ((StatementContext)_localctx).cub =  new CubexBind((((StatementContext)_localctx).c!=null?((StatementContext)_localctx).c.getText():null), ((StatementContext)_localctx).e.cub); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(318); match(IF);
				setState(319); match(LPAREN);
				setState(320); ((StatementContext)_localctx).e = expr(0);
				setState(321); match(RPAREN);
				setState(322); ((StatementContext)_localctx).s1 = statement();
				setState(323); match(ELSE);
				setState(324); ((StatementContext)_localctx).s2 = statement();
				 ((StatementContext)_localctx).cub =  new CubexIf(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s1.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(327); match(IF);
				setState(328); match(LPAREN);
				setState(329); ((StatementContext)_localctx).e = expr(0);
				setState(330); match(RPAREN);
				setState(331); ((StatementContext)_localctx).s1 = statement();
				 ((StatementContext)_localctx).cub =  new CubexIf(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s1.cub, null); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(334); match(WHILE);
				setState(335); match(LPAREN);
				setState(336); ((StatementContext)_localctx).e = expr(0);
				setState(337); match(RPAREN);
				setState(338); ((StatementContext)_localctx).s2 = statement();
				 ((StatementContext)_localctx).cub =  new CubexWhile(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(341); match(FOR);
				setState(342); match(LPAREN);
				setState(343); ((StatementContext)_localctx).VARFUN = match(VARFUN);
				setState(344); match(IN);
				setState(345); ((StatementContext)_localctx).e = expr(0);
				setState(346); match(RPAREN);
				setState(347); ((StatementContext)_localctx).s2 = statement();
				 ((StatementContext)_localctx).cub =  new CubexFor((((StatementContext)_localctx).VARFUN!=null?((StatementContext)_localctx).VARFUN.getText():null), ((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(350);
				_la = _input.LA(1);
				if ( !(_la==RETURN || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(351); ((StatementContext)_localctx).e = expr(0);
				setState(352); match(SEMICOLON);
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
		enterRule(_localctx, 26, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementsContext)_localctx).cub =  new CubexList<CubexStatement>(); 
			setState(361); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(358); ((StatementsContext)_localctx).s = statement();
					 _localctx.cub.add(((StatementsContext)_localctx).s.cub); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(363); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 28, RULE_statementsopt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementsoptContext)_localctx).cub =  new CubexList<CubexStatement>(); 
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << FOR) | (1L << VARFUN) | (1L << EQUAL) | (1L << LBRACE))) != 0)) {
				{
				{
				setState(366); ((StatementsoptContext)_localctx).s = statement();
				 _localctx.cub.add(((StatementsoptContext)_localctx).s.cub); 
				}
				}
				setState(373);
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
		public TerminalNode LBRACE() { return getToken(CompParser.LBRACE, 0); }
		public List<FuncoptionContext> funcoption() {
			return getRuleContexts(FuncoptionContext.class);
		}
		public TerminalNode CLASSID() { return getToken(CompParser.CLASSID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncoptionContext funcoption(int i) {
			return getRuleContext(FuncoptionContext.class,i);
		}
		public TerminalNode LANGLE() { return getToken(CompParser.LANGLE, 0); }
		public TerminalNode INTERFACE() { return getToken(CompParser.INTERFACE, 0); }
		public TerminalNode RBRACE() { return getToken(CompParser.RBRACE, 0); }
		public KcontContext kcont() {
			return getRuleContext(KcontContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(CompParser.EXTENDS, 0); }
		public TerminalNode RANGLE() { return getToken(CompParser.RANGLE, 0); }
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public IfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iface; }
	}

	public final IfaceContext iface() throws RecognitionException {
		IfaceContext _localctx = new IfaceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_iface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 CubexList<CubexFunctionDef> list = new CubexList<CubexFunctionDef>(); 
			      CubexList<String> klist = new CubexList<String>();
			      CubexTypeGrammar typegrammar = new CubexTypeName("Thing");
			    
			setState(375); match(INTERFACE);
			setState(376);
			((IfaceContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((IfaceContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(382);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(377); match(LANGLE);
				setState(378); ((IfaceContext)_localctx).k = kcont();
				setState(379); match(RANGLE);
				 klist = ((IfaceContext)_localctx).k.cub; 
				}
			}

			setState(389);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				{
				setState(384); match(EXTENDS);
				setState(385); ((IfaceContext)_localctx).t = type(0);
				}
				 typegrammar = ((IfaceContext)_localctx).t.cub; 
				}
			}

			setState(391); match(LBRACE);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(392); ((IfaceContext)_localctx).f = funcoption();
				 list.add(((IfaceContext)_localctx).f.cub); 
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(400); match(RBRACE);
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
		public TerminalNode LBRACE() { return getToken(CompParser.LBRACE, 0); }
		public TcontContext tcont() {
			return getRuleContext(TcontContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CompParser.SEMICOLON, 0); }
		public TerminalNode SUPER() { return getToken(CompParser.SUPER, 0); }
		public TerminalNode RPAREN(int i) {
			return getToken(CompParser.RPAREN, i);
		}
		public TerminalNode LANGLE() { return getToken(CompParser.LANGLE, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(CompParser.LPAREN); }
		public TerminalNode RBRACE() { return getToken(CompParser.RBRACE, 0); }
		public TerminalNode RANGLE() { return getToken(CompParser.RANGLE, 0); }
		public TerminalNode CLASS() { return getToken(CompParser.CLASS, 0); }
		public TerminalNode VARFUN() { return getToken(CompParser.VARFUN, 0); }
		public TerminalNode LPAREN(int i) {
			return getToken(CompParser.LPAREN, i);
		}
		public StatementsoptContext statementsopt() {
			return getRuleContext(StatementsoptContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(CompParser.RPAREN); }
		public TerminalNode CLASSID() { return getToken(CompParser.CLASSID, 0); }
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
		public TerminalNode EXTENDS() { return getToken(CompParser.EXTENDS, 0); }
		public ClassgrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classgrammar; }
	}

	public final ClassgrammarContext classgrammar() throws RecognitionException {
		ClassgrammarContext _localctx = new ClassgrammarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classgrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 CubexList<CubexFunctionDef> list = new CubexList<CubexFunctionDef>(); 
			      CubexList<String> klist = new CubexList<String>();
			      CubexTypeGrammar typegrammar = new CubexTypeName("Thing");
			      CubexList<CubexExpression> elist = new CubexList<CubexExpression>();
			    
			setState(404); match(CLASS);
			setState(405);
			((ClassgrammarContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((ClassgrammarContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(411);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(406); match(LANGLE);
				setState(407); ((ClassgrammarContext)_localctx).k = kcont();
				setState(408); match(RANGLE);
				 klist = ((ClassgrammarContext)_localctx).k.cub; 
				}
			}

			setState(413); match(LPAREN);
			setState(414); ((ClassgrammarContext)_localctx).t = tcont();
			setState(415); match(RPAREN);
			setState(421);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				{
				setState(416); match(EXTENDS);
				setState(417); ((ClassgrammarContext)_localctx).ty = type(0);
				}
				 typegrammar = ((ClassgrammarContext)_localctx).ty.cub; 
				}
			}

			setState(423); match(LBRACE);
			setState(424); ((ClassgrammarContext)_localctx).s = statementsopt();
			setState(433);
			_la = _input.LA(1);
			if (_la==SUPER) {
				{
				{
				setState(425); match(SUPER);
				setState(426); match(LPAREN);
				setState(427); ((ClassgrammarContext)_localctx).e = exprs();
				setState(428); match(RPAREN);
				setState(429); match(SEMICOLON);
				}
				 elist = ((ClassgrammarContext)_localctx).e.cub; 
				}
			}

			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(435); ((ClassgrammarContext)_localctx).f = func();
				 list.add(((ClassgrammarContext)_localctx).f.cub); 
				}
				}
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(443); match(RBRACE);
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
		enterRule(_localctx, 34, RULE_program);
		try {
			setState(465);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(446); ((ProgramContext)_localctx).s = statement();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramStatement(((ProgramContext)_localctx).s.cub), null); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449); ((ProgramContext)_localctx).s2 = statements();
				setState(450); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramStatementList(((ProgramContext)_localctx).s2.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(453); ((ProgramContext)_localctx).f = funcs();
				setState(454); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramFunctionList(((ProgramContext)_localctx).f.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(457); ((ProgramContext)_localctx).i = iface();
				setState(458); ((ProgramContext)_localctx).p = program();
				 ((ProgramContext)_localctx).cub =  new CubexProgram(new CubexProgramInterface(((ProgramContext)_localctx).i.cub), ((ProgramContext)_localctx).p.cub); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(461); ((ProgramContext)_localctx).c = classgrammar();
				setState(462); ((ProgramContext)_localctx).p = program();
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
		enterRule(_localctx, 36, RULE_fullprogram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); ((FullprogramContext)_localctx).p = program();
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

		case 7: return expr_sempred((ExprContext)_localctx, predIndex);
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

		case 8: return 16 >= _localctx._p;

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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3:\u01d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2"+
		"\5\2\64\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4B\n\4\f"+
		"\4\16\4E\13\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"T\n\5\3\5\3\5\3\5\3\5\3\5\5\5[\n\5\3\5\3\5\3\5\3\5\3\5\7\5b\n\5\f\5\16"+
		"\5e\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\5\6s\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7{\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\b\u009c\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b1\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u00c8\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u00de\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u00fb\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0106\n\t\3\t"+
		"\7\t\u0109\n\t\f\t\16\t\u010c\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0115"+
		"\n\n\f\n\16\n\u0118\13\n\5\n\u011a\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0124\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\6\r\u0132\n\r\r\r\16\r\u0133\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0166"+
		"\n\16\3\17\3\17\3\17\3\17\6\17\u016c\n\17\r\17\16\17\u016d\3\20\3\20\3"+
		"\20\3\20\7\20\u0174\n\20\f\20\16\20\u0177\13\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u0181\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u0188"+
		"\n\21\3\21\3\21\3\21\3\21\7\21\u018e\n\21\f\21\16\21\u0191\13\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u019e\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01a8\n\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01b4\n\22\3\22\3\22\3\22\7\22\u01b9"+
		"\n\22\f\22\16\22\u01bc\13\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u01d4\n\23\3\24\3\24\3\24\3\24\2\25\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&\2\n\4\2\62\62\65\65\3\2\23\24\3\2-/\3\2\61\62\3\2\37 \4"+
		"\2\27\27\31\33\4\2\30\30\34\34\4\2\4\4&&\u0203\2(\3\2\2\2\4\65\3\2\2\2"+
		"\6:\3\2\2\2\bZ\3\2\2\2\nf\3\2\2\2\ft\3\2\2\2\16\u009b\3\2\2\2\20\u00c7"+
		"\3\2\2\2\22\u010d\3\2\2\2\24\u011b\3\2\2\2\26\u0127\3\2\2\2\30\u012d\3"+
		"\2\2\2\32\u0165\3\2\2\2\34\u0167\3\2\2\2\36\u016f\3\2\2\2 \u0178\3\2\2"+
		"\2\"\u0195\3\2\2\2$\u01d3\3\2\2\2&\u01d5\3\2\2\2(\63\b\2\1\2)*\7\25\2"+
		"\2*\60\b\2\1\2+,\7)\2\2,-\7\25\2\2-/\b\2\1\2.+\3\2\2\2/\62\3\2\2\2\60"+
		".\3\2\2\2\60\61\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\63)\3\2\2\2\63\64"+
		"\3\2\2\2\64\3\3\2\2\2\65\66\7\23\2\2\66\67\7$\2\2\678\5\b\5\289\b\3\1"+
		"\29\5\3\2\2\2:F\b\4\1\2;<\5\4\3\2<C\b\4\1\2=>\7)\2\2>?\5\4\3\2?@\b\4\1"+
		"\2@B\3\2\2\2A=\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2"+
		"\2F;\3\2\2\2FG\3\2\2\2G\7\3\2\2\2HI\b\5\1\2IJ\7\25\2\2J[\b\5\1\2KL\b\5"+
		"\1\2LS\7\24\2\2MN\7\63\2\2NO\5\n\6\2OP\b\5\1\2PQ\3\2\2\2QR\7\64\2\2RT"+
		"\3\2\2\2SM\3\2\2\2ST\3\2\2\2TU\3\2\2\2U[\b\5\1\2VW\7\21\2\2W[\b\5\1\2"+
		"XY\7\22\2\2Y[\b\5\1\2ZH\3\2\2\2ZK\3\2\2\2ZV\3\2\2\2ZX\3\2\2\2[c\3\2\2"+
		"\2\\]\6\5\2\3]^\7\66\2\2^_\5\b\5\2_`\b\5\1\2`b\3\2\2\2a\\\3\2\2\2be\3"+
		"\2\2\2ca\3\2\2\2cd\3\2\2\2d\t\3\2\2\2ec\3\2\2\2fr\b\6\1\2gh\5\b\5\2ho"+
		"\b\6\1\2ij\7)\2\2jk\5\b\5\2kl\b\6\1\2ln\3\2\2\2mi\3\2\2\2nq\3\2\2\2om"+
		"\3\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rg\3\2\2\2rs\3\2\2\2s\13\3\2\2\2"+
		"tz\b\7\1\2uv\7\63\2\2vw\5\2\2\2wx\b\7\1\2xy\7\64\2\2y{\3\2\2\2zu\3\2\2"+
		"\2z{\3\2\2\2{|\3\2\2\2|}\7\'\2\2}~\5\6\4\2~\177\7(\2\2\177\u0080\7$\2"+
		"\2\u0080\u0081\5\b\5\2\u0081\u0082\b\7\1\2\u0082\r\3\2\2\2\u0083\u0084"+
		"\5\20\t\2\u0084\u0085\b\b\1\2\u0085\u009c\3\2\2\2\u0086\u0087\5\20\t\2"+
		"\u0087\u0088\7)\2\2\u0088\u0089\5\16\b\2\u0089\u008a\b\b\1\2\u008a\u009c"+
		"\3\2\2\2\u008b\u008c\7\6\2\2\u008c\u008d\7\'\2\2\u008d\u008e\5\20\t\2"+
		"\u008e\u008f\7(\2\2\u008f\u0090\5\16\b\2\u0090\u0091\b\b\1\2\u0091\u009c"+
		"\3\2\2\2\u0092\u0093\7\n\2\2\u0093\u0094\7\'\2\2\u0094\u0095\7\23\2\2"+
		"\u0095\u0096\7\13\2\2\u0096\u0097\5\20\t\2\u0097\u0098\7(\2\2\u0098\u0099"+
		"\5\16\b\2\u0099\u009a\b\b\1\2\u009a\u009c\3\2\2\2\u009b\u0083\3\2\2\2"+
		"\u009b\u0086\3\2\2\2\u009b\u008b\3\2\2\2\u009b\u0092\3\2\2\2\u009c\17"+
		"\3\2\2\2\u009d\u009e\b\t\1\2\u009e\u009f\t\2\2\2\u009f\u00a0\5\20\t\2"+
		"\u00a0\u00a1\b\t\1\2\u00a1\u00c8\3\2\2\2\u00a2\u00a3\7\23\2\2\u00a3\u00c8"+
		"\b\t\1\2\u00a4\u00a5\7\'\2\2\u00a5\u00a6\5\20\t\2\u00a6\u00a7\7(\2\2\u00a7"+
		"\u00a8\b\t\1\2\u00a8\u00c8\3\2\2\2\u00a9\u00aa\b\t\1\2\u00aa\u00b0\t\3"+
		"\2\2\u00ab\u00ac\7\63\2\2\u00ac\u00ad\5\n\6\2\u00ad\u00ae\b\t\1\2\u00ae"+
		"\u00af\7\64\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00b1\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\'\2\2\u00b3\u00b4\5\22\n\2\u00b4"+
		"\u00b5\7(\2\2\u00b5\u00b6\b\t\1\2\u00b6\u00c8\3\2\2\2\u00b7\u00b8\7\""+
		"\2\2\u00b8\u00b9\5\16\b\2\u00b9\u00ba\7#\2\2\u00ba\u00bb\b\t\1\2\u00bb"+
		"\u00c8\3\2\2\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\7#\2\2\u00be\u00c8\b\t"+
		"\1\2\u00bf\u00c0\7\b\2\2\u00c0\u00c8\b\t\1\2\u00c1\u00c2\7\t\2\2\u00c2"+
		"\u00c8\b\t\1\2\u00c3\u00c4\7\26\2\2\u00c4\u00c8\b\t\1\2\u00c5\u00c6\7"+
		"\3\2\2\u00c6\u00c8\b\t\1\2\u00c7\u009d\3\2\2\2\u00c7\u00a2\3\2\2\2\u00c7"+
		"\u00a4\3\2\2\2\u00c7\u00a9\3\2\2\2\u00c7\u00b7\3\2\2\2\u00c7\u00bc\3\2"+
		"\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u010a\3\2\2\2\u00c9\u00ca\6\t\3\3\u00ca\u00cb\t\4"+
		"\2\2\u00cb\u00cc\5\20\t\2\u00cc\u00cd\b\t\1\2\u00cd\u0109\3\2\2\2\u00ce"+
		"\u00cf\6\t\4\3\u00cf\u00d0\t\5\2\2\u00d0\u00d1\5\20\t\2\u00d1\u00d2\b"+
		"\t\1\2\u00d2\u0109\3\2\2\2\u00d3\u00d4\6\t\5\3\u00d4\u00d5\7\60\2\2\u00d5"+
		"\u00d6\5\20\t\2\u00d6\u00d7\b\t\1\2\u00d7\u0109\3\2\2\2\u00d8\u00dd\6"+
		"\t\6\3\u00d9\u00de\7\63\2\2\u00da\u00de\7\35\2\2\u00db\u00de\7\64\2\2"+
		"\u00dc\u00de\7\36\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\5\20\t\2"+
		"\u00e0\u00e1\b\t\1\2\u00e1\u0109\3\2\2\2\u00e2\u00e3\6\t\7\3\u00e3\u00e4"+
		"\t\6\2\2\u00e4\u00e5\5\20\t\2\u00e5\u00e6\b\t\1\2\u00e6\u0109\3\2\2\2"+
		"\u00e7\u00e8\6\t\b\3\u00e8\u00e9\7\66\2\2\u00e9\u00ea\5\20\t\2\u00ea\u00eb"+
		"\b\t\1\2\u00eb\u0109\3\2\2\2\u00ec\u00ed\6\t\t\3\u00ed\u00ee\7\67\2\2"+
		"\u00ee\u00ef\5\20\t\2\u00ef\u00f0\b\t\1\2\u00f0\u0109\3\2\2\2\u00f1\u00f2"+
		"\6\t\n\3\u00f2\u00f3\7!\2\2\u00f3\u00f4\7\23\2\2\u00f4\u00fa\b\t\1\2\u00f5"+
		"\u00f6\7\63\2\2\u00f6\u00f7\5\n\6\2\u00f7\u00f8\b\t\1\2\u00f8\u00f9\7"+
		"\64\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\7\'\2\2\u00fd\u00fe\5\22\n\2\u00fe\u00ff\7"+
		"(\2\2\u00ff\u0100\b\t\1\2\u0100\u0109\3\2\2\2\u0101\u0105\6\t\13\3\u0102"+
		"\u0103\t\7\2\2\u0103\u0106\5\20\t\2\u0104\u0106\t\b\2\2\u0105\u0102\3"+
		"\2\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\b\t\1\2\u0108"+
		"\u00c9\3\2\2\2\u0108\u00ce\3\2\2\2\u0108\u00d3\3\2\2\2\u0108\u00d8\3\2"+
		"\2\2\u0108\u00e2\3\2\2\2\u0108\u00e7\3\2\2\2\u0108\u00ec\3\2\2\2\u0108"+
		"\u00f1\3\2\2\2\u0108\u0101\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\21\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0119"+
		"\b\n\1\2\u010e\u010f\5\20\t\2\u010f\u0116\b\n\1\2\u0110\u0111\7)\2\2\u0111"+
		"\u0112\5\20\t\2\u0112\u0113\b\n\1\2\u0113\u0115\3\2\2\2\u0114\u0110\3"+
		"\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u010e\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\23\3\2\2\2\u011b\u011c\b\13\1\2\u011c\u011d\7\17\2\2\u011d"+
		"\u011e\7\23\2\2\u011e\u0123\5\f\7\2\u011f\u0120\5\32\16\2\u0120\u0121"+
		"\b\13\1\2\u0121\u0124\3\2\2\2\u0122\u0124\7*\2\2\u0123\u011f\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\b\13\1\2\u0126\25\3\2\2"+
		"\2\u0127\u0128\7\17\2\2\u0128\u0129\7\23\2\2\u0129\u012a\5\f\7\2\u012a"+
		"\u012b\5\32\16\2\u012b\u012c\b\f\1\2\u012c\27\3\2\2\2\u012d\u0131\b\r"+
		"\1\2\u012e\u012f\5\26\f\2\u012f\u0130\b\r\1\2\u0130\u0132\3\2\2\2\u0131"+
		"\u012e\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\31\3\2\2\2\u0135\u0136\7+\2\2\u0136\u0137\5\36\20\2\u0137\u0138"+
		"\7,\2\2\u0138\u0139\b\16\1\2\u0139\u0166\3\2\2\2\u013a\u013b\7\23\2\2"+
		"\u013b\u013c\7%\2\2\u013c\u013d\5\20\t\2\u013d\u013e\7*\2\2\u013e\u013f"+
		"\b\16\1\2\u013f\u0166\3\2\2\2\u0140\u0141\7\6\2\2\u0141\u0142\7\'\2\2"+
		"\u0142\u0143\5\20\t\2\u0143\u0144\7(\2\2\u0144\u0145\5\32\16\2\u0145\u0146"+
		"\7\7\2\2\u0146\u0147\5\32\16\2\u0147\u0148\b\16\1\2\u0148\u0166\3\2\2"+
		"\2\u0149\u014a\7\6\2\2\u014a\u014b\7\'\2\2\u014b\u014c\5\20\t\2\u014c"+
		"\u014d\7(\2\2\u014d\u014e\5\32\16\2\u014e\u014f\b\16\1\2\u014f\u0166\3"+
		"\2\2\2\u0150\u0151\7\5\2\2\u0151\u0152\7\'\2\2\u0152\u0153\5\20\t\2\u0153"+
		"\u0154\7(\2\2\u0154\u0155\5\32\16\2\u0155\u0156\b\16\1\2\u0156\u0166\3"+
		"\2\2\2\u0157\u0158\7\n\2\2\u0158\u0159\7\'\2\2\u0159\u015a\7\23\2\2\u015a"+
		"\u015b\7\13\2\2\u015b\u015c\5\20\t\2\u015c\u015d\7(\2\2\u015d\u015e\5"+
		"\32\16\2\u015e\u015f\b\16\1\2\u015f\u0166\3\2\2\2\u0160\u0161\t\t\2\2"+
		"\u0161\u0162\5\20\t\2\u0162\u0163\7*\2\2\u0163\u0164\b\16\1\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0135\3\2\2\2\u0165\u013a\3\2\2\2\u0165\u0140\3\2\2\2\u0165"+
		"\u0149\3\2\2\2\u0165\u0150\3\2\2\2\u0165\u0157\3\2\2\2\u0165\u0160\3\2"+
		"\2\2\u0166\33\3\2\2\2\u0167\u016b\b\17\1\2\u0168\u0169\5\32\16\2\u0169"+
		"\u016a\b\17\1\2\u016a\u016c\3\2\2\2\u016b\u0168\3\2\2\2\u016c\u016d\3"+
		"\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\35\3\2\2\2\u016f"+
		"\u0175\b\20\1\2\u0170\u0171\5\32\16\2\u0171\u0172\b\20\1\2\u0172\u0174"+
		"\3\2\2\2\u0173\u0170\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\37\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\b\21\1"+
		"\2\u0179\u017a\7\f\2\2\u017a\u0180\t\3\2\2\u017b\u017c\7\63\2\2\u017c"+
		"\u017d\5\2\2\2\u017d\u017e\7\64\2\2\u017e\u017f\b\21\1\2\u017f\u0181\3"+
		"\2\2\2\u0180\u017b\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0187\3\2\2\2\u0182"+
		"\u0183\7\20\2\2\u0183\u0184\5\b\5\2\u0184\u0185\3\2\2\2\u0185\u0186\b"+
		"\21\1\2\u0186\u0188\3\2\2\2\u0187\u0182\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018f\7+\2\2\u018a\u018b\5\24\13\2\u018b\u018c\b"+
		"\21\1\2\u018c\u018e\3\2\2\2\u018d\u018a\3\2\2\2\u018e\u0191\3\2\2\2\u018f"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u018f\3\2"+
		"\2\2\u0192\u0193\7,\2\2\u0193\u0194\b\21\1\2\u0194!\3\2\2\2\u0195\u0196"+
		"\b\22\1\2\u0196\u0197\7\r\2\2\u0197\u019d\t\3\2\2\u0198\u0199\7\63\2\2"+
		"\u0199\u019a\5\2\2\2\u019a\u019b\7\64\2\2\u019b\u019c\b\22\1\2\u019c\u019e"+
		"\3\2\2\2\u019d\u0198\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f"+
		"\u01a0\7\'\2\2\u01a0\u01a1\5\6\4\2\u01a1\u01a7\7(\2\2\u01a2\u01a3\7\20"+
		"\2\2\u01a3\u01a4\5\b\5\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\b\22\1\2\u01a6"+
		"\u01a8\3\2\2\2\u01a7\u01a2\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2"+
		"\2\2\u01a9\u01aa\7+\2\2\u01aa\u01b3\5\36\20\2\u01ab\u01ac\7\16\2\2\u01ac"+
		"\u01ad\7\'\2\2\u01ad\u01ae\5\22\n\2\u01ae\u01af\7(\2\2\u01af\u01b0\7*"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\b\22\1\2\u01b2\u01b4\3\2\2\2\u01b3"+
		"\u01ab\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01ba\3\2\2\2\u01b5\u01b6\5\26"+
		"\f\2\u01b6\u01b7\b\22\1\2\u01b7\u01b9\3\2\2\2\u01b8\u01b5\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\7,\2\2\u01be\u01bf\b\22\1\2\u01bf"+
		"#\3\2\2\2\u01c0\u01c1\5\32\16\2\u01c1\u01c2\b\23\1\2\u01c2\u01d4\3\2\2"+
		"\2\u01c3\u01c4\5\34\17\2\u01c4\u01c5\5$\23\2\u01c5\u01c6\b\23\1\2\u01c6"+
		"\u01d4\3\2\2\2\u01c7\u01c8\5\30\r\2\u01c8\u01c9\5$\23\2\u01c9\u01ca\b"+
		"\23\1\2\u01ca\u01d4\3\2\2\2\u01cb\u01cc\5 \21\2\u01cc\u01cd\5$\23\2\u01cd"+
		"\u01ce\b\23\1\2\u01ce\u01d4\3\2\2\2\u01cf\u01d0\5\"\22\2\u01d0\u01d1\5"+
		"$\23\2\u01d1\u01d2\b\23\1\2\u01d2\u01d4\3\2\2\2\u01d3\u01c0\3\2\2\2\u01d3"+
		"\u01c3\3\2\2\2\u01d3\u01c7\3\2\2\2\u01d3\u01cb\3\2\2\2\u01d3\u01cf\3\2"+
		"\2\2\u01d4%\3\2\2\2\u01d5\u01d6\5$\23\2\u01d6\u01d7\b\24\1\2\u01d7\'\3"+
		"\2\2\2#\60\63CFSZcorz\u009b\u00b0\u00c7\u00dd\u00fa\u0105\u0108\u010a"+
		"\u0116\u0119\u0123\u0133\u0165\u016d\u0175\u0180\u0187\u018f\u019d\u01a7"+
		"\u01b3\u01ba\u01d3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
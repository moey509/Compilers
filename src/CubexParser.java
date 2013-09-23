// Generated from CubexParser.g4 by ANTLR 4.1

package tools;
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
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


	  CubexProgram programAST = new CubexProgram();

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
			setState(83);
			switch (_input.LA(1)) {
			case TYPEPARAM:
				{
				setState(69); ((TypeContext)_localctx).TYPEPARAM = match(TYPEPARAM);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).TYPEPARAM!=null?((TypeContext)_localctx).TYPEPARAM.getText():null)); 
				}
				break;
			case CLASSID:
				{
				setState(71); ((TypeContext)_localctx).CLASSID = match(CLASSID);
				setState(76);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(72); match(LANGLE);
					setState(73); ((TypeContext)_localctx).t = types();
					setState(74); match(RANGLE);
					}
					break;
				}
				 ((TypeContext)_localctx).cub =  t==null ? CubexType.getTypeDeclaration((((TypeContext)_localctx).CLASSID!=null?((TypeContext)_localctx).CLASSID.getText():null), ((TypeContext)_localctx).t.cub); 
				                                                      : CubexType.getTypeDeclaration((((TypeContext)_localctx).CLASSID!=null?((TypeContext)_localctx).CLASSID.getText():null), null);
				}
				break;
			case THING:
				{
				setState(79); ((TypeContext)_localctx).THING = match(THING);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).THING!=null?((TypeContext)_localctx).THING.getText():null)); 
				}
				break;
			case NOTHING:
				{
				setState(81); ((TypeContext)_localctx).NOTHING = match(NOTHING);
				 ((TypeContext)_localctx).cub =  new CubexTypeName((((TypeContext)_localctx).NOTHING!=null?((TypeContext)_localctx).NOTHING.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
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
					setState(85);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(86); match(AMPERSAND);
					setState(87); ((TypeContext)_localctx).t2 = type(4);
					 _localctx.cub = new CubexTypeIntersection(t1, t2) 
					}
					} 
				}
				setState(94);
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
			 ((TypesContext)_localctx).cub =  new CubexList<cubexTypeGrammar>(); 
			setState(107);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THING) | (1L << NOTHING) | (1L << CLASSID) | (1L << TYPEPARAM))) != 0)) {
				{
				setState(96); ((TypesContext)_localctx).t = type(0);
				 _localctx.cub.add(((TypesContext)_localctx).t.cub); 
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(98); match(COMMA);
					setState(99); ((TypesContext)_localctx).t = type(0);
					 _localctx.cub.add(((TypesContext)_localctx).t.cub); 
					}
					}
					setState(106);
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
		public KcontContext kcont;
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
			setState(113);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(109); match(LANGLE);
				setState(110); ((TschemeContext)_localctx).kcont = kcont();
				setState(111); match(RANGLE);
				}
			}

			setState(115); match(LPAREN);
			setState(116); ((TschemeContext)_localctx).tcont = tcont();
			setState(117); match(RPAREN);
			setState(118); match(COLON);
			setState(119); ((TschemeContext)_localctx).type = type(0);
			 
			    ((TschemeContext)_localctx).cub =  kcont == null ? new CubexTypeScheme(null, ((TschemeContext)_localctx).tcont.cub, ((TschemeContext)_localctx).type.cub) 
			               : new CubexTypeScheme(((TschemeContext)_localctx).kcont.cub, ((TschemeContext)_localctx).tcont.cub, ((TschemeContext)_localctx).type.cub);
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
		public ExprContext ex2;
		public ExprContext r;
		public Token eq;
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
		public TerminalNode PERCENT() { return getToken(CubexParser.PERCENT, 0); }
		public TerminalNode BANG() { return getToken(CubexParser.BANG, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode DASH() { return getToken(CubexParser.DASH, 0); }
		public TerminalNode EQUAL() { return getToken(CubexParser.EQUAL, 0); }
		public TerminalNode LPAREN() { return getToken(CubexParser.LPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(CubexParser.LBRACKET, 0); }
		public TerminalNode RANGLE() { return getToken(CubexParser.RANGLE, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public TerminalNode DOT() { return getToken(CubexParser.DOT, 0); }
		public TerminalNode LL() { return getToken(CubexParser.LL, 0); }
		public TerminalNode LDOTDOT() { return getToken(CubexParser.LDOTDOT, 0); }
		public TerminalNode THROUGH() { return getToken(CubexParser.THROUGH, 0); }
		public TerminalNode RPAREN() { return getToken(CubexParser.RPAREN, 0); }
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
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(123);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DASH || _la==BANG) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(124); ((ExprContext)_localctx).e = expr(9);
				 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DASH ? new CubexNegative(((ExprContext)_localctx).e.cub) : new CubexNegate(((ExprContext)_localctx).e.cub);
				}
				break;

			case 2:
				{
				setState(127); ((ExprContext)_localctx).VARFUN = match(VARFUN);
				 ((ExprContext)_localctx).cub =  new CubexVariable((((ExprContext)_localctx).VARFUN!=null?((ExprContext)_localctx).VARFUN.getText():null)); 
				}
				break;

			case 3:
				{
				setState(129);
				((ExprContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VARFUN || _la==CLASSID) ) {
					((ExprContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(134);
				_la = _input.LA(1);
				if (_la==LANGLE) {
					{
					setState(130); match(LANGLE);
					setState(131); ((ExprContext)_localctx).tes = types();
					setState(132); match(RANGLE);
					}
				}

				setState(136); match(LPAREN);
				setState(137); ((ExprContext)_localctx).pes = exprs();
				setState(138); match(RPAREN);
				 ((ExprContext)_localctx).cub =  tes == null ? new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), null, ((ExprContext)_localctx).pes.cub) 
				                         : new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), ((ExprContext)_localctx).tes.cub, ((ExprContext)_localctx).pes.cub); 
				}
				break;

			case 4:
				{
				setState(141); match(LBRACKET);
				setState(142); ((ExprContext)_localctx).es = exprs();
				setState(143); match(RBRACKET);
				((ExprContext)_localctx).cub =  new CubexIterable(((ExprContext)_localctx).es.cub); 
				}
				break;

			case 5:
				{
				setState(146); match(TRUE);
				 ((ExprContext)_localctx).cub =  new CubexBoolean(true); 
				}
				break;

			case 6:
				{
				setState(148); match(FALSE);
				 ((ExprContext)_localctx).cub =  new CubexBoolean(false); 
				}
				break;

			case 7:
				{
				setState(150); ((ExprContext)_localctx).INTEGER = match(INTEGER);
				 ((ExprContext)_localctx).cub =  new CubexInteger((((ExprContext)_localctx).INTEGER!=null?Integer.valueOf(((ExprContext)_localctx).INTEGER.getText()):0)); 
				}
				break;

			case 8:
				{
				setState(152); ((ExprContext)_localctx).STRING = match(STRING);
				 ((ExprContext)_localctx).cub =  new CubexString((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(225);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(157); match(PLPL);
						setState(158); ((ExprContext)_localctx).ex2 = expr(15);
						 ((ExprContext)_localctx).cub =  new CubexAppend(((ExprContext)_localctx).ex.cub, ((ExprContext)_localctx).ex2.cub); 
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(162);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << SLASH) | (1L << PERCENT))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(163); ((ExprContext)_localctx).r = expr(9);
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == STAR
						                      ? new CubexMultiply(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                      : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == SLASH
						                      ? new CubexDivide(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                      : new CubexMod(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(167);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==DASH) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(168); ((ExprContext)_localctx).r = expr(8);
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == PLUS
						                       ? new CubexAdd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                       : new CubexSubtract(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(178);
						switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
						case 1:
							{
							setState(172); ((ExprContext)_localctx).op = match(LANGLE);
							}
							break;

						case 2:
							{
							setState(173); ((ExprContext)_localctx).op = match(LANGLE);
							setState(174); ((ExprContext)_localctx).eq = match(EQUAL);
							}
							break;

						case 3:
							{
							setState(175); ((ExprContext)_localctx).op = match(RANGLE);
							}
							break;

						case 4:
							{
							setState(176); ((ExprContext)_localctx).op = match(RANGLE);
							setState(177); ((ExprContext)_localctx).eq = match(EQUAL);
							}
							break;
						}
						setState(180); ((ExprContext)_localctx).right = expr(7);
						 CubexExpression l = (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LANGLE ? ((ExprContext)_localctx).left.cub : ((ExprContext)_localctx).right.cub;
						                    CubexExpression r = (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LANGLE ? ((ExprContext)_localctx).right.cub : ((ExprContext)_localctx).left.cub;
						                    ((ExprContext)_localctx).cub =  ((ExprContext)_localctx).eq == null ? new CubexLessStrict(l, r) : new CubexLessNotStrict(l, r); 
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(188);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(184); ((ExprContext)_localctx).op = match(EQUAL);
							setState(185); match(EQUAL);
							}
							break;
						case BANG:
							{
							setState(186); ((ExprContext)_localctx).op = match(BANG);
							setState(187); match(EQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(190); ((ExprContext)_localctx).r = expr(6);
						 ((ExprContext)_localctx).cub =  new CubexEquals(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub);
						                if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == BANG) ((ExprContext)_localctx).cub =  new CubexNegate(_localctx.cub); 
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(194); match(AMPERSAND);
						setState(195); ((ExprContext)_localctx).r = expr(5);
						 ((ExprContext)_localctx).cub =  new CubexAnd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(199); match(PIPE);
						setState(200); ((ExprContext)_localctx).r = expr(4);
						 ((ExprContext)_localctx).cub =  new CubexOr(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(204);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THROUGH) | (1L << LDOT) | (1L << DOTL) | (1L << LL))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(205); ((ExprContext)_localctx).r = expr(3);
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == THROUGH
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, true, true)
						                   : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LDOT
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, false, true)
						                   : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DOTL
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, true, false)
						                   : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LL
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, false, false);
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(209); match(DOT);
						setState(210); ((ExprContext)_localctx).VARFUN = match(VARFUN);
						setState(215);
						_la = _input.LA(1);
						if (_la==LANGLE) {
							{
							setState(211); match(LANGLE);
							setState(212); ((ExprContext)_localctx).tes = types();
							setState(213); match(RANGLE);
							}
						}

						setState(217); match(LPAREN);
						setState(218); ((ExprContext)_localctx).pes = exprs();
						setState(219); match(RPAREN);
						 ((ExprContext)_localctx).cub =  tes == null ? new CubexFunctionCall(((ExprContext)_localctx).ex.cub, null, ((ExprContext)_localctx).pes.cub)
						                                   : new CubexFunctionCall(((ExprContext)_localctx).ex.cub, ((ExprContext)_localctx).tes.cub, ((ExprContext)_localctx).pes.cub); 
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(223);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ONW || _la==LDOTDOT) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == ONW
						                       ? new CubexOnwards(((ExprContext)_localctx).l.cub, true)
						                   : new CubexOnwards(((ExprContext)_localctx).l.cub, false);
						}
						break;
					}
					} 
				}
				setState(229);
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
		public CubexList cub;
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
			 ((ExprsContext)_localctx).cub =  new CubexList(); 
			setState(242);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << TRUE) | (1L << FALSE) | (1L << VARFUN) | (1L << CLASSID) | (1L << INTEGER) | (1L << LBRACKET) | (1L << DASH) | (1L << BANG))) != 0)) {
				{
				setState(231); ((ExprsContext)_localctx).e = expr(0);
				 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(233); match(COMMA);
					setState(234); ((ExprsContext)_localctx).e = expr(0);
					 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
					}
					}
					setState(241);
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
			setState(244); match(FUN);
			setState(245); ((FuncoptionContext)_localctx).VARFUN = match(VARFUN);
			setState(246); ((FuncoptionContext)_localctx).t = tscheme();
			setState(249);
			switch (_input.LA(1)) {
			case RETURN:
			case WHILE:
			case IF:
			case FOR:
			case CLASSID:
			case EQUAL:
			case LBRACE:
				{
				setState(247); ((FuncoptionContext)_localctx).s = statement();
				}
				break;
			case SEMICOLON:
				{
				setState(248); match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((FuncoptionContext)_localctx).cub =  new CubexFunctionDef((((FuncoptionContext)_localctx).VARFUN!=null?((FuncoptionContext)_localctx).VARFUN.getText():null), ((FuncoptionContext)_localctx).t.cub, ((FuncoptionContext)_localctx).s.cub);
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
			setState(253); match(FUN);
			setState(254); ((FuncContext)_localctx).VARFUN = match(VARFUN);
			setState(255); ((FuncContext)_localctx).t = tscheme();
			setState(256); ((FuncContext)_localctx).s = statement();
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
			 ((FuncsContext)_localctx).cub =  new ArrayList<CubexFunctionDef>(); 
			setState(263); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(260); ((FuncsContext)_localctx).f = func();
					 _localctx.cub.add(((FuncsContext)_localctx).f.cub); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(265); 
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
		public TerminalNode ELSE() { return getToken(CubexParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLASSID() { return getToken(CubexParser.CLASSID, 0); }
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
			setState(309);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); match(LBRACE);
				setState(268); ((StatementContext)_localctx).s = statementsopt();
				setState(269); match(RBRACE);
				 ((StatementContext)_localctx).cub =  new CubexListStatement(((StatementContext)_localctx).s.cub); 
				}
				break;
			case CLASSID:
				enterOuterAlt(_localctx, 2);
				{
				setState(272); match(CLASSID);
				setState(273); match(GET);
				setState(274); ((StatementContext)_localctx).e = expr(0);
				setState(275); match(SEMICOLON);
				 ((StatementContext)_localctx).cub =  new CubexBind(((StatementContext)_localctx).e.cub); 
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(278); match(IF);
				setState(279); match(LPAREN);
				setState(280); ((StatementContext)_localctx).e = expr(0);
				setState(281); match(RPAREN);
				setState(282); ((StatementContext)_localctx).s1 = statement();
				setState(285);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(283); match(ELSE);
					setState(284); ((StatementContext)_localctx).s2 = statement();
					}
					break;
				}
				 ((StatementContext)_localctx).cub =  new CubexIf(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s1.cub, ((StatementContext)_localctx).s2.cub); 
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(289); match(WHILE);
				setState(290); match(LPAREN);
				setState(291); ((StatementContext)_localctx).e = expr(0);
				setState(292); match(RPAREN);
				setState(293); ((StatementContext)_localctx).s = statement();
				 ((StatementContext)_localctx).cub =  new CubexWhile(((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s.cub); 
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(296); match(FOR);
				setState(297); match(LPAREN);
				setState(298); ((StatementContext)_localctx).VARFUN = match(VARFUN);
				setState(299); match(IN);
				setState(300); ((StatementContext)_localctx).e = expr(0);
				setState(301); match(RPAREN);
				setState(302); ((StatementContext)_localctx).s = statement();
				 ((StatementContext)_localctx).cub =  new CubexFor((((StatementContext)_localctx).VARFUN!=null?((StatementContext)_localctx).VARFUN.getText():null), ((StatementContext)_localctx).e.cub, ((StatementContext)_localctx).s.cub); 
				}
				break;
			case RETURN:
			case EQUAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(305);
				_la = _input.LA(1);
				if ( !(_la==RETURN || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(306); ((StatementContext)_localctx).e = expr(0);
				 ((StatementContext)_localctx).cub =  new CubexReturn(((StatementContext)_localctx).e.cub); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
			setState(315); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(312); ((StatementsContext)_localctx).s = statement();
					 _localctx.cub.add(((StatementsContext)_localctx).s.cub); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(317); 
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
		enterRule(_localctx, 26, RULE_statementsopt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementsoptContext)_localctx).cub =  new CubexList<CubexStatement(); 
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << FOR) | (1L << CLASSID) | (1L << EQUAL) | (1L << LBRACE))) != 0)) {
				{
				{
				setState(320); ((StatementsoptContext)_localctx).s = statement();
				 _localctx.cub.add(((StatementsoptContext)_localctx).s.cub); 
				}
				}
				setState(327);
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
			setState(329); match(INTERFACE);
			setState(330);
			((IfaceContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((IfaceContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(331); match(LANGLE);
			setState(332); ((IfaceContext)_localctx).k = kcont();
			setState(333); match(RANGLE);
			setState(336);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(334); match(EXTENDS);
				setState(335); ((IfaceContext)_localctx).t = type(0);
				}
			}

			setState(338); match(LBRACE);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(339); ((IfaceContext)_localctx).f = funcoption();
				 list.add(((IfaceContext)_localctx).f.cub); 
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(347); match(RBRACE);
			 ((IfaceContext)_localctx).cub =  new CubexInterface((((IfaceContext)_localctx).name!=null?((IfaceContext)_localctx).name.getText():null), ((IfaceContext)_localctx).k.cub, ((IfaceContext)_localctx).t.cub, list); 
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
			setState(351); match(CLASS);
			setState(352);
			((ClassgrammarContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((ClassgrammarContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(357);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(353); match(LANGLE);
				setState(354); ((ClassgrammarContext)_localctx).k = kcont();
				setState(355); match(RANGLE);
				}
			}

			setState(359); match(LPAREN);
			setState(360); ((ClassgrammarContext)_localctx).t = tcont();
			setState(361); match(RPAREN);
			setState(364);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(362); match(EXTENDS);
				setState(363); ((ClassgrammarContext)_localctx).ty = type(0);
				}
			}

			setState(366); match(LBRACE);
			setState(367); ((ClassgrammarContext)_localctx).s = statementsopt();
			setState(374);
			_la = _input.LA(1);
			if (_la==SUPER) {
				{
				setState(368); match(SUPER);
				setState(369); match(LPAREN);
				setState(370); ((ClassgrammarContext)_localctx).e = exprs();
				setState(371); match(RPAREN);
				setState(372); match(SEMICOLON);
				}
			}

			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(376); ((ClassgrammarContext)_localctx).f = func();
				 list.add(((ClassgrammarContext)_localctx).f.cub); 
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(384); match(RBRACE);
			 ((ClassgrammarContext)_localctx).cub =  new CubexClassGrammar((((ClassgrammarContext)_localctx).name!=null?((ClassgrammarContext)_localctx).name.getText():null), ((ClassgrammarContext)_localctx).k.cub, ((ClassgrammarContext)_localctx).t.cub, ((ClassgrammarContext)_localctx).ty.cub, ((ClassgrammarContext)_localctx).s.cub, ((ClassgrammarContext)_localctx).e.cub, list); 
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
			setState(406);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387); ((ProgramContext)_localctx).s = statement();
				 ((ProgramContext)_localctx).cub =  new CubexProgramStatement(((ProgramContext)_localctx).s.cub); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(390); ((ProgramContext)_localctx).s = statements();
				setState(391); program();
				 ((ProgramContext)_localctx).cub =  new CubexProgramStatementList(((ProgramContext)_localctx).s.cub); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(394); ((ProgramContext)_localctx).f = funcs();
				setState(395); program();
				 ((ProgramContext)_localctx).cub =  new CubexProgramFunctionDefList(((ProgramContext)_localctx).f.cub); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(398); ((ProgramContext)_localctx).i = iface();
				setState(399); program();
				 ((ProgramContext)_localctx).cub =  new CubexProgramInterface(((ProgramContext)_localctx).i.cub); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(402); ((ProgramContext)_localctx).c = classgrammar();
				setState(403); program();
				 ((ProgramContext)_localctx).cub =  new CubexProgramClassGrammar(((ProgramContext)_localctx).c.cub); 
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
			setState(408); ((FullprogramContext)_localctx).p = program();
			 programAST = ((FullprogramContext)_localctx).p.cub 
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
		case 1: return 14 >= _localctx._p;

		case 2: return 8 >= _localctx._p;

		case 3: return 7 >= _localctx._p;

		case 4: return 6 >= _localctx._p;

		case 5: return 5 >= _localctx._p;

		case 6: return 4 >= _localctx._p;

		case 7: return 3 >= _localctx._p;

		case 8: return 2 >= _localctx._p;

		case 9: return 16 >= _localctx._p;

		case 10: return 1 >= _localctx._p;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3:\u019e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\5\2\62\n"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C"+
		"\13\4\5\4E\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5V\n\5\3\5\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\5\6n\n\6\3\7\3\7\3\7\3\7\5"+
		"\7t\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u0089\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009d\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b5"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00bf\n\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u00da\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00e4\n\b"+
		"\f\b\16\b\u00e7\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f0\n\t\f\t\16"+
		"\t\u00f3\13\t\5\t\u00f5\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00fc\n\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\6\f\u010a\n\f\r\f\16\f"+
		"\u010b\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u0120\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0138\n\r\3\16\3\16\3\16"+
		"\3\16\6\16\u013e\n\16\r\16\16\16\u013f\3\17\3\17\3\17\3\17\7\17\u0146"+
		"\n\17\f\17\16\17\u0149\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u0153\n\20\3\20\3\20\3\20\3\20\7\20\u0159\n\20\f\20\16\20\u015c\13"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0168\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u016f\n\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0179\n\21\3\21\3\21\3\21\7\21\u017e\n\21\f\21\16\21\u0181"+
		"\13\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0199\n\22\3\23\3\23"+
		"\3\23\3\23\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\t\4\2\62"+
		"\62\65\65\3\2\23\24\3\2-/\3\2\61\62\4\2\27\27\31\33\4\2\30\30\34\34\4"+
		"\2\4\4&&\u01c4\2&\3\2\2\2\4\63\3\2\2\2\68\3\2\2\2\bU\3\2\2\2\na\3\2\2"+
		"\2\fs\3\2\2\2\16\u009c\3\2\2\2\20\u00e8\3\2\2\2\22\u00f6\3\2\2\2\24\u00ff"+
		"\3\2\2\2\26\u0105\3\2\2\2\30\u0137\3\2\2\2\32\u0139\3\2\2\2\34\u0141\3"+
		"\2\2\2\36\u014a\3\2\2\2 \u0160\3\2\2\2\"\u0198\3\2\2\2$\u019a\3\2\2\2"+
		"&\61\b\2\1\2\'(\7\25\2\2(.\b\2\1\2)*\7)\2\2*+\7\25\2\2+-\b\2\1\2,)\3\2"+
		"\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61\'\3\2"+
		"\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\64\7\23\2\2\64\65\7$\2\2\65\66\5\b"+
		"\5\2\66\67\b\3\1\2\67\5\3\2\2\28D\b\4\1\29:\5\4\3\2:A\b\4\1\2;<\7)\2\2"+
		"<=\5\4\3\2=>\b\4\1\2>@\3\2\2\2?;\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2"+
		"BE\3\2\2\2CA\3\2\2\2D9\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FG\b\5\1\2GH\7\25\2"+
		"\2HV\b\5\1\2IN\7\24\2\2JK\7\63\2\2KL\5\n\6\2LM\7\64\2\2MO\3\2\2\2NJ\3"+
		"\2\2\2NO\3\2\2\2OP\3\2\2\2PV\b\5\1\2QR\7\21\2\2RV\b\5\1\2ST\7\22\2\2T"+
		"V\b\5\1\2UF\3\2\2\2UI\3\2\2\2UQ\3\2\2\2US\3\2\2\2V^\3\2\2\2WX\6\5\2\3"+
		"XY\7\66\2\2YZ\5\b\5\2Z[\b\5\1\2[]\3\2\2\2\\W\3\2\2\2]`\3\2\2\2^\\\3\2"+
		"\2\2^_\3\2\2\2_\t\3\2\2\2`^\3\2\2\2am\b\6\1\2bc\5\b\5\2cj\b\6\1\2de\7"+
		")\2\2ef\5\b\5\2fg\b\6\1\2gi\3\2\2\2hd\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3"+
		"\2\2\2kn\3\2\2\2lj\3\2\2\2mb\3\2\2\2mn\3\2\2\2n\13\3\2\2\2op\7\63\2\2"+
		"pq\5\2\2\2qr\7\64\2\2rt\3\2\2\2so\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\'\2"+
		"\2vw\5\6\4\2wx\7(\2\2xy\7$\2\2yz\5\b\5\2z{\b\7\1\2{\r\3\2\2\2|}\b\b\1"+
		"\2}~\t\2\2\2~\177\5\16\b\2\177\u0080\b\b\1\2\u0080\u009d\3\2\2\2\u0081"+
		"\u0082\7\23\2\2\u0082\u009d\b\b\1\2\u0083\u0088\t\3\2\2\u0084\u0085\7"+
		"\63\2\2\u0085\u0086\5\n\6\2\u0086\u0087\7\64\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0084\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7\'"+
		"\2\2\u008b\u008c\5\20\t\2\u008c\u008d\7(\2\2\u008d\u008e\b\b\1\2\u008e"+
		"\u009d\3\2\2\2\u008f\u0090\7\"\2\2\u0090\u0091\5\20\t\2\u0091\u0092\7"+
		"#\2\2\u0092\u0093\b\b\1\2\u0093\u009d\3\2\2\2\u0094\u0095\7\b\2\2\u0095"+
		"\u009d\b\b\1\2\u0096\u0097\7\t\2\2\u0097\u009d\b\b\1\2\u0098\u0099\7\26"+
		"\2\2\u0099\u009d\b\b\1\2\u009a\u009b\7\3\2\2\u009b\u009d\b\b\1\2\u009c"+
		"|\3\2\2\2\u009c\u0081\3\2\2\2\u009c\u0083\3\2\2\2\u009c\u008f\3\2\2\2"+
		"\u009c\u0094\3\2\2\2\u009c\u0096\3\2\2\2\u009c\u0098\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u00e5\3\2\2\2\u009e\u009f\6\b\3\3\u009f\u00a0\7\60\2\2"+
		"\u00a0\u00a1\5\16\b\2\u00a1\u00a2\b\b\1\2\u00a2\u00e4\3\2\2\2\u00a3\u00a4"+
		"\6\b\4\3\u00a4\u00a5\t\4\2\2\u00a5\u00a6\5\16\b\2\u00a6\u00a7\b\b\1\2"+
		"\u00a7\u00e4\3\2\2\2\u00a8\u00a9\6\b\5\3\u00a9\u00aa\t\5\2\2\u00aa\u00ab"+
		"\5\16\b\2\u00ab\u00ac\b\b\1\2\u00ac\u00e4\3\2\2\2\u00ad\u00b4\6\b\6\3"+
		"\u00ae\u00b5\7\63\2\2\u00af\u00b0\7\63\2\2\u00b0\u00b5\7&\2\2\u00b1\u00b5"+
		"\7\64\2\2\u00b2\u00b3\7\64\2\2\u00b3\u00b5\7&\2\2\u00b4\u00ae\3\2\2\2"+
		"\u00b4\u00af\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\5\16\b\2\u00b7\u00b8\b\b\1\2\u00b8\u00e4\3\2\2\2"+
		"\u00b9\u00be\6\b\7\3\u00ba\u00bb\7&\2\2\u00bb\u00bf\7&\2\2\u00bc\u00bd"+
		"\7\65\2\2\u00bd\u00bf\7&\2\2\u00be\u00ba\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\5\16\b\2\u00c1\u00c2\b\b\1\2\u00c2\u00e4\3"+
		"\2\2\2\u00c3\u00c4\6\b\b\3\u00c4\u00c5\7\66\2\2\u00c5\u00c6\5\16\b\2\u00c6"+
		"\u00c7\b\b\1\2\u00c7\u00e4\3\2\2\2\u00c8\u00c9\6\b\t\3\u00c9\u00ca\7\67"+
		"\2\2\u00ca\u00cb\5\16\b\2\u00cb\u00cc\b\b\1\2\u00cc\u00e4\3\2\2\2\u00cd"+
		"\u00ce\6\b\n\3\u00ce\u00cf\t\6\2\2\u00cf\u00d0\5\16\b\2\u00d0\u00d1\b"+
		"\b\1\2\u00d1\u00e4\3\2\2\2\u00d2\u00d3\6\b\13\3\u00d3\u00d4\7!\2\2\u00d4"+
		"\u00d9\7\23\2\2\u00d5\u00d6\7\63\2\2\u00d6\u00d7\5\n\6\2\u00d7\u00d8\7"+
		"\64\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d5\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\7\'\2\2\u00dc\u00dd\5\20\t\2\u00dd\u00de\7"+
		"(\2\2\u00de\u00df\b\b\1\2\u00df\u00e4\3\2\2\2\u00e0\u00e1\6\b\f\3\u00e1"+
		"\u00e2\t\7\2\2\u00e2\u00e4\b\b\1\2\u00e3\u009e\3\2\2\2\u00e3\u00a3\3\2"+
		"\2\2\u00e3\u00a8\3\2\2\2\u00e3\u00ad\3\2\2\2\u00e3\u00b9\3\2\2\2\u00e3"+
		"\u00c3\3\2\2\2\u00e3\u00c8\3\2\2\2\u00e3\u00cd\3\2\2\2\u00e3\u00d2\3\2"+
		"\2\2\u00e3\u00e0\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\17\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00f4\b\t\1"+
		"\2\u00e9\u00ea\5\16\b\2\u00ea\u00f1\b\t\1\2\u00eb\u00ec\7)\2\2\u00ec\u00ed"+
		"\5\16\b\2\u00ed\u00ee\b\t\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2"+
		"\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f5"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00e9\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\21\3\2\2\2\u00f6\u00f7\7\17\2\2\u00f7\u00f8\7\23\2\2\u00f8\u00fb\5\f"+
		"\7\2\u00f9\u00fc\5\30\r\2\u00fa\u00fc\7*\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\b\n\1\2\u00fe\23\3\2\2"+
		"\2\u00ff\u0100\7\17\2\2\u0100\u0101\7\23\2\2\u0101\u0102\5\f\7\2\u0102"+
		"\u0103\5\30\r\2\u0103\u0104\b\13\1\2\u0104\25\3\2\2\2\u0105\u0109\b\f"+
		"\1\2\u0106\u0107\5\24\13\2\u0107\u0108\b\f\1\2\u0108\u010a\3\2\2\2\u0109"+
		"\u0106\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\27\3\2\2\2\u010d\u010e\7+\2\2\u010e\u010f\5\34\17\2\u010f\u0110"+
		"\7,\2\2\u0110\u0111\b\r\1\2\u0111\u0138\3\2\2\2\u0112\u0113\7\24\2\2\u0113"+
		"\u0114\7%\2\2\u0114\u0115\5\16\b\2\u0115\u0116\7*\2\2\u0116\u0117\b\r"+
		"\1\2\u0117\u0138\3\2\2\2\u0118\u0119\7\6\2\2\u0119\u011a\7\'\2\2\u011a"+
		"\u011b\5\16\b\2\u011b\u011c\7(\2\2\u011c\u011f\5\30\r\2\u011d\u011e\7"+
		"\7\2\2\u011e\u0120\5\30\r\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0122\b\r\1\2\u0122\u0138\3\2\2\2\u0123\u0124\7\5"+
		"\2\2\u0124\u0125\7\'\2\2\u0125\u0126\5\16\b\2\u0126\u0127\7(\2\2\u0127"+
		"\u0128\5\30\r\2\u0128\u0129\b\r\1\2\u0129\u0138\3\2\2\2\u012a\u012b\7"+
		"\n\2\2\u012b\u012c\7\'\2\2\u012c\u012d\7\23\2\2\u012d\u012e\7\13\2\2\u012e"+
		"\u012f\5\16\b\2\u012f\u0130\7(\2\2\u0130\u0131\5\30\r\2\u0131\u0132\b"+
		"\r\1\2\u0132\u0138\3\2\2\2\u0133\u0134\t\b\2\2\u0134\u0135\5\16\b\2\u0135"+
		"\u0136\b\r\1\2\u0136\u0138\3\2\2\2\u0137\u010d\3\2\2\2\u0137\u0112\3\2"+
		"\2\2\u0137\u0118\3\2\2\2\u0137\u0123\3\2\2\2\u0137\u012a\3\2\2\2\u0137"+
		"\u0133\3\2\2\2\u0138\31\3\2\2\2\u0139\u013d\b\16\1\2\u013a\u013b\5\30"+
		"\r\2\u013b\u013c\b\16\1\2\u013c\u013e\3\2\2\2\u013d\u013a\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\33\3\2\2"+
		"\2\u0141\u0147\b\17\1\2\u0142\u0143\5\30\r\2\u0143\u0144\b\17\1\2\u0144"+
		"\u0146\3\2\2\2\u0145\u0142\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148\35\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b"+
		"\b\20\1\2\u014b\u014c\7\f\2\2\u014c\u014d\t\3\2\2\u014d\u014e\7\63\2\2"+
		"\u014e\u014f\5\2\2\2\u014f\u0152\7\64\2\2\u0150\u0151\7\20\2\2\u0151\u0153"+
		"\5\b\5\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u015a\7+\2\2\u0155\u0156\5\22\n\2\u0156\u0157\b\20\1\2\u0157\u0159\3"+
		"\2\2\2\u0158\u0155\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7,"+
		"\2\2\u015e\u015f\b\20\1\2\u015f\37\3\2\2\2\u0160\u0161\b\21\1\2\u0161"+
		"\u0162\7\r\2\2\u0162\u0167\t\3\2\2\u0163\u0164\7\63\2\2\u0164\u0165\5"+
		"\2\2\2\u0165\u0166\7\64\2\2\u0166\u0168\3\2\2\2\u0167\u0163\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\7\'\2\2\u016a\u016b\5\6"+
		"\4\2\u016b\u016e\7(\2\2\u016c\u016d\7\20\2\2\u016d\u016f\5\b\5\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\7+"+
		"\2\2\u0171\u0178\5\34\17\2\u0172\u0173\7\16\2\2\u0173\u0174\7\'\2\2\u0174"+
		"\u0175\5\20\t\2\u0175\u0176\7(\2\2\u0176\u0177\7*\2\2\u0177\u0179\3\2"+
		"\2\2\u0178\u0172\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017f\3\2\2\2\u017a"+
		"\u017b\5\24\13\2\u017b\u017c\b\21\1\2\u017c\u017e\3\2\2\2\u017d\u017a"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7,\2\2\u0183\u0184\b\21"+
		"\1\2\u0184!\3\2\2\2\u0185\u0186\5\30\r\2\u0186\u0187\b\22\1\2\u0187\u0199"+
		"\3\2\2\2\u0188\u0189\5\32\16\2\u0189\u018a\5\"\22\2\u018a\u018b\b\22\1"+
		"\2\u018b\u0199\3\2\2\2\u018c\u018d\5\26\f\2\u018d\u018e\5\"\22\2\u018e"+
		"\u018f\b\22\1\2\u018f\u0199\3\2\2\2\u0190\u0191\5\36\20\2\u0191\u0192"+
		"\5\"\22\2\u0192\u0193\b\22\1\2\u0193\u0199\3\2\2\2\u0194\u0195\5 \21\2"+
		"\u0195\u0196\5\"\22\2\u0196\u0197\b\22\1\2\u0197\u0199\3\2\2\2\u0198\u0185"+
		"\3\2\2\2\u0198\u0188\3\2\2\2\u0198\u018c\3\2\2\2\u0198\u0190\3\2\2\2\u0198"+
		"\u0194\3\2\2\2\u0199#\3\2\2\2\u019a\u019b\5\"\22\2\u019b\u019c\b\23\1"+
		"\2\u019c%\3\2\2\2\".\61ADNU^jms\u0088\u009c\u00b4\u00be\u00d9\u00e3\u00e5"+
		"\u00f1\u00f4\u00fb\u010b\u011f\u0137\u013f\u0147\u0152\u015a\u0167\u016e"+
		"\u0178\u017f\u0198";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
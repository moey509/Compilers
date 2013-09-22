// Generated from CubexParser.g4 by ANTLR 4.1
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
		RULE_tscheme = 5, RULE_expr = 6, RULE_exprs = 7, RULE_func = 8, RULE_statement = 9, 
		RULE_iface = 10, RULE_classgrammar = 11, RULE_program = 12;
	public static final String[] ruleNames = {
		"kcont", "ttuple", "tcont", "type", "types", "tscheme", "expr", "exprs", 
		"func", "statement", "iface", "classgrammar", "program"
	};

	@Override
	public String getGrammarFileName() { return "CubexParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public CubexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class KcontContext extends ParserRuleContext {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterKcont(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitKcont(this);
		}
	}

	public final KcontContext kcont() throws RecognitionException {
		KcontContext _localctx = new KcontContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_kcont);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if (_la==TYPEPARAM) {
				{
				setState(26); match(TYPEPARAM);
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(27); match(COMMA);
					setState(28); match(TYPEPARAM);
					}
					}
					setState(33);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CubexParser.COLON, 0); }
		public TerminalNode VARFUN() { return getToken(CubexParser.VARFUN, 0); }
		public TtupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ttuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterTtuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitTtuple(this);
		}
	}

	public final TtupleContext ttuple() throws RecognitionException {
		TtupleContext _localctx = new TtupleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ttuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(VARFUN);
			setState(37); match(COLON);
			setState(38); type(0);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterTcont(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitTcont(this);
		}
	}

	public final TcontContext tcont() throws RecognitionException {
		TcontContext _localctx = new TcontContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tcont);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if (_la==VARFUN) {
				{
				setState(40); ttuple();
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(41); match(COMMA);
					setState(42); ttuple();
					}
					}
					setState(47);
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
		public TerminalNode NOTHING() { return getToken(CubexParser.NOTHING, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TypeContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitType(this);
		}
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
			setState(56);
			switch (_input.LA(1)) {
			case TYPEPARAM:
				{
				setState(51); match(TYPEPARAM);
				}
				break;
			case CLASSID:
				{
				setState(52); match(CLASSID);
				setState(53); types();
				}
				break;
			case THING:
				{
				setState(54); match(THING);
				}
				break;
			case NOTHING:
				{
				setState(55); match(NOTHING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(58);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(59); match(AMPERSAND);
					setState(60); type(4);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitTypes(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_types);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(66); type(0);
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(67); match(COMMA);
						setState(68); type(0);
						}
						} 
					}
					setState(73);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				}
				break;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterTscheme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitTscheme(this);
		}
	}

	public final TschemeContext tscheme() throws RecognitionException {
		TschemeContext _localctx = new TschemeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tscheme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(76); match(LANGLE);
				setState(77); kcont();
				setState(78); match(RANGLE);
				}
			}

			setState(82); match(LPAREN);
			setState(83); tcont();
			setState(84); match(RPAREN);
			setState(85); match(COLON);
			setState(86); type(0);
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
		public Token op;
		public ExprContext e;
		public Token VARFUN;
		public Token name;
		public ExprsContext tes;
		public ExprsContext pes;
		public ExprsContext es;
		public Token INTEGER;
		public Token STRING;
		public ExprContext ex2;
		public ExprContext r;
		public Token eq;
		public ExprsContext exprs(int i) {
			return getRuleContext(ExprsContext.class,i);
		}
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
		public List<ExprsContext> exprs() {
			return getRuleContexts(ExprsContext.class);
		}
		public TerminalNode PIPE() { return getToken(CubexParser.PIPE, 0); }
		public TerminalNode PERCENT() { return getToken(CubexParser.PERCENT, 0); }
		public TerminalNode BANG() { return getToken(CubexParser.BANG, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitExpr(this);
		}
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
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(89);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DASH || _la==BANG) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(90); ((ExprContext)_localctx).e = expr(9);
				 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DASH ? new CubexNegative(((ExprContext)_localctx).e.cub) : new CubexNegate(((ExprContext)_localctx).e.cub);
				}
				break;

			case 2:
				{
				setState(93); ((ExprContext)_localctx).VARFUN = match(VARFUN);
				 _localctx.cub = new CubexVariable((((ExprContext)_localctx).VARFUN!=null?((ExprContext)_localctx).VARFUN.getText():null)) 
				}
				break;

			case 3:
				{
				setState(95);
				((ExprContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VARFUN || _la==CLASSID) ) {
					((ExprContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(96); match(LANGLE);
				setState(97); ((ExprContext)_localctx).tes = exprs();
				setState(98); match(RANGLE);
				setState(99); match(LPAREN);
				setState(100); ((ExprContext)_localctx).pes = exprs();
				setState(101); match(RPAREN);
				 _localctx.cub = new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), ((ExprContext)_localctx).tes.cub, ((ExprContext)_localctx).pes.cub) 
				}
				break;

			case 4:
				{
				setState(104);
				((ExprContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VARFUN || _la==CLASSID) ) {
					((ExprContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(105); match(LPAREN);
				setState(106); ((ExprContext)_localctx).pes = exprs();
				setState(107); match(RPAREN);
				 _localctx.cub = new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), ((ExprContext)_localctx).pes.cub) 
				}
				break;

			case 5:
				{
				setState(110); match(LBRACKET);
				setState(111); ((ExprContext)_localctx).es = exprs();
				setState(112); match(RBRACKET);
				((ExprContext)_localctx).cub =  new CubexIterable(((ExprContext)_localctx).es.cub); 
				}
				break;

			case 6:
				{
				setState(115); match(TRUE);
				 _localctx.cub = new CubexBoolean(true) 
				}
				break;

			case 7:
				{
				setState(117); match(FALSE);
				 _localctx.cub = new CubexBoolean(false) 
				}
				break;

			case 8:
				{
				setState(119); ((ExprContext)_localctx).INTEGER = match(INTEGER);
				 ((ExprContext)_localctx).cub =  new CubexInteger((((ExprContext)_localctx).INTEGER!=null?Integer.valueOf(((ExprContext)_localctx).INTEGER.getText()):0)); 
				}
				break;

			case 9:
				{
				setState(121); ((ExprContext)_localctx).STRING = match(STRING);
				 ((ExprContext)_localctx).cub =  new CubexString((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(126); match(PLPL);
						setState(127); ((ExprContext)_localctx).ex2 = expr(15);
						 ((ExprContext)_localctx).cub =  new CubexAppend(((ExprContext)_localctx).ex.cub, ((ExprContext)_localctx).ex2.cub); 
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(131);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << SLASH) | (1L << PERCENT))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(132); ((ExprContext)_localctx).r = expr(9);
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
						setState(135);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(136);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==DASH) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(137); ((ExprContext)_localctx).r = expr(8);
						 ((ExprContext)_localctx).cub =  (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == PLUS
						                       ? new CubexAdd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub)
						                       : new CubexSubtract(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(147);
						switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
						case 1:
							{
							setState(141); ((ExprContext)_localctx).op = match(LANGLE);
							}
							break;

						case 2:
							{
							setState(142); ((ExprContext)_localctx).op = match(LANGLE);
							setState(143); ((ExprContext)_localctx).eq = match(EQUAL);
							}
							break;

						case 3:
							{
							setState(144); ((ExprContext)_localctx).op = match(RANGLE);
							}
							break;

						case 4:
							{
							setState(145); ((ExprContext)_localctx).op = match(RANGLE);
							setState(146); ((ExprContext)_localctx).eq = match(EQUAL);
							}
							break;
						}
						setState(149); ((ExprContext)_localctx).r = expr(7);
						 CubexExpression l = (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LANGLE ? ((ExprContext)_localctx).l.cub : ((ExprContext)_localctx).r.cub;
						                    CubexExpression r = (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LANGLE ? ((ExprContext)_localctx).r.cub : ((ExprContext)_localctx).l.cub;
						                    ((ExprContext)_localctx).cub =  ((ExprContext)_localctx).eq == null ? new CubexLessStrict(l, r) : new CubexLessEqual(l, r); 
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(157);
						switch (_input.LA(1)) {
						case EQUAL:
							{
							setState(153); ((ExprContext)_localctx).op = match(EQUAL);
							setState(154); match(EQUAL);
							}
							break;
						case BANG:
							{
							setState(155); ((ExprContext)_localctx).op = match(BANG);
							setState(156); match(EQUAL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(159); ((ExprContext)_localctx).r = expr(6);
						 ((ExprContext)_localctx).cub =  new CubexEquals(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub);
						                if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == BANG) ((ExprContext)_localctx).cub =  new CubexNegate(_localctx.cub); 
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(163); match(AMPERSAND);
						setState(164); ((ExprContext)_localctx).r = expr(5);
						 ((ExprContext)_localctx).cub =  new CubexAnd(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(168); match(PIPE);
						setState(169); ((ExprContext)_localctx).r = expr(4);
						 ((ExprContext)_localctx).cub =  new CubexOr(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub); 
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(173);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << THROUGH) | (1L << LDOT) | (1L << DOTL) | (1L << LL))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(174); ((ExprContext)_localctx).r = expr(3);
						 _localctx.cub = (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == THROUGH
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, true, true)
						                   : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LDOT
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, false, true)
						                   : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == DOTL
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, true, false)
						                   : (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == LL
						                   ? new CubexThrough(((ExprContext)_localctx).l.cub, ((ExprContext)_localctx).r.cub, false, false)
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(178); match(DOT);
						setState(179); ((ExprContext)_localctx).VARFUN = match(VARFUN);
						setState(180); match(LANGLE);
						setState(181); ((ExprContext)_localctx).tes = exprs();
						setState(182); match(RANGLE);
						setState(183); match(LPAREN);
						setState(184); ((ExprContext)_localctx).pes = exprs();
						setState(185); match(RPAREN);
						 _localctx.cub = new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), ((ExprContext)_localctx).tes.cub, ((ExprContext)_localctx).pes.cub) 
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(189); match(DOT);
						setState(190); ((ExprContext)_localctx).VARFUN = match(VARFUN);
						setState(191); match(LPAREN);
						setState(192); ((ExprContext)_localctx).pes = exprs();
						setState(193); match(RPAREN);
						 _localctx.cub = new CubexFunctionCall((((ExprContext)_localctx).name!=null?((ExprContext)_localctx).name.getText():null), ((ExprContext)_localctx).pes.cub) 
						}
						break;

					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(197);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ONW || _la==LDOTDOT) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						 _localctx.cub = (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getType():0) == ONW
						                       ? new CubexOnwards(((ExprContext)_localctx).l.cub, true)
						                   : new CubexOnwards(((ExprContext)_localctx).l.cub, false)
						}
						break;
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public List<CubexExpression> cub;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExprsContext)_localctx).cub =  new ArrayList<CubexExpression>(); 
			setState(216);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << TRUE) | (1L << FALSE) | (1L << VARFUN) | (1L << CLASSID) | (1L << INTEGER) | (1L << LBRACKET) | (1L << DASH) | (1L << BANG))) != 0)) {
				{
				setState(205); ((ExprsContext)_localctx).e = expr(0);
				 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(207); match(COMMA);
					setState(208); ((ExprsContext)_localctx).e = expr(0);
					 _localctx.cub.add(((ExprsContext)_localctx).e.cub); 
					}
					}
					setState(215);
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

	public static class FuncContext extends ParserRuleContext {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(FUN);
			setState(219); match(VARFUN);
			setState(220); ((FuncContext)_localctx).t = tscheme();
			setState(222);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(221); ((FuncContext)_localctx).s = statement();
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
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
		public TerminalNode FOR() { return getToken(CubexParser.FOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(CubexParser.ELSE, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(262);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(224); match(LBRACE);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << FOR) | (1L << CLASSID) | (1L << EQUAL) | (1L << LBRACE))) != 0)) {
					{
					{
					setState(225); statement();
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(231); match(RBRACE);
				}
				break;
			case CLASSID:
				enterOuterAlt(_localctx, 2);
				{
				setState(232); match(CLASSID);
				setState(233); match(GET);
				setState(234); expr(0);
				setState(235); match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(237); match(IF);
				setState(238); match(LPAREN);
				setState(239); expr(0);
				setState(240); match(RPAREN);
				setState(241); statement();
				setState(244);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(242); match(ELSE);
					setState(243); statement();
					}
					break;
				}
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(246); match(WHILE);
				setState(247); match(LPAREN);
				setState(248); expr(0);
				setState(249); match(RPAREN);
				setState(250); statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(252); match(FOR);
				setState(253); match(LPAREN);
				setState(254); match(VARFUN);
				setState(255); match(IN);
				setState(256); expr(0);
				setState(257); match(RPAREN);
				setState(258); statement();
				}
				break;
			case RETURN:
			case EQUAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
				_la = _input.LA(1);
				if ( !(_la==RETURN || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(261); expr(0);
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

	public static class IfaceContext extends ParserRuleContext {
		public Token name;
		public TerminalNode LBRACE() { return getToken(CubexParser.LBRACE, 0); }
		public TerminalNode CLASSID() { return getToken(CubexParser.CLASSID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public TerminalNode LANGLE() { return getToken(CubexParser.LANGLE, 0); }
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterIface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitIface(this);
		}
	}

	public final IfaceContext iface() throws RecognitionException {
		IfaceContext _localctx = new IfaceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_iface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(INTERFACE);
			setState(265);
			((IfaceContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
				((IfaceContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(266); match(LANGLE);
			setState(267); kcont();
			setState(268); match(RANGLE);
			setState(271);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(269); match(EXTENDS);
				setState(270); type(0);
				}
			}

			setState(273); match(LBRACE);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(274); func();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280); match(RBRACE);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TcontContext tcont() {
			return getRuleContext(TcontContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(CubexParser.LBRACE, 0); }
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public KcontContext kcont() {
			return getRuleContext(KcontContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(CubexParser.EXTENDS, 0); }
		public ClassgrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classgrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterClassgrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitClassgrammar(this);
		}
	}

	public final ClassgrammarContext classgrammar() throws RecognitionException {
		ClassgrammarContext _localctx = new ClassgrammarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classgrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(CLASS);
			setState(283);
			_la = _input.LA(1);
			if ( !(_la==VARFUN || _la==CLASSID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(288);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(284); match(LANGLE);
				setState(285); kcont();
				setState(286); match(RANGLE);
				}
			}

			setState(290); match(LPAREN);
			setState(291); tcont();
			setState(292); match(RPAREN);
			setState(295);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(293); match(EXTENDS);
				setState(294); type(0);
				}
			}

			setState(297); match(LBRACE);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << FOR) | (1L << CLASSID) | (1L << EQUAL) | (1L << LBRACE))) != 0)) {
				{
				{
				setState(298); statement();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(314);
			_la = _input.LA(1);
			if (_la==SUPER) {
				{
				setState(304); match(SUPER);
				setState(305); match(LPAREN);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << TRUE) | (1L << FALSE) | (1L << VARFUN) | (1L << CLASSID) | (1L << INTEGER) | (1L << LBRACKET) | (1L << DASH) | (1L << BANG))) != 0)) {
					{
					{
					setState(306); expr(0);
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(312); match(RPAREN);
				setState(313); match(SEMICOLON);
				}
			}

			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(316); func();
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(322); match(RBRACE);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public IfaceContext iface() {
			return getRuleContext(IfaceContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ClassgrammarContext classgrammar() {
			return getRuleContext(ClassgrammarContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CubexParserListener ) ((CubexParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_program);
		try {
			int _alt;
			setState(345);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324); statement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(325); statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(328); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(330); program();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(333); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(332); func();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(335); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(337); program();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(339); iface();
				setState(340); program();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(342); classgrammar();
				setState(343); program();
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

		case 9: return 17 >= _localctx._p;

		case 10: return 16 >= _localctx._p;

		case 11: return 1 >= _localctx._p;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3:\u015e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\5\2"+
		"%\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\5\4\63\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5;\n\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5"+
		"\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\5\6M\n\6\3\7\3\7\3\7\3\7\5\7S\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b~\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0096\n\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a0\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ca"+
		"\n\b\f\b\16\b\u00cd\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00d6\n\t\f\t"+
		"\16\t\u00d9\13\t\5\t\u00db\n\t\3\n\3\n\3\n\3\n\5\n\u00e1\n\n\3\13\3\13"+
		"\7\13\u00e5\n\13\f\13\16\13\u00e8\13\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f7\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0109"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0112\n\f\3\f\3\f\7\f\u0116\n\f"+
		"\f\f\16\f\u0119\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0123\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u012a\n\r\3\r\3\r\7\r\u012e\n\r\f\r\16\r\u0131\13"+
		"\r\3\r\3\r\3\r\7\r\u0136\n\r\f\r\16\r\u0139\13\r\3\r\3\r\5\r\u013d\n\r"+
		"\3\r\7\r\u0140\n\r\f\r\16\r\u0143\13\r\3\r\3\r\3\16\3\16\6\16\u0149\n"+
		"\16\r\16\16\16\u014a\3\16\3\16\3\16\6\16\u0150\n\16\r\16\16\16\u0151\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u015c\n\16\3\16\2\17\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\2\t\4\2\62\62\65\65\3\2\23\24\3\2-/\3\2\61"+
		"\62\4\2\27\27\31\33\4\2\30\30\34\34\4\2\4\4&&\u018a\2$\3\2\2\2\4&\3\2"+
		"\2\2\6\62\3\2\2\2\b:\3\2\2\2\nL\3\2\2\2\fR\3\2\2\2\16}\3\2\2\2\20\u00ce"+
		"\3\2\2\2\22\u00dc\3\2\2\2\24\u0108\3\2\2\2\26\u010a\3\2\2\2\30\u011c\3"+
		"\2\2\2\32\u015b\3\2\2\2\34!\7\25\2\2\35\36\7)\2\2\36 \7\25\2\2\37\35\3"+
		"\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#!\3\2\2\2$\34\3\2\2"+
		"\2$%\3\2\2\2%\3\3\2\2\2&\'\7\23\2\2\'(\7$\2\2()\5\b\5\2)\5\3\2\2\2*/\5"+
		"\4\3\2+,\7)\2\2,.\5\4\3\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\62*\3\2\2\2\62\63\3\2\2\2\63\7\3\2\2\2\64\65"+
		"\b\5\1\2\65;\7\25\2\2\66\67\7\24\2\2\67;\5\n\6\28;\7\21\2\29;\7\22\2\2"+
		":\64\3\2\2\2:\66\3\2\2\2:8\3\2\2\2:9\3\2\2\2;A\3\2\2\2<=\6\5\2\3=>\7\66"+
		"\2\2>@\5\b\5\2?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\t\3\2\2\2CA\3"+
		"\2\2\2DI\5\b\5\2EF\7)\2\2FH\5\b\5\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2LD\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NO\7\63\2\2"+
		"OP\5\2\2\2PQ\7\64\2\2QS\3\2\2\2RN\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\'\2"+
		"\2UV\5\6\4\2VW\7(\2\2WX\7$\2\2XY\5\b\5\2Y\r\3\2\2\2Z[\b\b\1\2[\\\t\2\2"+
		"\2\\]\5\16\b\2]^\b\b\1\2^~\3\2\2\2_`\7\23\2\2`~\b\b\1\2ab\t\3\2\2bc\7"+
		"\63\2\2cd\5\20\t\2de\7\64\2\2ef\7\'\2\2fg\5\20\t\2gh\7(\2\2hi\b\b\1\2"+
		"i~\3\2\2\2jk\t\3\2\2kl\7\'\2\2lm\5\20\t\2mn\7(\2\2no\b\b\1\2o~\3\2\2\2"+
		"pq\7\"\2\2qr\5\20\t\2rs\7#\2\2st\b\b\1\2t~\3\2\2\2uv\7\b\2\2v~\b\b\1\2"+
		"wx\7\t\2\2x~\b\b\1\2yz\7\26\2\2z~\b\b\1\2{|\7\3\2\2|~\b\b\1\2}Z\3\2\2"+
		"\2}_\3\2\2\2}a\3\2\2\2}j\3\2\2\2}p\3\2\2\2}u\3\2\2\2}w\3\2\2\2}y\3\2\2"+
		"\2}{\3\2\2\2~\u00cb\3\2\2\2\177\u0080\6\b\3\3\u0080\u0081\7\60\2\2\u0081"+
		"\u0082\5\16\b\2\u0082\u0083\b\b\1\2\u0083\u00ca\3\2\2\2\u0084\u0085\6"+
		"\b\4\3\u0085\u0086\t\4\2\2\u0086\u0087\5\16\b\2\u0087\u0088\b\b\1\2\u0088"+
		"\u00ca\3\2\2\2\u0089\u008a\6\b\5\3\u008a\u008b\t\5\2\2\u008b\u008c\5\16"+
		"\b\2\u008c\u008d\b\b\1\2\u008d\u00ca\3\2\2\2\u008e\u0095\6\b\6\3\u008f"+
		"\u0096\7\63\2\2\u0090\u0091\7\63\2\2\u0091\u0096\7&\2\2\u0092\u0096\7"+
		"\64\2\2\u0093\u0094\7\64\2\2\u0094\u0096\7&\2\2\u0095\u008f\3\2\2\2\u0095"+
		"\u0090\3\2\2\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u0098\5\16\b\2\u0098\u0099\b\b\1\2\u0099\u00ca\3\2\2\2\u009a"+
		"\u009f\6\b\7\3\u009b\u009c\7&\2\2\u009c\u00a0\7&\2\2\u009d\u009e\7\65"+
		"\2\2\u009e\u00a0\7&\2\2\u009f\u009b\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\5\16\b\2\u00a2\u00a3\b\b\1\2\u00a3\u00ca\3"+
		"\2\2\2\u00a4\u00a5\6\b\b\3\u00a5\u00a6\7\66\2\2\u00a6\u00a7\5\16\b\2\u00a7"+
		"\u00a8\b\b\1\2\u00a8\u00ca\3\2\2\2\u00a9\u00aa\6\b\t\3\u00aa\u00ab\7\67"+
		"\2\2\u00ab\u00ac\5\16\b\2\u00ac\u00ad\b\b\1\2\u00ad\u00ca\3\2\2\2\u00ae"+
		"\u00af\6\b\n\3\u00af\u00b0\t\6\2\2\u00b0\u00b1\5\16\b\2\u00b1\u00b2\b"+
		"\b\1\2\u00b2\u00ca\3\2\2\2\u00b3\u00b4\6\b\13\3\u00b4\u00b5\7!\2\2\u00b5"+
		"\u00b6\7\23\2\2\u00b6\u00b7\7\63\2\2\u00b7\u00b8\5\20\t\2\u00b8\u00b9"+
		"\7\64\2\2\u00b9\u00ba\7\'\2\2\u00ba\u00bb\5\20\t\2\u00bb\u00bc\7(\2\2"+
		"\u00bc\u00bd\b\b\1\2\u00bd\u00ca\3\2\2\2\u00be\u00bf\6\b\f\3\u00bf\u00c0"+
		"\7!\2\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\7\'\2\2\u00c2\u00c3\5\20\t\2"+
		"\u00c3\u00c4\7(\2\2\u00c4\u00c5\b\b\1\2\u00c5\u00ca\3\2\2\2\u00c6\u00c7"+
		"\6\b\r\3\u00c7\u00c8\t\7\2\2\u00c8\u00ca\b\b\1\2\u00c9\177\3\2\2\2\u00c9"+
		"\u0084\3\2\2\2\u00c9\u0089\3\2\2\2\u00c9\u008e\3\2\2\2\u00c9\u009a\3\2"+
		"\2\2\u00c9\u00a4\3\2\2\2\u00c9\u00a9\3\2\2\2\u00c9\u00ae\3\2\2\2\u00c9"+
		"\u00b3\3\2\2\2\u00c9\u00be\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\17\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00da\b\t\1\2\u00cf\u00d0\5\16\b\2\u00d0\u00d7\b\t\1\2"+
		"\u00d1\u00d2\7)\2\2\u00d2\u00d3\5\16\b\2\u00d3\u00d4\b\t\1\2\u00d4\u00d6"+
		"\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00cf\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\21\3\2\2\2\u00dc\u00dd\7\17\2\2\u00dd\u00de"+
		"\7\23\2\2\u00de\u00e0\5\f\7\2\u00df\u00e1\5\24\13\2\u00e0\u00df\3\2\2"+
		"\2\u00e0\u00e1\3\2\2\2\u00e1\23\3\2\2\2\u00e2\u00e6\7+\2\2\u00e3\u00e5"+
		"\5\24\13\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u0109"+
		"\7,\2\2\u00ea\u00eb\7\24\2\2\u00eb\u00ec\7%\2\2\u00ec\u00ed\5\16\b\2\u00ed"+
		"\u00ee\7*\2\2\u00ee\u0109\3\2\2\2\u00ef\u00f0\7\6\2\2\u00f0\u00f1\7\'"+
		"\2\2\u00f1\u00f2\5\16\b\2\u00f2\u00f3\7(\2\2\u00f3\u00f6\5\24\13\2\u00f4"+
		"\u00f5\7\7\2\2\u00f5\u00f7\5\24\13\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3"+
		"\2\2\2\u00f7\u0109\3\2\2\2\u00f8\u00f9\7\5\2\2\u00f9\u00fa\7\'\2\2\u00fa"+
		"\u00fb\5\16\b\2\u00fb\u00fc\7(\2\2\u00fc\u00fd\5\24\13\2\u00fd\u0109\3"+
		"\2\2\2\u00fe\u00ff\7\n\2\2\u00ff\u0100\7\'\2\2\u0100\u0101\7\23\2\2\u0101"+
		"\u0102\7\13\2\2\u0102\u0103\5\16\b\2\u0103\u0104\7(\2\2\u0104\u0105\5"+
		"\24\13\2\u0105\u0109\3\2\2\2\u0106\u0107\t\b\2\2\u0107\u0109\5\16\b\2"+
		"\u0108\u00e2\3\2\2\2\u0108\u00ea\3\2\2\2\u0108\u00ef\3\2\2\2\u0108\u00f8"+
		"\3\2\2\2\u0108\u00fe\3\2\2\2\u0108\u0106\3\2\2\2\u0109\25\3\2\2\2\u010a"+
		"\u010b\7\f\2\2\u010b\u010c\t\3\2\2\u010c\u010d\7\63\2\2\u010d\u010e\5"+
		"\2\2\2\u010e\u0111\7\64\2\2\u010f\u0110\7\20\2\2\u0110\u0112\5\b\5\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0117\7+"+
		"\2\2\u0114\u0116\5\22\n\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u011a\u011b\7,\2\2\u011b\27\3\2\2\2\u011c\u011d\7\r\2\2\u011d\u0122"+
		"\t\3\2\2\u011e\u011f\7\63\2\2\u011f\u0120\5\2\2\2\u0120\u0121\7\64\2\2"+
		"\u0121\u0123\3\2\2\2\u0122\u011e\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u0125\7\'\2\2\u0125\u0126\5\6\4\2\u0126\u0129\7(\2\2\u0127"+
		"\u0128\7\20\2\2\u0128\u012a\5\b\5\2\u0129\u0127\3\2\2\2\u0129\u012a\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u012f\7+\2\2\u012c\u012e\5\24\13\2\u012d"+
		"\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130\u013c\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7\16\2\2\u0133"+
		"\u0137\7\'\2\2\u0134\u0136\5\16\b\2\u0135\u0134\3\2\2\2\u0136\u0139\3"+
		"\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013b\7(\2\2\u013b\u013d\7*\2\2\u013c\u0132\3\2\2"+
		"\2\u013c\u013d\3\2\2\2\u013d\u0141\3\2\2\2\u013e\u0140\5\22\n\2\u013f"+
		"\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\7,\2\2\u0145"+
		"\31\3\2\2\2\u0146\u015c\5\24\13\2\u0147\u0149\5\24\13\2\u0148\u0147\3"+
		"\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\5\32\16\2\u014d\u015c\3\2\2\2\u014e\u0150\5"+
		"\22\n\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\5\32\16\2\u0154\u015c\3"+
		"\2\2\2\u0155\u0156\5\26\f\2\u0156\u0157\5\32\16\2\u0157\u015c\3\2\2\2"+
		"\u0158\u0159\5\30\r\2\u0159\u015a\5\32\16\2\u015a\u015c\3\2\2\2\u015b"+
		"\u0146\3\2\2\2\u015b\u0148\3\2\2\2\u015b\u014f\3\2\2\2\u015b\u0155\3\2"+
		"\2\2\u015b\u0158\3\2\2\2\u015c\33\3\2\2\2!!$/\62:AILR}\u0095\u009f\u00c9"+
		"\u00cb\u00d7\u00da\u00e0\u00e6\u00f6\u0108\u0111\u0117\u0122\u0129\u012f"+
		"\u0137\u013c\u0141\u014a\u0151\u015b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
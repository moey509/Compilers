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
		FOR=8, LDOTDOT=26, DOTL=24, LPAREN=37, TYPE=18, IF=4, LBRACKET=32, RPAREN=38, 
		SLASH=44, IN=9, COMMA=39, EQUAL=36, RETURN=2, NOTHING=16, PIPE=53, GET=35, 
		PLUS=47, TYPEPARAM=19, SUPER=12, GEQ=28, RANGLE=50, RBRACKET=33, COMMENT=56, 
		DOT=31, LDOT=23, EQEQ=29, INTEGER=20, PLPL=46, RBRACE=42, PERCENT=45, 
		DASH=48, ELSE=5, AMPERSAND=52, BANG=51, SEMICOLON=40, TRUE=6, COLON=34, 
		WS=54, NEQ=30, THROUGH=21, INTERFACE=10, VARFUN=17, FUN=13, FALSE=7, EXTENDS=14, 
		NESTEDCOMMENT=55, STRING=1, LEQ=27;
	public static final String[] tokenNames = {
		"<INVALID>", "STRING", "'return'", "'while'", "'if'", "'else'", "'true'", 
		"'false'", "'for'", "'in'", "'interface'", "'class'", "'super'", "'fun'", 
		"'extends'", "'Thing'", "'Nothing'", "VARFUN", "TYPE", "TYPEPARAM", "INTEGER", 
		"'..'", "'...'", "'<.'", "'.<'", "'<<'", "'<..'", "'<='", "'>='", "'=='", 
		"'!='", "'.'", "'['", "']'", "':'", "':='", "'='", "'('", "')'", "','", 
		"';'", "'{'", "'}'", "'*'", "'/'", "'%'", "'++'", "'+'", "'-'", "'<'", 
		"'>'", "'!'", "'&'", "'|'", "WS", "NESTEDCOMMENT", "COMMENT"
	};
	public static final int
		RULE_file = 0;
	public static final String[] ruleNames = {
		"file"
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
	public static class FileContext extends ParserRuleContext {
		public TerminalNode NEQ(int i) {
			return getToken(CubexParser.NEQ, i);
		}
		public List<TerminalNode> GET() { return getTokens(CubexParser.GET); }
		public TerminalNode RANGLE(int i) {
			return getToken(CubexParser.RANGLE, i);
		}
		public TerminalNode SEMICOLON(int i) {
			return getToken(CubexParser.SEMICOLON, i);
		}
		public TerminalNode PERCENT(int i) {
			return getToken(CubexParser.PERCENT, i);
		}
		public TerminalNode AMPERSAND(int i) {
			return getToken(CubexParser.AMPERSAND, i);
		}
		public TerminalNode DASH(int i) {
			return getToken(CubexParser.DASH, i);
		}
		public TerminalNode TYPE(int i) {
			return getToken(CubexParser.TYPE, i);
		}
		public TerminalNode LBRACKET(int i) {
			return getToken(CubexParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(CubexParser.RBRACKET); }
		public TerminalNode GET(int i) {
			return getToken(CubexParser.GET, i);
		}
		public TerminalNode FUN(int i) {
			return getToken(CubexParser.FUN, i);
		}
		public TerminalNode LEQ(int i) {
			return getToken(CubexParser.LEQ, i);
		}
		public List<TerminalNode> ONW() { return getTokens(CubexParser.ONW); }
		public TerminalNode PLPL(int i) {
			return getToken(CubexParser.PLPL, i);
		}
		public List<TerminalNode> PIPE() { return getTokens(CubexParser.PIPE); }
		public TerminalNode THROUGH(int i) {
			return getToken(CubexParser.THROUGH, i);
		}
		public TerminalNode FOR(int i) {
			return getToken(CubexParser.FOR, i);
		}
		public List<TerminalNode> DASH() { return getTokens(CubexParser.DASH); }
		public TerminalNode INTERFACE(int i) {
			return getToken(CubexParser.INTERFACE, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(CubexParser.EQUAL); }
		public List<TerminalNode> DOT() { return getTokens(CubexParser.DOT); }
		public List<TerminalNode> ELSE() { return getTokens(CubexParser.ELSE); }
		public List<TerminalNode> THROUGH() { return getTokens(CubexParser.THROUGH); }
		public List<TerminalNode> INTERFACE() { return getTokens(CubexParser.INTERFACE); }
		public List<TerminalNode> COLON() { return getTokens(CubexParser.COLON); }
		public TerminalNode RBRACE(int i) {
			return getToken(CubexParser.RBRACE, i);
		}
		public List<TerminalNode> TRUE() { return getTokens(CubexParser.TRUE); }
		public TerminalNode IF(int i) {
			return getToken(CubexParser.IF, i);
		}
		public TerminalNode LDOT(int i) {
			return getToken(CubexParser.LDOT, i);
		}
		public List<TerminalNode> PLPL() { return getTokens(CubexParser.PLPL); }
		public List<TerminalNode> LDOT() { return getTokens(CubexParser.LDOT); }
		public List<TerminalNode> CLASS() { return getTokens(CubexParser.CLASS); }
		public List<TerminalNode> IN() { return getTokens(CubexParser.IN); }
		public TerminalNode SLASH(int i) {
			return getToken(CubexParser.SLASH, i);
		}
		public List<TerminalNode> RETURN() { return getTokens(CubexParser.RETURN); }
		public TerminalNode COLON(int i) {
			return getToken(CubexParser.COLON, i);
		}
		public TerminalNode FALSE(int i) {
			return getToken(CubexParser.FALSE, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CubexParser.PLUS); }
		public TerminalNode LL(int i) {
			return getToken(CubexParser.LL, i);
		}
		public TerminalNode LBRACE(int i) {
			return getToken(CubexParser.LBRACE, i);
		}
		public List<TerminalNode> GEQ() { return getTokens(CubexParser.GEQ); }
		public List<TerminalNode> SUPER() { return getTokens(CubexParser.SUPER); }
		public TerminalNode VARFUN(int i) {
			return getToken(CubexParser.VARFUN, i);
		}
		public List<TerminalNode> BANG() { return getTokens(CubexParser.BANG); }
		public TerminalNode COMMA(int i) {
			return getToken(CubexParser.COMMA, i);
		}
		public List<TerminalNode> RANGLE() { return getTokens(CubexParser.RANGLE); }
		public List<TerminalNode> NEQ() { return getTokens(CubexParser.NEQ); }
		public TerminalNode LPAREN(int i) {
			return getToken(CubexParser.LPAREN, i);
		}
		public TerminalNode GEQ(int i) {
			return getToken(CubexParser.GEQ, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CubexParser.COMMA); }
		public List<TerminalNode> STRING() { return getTokens(CubexParser.STRING); }
		public List<TerminalNode> SLASH() { return getTokens(CubexParser.SLASH); }
		public List<TerminalNode> FALSE() { return getTokens(CubexParser.FALSE); }
		public TerminalNode ELSE(int i) {
			return getToken(CubexParser.ELSE, i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(CubexParser.LBRACE); }
		public TerminalNode STRING(int i) {
			return getToken(CubexParser.STRING, i);
		}
		public List<TerminalNode> FUN() { return getTokens(CubexParser.FUN); }
		public TerminalNode TRUE(int i) {
			return getToken(CubexParser.TRUE, i);
		}
		public List<TerminalNode> AMPERSAND() { return getTokens(CubexParser.AMPERSAND); }
		public List<TerminalNode> IF() { return getTokens(CubexParser.IF); }
		public TerminalNode IN(int i) {
			return getToken(CubexParser.IN, i);
		}
		public TerminalNode EQUAL(int i) {
			return getToken(CubexParser.EQUAL, i);
		}
		public TerminalNode SUPER(int i) {
			return getToken(CubexParser.SUPER, i);
		}
		public TerminalNode EQEQ(int i) {
			return getToken(CubexParser.EQEQ, i);
		}
		public TerminalNode BANG(int i) {
			return getToken(CubexParser.BANG, i);
		}
		public TerminalNode LDOTDOT(int i) {
			return getToken(CubexParser.LDOTDOT, i);
		}
		public TerminalNode STAR(int i) {
			return getToken(CubexParser.STAR, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CubexParser.TYPE); }
		public TerminalNode RPAREN(int i) {
			return getToken(CubexParser.RPAREN, i);
		}
		public TerminalNode PIPE(int i) {
			return getToken(CubexParser.PIPE, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(CubexParser.LPAREN); }
		public TerminalNode DOT(int i) {
			return getToken(CubexParser.DOT, i);
		}
		public List<TerminalNode> VARFUN() { return getTokens(CubexParser.VARFUN); }
		public TerminalNode PLUS(int i) {
			return getToken(CubexParser.PLUS, i);
		}
		public TerminalNode INTEGER(int i) {
			return getToken(CubexParser.INTEGER, i);
		}
		public List<TerminalNode> LL() { return getTokens(CubexParser.LL); }
		public List<TerminalNode> DOTL() { return getTokens(CubexParser.DOTL); }
		public TerminalNode RETURN(int i) {
			return getToken(CubexParser.RETURN, i);
		}
		public TerminalNode ONW(int i) {
			return getToken(CubexParser.ONW, i);
		}
		public TerminalNode WHILE(int i) {
			return getToken(CubexParser.WHILE, i);
		}
		public List<TerminalNode> STAR() { return getTokens(CubexParser.STAR); }
		public List<TerminalNode> LANGLE() { return getTokens(CubexParser.LANGLE); }
		public List<TerminalNode> WHILE() { return getTokens(CubexParser.WHILE); }
		public TerminalNode DOTL(int i) {
			return getToken(CubexParser.DOTL, i);
		}
		public TerminalNode RBRACKET(int i) {
			return getToken(CubexParser.RBRACKET, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CubexParser.SEMICOLON); }
		public List<TerminalNode> EQEQ() { return getTokens(CubexParser.EQEQ); }
		public TerminalNode CLASS(int i) {
			return getToken(CubexParser.CLASS, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(CubexParser.PERCENT); }
		public TerminalNode LANGLE(int i) {
			return getToken(CubexParser.LANGLE, i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(CubexParser.LBRACKET); }
		public List<TerminalNode> RBRACE() { return getTokens(CubexParser.RBRACE); }
		public List<TerminalNode> LDOTDOT() { return getTokens(CubexParser.LDOTDOT); }
		public List<TerminalNode> FOR() { return getTokens(CubexParser.FOR); }
		public List<TerminalNode> RPAREN() { return getTokens(CubexParser.RPAREN); }
		public List<TerminalNode> LEQ() { return getTokens(CubexParser.LEQ); }
		public List<TerminalNode> INTEGER() { return getTokens(CubexParser.INTEGER); }
		public List<TerminalNode> EXTENDS() { return getTokens(CubexParser.EXTENDS); }
		public TerminalNode EXTENDS(int i) {
			return getToken(CubexParser.EXTENDS, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << ELSE) | (1L << TRUE) | (1L << FALSE) | (1L << FOR) | (1L << IN) | (1L << INTERFACE) | (1L << CLASS) | (1L << SUPER) | (1L << FUN) | (1L << EXTENDS) | (1L << VARFUN) | (1L << TYPE) | (1L << INTEGER) | (1L << THROUGH) | (1L << ONW) | (1L << LDOT) | (1L << DOTL) | (1L << LL) | (1L << LDOTDOT) | (1L << LEQ) | (1L << GEQ) | (1L << EQEQ) | (1L << NEQ) | (1L << DOT) | (1L << LBRACKET) | (1L << RBRACKET) | (1L << COLON) | (1L << GET) | (1L << EQUAL) | (1L << LPAREN) | (1L << RPAREN) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LBRACE) | (1L << RBRACE) | (1L << STAR) | (1L << SLASH) | (1L << PERCENT) | (1L << PLPL) | (1L << PLUS) | (1L << DASH) | (1L << LANGLE) | (1L << RANGLE) | (1L << BANG) | (1L << AMPERSAND) | (1L << PIPE))) != 0)) {
				{
				{
				setState(2);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << ELSE) | (1L << TRUE) | (1L << FALSE) | (1L << FOR) | (1L << IN) | (1L << INTERFACE) | (1L << CLASS) | (1L << SUPER) | (1L << FUN) | (1L << EXTENDS) | (1L << VARFUN) | (1L << TYPE) | (1L << INTEGER) | (1L << THROUGH) | (1L << ONW) | (1L << LDOT) | (1L << DOTL) | (1L << LL) | (1L << LDOTDOT) | (1L << LEQ) | (1L << GEQ) | (1L << EQEQ) | (1L << NEQ) | (1L << DOT) | (1L << LBRACKET) | (1L << RBRACKET) | (1L << COLON) | (1L << GET) | (1L << EQUAL) | (1L << LPAREN) | (1L << RPAREN) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LBRACE) | (1L << RBRACE) | (1L << STAR) | (1L << SLASH) | (1L << PERCENT) | (1L << PLPL) | (1L << PLUS) | (1L << DASH) | (1L << LANGLE) | (1L << RANGLE) | (1L << BANG) | (1L << AMPERSAND) | (1L << PIPE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(7);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3:\13\4\2\t\2\3\2\7"+
		"\2\6\n\2\f\2\16\2\t\13\2\3\2\2\3\2\2\3\5\2\3\20\23\24\26\67\n\2\7\3\2"+
		"\2\2\4\6\t\2\2\2\5\4\3\2\2\2\6\t\3\2\2\2\7\5\3\2\2\2\7\b\3\2\2\2\b\3\3"+
		"\2\2\2\t\7\3\2\2\2\3\7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
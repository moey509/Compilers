// Generated from CubexLexer.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CubexLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, RETURN=2, WHILE=3, IF=4, ELSE=5, TRUE=6, FALSE=7, FOR=8, IN=9, 
		INTERFACE=10, CLASS=11, SUPER=12, FUN=13, EXTENDS=14, THING=15, NOTHING=16, 
		VARFUN=17, TYPE=18, TYPEPARAM=19, INTEGER=20, THROUGH=21, ONW=22, LDOT=23, 
		DOTL=24, LL=25, LDOTDOT=26, LEQ=27, GEQ=28, EQEQ=29, NEQ=30, DOT=31, LBRACKET=32, 
		RBRACKET=33, COLON=34, GET=35, EQUAL=36, LPAREN=37, RPAREN=38, COMMA=39, 
		SEMICOLON=40, LBRACE=41, RBRACE=42, STAR=43, SLASH=44, PERCENT=45, PLPL=46, 
		PLUS=47, DASH=48, LANGLE=49, RANGLE=50, BANG=51, AMPERSAND=52, PIPE=53, 
		WS=54, NESTEDCOMMENT=55, COMMENT=56;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"STRING", "'return'", "'while'", "'if'", "'else'", "'true'", "'false'", 
		"'for'", "'in'", "'interface'", "'class'", "'super'", "'fun'", "'extends'", 
		"'Thing'", "'Nothing'", "VARFUN", "TYPE", "TYPEPARAM", "INTEGER", "'..'", 
		"'...'", "'<.'", "'.<'", "'<<'", "'<..'", "'<='", "'>='", "'=='", "'!='", 
		"'.'", "'['", "']'", "':'", "':='", "'='", "'('", "')'", "','", "';'", 
		"'{'", "'}'", "'*'", "'/'", "'%'", "'++'", "'+'", "'-'", "'<'", "'>'", 
		"'!'", "'&'", "'|'", "WS", "NESTEDCOMMENT", "COMMENT"
	};
	public static final String[] ruleNames = {
		"STRING", "RETURN", "WHILE", "IF", "ELSE", "TRUE", "FALSE", "FOR", "IN", 
		"INTERFACE", "CLASS", "SUPER", "FUN", "EXTENDS", "THING", "NOTHING", "VARFUN", 
		"TYPE", "TYPEPARAM", "INTEGER", "THROUGH", "ONW", "LDOT", "DOTL", "LL", 
		"LDOTDOT", "LEQ", "GEQ", "EQEQ", "NEQ", "DOT", "LBRACKET", "RBRACKET", 
		"COLON", "GET", "EQUAL", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", "LBRACE", 
		"RBRACE", "STAR", "SLASH", "PERCENT", "PLPL", "PLUS", "DASH", "LANGLE", 
		"RANGLE", "BANG", "AMPERSAND", "PIPE", "WS", "NESTEDCOMMENT", "COMMENT"
	};


	public CubexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CubexLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 53: WS_action((RuleContext)_localctx, actionIndex); break;

		case 54: NESTEDCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 55: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void NESTEDCOMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2:\u0160\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\7\2v\n\2\f\2\16"+
		"\2y\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22\u00d6"+
		"\n\22\f\22\16\22\u00d9\13\22\3\23\3\23\6\23\u00dd\n\23\r\23\16\23\u00de"+
		"\3\24\3\24\3\25\6\25\u00e4\n\25\r\25\16\25\u00e5\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		" \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63"+
		"\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\6\67\u0139\n\67\r\67\16\67\u013a"+
		"\3\67\3\67\38\38\78\u0141\n8\f8\168\u0144\138\38\38\78\u0148\n8\f8\16"+
		"8\u014b\138\78\u014d\n8\f8\168\u0150\138\38\38\38\38\39\39\79\u0158\n"+
		"9\f9\169\u015b\139\39\39\39\39\6w\u0142\u0149\u0159:\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1"+
		"K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65"+
		"\1i\66\1k\67\1m8\2o9\3q:\4\3\2\n\4\2\13\f\17\17\3\2c|\6\2\62;C\\aac|\3"+
		"\2C\\\3\2\62;\5\2\13\f\17\17\"\"\3\2bb\4\2\f\f\17\17\u0168\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2q\3\2\2\2\3s\3\2\2\2\5|\3\2\2\2\7\u0083\3\2\2\2\t\u0089\3\2\2\2\13\u008c"+
		"\3\2\2\2\r\u0091\3\2\2\2\17\u0096\3\2\2\2\21\u009c\3\2\2\2\23\u00a0\3"+
		"\2\2\2\25\u00a3\3\2\2\2\27\u00ad\3\2\2\2\31\u00b3\3\2\2\2\33\u00b9\3\2"+
		"\2\2\35\u00bd\3\2\2\2\37\u00c5\3\2\2\2!\u00cb\3\2\2\2#\u00d3\3\2\2\2%"+
		"\u00da\3\2\2\2\'\u00e0\3\2\2\2)\u00e3\3\2\2\2+\u00e7\3\2\2\2-\u00ea\3"+
		"\2\2\2/\u00ee\3\2\2\2\61\u00f1\3\2\2\2\63\u00f4\3\2\2\2\65\u00f7\3\2\2"+
		"\2\67\u00fb\3\2\2\29\u00fe\3\2\2\2;\u0101\3\2\2\2=\u0104\3\2\2\2?\u0107"+
		"\3\2\2\2A\u0109\3\2\2\2C\u010b\3\2\2\2E\u010d\3\2\2\2G\u010f\3\2\2\2I"+
		"\u0112\3\2\2\2K\u0114\3\2\2\2M\u0116\3\2\2\2O\u0118\3\2\2\2Q\u011a\3\2"+
		"\2\2S\u011c\3\2\2\2U\u011e\3\2\2\2W\u0120\3\2\2\2Y\u0122\3\2\2\2[\u0124"+
		"\3\2\2\2]\u0126\3\2\2\2_\u0129\3\2\2\2a\u012b\3\2\2\2c\u012d\3\2\2\2e"+
		"\u012f\3\2\2\2g\u0131\3\2\2\2i\u0133\3\2\2\2k\u0135\3\2\2\2m\u0138\3\2"+
		"\2\2o\u013e\3\2\2\2q\u0155\3\2\2\2sw\7$\2\2tv\n\2\2\2ut\3\2\2\2vy\3\2"+
		"\2\2wx\3\2\2\2wu\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7$\2\2{\4\3\2\2\2|}\7t"+
		"\2\2}~\7g\2\2~\177\7v\2\2\177\u0080\7w\2\2\u0080\u0081\7t\2\2\u0081\u0082"+
		"\7p\2\2\u0082\6\3\2\2\2\u0083\u0084\7y\2\2\u0084\u0085\7j\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088\b\3\2\2\2\u0089\u008a"+
		"\7k\2\2\u008a\u008b\7h\2\2\u008b\n\3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e"+
		"\7n\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\f\3\2\2\2\u0091\u0092"+
		"\7v\2\2\u0092\u0093\7t\2\2\u0093\u0094\7w\2\2\u0094\u0095\7g\2\2\u0095"+
		"\16\3\2\2\2\u0096\u0097\7h\2\2\u0097\u0098\7c\2\2\u0098\u0099\7n\2\2\u0099"+
		"\u009a\7u\2\2\u009a\u009b\7g\2\2\u009b\20\3\2\2\2\u009c\u009d\7h\2\2\u009d"+
		"\u009e\7q\2\2\u009e\u009f\7t\2\2\u009f\22\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1"+
		"\u00a2\7p\2\2\u00a2\24\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a5"+
		"\u00a6\7v\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7h\2\2"+
		"\u00a9\u00aa\7c\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7g\2\2\u00ac\26\3\2"+
		"\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1"+
		"\7u\2\2\u00b1\u00b2\7u\2\2\u00b2\30\3\2\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5"+
		"\7w\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7t\2\2\u00b8"+
		"\32\3\2\2\2\u00b9\u00ba\7h\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7p\2\2\u00bc"+
		"\34\3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7z\2\2\u00bf\u00c0\7v\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7u\2\2"+
		"\u00c4\36\3\2\2\2\u00c5\u00c6\7V\2\2\u00c6\u00c7\7j\2\2\u00c7\u00c8\7"+
		"k\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7i\2\2\u00ca \3\2\2\2\u00cb\u00cc"+
		"\7P\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7j\2\2\u00cf"+
		"\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7i\2\2\u00d2\"\3\2\2\2\u00d3"+
		"\u00d7\t\3\2\2\u00d4\u00d6\t\4\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8$\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00da\u00dc\t\5\2\2\u00db\u00dd\t\4\2\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df&\3\2\2\2"+
		"\u00e0\u00e1\t\5\2\2\u00e1(\3\2\2\2\u00e2\u00e4\t\6\2\2\u00e3\u00e2\3"+
		"\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"*\3\2\2\2\u00e7\u00e8\7\60\2\2\u00e8\u00e9\7\60\2\2\u00e9,\3\2\2\2\u00ea"+
		"\u00eb\7\60\2\2\u00eb\u00ec\7\60\2\2\u00ec\u00ed\7\60\2\2\u00ed.\3\2\2"+
		"\2\u00ee\u00ef\7>\2\2\u00ef\u00f0\7\60\2\2\u00f0\60\3\2\2\2\u00f1\u00f2"+
		"\7\60\2\2\u00f2\u00f3\7>\2\2\u00f3\62\3\2\2\2\u00f4\u00f5\7>\2\2\u00f5"+
		"\u00f6\7>\2\2\u00f6\64\3\2\2\2\u00f7\u00f8\7>\2\2\u00f8\u00f9\7\60\2\2"+
		"\u00f9\u00fa\7\60\2\2\u00fa\66\3\2\2\2\u00fb\u00fc\7>\2\2\u00fc\u00fd"+
		"\7?\2\2\u00fd8\3\2\2\2\u00fe\u00ff\7@\2\2\u00ff\u0100\7?\2\2\u0100:\3"+
		"\2\2\2\u0101\u0102\7?\2\2\u0102\u0103\7?\2\2\u0103<\3\2\2\2\u0104\u0105"+
		"\7#\2\2\u0105\u0106\7?\2\2\u0106>\3\2\2\2\u0107\u0108\7\60\2\2\u0108@"+
		"\3\2\2\2\u0109\u010a\7]\2\2\u010aB\3\2\2\2\u010b\u010c\7_\2\2\u010cD\3"+
		"\2\2\2\u010d\u010e\7<\2\2\u010eF\3\2\2\2\u010f\u0110\7<\2\2\u0110\u0111"+
		"\7?\2\2\u0111H\3\2\2\2\u0112\u0113\7?\2\2\u0113J\3\2\2\2\u0114\u0115\7"+
		"*\2\2\u0115L\3\2\2\2\u0116\u0117\7+\2\2\u0117N\3\2\2\2\u0118\u0119\7."+
		"\2\2\u0119P\3\2\2\2\u011a\u011b\7=\2\2\u011bR\3\2\2\2\u011c\u011d\7}\2"+
		"\2\u011dT\3\2\2\2\u011e\u011f\7\177\2\2\u011fV\3\2\2\2\u0120\u0121\7,"+
		"\2\2\u0121X\3\2\2\2\u0122\u0123\7\61\2\2\u0123Z\3\2\2\2\u0124\u0125\7"+
		"\'\2\2\u0125\\\3\2\2\2\u0126\u0127\7-\2\2\u0127\u0128\7-\2\2\u0128^\3"+
		"\2\2\2\u0129\u012a\7-\2\2\u012a`\3\2\2\2\u012b\u012c\7/\2\2\u012cb\3\2"+
		"\2\2\u012d\u012e\7>\2\2\u012ed\3\2\2\2\u012f\u0130\7@\2\2\u0130f\3\2\2"+
		"\2\u0131\u0132\7#\2\2\u0132h\3\2\2\2\u0133\u0134\7(\2\2\u0134j\3\2\2\2"+
		"\u0135\u0136\7~\2\2\u0136l\3\2\2\2\u0137\u0139\t\7\2\2\u0138\u0137\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\b\67\2\2\u013dn\3\2\2\2\u013e\u0142\7b\2\2"+
		"\u013f\u0141\n\b\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u014e\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0149\5o8\2\u0146\u0148\n\b\2\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2"+
		"\2\u0149\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014c\u0145\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7)"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b8\3\2\u0154p\3\2\2\2\u0155\u0159"+
		"\7%\2\2\u0156\u0158\13\2\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015c\u015d\t\t\2\2\u015d\u015e\3\2\2\2\u015e\u015f\b9\4\2\u015f"+
		"r\3\2\2\2\f\2w\u00d7\u00de\u00e5\u013a\u0142\u0149\u014e\u0159";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
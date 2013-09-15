package src;

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
		STRING=1, RETURN=2, WHILE=3, IF=4, ELSE=5, TRUE=6, FALSE=7, FOR=8, INTERFACE=9, 
		CLASS=10, SUPER=11, FUN=12, EXTENDS=13, THING=14, NOTHING=15, VARFUN=16, 
		TYPE=17, TYPEPARAM=18, INTEGER=19, THROUGH=20, ONW=21, LDOT=22, DOTL=23, 
		LL=24, LDOTDOT=25, LEQ=26, GEQ=27, EQEQ=28, NEQ=29, DOT=30, LBRACKET=31, 
		RBRACKET=32, COLON=33, GET=34, EQUAL=35, LPAREN=36, RPAREN=37, COMMA=38, 
		SEMICOLON=39, LBRACE=40, RBRACE=41, STAR=42, SLASH=43, PERCENT=44, PLPL=45, 
		PLUS=46, DASH=47, LANGLE=48, RANGLE=49, BANG=50, AMPERSAND=51, PIPE=52, 
		WS=53, NESTEDCOMMENT=54, COMMENT=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"STRING", "'return'", "'while'", "'if'", "'else'", "'true'", "'false'", 
		"'for'", "'interface'", "'class'", "'super'", "'fun'", "'extends'", "'Thing'", 
		"'Nothing'", "VARFUN", "TYPE", "TYPEPARAM", "INTEGER", "'..'", "'...'", 
		"'<.'", "'.<'", "'<<'", "'<..'", "'<='", "'>='", "'=='", "'!='", "'.'", 
		"'['", "']'", "':'", "':='", "'='", "'('", "')'", "','", "';'", "'{'", 
		"'}'", "'*'", "'/'", "'%'", "'++'", "'+'", "'-'", "'<'", "'>'", "'!'", 
		"'&'", "'|'", "WS", "NESTEDCOMMENT", "COMMENT"
	};
	public static final String[] ruleNames = {
		"STRING", "RETURN", "WHILE", "IF", "ELSE", "TRUE", "FALSE", "FOR", "INTERFACE", 
		"CLASS", "SUPER", "FUN", "EXTENDS", "THING", "NOTHING", "VARFUN", "TYPE", 
		"TYPEPARAM", "INTEGER", "THROUGH", "ONW", "LDOT", "DOTL", "LL", "LDOTDOT", 
		"LEQ", "GEQ", "EQEQ", "NEQ", "DOT", "LBRACKET", "RBRACKET", "COLON", "GET", 
		"EQUAL", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", "LBRACE", "RBRACE", 
		"STAR", "SLASH", "PERCENT", "PLPL", "PLUS", "DASH", "LANGLE", "RANGLE", 
		"BANG", "AMPERSAND", "PIPE", "WS", "NESTEDCOMMENT", "COMMENT"
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
		case 52: WS_action((RuleContext)_localctx, actionIndex); break;

		case 53: NESTEDCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 54: COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\29\u015b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\7\2t\n\2\f\2\16\2w\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u00d1\n\21\f\21\16\21\u00d4\13"+
		"\21\3\22\3\22\6\22\u00d8\n\22\r\22\16\22\u00d9\3\23\3\23\3\24\6\24\u00df"+
		"\n\24\r\24\16\24\u00e0\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64"+
		"\3\65\3\65\3\66\6\66\u0134\n\66\r\66\16\66\u0135\3\66\3\66\3\67\3\67\7"+
		"\67\u013c\n\67\f\67\16\67\u013f\13\67\3\67\3\67\7\67\u0143\n\67\f\67\16"+
		"\67\u0146\13\67\7\67\u0148\n\67\f\67\16\67\u014b\13\67\3\67\3\67\3\67"+
		"\3\67\38\38\78\u0153\n8\f8\168\u0156\138\38\38\38\38\6u\u013d\u0144\u0154"+
		"9\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\1g\65\1i\66\1k\67\2m8\3o9\4\3\2\n\4\2\13\f\17\17\3\2c|\6"+
		"\2\62;C\\aac|\3\2C\\\3\2\62;\5\2\13\f\17\17\"\"\3\2bb\4\2\f\f\17\17\u0163"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\3q\3\2\2\2\5z\3\2\2\2\7\u0081\3\2\2\2\t\u0087\3\2\2\2\13"+
		"\u008a\3\2\2\2\r\u008f\3\2\2\2\17\u0094\3\2\2\2\21\u009a\3\2\2\2\23\u009e"+
		"\3\2\2\2\25\u00a8\3\2\2\2\27\u00ae\3\2\2\2\31\u00b4\3\2\2\2\33\u00b8\3"+
		"\2\2\2\35\u00c0\3\2\2\2\37\u00c6\3\2\2\2!\u00ce\3\2\2\2#\u00d5\3\2\2\2"+
		"%\u00db\3\2\2\2\'\u00de\3\2\2\2)\u00e2\3\2\2\2+\u00e5\3\2\2\2-\u00e9\3"+
		"\2\2\2/\u00ec\3\2\2\2\61\u00ef\3\2\2\2\63\u00f2\3\2\2\2\65\u00f6\3\2\2"+
		"\2\67\u00f9\3\2\2\29\u00fc\3\2\2\2;\u00ff\3\2\2\2=\u0102\3\2\2\2?\u0104"+
		"\3\2\2\2A\u0106\3\2\2\2C\u0108\3\2\2\2E\u010a\3\2\2\2G\u010d\3\2\2\2I"+
		"\u010f\3\2\2\2K\u0111\3\2\2\2M\u0113\3\2\2\2O\u0115\3\2\2\2Q\u0117\3\2"+
		"\2\2S\u0119\3\2\2\2U\u011b\3\2\2\2W\u011d\3\2\2\2Y\u011f\3\2\2\2[\u0121"+
		"\3\2\2\2]\u0124\3\2\2\2_\u0126\3\2\2\2a\u0128\3\2\2\2c\u012a\3\2\2\2e"+
		"\u012c\3\2\2\2g\u012e\3\2\2\2i\u0130\3\2\2\2k\u0133\3\2\2\2m\u0139\3\2"+
		"\2\2o\u0150\3\2\2\2qu\7$\2\2rt\n\2\2\2sr\3\2\2\2tw\3\2\2\2uv\3\2\2\2u"+
		"s\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7$\2\2y\4\3\2\2\2z{\7t\2\2{|\7g\2\2|}"+
		"\7v\2\2}~\7w\2\2~\177\7t\2\2\177\u0080\7p\2\2\u0080\6\3\2\2\2\u0081\u0082"+
		"\7y\2\2\u0082\u0083\7j\2\2\u0083\u0084\7k\2\2\u0084\u0085\7n\2\2\u0085"+
		"\u0086\7g\2\2\u0086\b\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7h\2\2\u0089"+
		"\n\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c\7n\2\2\u008c\u008d\7u\2\2\u008d"+
		"\u008e\7g\2\2\u008e\f\3\2\2\2\u008f\u0090\7v\2\2\u0090\u0091\7t\2\2\u0091"+
		"\u0092\7w\2\2\u0092\u0093\7g\2\2\u0093\16\3\2\2\2\u0094\u0095\7h\2\2\u0095"+
		"\u0096\7c\2\2\u0096\u0097\7n\2\2\u0097\u0098\7u\2\2\u0098\u0099\7g\2\2"+
		"\u0099\20\3\2\2\2\u009a\u009b\7h\2\2\u009b\u009c\7q\2\2\u009c\u009d\7"+
		"t\2\2\u009d\22\3\2\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1"+
		"\7v\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7h\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7g\2\2\u00a7\24\3\2\2\2\u00a8"+
		"\u00a9\7e\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7u\2\2"+
		"\u00ac\u00ad\7u\2\2\u00ad\26\3\2\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7"+
		"w\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7t\2\2\u00b3\30"+
		"\3\2\2\2\u00b4\u00b5\7h\2\2\u00b5\u00b6\7w\2\2\u00b6\u00b7\7p\2\2\u00b7"+
		"\32\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7z\2\2\u00ba\u00bb\7v\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7f\2\2\u00be\u00bf\7u\2\2"+
		"\u00bf\34\3\2\2\2\u00c0\u00c1\7V\2\2\u00c1\u00c2\7j\2\2\u00c2\u00c3\7"+
		"k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7i\2\2\u00c5\36\3\2\2\2\u00c6\u00c7"+
		"\7P\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca\7j\2\2\u00ca"+
		"\u00cb\7k\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7i\2\2\u00cd \3\2\2\2\u00ce"+
		"\u00d2\t\3\2\2\u00cf\u00d1\t\4\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\"\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d5\u00d7\t\5\2\2\u00d6\u00d8\t\4\2\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da$\3\2\2\2"+
		"\u00db\u00dc\t\5\2\2\u00dc&\3\2\2\2\u00dd\u00df\t\6\2\2\u00de\u00dd\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"(\3\2\2\2\u00e2\u00e3\7\60\2\2\u00e3\u00e4\7\60\2\2\u00e4*\3\2\2\2\u00e5"+
		"\u00e6\7\60\2\2\u00e6\u00e7\7\60\2\2\u00e7\u00e8\7\60\2\2\u00e8,\3\2\2"+
		"\2\u00e9\u00ea\7>\2\2\u00ea\u00eb\7\60\2\2\u00eb.\3\2\2\2\u00ec\u00ed"+
		"\7\60\2\2\u00ed\u00ee\7>\2\2\u00ee\60\3\2\2\2\u00ef\u00f0\7>\2\2\u00f0"+
		"\u00f1\7>\2\2\u00f1\62\3\2\2\2\u00f2\u00f3\7>\2\2\u00f3\u00f4\7\60\2\2"+
		"\u00f4\u00f5\7\60\2\2\u00f5\64\3\2\2\2\u00f6\u00f7\7>\2\2\u00f7\u00f8"+
		"\7?\2\2\u00f8\66\3\2\2\2\u00f9\u00fa\7@\2\2\u00fa\u00fb\7?\2\2\u00fb8"+
		"\3\2\2\2\u00fc\u00fd\7?\2\2\u00fd\u00fe\7?\2\2\u00fe:\3\2\2\2\u00ff\u0100"+
		"\7#\2\2\u0100\u0101\7?\2\2\u0101<\3\2\2\2\u0102\u0103\7\60\2\2\u0103>"+
		"\3\2\2\2\u0104\u0105\7]\2\2\u0105@\3\2\2\2\u0106\u0107\7_\2\2\u0107B\3"+
		"\2\2\2\u0108\u0109\7<\2\2\u0109D\3\2\2\2\u010a\u010b\7<\2\2\u010b\u010c"+
		"\7?\2\2\u010cF\3\2\2\2\u010d\u010e\7?\2\2\u010eH\3\2\2\2\u010f\u0110\7"+
		"*\2\2\u0110J\3\2\2\2\u0111\u0112\7+\2\2\u0112L\3\2\2\2\u0113\u0114\7."+
		"\2\2\u0114N\3\2\2\2\u0115\u0116\7=\2\2\u0116P\3\2\2\2\u0117\u0118\7}\2"+
		"\2\u0118R\3\2\2\2\u0119\u011a\7\177\2\2\u011aT\3\2\2\2\u011b\u011c\7,"+
		"\2\2\u011cV\3\2\2\2\u011d\u011e\7\61\2\2\u011eX\3\2\2\2\u011f\u0120\7"+
		"\'\2\2\u0120Z\3\2\2\2\u0121\u0122\7-\2\2\u0122\u0123\7-\2\2\u0123\\\3"+
		"\2\2\2\u0124\u0125\7-\2\2\u0125^\3\2\2\2\u0126\u0127\7/\2\2\u0127`\3\2"+
		"\2\2\u0128\u0129\7>\2\2\u0129b\3\2\2\2\u012a\u012b\7@\2\2\u012bd\3\2\2"+
		"\2\u012c\u012d\7#\2\2\u012df\3\2\2\2\u012e\u012f\7(\2\2\u012fh\3\2\2\2"+
		"\u0130\u0131\7~\2\2\u0131j\3\2\2\2\u0132\u0134\t\7\2\2\u0133\u0132\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u0138\b\66\2\2\u0138l\3\2\2\2\u0139\u013d\7b\2\2"+
		"\u013a\u013c\n\b\2\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0149\3\2\2\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0144\5m\67\2\u0141\u0143\n\b\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2"+
		"\2\2\u0144\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0148\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u0140\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c"+
		"\u014d\7)\2\2\u014d\u014e\3\2\2\2\u014e\u014f\b\67\3\2\u014fn\3\2\2\2"+
		"\u0150\u0154\7%\2\2\u0151\u0153\13\2\2\2\u0152\u0151\3\2\2\2\u0153\u0156"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0157\u0158\t\t\2\2\u0158\u0159\3\2\2\2\u0159\u015a\b8"+
		"\4\2\u015ap\3\2\2\2\f\2u\u00d2\u00d9\u00e0\u0135\u013d\u0144\u0149\u0154";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
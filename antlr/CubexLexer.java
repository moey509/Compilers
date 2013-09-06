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
		CLASS=10, SUPER=11, FUN=12, EXTENDS=13, ID=14, INTEGER=15, THROUGH=16, 
		TOINF=17, LDOT=18, DOTL=19, LL=20, LDOTDOT=21, LEQ=22, GREQ=23, EQEQ=24, 
		NEQ=25, DOT=26, LBRACKET=27, RBRACKET=28, COLON=29, GET=30, EQUAL=31, 
		LPAREN=32, RPAREN=33, COMMA=34, SEMICOLON=35, LBRACE=36, RBRACE=37, STAR=38, 
		SLASH=39, PERCENT=40, PLUS=41, DASH=42, LANGLE=43, RANGLE=44, BANG=45, 
		AMPERSAND=46, PIPE=47, WS=48, NESTEDCOMMENT=49, COMMENT=50;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"STRING", "'return'", "'while'", "'if'", "'else'", "'true'", "'false'", 
		"'for'", "'interface'", "'class'", "'super'", "'fun'", "'extends'", "ID", 
		"INTEGER", "'..'", "'...'", "'<.'", "'.<'", "'<<'", "'<..'", "'<='", "'>='", 
		"'=='", "'!='", "'.'", "'['", "']'", "':'", "':='", "'='", "'('", "')'", 
		"','", "';'", "'{'", "'}'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", 
		"'>'", "'!'", "'&'", "'|'", "WS", "NESTEDCOMMENT", "COMMENT"
	};
	public static final String[] ruleNames = {
		"STRING", "RETURN", "WHILE", "IF", "ELSE", "TRUE", "FALSE", "FOR", "INTERFACE", 
		"CLASS", "SUPER", "FUN", "EXTENDS", "ID", "INTEGER", "THROUGH", "TOINF", 
		"LDOT", "DOTL", "LL", "LDOTDOT", "LEQ", "GREQ", "EQEQ", "NEQ", "DOT", 
		"LBRACKET", "RBRACKET", "COLON", "GET", "EQUAL", "LPAREN", "RPAREN", "COMMA", 
		"SEMICOLON", "LBRACE", "RBRACE", "STAR", "SLASH", "PERCENT", "PLUS", "DASH", 
		"LANGLE", "RANGLE", "BANG", "AMPERSAND", "PIPE", "WS", "NESTEDCOMMENT", 
		"COMMENT"
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
		case 47: WS_action((RuleContext)_localctx, actionIndex); break;

		case 48: NESTEDCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 49: COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\64\u0135\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\7\2j\n\2\f\2\16\2m\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\7\17\u00b9"+
		"\n\17\f\17\16\17\u00bc\13\17\3\20\6\20\u00bf\n\20\r\20\16\20\u00c0\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\6\61\u0111\n\61\r\61\16"+
		"\61\u0112\3\61\3\61\3\62\3\62\7\62\u0119\n\62\f\62\16\62\u011c\13\62\3"+
		"\62\5\62\u011f\n\62\3\62\7\62\u0122\n\62\f\62\16\62\u0125\13\62\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\7\63\u012d\n\63\f\63\16\63\u0130\13\63\3\63\3"+
		"\63\3\63\3\63\6k\u011a\u0123\u012e\64\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21"+
		"\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65"+
		"\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*"+
		"\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\2c\63\3e\64\4\3\2\7\4\2C\\c|\7"+
		"\2))\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u013c\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5p\3\2\2\2\7w\3\2\2\2\t}\3\2\2\2\13\u0080"+
		"\3\2\2\2\r\u0085\3\2\2\2\17\u008a\3\2\2\2\21\u0090\3\2\2\2\23\u0094\3"+
		"\2\2\2\25\u009e\3\2\2\2\27\u00a4\3\2\2\2\31\u00aa\3\2\2\2\33\u00ae\3\2"+
		"\2\2\35\u00b6\3\2\2\2\37\u00be\3\2\2\2!\u00c2\3\2\2\2#\u00c5\3\2\2\2%"+
		"\u00c9\3\2\2\2\'\u00cc\3\2\2\2)\u00cf\3\2\2\2+\u00d2\3\2\2\2-\u00d6\3"+
		"\2\2\2/\u00d9\3\2\2\2\61\u00dc\3\2\2\2\63\u00df\3\2\2\2\65\u00e2\3\2\2"+
		"\2\67\u00e4\3\2\2\29\u00e6\3\2\2\2;\u00e8\3\2\2\2=\u00ea\3\2\2\2?\u00ed"+
		"\3\2\2\2A\u00ef\3\2\2\2C\u00f1\3\2\2\2E\u00f3\3\2\2\2G\u00f5\3\2\2\2I"+
		"\u00f7\3\2\2\2K\u00f9\3\2\2\2M\u00fb\3\2\2\2O\u00fd\3\2\2\2Q\u00ff\3\2"+
		"\2\2S\u0101\3\2\2\2U\u0103\3\2\2\2W\u0105\3\2\2\2Y\u0107\3\2\2\2[\u0109"+
		"\3\2\2\2]\u010b\3\2\2\2_\u010d\3\2\2\2a\u0110\3\2\2\2c\u0116\3\2\2\2e"+
		"\u012a\3\2\2\2gk\7$\2\2hj\13\2\2\2ih\3\2\2\2jm\3\2\2\2kl\3\2\2\2ki\3\2"+
		"\2\2ln\3\2\2\2mk\3\2\2\2no\7$\2\2o\4\3\2\2\2pq\7t\2\2qr\7g\2\2rs\7v\2"+
		"\2st\7w\2\2tu\7t\2\2uv\7p\2\2v\6\3\2\2\2wx\7y\2\2xy\7j\2\2yz\7k\2\2z{"+
		"\7n\2\2{|\7g\2\2|\b\3\2\2\2}~\7k\2\2~\177\7h\2\2\177\n\3\2\2\2\u0080\u0081"+
		"\7g\2\2\u0081\u0082\7n\2\2\u0082\u0083\7u\2\2\u0083\u0084\7g\2\2\u0084"+
		"\f\3\2\2\2\u0085\u0086\7v\2\2\u0086\u0087\7t\2\2\u0087\u0088\7w\2\2\u0088"+
		"\u0089\7g\2\2\u0089\16\3\2\2\2\u008a\u008b\7h\2\2\u008b\u008c\7c\2\2\u008c"+
		"\u008d\7n\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f\20\3\2\2\2\u0090"+
		"\u0091\7h\2\2\u0091\u0092\7q\2\2\u0092\u0093\7t\2\2\u0093\22\3\2\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\u0098\7g\2\2"+
		"\u0098\u0099\7t\2\2\u0099\u009a\7h\2\2\u009a\u009b\7c\2\2\u009b\u009c"+
		"\7e\2\2\u009c\u009d\7g\2\2\u009d\24\3\2\2\2\u009e\u009f\7e\2\2\u009f\u00a0"+
		"\7n\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"\26\3\2\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7r\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\u00a9\7t\2\2\u00a9\30\3\2\2\2\u00aa\u00ab\7h\2\2\u00ab"+
		"\u00ac\7w\2\2\u00ac\u00ad\7p\2\2\u00ad\32\3\2\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7z\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7p\2\2"+
		"\u00b3\u00b4\7f\2\2\u00b4\u00b5\7u\2\2\u00b5\34\3\2\2\2\u00b6\u00ba\t"+
		"\2\2\2\u00b7\u00b9\t\3\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\36\3\2\2\2\u00bc\u00ba\3\2\2"+
		"\2\u00bd\u00bf\t\4\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1 \3\2\2\2\u00c2\u00c3\7\60\2\2\u00c3"+
		"\u00c4\7\60\2\2\u00c4\"\3\2\2\2\u00c5\u00c6\7\60\2\2\u00c6\u00c7\7\60"+
		"\2\2\u00c7\u00c8\7\60\2\2\u00c8$\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb"+
		"\7\60\2\2\u00cb&\3\2\2\2\u00cc\u00cd\7\60\2\2\u00cd\u00ce\7>\2\2\u00ce"+
		"(\3\2\2\2\u00cf\u00d0\7>\2\2\u00d0\u00d1\7>\2\2\u00d1*\3\2\2\2\u00d2\u00d3"+
		"\7>\2\2\u00d3\u00d4\7\60\2\2\u00d4\u00d5\7\60\2\2\u00d5,\3\2\2\2\u00d6"+
		"\u00d7\7>\2\2\u00d7\u00d8\7?\2\2\u00d8.\3\2\2\2\u00d9\u00da\7@\2\2\u00da"+
		"\u00db\7?\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7?\2\2\u00dd\u00de\7?\2\2\u00de"+
		"\62\3\2\2\2\u00df\u00e0\7#\2\2\u00e0\u00e1\7?\2\2\u00e1\64\3\2\2\2\u00e2"+
		"\u00e3\7\60\2\2\u00e3\66\3\2\2\2\u00e4\u00e5\7]\2\2\u00e58\3\2\2\2\u00e6"+
		"\u00e7\7_\2\2\u00e7:\3\2\2\2\u00e8\u00e9\7<\2\2\u00e9<\3\2\2\2\u00ea\u00eb"+
		"\7<\2\2\u00eb\u00ec\7?\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7?\2\2\u00ee@\3"+
		"\2\2\2\u00ef\u00f0\7*\2\2\u00f0B\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2D\3\2"+
		"\2\2\u00f3\u00f4\7.\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7=\2\2\u00f6H\3\2\2"+
		"\2\u00f7\u00f8\7}\2\2\u00f8J\3\2\2\2\u00f9\u00fa\7\177\2\2\u00faL\3\2"+
		"\2\2\u00fb\u00fc\7,\2\2\u00fcN\3\2\2\2\u00fd\u00fe\7\61\2\2\u00feP\3\2"+
		"\2\2\u00ff\u0100\7\'\2\2\u0100R\3\2\2\2\u0101\u0102\7-\2\2\u0102T\3\2"+
		"\2\2\u0103\u0104\7/\2\2\u0104V\3\2\2\2\u0105\u0106\7>\2\2\u0106X\3\2\2"+
		"\2\u0107\u0108\7@\2\2\u0108Z\3\2\2\2\u0109\u010a\7#\2\2\u010a\\\3\2\2"+
		"\2\u010b\u010c\7(\2\2\u010c^\3\2\2\2\u010d\u010e\7~\2\2\u010e`\3\2\2\2"+
		"\u010f\u0111\t\5\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b\61\2\2"+
		"\u0115b\3\2\2\2\u0116\u011a\7b\2\2\u0117\u0119\13\2\2\2\u0118\u0117\3"+
		"\2\2\2\u0119\u011c\3\2\2\2\u011a\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011f\5c\62\2\u011e\u011d\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0123\3\2\2\2\u0120\u0122\13\2\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7)\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\b\62\3\2\u0129d\3\2\2\2\u012a\u012e\7%\2\2"+
		"\u012b\u012d\13\2\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0132\t\6\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b\63\4\2\u0134f\3\2\2\2"+
		"\13\2k\u00ba\u00c0\u0112\u011a\u011e\u0123\u012e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
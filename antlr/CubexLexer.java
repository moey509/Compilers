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
		CLASS=10, SUPER=11, FUN=12, EXTENDS=13, VARFUNID=14, TYPEID=15, INTEGER=16, 
		THROUGH=17, ONW=18, LDOT=19, DOTL=20, LL=21, LDOTDOT=22, LEQ=23, GEQ=24, 
		EQEQ=25, NEQ=26, DOT=27, LBRACKET=28, RBRACKET=29, COLON=30, GET=31, EQUAL=32, 
		LPAREN=33, RPAREN=34, COMMA=35, SEMICOLON=36, LBRACE=37, RBRACE=38, STAR=39, 
		SLASH=40, PERCENT=41, PLPL=42, PLUS=43, DASH=44, LANGLE=45, RANGLE=46, 
		BANG=47, AMPERSAND=48, PIPE=49, WS=50, NESTEDCOMMENT=51, COMMENT=52;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"STRING", "'return'", "'while'", "'if'", "'else'", "'true'", "'false'", 
		"'for'", "'interface'", "'class'", "'super'", "'fun'", "'extends'", "VARFUNID", 
		"TYPEID", "INTEGER", "'..'", "'...'", "'<.'", "'.<'", "'<<'", "'<..'", 
		"'<='", "'>='", "'=='", "'!='", "'.'", "'['", "']'", "':'", "':='", "'='", 
		"'('", "')'", "','", "';'", "'{'", "'}'", "'*'", "'/'", "'%'", "'++'", 
		"'+'", "'-'", "'<'", "'>'", "'!'", "'&'", "'|'", "WS", "NESTEDCOMMENT", 
		"COMMENT"
	};
	public static final String[] ruleNames = {
		"STRING", "RETURN", "WHILE", "IF", "ELSE", "TRUE", "FALSE", "FOR", "INTERFACE", 
		"CLASS", "SUPER", "FUN", "EXTENDS", "VARFUNID", "TYPEID", "INTEGER", "THROUGH", 
		"ONW", "LDOT", "DOTL", "LL", "LDOTDOT", "LEQ", "GEQ", "EQEQ", "NEQ", "DOT", 
		"LBRACKET", "RBRACKET", "COLON", "GET", "EQUAL", "LPAREN", "RPAREN", "COMMA", 
		"SEMICOLON", "LBRACE", "RBRACE", "STAR", "SLASH", "PERCENT", "PLPL", "PLUS", 
		"DASH", "LANGLE", "RANGLE", "BANG", "AMPERSAND", "PIPE", "WS", "NESTEDCOMMENT", 
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
		case 49: WS_action((RuleContext)_localctx, actionIndex); break;

		case 50: NESTEDCOMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 51: COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\66\u0146\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\7\2n\n\2\f\2\16\2q\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\7\17\u00bd\n\17\f\17\16\17\u00c0\13\17\3\20\3\20\7\20\u00c4"+
		"\n\20\f\20\16\20\u00c7\13\20\3\21\6\21\u00ca\n\21\r\21\16\21\u00cb\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\6\63\u011f\n"+
		"\63\r\63\16\63\u0120\3\63\3\63\3\64\3\64\7\64\u0127\n\64\f\64\16\64\u012a"+
		"\13\64\3\64\3\64\7\64\u012e\n\64\f\64\16\64\u0131\13\64\7\64\u0133\n\64"+
		"\f\64\16\64\u0136\13\64\3\64\3\64\3\64\3\64\3\65\3\65\7\65\u013e\n\65"+
		"\f\65\16\65\u0141\13\65\3\65\3\65\3\65\3\65\6o\u0128\u012f\u013f\66\3"+
		"\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r"+
		"\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\2g\65\3i\66\4\3\2\b\3\2c|\6\2\62;C\\aac|\3\2C\\\3\2\62;\5"+
		"\2\13\f\17\17\"\"\4\2\f\f\17\17\u014e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5t\3\2\2\2\7{\3\2\2\2\t\u0081\3\2\2\2\13"+
		"\u0084\3\2\2\2\r\u0089\3\2\2\2\17\u008e\3\2\2\2\21\u0094\3\2\2\2\23\u0098"+
		"\3\2\2\2\25\u00a2\3\2\2\2\27\u00a8\3\2\2\2\31\u00ae\3\2\2\2\33\u00b2\3"+
		"\2\2\2\35\u00ba\3\2\2\2\37\u00c1\3\2\2\2!\u00c9\3\2\2\2#\u00cd\3\2\2\2"+
		"%\u00d0\3\2\2\2\'\u00d4\3\2\2\2)\u00d7\3\2\2\2+\u00da\3\2\2\2-\u00dd\3"+
		"\2\2\2/\u00e1\3\2\2\2\61\u00e4\3\2\2\2\63\u00e7\3\2\2\2\65\u00ea\3\2\2"+
		"\2\67\u00ed\3\2\2\29\u00ef\3\2\2\2;\u00f1\3\2\2\2=\u00f3\3\2\2\2?\u00f5"+
		"\3\2\2\2A\u00f8\3\2\2\2C\u00fa\3\2\2\2E\u00fc\3\2\2\2G\u00fe\3\2\2\2I"+
		"\u0100\3\2\2\2K\u0102\3\2\2\2M\u0104\3\2\2\2O\u0106\3\2\2\2Q\u0108\3\2"+
		"\2\2S\u010a\3\2\2\2U\u010c\3\2\2\2W\u010f\3\2\2\2Y\u0111\3\2\2\2[\u0113"+
		"\3\2\2\2]\u0115\3\2\2\2_\u0117\3\2\2\2a\u0119\3\2\2\2c\u011b\3\2\2\2e"+
		"\u011e\3\2\2\2g\u0124\3\2\2\2i\u013b\3\2\2\2ko\7$\2\2ln\13\2\2\2ml\3\2"+
		"\2\2nq\3\2\2\2op\3\2\2\2om\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7$\2\2s\4\3\2"+
		"\2\2tu\7t\2\2uv\7g\2\2vw\7v\2\2wx\7w\2\2xy\7t\2\2yz\7p\2\2z\6\3\2\2\2"+
		"{|\7y\2\2|}\7j\2\2}~\7k\2\2~\177\7n\2\2\177\u0080\7g\2\2\u0080\b\3\2\2"+
		"\2\u0081\u0082\7k\2\2\u0082\u0083\7h\2\2\u0083\n\3\2\2\2\u0084\u0085\7"+
		"g\2\2\u0085\u0086\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088\f"+
		"\3\2\2\2\u0089\u008a\7v\2\2\u008a\u008b\7t\2\2\u008b\u008c\7w\2\2\u008c"+
		"\u008d\7g\2\2\u008d\16\3\2\2\2\u008e\u008f\7h\2\2\u008f\u0090\7c\2\2\u0090"+
		"\u0091\7n\2\2\u0091\u0092\7u\2\2\u0092\u0093\7g\2\2\u0093\20\3\2\2\2\u0094"+
		"\u0095\7h\2\2\u0095\u0096\7q\2\2\u0096\u0097\7t\2\2\u0097\22\3\2\2\2\u0098"+
		"\u0099\7k\2\2\u0099\u009a\7p\2\2\u009a\u009b\7v\2\2\u009b\u009c\7g\2\2"+
		"\u009c\u009d\7t\2\2\u009d\u009e\7h\2\2\u009e\u009f\7c\2\2\u009f\u00a0"+
		"\7e\2\2\u00a0\u00a1\7g\2\2\u00a1\24\3\2\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4"+
		"\7n\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\26\3\2\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7r\2\2\u00ab"+
		"\u00ac\7g\2\2\u00ac\u00ad\7t\2\2\u00ad\30\3\2\2\2\u00ae\u00af\7h\2\2\u00af"+
		"\u00b0\7w\2\2\u00b0\u00b1\7p\2\2\u00b1\32\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\u00b4\7z\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7p\2\2"+
		"\u00b7\u00b8\7f\2\2\u00b8\u00b9\7u\2\2\u00b9\34\3\2\2\2\u00ba\u00be\t"+
		"\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\36\3\2\2\2\u00c0\u00be\3\2\2"+
		"\2\u00c1\u00c5\t\4\2\2\u00c2\u00c4\t\3\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6 \3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ca\t\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\"\3\2\2\2\u00cd\u00ce"+
		"\7\60\2\2\u00ce\u00cf\7\60\2\2\u00cf$\3\2\2\2\u00d0\u00d1\7\60\2\2\u00d1"+
		"\u00d2\7\60\2\2\u00d2\u00d3\7\60\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7>\2\2"+
		"\u00d5\u00d6\7\60\2\2\u00d6(\3\2\2\2\u00d7\u00d8\7\60\2\2\u00d8\u00d9"+
		"\7>\2\2\u00d9*\3\2\2\2\u00da\u00db\7>\2\2\u00db\u00dc\7>\2\2\u00dc,\3"+
		"\2\2\2\u00dd\u00de\7>\2\2\u00de\u00df\7\60\2\2\u00df\u00e0\7\60\2\2\u00e0"+
		".\3\2\2\2\u00e1\u00e2\7>\2\2\u00e2\u00e3\7?\2\2\u00e3\60\3\2\2\2\u00e4"+
		"\u00e5\7@\2\2\u00e5\u00e6\7?\2\2\u00e6\62\3\2\2\2\u00e7\u00e8\7?\2\2\u00e8"+
		"\u00e9\7?\2\2\u00e9\64\3\2\2\2\u00ea\u00eb\7#\2\2\u00eb\u00ec\7?\2\2\u00ec"+
		"\66\3\2\2\2\u00ed\u00ee\7\60\2\2\u00ee8\3\2\2\2\u00ef\u00f0\7]\2\2\u00f0"+
		":\3\2\2\2\u00f1\u00f2\7_\2\2\u00f2<\3\2\2\2\u00f3\u00f4\7<\2\2\u00f4>"+
		"\3\2\2\2\u00f5\u00f6\7<\2\2\u00f6\u00f7\7?\2\2\u00f7@\3\2\2\2\u00f8\u00f9"+
		"\7?\2\2\u00f9B\3\2\2\2\u00fa\u00fb\7*\2\2\u00fbD\3\2\2\2\u00fc\u00fd\7"+
		"+\2\2\u00fdF\3\2\2\2\u00fe\u00ff\7.\2\2\u00ffH\3\2\2\2\u0100\u0101\7="+
		"\2\2\u0101J\3\2\2\2\u0102\u0103\7}\2\2\u0103L\3\2\2\2\u0104\u0105\7\177"+
		"\2\2\u0105N\3\2\2\2\u0106\u0107\7,\2\2\u0107P\3\2\2\2\u0108\u0109\7\61"+
		"\2\2\u0109R\3\2\2\2\u010a\u010b\7\'\2\2\u010bT\3\2\2\2\u010c\u010d\7-"+
		"\2\2\u010d\u010e\7-\2\2\u010eV\3\2\2\2\u010f\u0110\7-\2\2\u0110X\3\2\2"+
		"\2\u0111\u0112\7/\2\2\u0112Z\3\2\2\2\u0113\u0114\7>\2\2\u0114\\\3\2\2"+
		"\2\u0115\u0116\7@\2\2\u0116^\3\2\2\2\u0117\u0118\7#\2\2\u0118`\3\2\2\2"+
		"\u0119\u011a\7(\2\2\u011ab\3\2\2\2\u011b\u011c\7~\2\2\u011cd\3\2\2\2\u011d"+
		"\u011f\t\6\2\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\b\63\2\2\u0123"+
		"f\3\2\2\2\u0124\u0128\7b\2\2\u0125\u0127\13\2\2\2\u0126\u0125\3\2\2\2"+
		"\u0127\u012a\3\2\2\2\u0128\u0129\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u0134"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012f\5g\64\2\u012c\u012e\13\2\2\2"+
		"\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0130\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u012b\3\2\2\2\u0133"+
		"\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0137\u0138\7)\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013a\b\64\3\2\u013ah\3\2\2\2\u013b\u013f\7%\2\2\u013c\u013e\13\2\2\2"+
		"\u013d\u013c\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u0140\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\t\7\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0145\b\65\4\2\u0145j\3\2\2\2\f\2o\u00be\u00c5\u00cb"+
		"\u0120\u0128\u012f\u0134\u013f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
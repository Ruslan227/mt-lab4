// Generated from Input.g4 by ANTLR 4.9.2
package antrl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EQ=1, END_COMMAND=2, CODE_OPEN=3, CODE_CLOSE=4, OPEN=5, CLOSE=6, TYPE=7, 
		ARGUMENT_DELIMITER=8, EPS=9, NEW_LINE=10, NON_TERMINAL_FIELD=11, VAR_NAME=12, 
		NON_TERMINAL=13, ARROW=14, UPPER_CASE_LETTERS=15, WS=16, TERMINAL=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"EQ", "END_COMMAND", "CODE_OPEN", "CODE_CLOSE", "OPEN", "CLOSE", "TYPE", 
			"ARGUMENT_DELIMITER", "EPS", "NEW_LINE", "NON_TERMINAL_FIELD", "INDEX", 
			"FIELD", "VAR_NAME", "NON_TERMINAL", "ARROW", "NUMBER", "UPPER_CASE_LETTERS", 
			"LOWER_CASE_LETTERS", "WS", "TERMINAL", "T"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'{'", "'}'", "'('", "')'", null, "','", "'eps'", 
			"'\n'", null, null, null, "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EQ", "END_COMMAND", "CODE_OPEN", "CODE_CLOSE", "OPEN", "CLOSE", 
			"TYPE", "ARGUMENT_DELIMITER", "EPS", "NEW_LINE", "NON_TERMINAL_FIELD", 
			"VAR_NAME", "NON_TERMINAL", "ARROW", "UPPER_CASE_LETTERS", "WS", "TERMINAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public InputLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\6\r[\n\r\r\r\16\r\\\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\7\17f\n\17\f\17\16\17i\13\17\3\20\3\20\7\20m\n\20\f\20\16\20p\13"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\23\6\23x\n\23\r\23\16\23y\3\24\6\24}\n"+
		"\24\r\24\16\24~\3\25\6\25\u0082\n\25\r\25\16\25\u0083\3\25\3\25\3\26\3"+
		"\26\6\26\u008a\n\26\r\26\16\26\u008b\3\26\3\26\3\27\3\27\2\2\30\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35\16\37\17!\20"+
		"#\2%\21\'\2)\22+\23-\2\3\2\7\3\2\62;\3\2C\\\3\2c|\5\2\13\13\17\17\"\""+
		"\3\2\u00b3\u00b3\2\u0094\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2%\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2"+
		"\2\13\67\3\2\2\2\r9\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25R\3"+
		"\2\2\2\27T\3\2\2\2\31X\3\2\2\2\33`\3\2\2\2\35c\3\2\2\2\37j\3\2\2\2!q\3"+
		"\2\2\2#t\3\2\2\2%w\3\2\2\2\'|\3\2\2\2)\u0081\3\2\2\2+\u0087\3\2\2\2-\u008f"+
		"\3\2\2\2/\60\7?\2\2\60\4\3\2\2\2\61\62\7=\2\2\62\6\3\2\2\2\63\64\7}\2"+
		"\2\64\b\3\2\2\2\65\66\7\177\2\2\66\n\3\2\2\2\678\7*\2\28\f\3\2\2\29:\7"+
		"+\2\2:\16\3\2\2\2;<\7k\2\2<=\7p\2\2=K\7v\2\2>?\7f\2\2?@\7q\2\2@A\7w\2"+
		"\2AB\7d\2\2BC\7n\2\2CK\7g\2\2DE\7U\2\2EF\7v\2\2FG\7t\2\2GH\7k\2\2HI\7"+
		"p\2\2IK\7i\2\2J;\3\2\2\2J>\3\2\2\2JD\3\2\2\2K\20\3\2\2\2LM\7.\2\2M\22"+
		"\3\2\2\2NO\7g\2\2OP\7r\2\2PQ\7u\2\2Q\24\3\2\2\2RS\7\f\2\2S\26\3\2\2\2"+
		"TU\5\37\20\2UV\5\31\r\2VW\5\33\16\2W\30\3\2\2\2XZ\7]\2\2Y[\5#\22\2ZY\3"+
		"\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7_\2\2_\32\3\2\2\2"+
		"`a\7\60\2\2ab\5\35\17\2b\34\3\2\2\2cg\5\'\24\2df\5#\22\2ed\3\2\2\2fi\3"+
		"\2\2\2ge\3\2\2\2gh\3\2\2\2h\36\3\2\2\2ig\3\2\2\2jn\5%\23\2km\5#\22\2l"+
		"k\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o \3\2\2\2pn\3\2\2\2qr\7/\2\2r"+
		"s\7@\2\2s\"\3\2\2\2tu\t\2\2\2u$\3\2\2\2vx\t\3\2\2wv\3\2\2\2xy\3\2\2\2"+
		"yw\3\2\2\2yz\3\2\2\2z&\3\2\2\2{}\t\4\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2"+
		"~\177\3\2\2\2\177(\3\2\2\2\u0080\u0082\t\5\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0086\b\25\2\2\u0086*\3\2\2\2\u0087\u0089\7\u00b3\2\2\u0088"+
		"\u008a\5-\27\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\u00b3\2\2\u008e"+
		",\3\2\2\2\u008f\u0090\n\6\2\2\u0090.\3\2\2\2\13\2J\\gny~\u0083\u008b\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
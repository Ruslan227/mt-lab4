package antrl;// Generated from /Users/ruslan/MY_GIT_HUB/REPA/sem-5/translationMethods/experiments/src/Input.g4 by ANTLR 4.9.2
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
		NON_TERMINAL=13, ARROW=14, DOUBLE=15, INT=16, STRING=17, OPERATION=18, 
		UPPER_CASE_LETTERS=19, WS=20, TERMINAL=21;
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
			"FIELD", "VAR_NAME", "NON_TERMINAL", "ARROW", "NUMBER", "DOUBLE", "INT", 
			"STRING", "OPERATION", "UPPER_CASE_LETTERS", "LOWER_CASE_LETTERS", "WS", 
			"TERMINAL", "T"
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
			"VAR_NAME", "NON_TERMINAL", "ARROW", "DOUBLE", "INT", "STRING", "OPERATION", 
			"UPPER_CASE_LETTERS", "WS", "TERMINAL"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00ad\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bS"+
		"\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\6\rc\n"+
		"\r\r\r\16\rd\3\r\3\r\3\16\3\16\3\16\3\17\3\17\7\17n\n\17\f\17\16\17q\13"+
		"\17\3\20\3\20\7\20u\n\20\f\20\16\20x\13\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\24\6\24\u0084\n\24\r\24\16\24\u0085\3\25\3\25\7\25"+
		"\u008a\n\25\f\25\16\25\u008d\13\25\3\25\3\25\3\26\3\26\3\27\6\27\u0094"+
		"\n\27\r\27\16\27\u0095\3\30\6\30\u0099\n\30\r\30\16\30\u009a\3\31\6\31"+
		"\u009e\n\31\r\31\16\31\u009f\3\31\3\31\3\32\3\32\6\32\u00a6\n\32\r\32"+
		"\16\32\u00a7\3\32\3\32\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\2\33\2\35\16\37\17!\20#\2%\21\'\22)\23+\24-\25"+
		"/\2\61\26\63\27\65\2\3\2\b\3\2\62;\6\2\'\',-//\61\61\3\2C\\\3\2c|\5\2"+
		"\13\13\17\17\"\"\3\2\u00b3\u00b3\2\u00b2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?"+
		"\3\2\2\2\rA\3\2\2\2\17R\3\2\2\2\21T\3\2\2\2\23V\3\2\2\2\25Z\3\2\2\2\27"+
		"\\\3\2\2\2\31`\3\2\2\2\33h\3\2\2\2\35k\3\2\2\2\37r\3\2\2\2!y\3\2\2\2#"+
		"|\3\2\2\2%~\3\2\2\2\'\u0083\3\2\2\2)\u0087\3\2\2\2+\u0090\3\2\2\2-\u0093"+
		"\3\2\2\2/\u0098\3\2\2\2\61\u009d\3\2\2\2\63\u00a3\3\2\2\2\65\u00ab\3\2"+
		"\2\2\678\7?\2\28\4\3\2\2\29:\7=\2\2:\6\3\2\2\2;<\7}\2\2<\b\3\2\2\2=>\7"+
		"\177\2\2>\n\3\2\2\2?@\7*\2\2@\f\3\2\2\2AB\7+\2\2B\16\3\2\2\2CD\7k\2\2"+
		"DE\7p\2\2ES\7v\2\2FG\7f\2\2GH\7q\2\2HI\7w\2\2IJ\7d\2\2JK\7n\2\2KS\7g\2"+
		"\2LM\7U\2\2MN\7v\2\2NO\7t\2\2OP\7k\2\2PQ\7p\2\2QS\7i\2\2RC\3\2\2\2RF\3"+
		"\2\2\2RL\3\2\2\2S\20\3\2\2\2TU\7.\2\2U\22\3\2\2\2VW\7g\2\2WX\7r\2\2XY"+
		"\7u\2\2Y\24\3\2\2\2Z[\7\f\2\2[\26\3\2\2\2\\]\5\37\20\2]^\5\31\r\2^_\5"+
		"\33\16\2_\30\3\2\2\2`b\7]\2\2ac\5#\22\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2"+
		"de\3\2\2\2ef\3\2\2\2fg\7_\2\2g\32\3\2\2\2hi\7\60\2\2ij\5\35\17\2j\34\3"+
		"\2\2\2ko\5/\30\2ln\5#\22\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\36"+
		"\3\2\2\2qo\3\2\2\2rv\5-\27\2su\5#\22\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2v"+
		"w\3\2\2\2w \3\2\2\2xv\3\2\2\2yz\7/\2\2z{\7@\2\2{\"\3\2\2\2|}\t\2\2\2}"+
		"$\3\2\2\2~\177\5\'\24\2\177\u0080\7\60\2\2\u0080\u0081\5\'\24\2\u0081"+
		"&\3\2\2\2\u0082\u0084\5#\22\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086(\3\2\2\2\u0087\u008b\7"+
		"$\2\2\u0088\u008a\5\65\33\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\7$\2\2\u008f*\3\2\2\2\u0090\u0091\t\3\2\2\u0091,\3\2"+
		"\2\2\u0092\u0094\t\4\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096.\3\2\2\2\u0097\u0099\t\5\2\2"+
		"\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\60\3\2\2\2\u009c\u009e\t\6\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a2\b\31\2\2\u00a2\62\3\2\2\2\u00a3\u00a5\7\u00b3\2\2\u00a4"+
		"\u00a6\5\65\33\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\u00b3\2\2"+
		"\u00aa\64\3\2\2\2\u00ab\u00ac\n\7\2\2\u00ac\66\3\2\2\2\r\2Rdov\u0085\u008b"+
		"\u0095\u009a\u009f\u00a7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
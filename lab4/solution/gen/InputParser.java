// Generated from Input.g4 by ANTLR 4.9.2
package antrl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EQ=1, END_COMMAND=2, CODE_OPEN=3, CODE_CLOSE=4, OPEN=5, CLOSE=6, TYPE=7, 
		ARGUMENT_DELIMITER=8, EPS=9, NEW_LINE=10, NON_TERMINAL_FIELD=11, VAR_NAME=12, 
		NON_TERMINAL=13, ARROW=14, UPPER_CASE_LETTERS=15, WS=16, TERMINAL=17;
	public static final int
		RULE_initStart = 0, RULE_constructors = 1, RULE_className = 2, RULE_arguments = 3, 
		RULE_argument = 4, RULE_rules = 5, RULE_targetRule = 6, RULE_rightPart = 7, 
		RULE_code = 8, RULE_pureCode = 9, RULE_command1 = 10, RULE_command2 = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"initStart", "constructors", "className", "arguments", "argument", "rules", 
			"targetRule", "rightPart", "code", "pureCode", "command1", "command2"
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

	@Override
	public String getGrammarFileName() { return "Input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InputParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InitStartContext extends ParserRuleContext {
		public ConstructorsContext constructors() {
			return getRuleContext(ConstructorsContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(InputParser.NEW_LINE, 0); }
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(InputParser.EOF, 0); }
		public InitStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterInitStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitInitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitInitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitStartContext initStart() throws RecognitionException {
		InitStartContext _localctx = new InitStartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_initStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			constructors();
			setState(25);
			match(NEW_LINE);
			setState(26);
			rules();
			setState(27);
			match(EOF);
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

	public static class ConstructorsContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(InputParser.NEW_LINE, 0); }
		public ConstructorsContext constructors() {
			return getRuleContext(ConstructorsContext.class,0);
		}
		public ConstructorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterConstructors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitConstructors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitConstructors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorsContext constructors() throws RecognitionException {
		ConstructorsContext _localctx = new ConstructorsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_constructors);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERMINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				className();
				setState(30);
				match(NEW_LINE);
				setState(31);
				constructors();
				}
				break;
			case NEW_LINE:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode NON_TERMINAL() { return getToken(InputParser.NON_TERMINAL, 0); }
		public TerminalNode OPEN() { return getToken(InputParser.OPEN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(InputParser.CLOSE, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(NON_TERMINAL);
			setState(37);
			match(OPEN);
			setState(38);
			arguments();
			setState(39);
			match(CLOSE);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode ARGUMENT_DELIMITER() { return getToken(InputParser.ARGUMENT_DELIMITER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arguments);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				argument();
				setState(43);
				match(ARGUMENT_DELIMITER);
				setState(44);
				arguments();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				argument();
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

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(InputParser.TYPE, 0); }
		public TerminalNode VAR_NAME() { return getToken(InputParser.VAR_NAME, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(TYPE);
			setState(50);
			match(VAR_NAME);
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

	public static class RulesContext extends ParserRuleContext {
		public TargetRuleContext targetRule() {
			return getRuleContext(TargetRuleContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(InputParser.NEW_LINE, 0); }
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rules);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERMINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				targetRule();
				setState(53);
				match(NEW_LINE);
				setState(54);
				rules();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class TargetRuleContext extends ParserRuleContext {
		public TerminalNode NON_TERMINAL() { return getToken(InputParser.NON_TERMINAL, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(InputParser.ARROW, 0); }
		public RightPartContext rightPart() {
			return getRuleContext(RightPartContext.class,0);
		}
		public TargetRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterTargetRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitTargetRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitTargetRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetRuleContext targetRule() throws RecognitionException {
		TargetRuleContext _localctx = new TargetRuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_targetRule);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(NON_TERMINAL);
				setState(60);
				code();
				setState(61);
				match(ARROW);
				setState(62);
				rightPart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(NON_TERMINAL);
				setState(65);
				match(ARROW);
				setState(66);
				rightPart();
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

	public static class RightPartContext extends ParserRuleContext {
		public TerminalNode NON_TERMINAL() { return getToken(InputParser.NON_TERMINAL, 0); }
		public RightPartContext rightPart() {
			return getRuleContext(RightPartContext.class,0);
		}
		public TerminalNode TERMINAL() { return getToken(InputParser.TERMINAL, 0); }
		public TerminalNode EPS() { return getToken(InputParser.EPS, 0); }
		public RightPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterRightPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitRightPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitRightPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightPartContext rightPart() throws RecognitionException {
		RightPartContext _localctx = new RightPartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rightPart);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(NON_TERMINAL);
				setState(70);
				rightPart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(TERMINAL);
				setState(72);
				rightPart();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(NON_TERMINAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(TERMINAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				match(EPS);
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

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode CODE_OPEN() { return getToken(InputParser.CODE_OPEN, 0); }
		public PureCodeContext pureCode() {
			return getRuleContext(PureCodeContext.class,0);
		}
		public TerminalNode CODE_CLOSE() { return getToken(InputParser.CODE_CLOSE, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(CODE_OPEN);
			setState(79);
			pureCode();
			setState(80);
			match(CODE_CLOSE);
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

	public static class PureCodeContext extends ParserRuleContext {
		public Command1Context command1() {
			return getRuleContext(Command1Context.class,0);
		}
		public PureCodeContext pureCode() {
			return getRuleContext(PureCodeContext.class,0);
		}
		public Command2Context command2() {
			return getRuleContext(Command2Context.class,0);
		}
		public PureCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterPureCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitPureCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitPureCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PureCodeContext pureCode() throws RecognitionException {
		PureCodeContext _localctx = new PureCodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pureCode);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				command1();
				setState(83);
				pureCode();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				command2();
				setState(86);
				pureCode();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				command1();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				command2();
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

	public static class Command1Context extends ParserRuleContext {
		public List<TerminalNode> VAR_NAME() { return getTokens(InputParser.VAR_NAME); }
		public TerminalNode VAR_NAME(int i) {
			return getToken(InputParser.VAR_NAME, i);
		}
		public TerminalNode EQ() { return getToken(InputParser.EQ, 0); }
		public TerminalNode END_COMMAND() { return getToken(InputParser.END_COMMAND, 0); }
		public TerminalNode NON_TERMINAL_FIELD() { return getToken(InputParser.NON_TERMINAL_FIELD, 0); }
		public Command1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterCommand1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitCommand1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitCommand1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Command1Context command1() throws RecognitionException {
		Command1Context _localctx = new Command1Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_command1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(VAR_NAME);
			setState(93);
			match(EQ);
			setState(94);
			_la = _input.LA(1);
			if ( !(_la==NON_TERMINAL_FIELD || _la==VAR_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(95);
			match(END_COMMAND);
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

	public static class Command2Context extends ParserRuleContext {
		public TerminalNode TERMINAL() { return getToken(InputParser.TERMINAL, 0); }
		public TerminalNode END_COMMAND() { return getToken(InputParser.END_COMMAND, 0); }
		public Command2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).enterCommand2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputListener ) ((InputListener)listener).exitCommand2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitCommand2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Command2Context command2() throws RecognitionException {
		Command2Context _localctx = new Command2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_command2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(TERMINAL);
			setState(98);
			match(END_COMMAND);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23g\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3%\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\5\7<\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bF\n\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\tO\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13]\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\2\2\16"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\2\r\16\2f\2\32\3\2\2\2\4$\3\2\2\2"+
		"\6&\3\2\2\2\b\61\3\2\2\2\n\63\3\2\2\2\f;\3\2\2\2\16E\3\2\2\2\20N\3\2\2"+
		"\2\22P\3\2\2\2\24\\\3\2\2\2\26^\3\2\2\2\30c\3\2\2\2\32\33\5\4\3\2\33\34"+
		"\7\f\2\2\34\35\5\f\7\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \5\6\4\2 !\7\f\2"+
		"\2!\"\5\4\3\2\"%\3\2\2\2#%\3\2\2\2$\37\3\2\2\2$#\3\2\2\2%\5\3\2\2\2&\'"+
		"\7\17\2\2\'(\7\7\2\2()\5\b\5\2)*\7\b\2\2*\7\3\2\2\2+\62\3\2\2\2,-\5\n"+
		"\6\2-.\7\n\2\2./\5\b\5\2/\62\3\2\2\2\60\62\5\n\6\2\61+\3\2\2\2\61,\3\2"+
		"\2\2\61\60\3\2\2\2\62\t\3\2\2\2\63\64\7\t\2\2\64\65\7\16\2\2\65\13\3\2"+
		"\2\2\66\67\5\16\b\2\678\7\f\2\289\5\f\7\29<\3\2\2\2:<\3\2\2\2;\66\3\2"+
		"\2\2;:\3\2\2\2<\r\3\2\2\2=>\7\17\2\2>?\5\22\n\2?@\7\20\2\2@A\5\20\t\2"+
		"AF\3\2\2\2BC\7\17\2\2CD\7\20\2\2DF\5\20\t\2E=\3\2\2\2EB\3\2\2\2F\17\3"+
		"\2\2\2GH\7\17\2\2HO\5\20\t\2IJ\7\23\2\2JO\5\20\t\2KO\7\17\2\2LO\7\23\2"+
		"\2MO\7\13\2\2NG\3\2\2\2NI\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\21\3"+
		"\2\2\2PQ\7\5\2\2QR\5\24\13\2RS\7\6\2\2S\23\3\2\2\2TU\5\26\f\2UV\5\24\13"+
		"\2V]\3\2\2\2WX\5\30\r\2XY\5\24\13\2Y]\3\2\2\2Z]\5\26\f\2[]\5\30\r\2\\"+
		"T\3\2\2\2\\W\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\25\3\2\2\2^_\7\16\2\2_`\7"+
		"\3\2\2`a\t\2\2\2ab\7\4\2\2b\27\3\2\2\2cd\7\23\2\2de\7\4\2\2e\31\3\2\2"+
		"\2\b$\61;EN\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from C:/Users/Spycsh/Desktop/hesse-sql\g.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		END=1, CHAR=2, CONJUNCTION=3, RELATION=4, OP=5, COMMA=6, LEFT_BRACKET=7, 
		RIGHT_BRACKET=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"END", "CHAR", "CONJUNCTION", "RELATION", "OP", "COMMA", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "END", "CHAR", "CONJUNCTION", "RELATION", "OP", "COMMA", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "WS"
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


	public gLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "g.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13V\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\6\3\31\n\3\r\3\16\3\32\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4&\n"+
		"\4\3\5\3\5\3\5\5\5+\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6E\n\6\3\7\3\7\3"+
		"\7\5\7J\n\7\3\b\3\b\3\t\3\t\3\n\6\nQ\n\n\r\n\16\nR\3\n\3\n\2\2\13\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\4\2\62;c|\4\2**]]\4\2++__"+
		"\5\2\13\f\17\17\"\"\2_\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25"+
		"\3\2\2\2\5\30\3\2\2\2\7%\3\2\2\2\t*\3\2\2\2\13D\3\2\2\2\rI\3\2\2\2\17"+
		"K\3\2\2\2\21M\3\2\2\2\23P\3\2\2\2\25\26\7=\2\2\26\4\3\2\2\2\27\31\t\2"+
		"\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\6\3\2"+
		"\2\2\34\35\7\"\2\2\35\36\7c\2\2\36\37\7p\2\2\37 \7f\2\2 &\7\"\2\2!\"\7"+
		"\"\2\2\"#\7q\2\2#$\7t\2\2$&\7\"\2\2%\34\3\2\2\2%!\3\2\2\2&\b\3\2\2\2\'"+
		"+\4>@\2()\7#\2\2)+\7?\2\2*\'\3\2\2\2*(\3\2\2\2+\n\3\2\2\2,-\7U\2\2-.\7"+
		"G\2\2./\7N\2\2/\60\7G\2\2\60\61\7E\2\2\61E\7V\2\2\62\63\7E\2\2\63\64\7"+
		"C\2\2\64\65\7N\2\2\65E\7N\2\2\66\67\7H\2\2\678\7T\2\289\7Q\2\29E\7O\2"+
		"\2:;\7V\2\2;E\7Q\2\2<=\7K\2\2=E\7P\2\2>?\7J\2\2?@\7C\2\2@A\7X\2\2AB\7"+
		"K\2\2BC\7P\2\2CE\7I\2\2D,\3\2\2\2D\62\3\2\2\2D\66\3\2\2\2D:\3\2\2\2D<"+
		"\3\2\2\2D>\3\2\2\2E\f\3\2\2\2FJ\7.\2\2GH\7.\2\2HJ\7\"\2\2IF\3\2\2\2IG"+
		"\3\2\2\2J\16\3\2\2\2KL\t\3\2\2L\20\3\2\2\2MN\t\4\2\2N\22\3\2\2\2OQ\t\5"+
		"\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\n\2\2U\24\3"+
		"\2\2\2\t\2\32%*DIR\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
package ir;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import lexer.CubexLexer;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

import context.IrContext;
import parser.CubexParser;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeCheckerMain;
import Exception.SemanticException;

public class IrMain {
	static boolean lexedWithError = false;
	static boolean parsedWithError = false;

	public static void main(String[] args) throws IOException {
		// CharStream charStream = new ANTLRFileStream(args[0]);
		CharStream charStream = new ANTLRFileStream(
				"semantics_tests/tc_test6.in");
		CubexLexer cubLexer = new CubexLexer(charStream);
		cubLexer.removeErrorListeners();

		ErrorListener listener = new ErrorListener();
		cubLexer.addErrorListener(listener);
		List<? extends Token> list1 = cubLexer.getAllTokens();
		if (lexedWithError) {
			System.out.print("reject");
			return;
		}
		cubLexer.reset();
		CubexParser cubParser = new CubexParser(new CommonTokenStream(cubLexer));
		cubParser.removeErrorListeners();
		ErrorListener plistener = new ErrorListener();
		cubParser.addErrorListener(plistener);

		cubParser.fullprogram();
		// ParseTree parseTree = xiParser.fullprogram();

		CubexCompleteContext c = (new TypeCheckerMain()).initialize();
		if (cubParser.getNumberOfSyntaxErrors() > 0) {
			System.out.print("reject");
			return;
		}
		System.out.println(cubParser.programAST);
		try {
			cubParser.programAST.typeCheck(c);
			IrContext context = new IrContext();
			IrProgram program = cubParser.programAST.toIr(context);
			ArrayList<String> programCode = program.toC();
			System.out.println("----------");
			for (int i = 1; i <= programCode.size(); i++){
				System.out.println(i + ": " + programCode.get(i));
			}
		} catch (SemanticException e) {
			// TODO GET RID OF e.toString() BEFORE WE SUBMIT
			e.printStackTrace();
			System.out.print("reject" + e.toString());
		}
	}

	static class ErrorListener implements ANTLRErrorListener {
		@Override
		public void reportAmbiguity(@NotNull Parser arg0, @NotNull DFA arg1,
				int arg2, int arg3, boolean arg4, @NotNull BitSet arg5,
				@NotNull ATNConfigSet arg6) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void reportAttemptingFullContext(@NotNull Parser arg0,
				@NotNull DFA arg1, int arg2, int arg3, @Nullable BitSet arg4,
				@NotNull ATNConfigSet arg5) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void reportContextSensitivity(@NotNull Parser arg0,
				@NotNull DFA arg1, int arg2, int arg3, int arg4,
				@NotNull ATNConfigSet arg5) {
			// TODO Auto-generated method stub
			return;
		}

		// private class lexException extends Exception{
		// public lexException(){ super(); }
		//
		// }

		@Override
		public void syntaxError(Recognizer<?, ?> arg0, @Nullable Object arg1,
				int arg2, int arg3, String arg4,
				@Nullable RecognitionException arg5) {
			// TODO Auto-generated method stub
			lexedWithError = true;
		}
	}
}

package ir;

import ir.program.IrProgram;

import java.io.File;
import java.io.FileWriter;
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

import parser.CubexParser;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeCheckerMain;
import Exception.SemanticException;

public class IrMain {
	static boolean lexedWithError = false;
	static boolean parsedWithError = false;

	public static void main(String[] args) throws IOException {
//		 CharStream charStream = new ANTLRFileStream(args[0]);


		CharStream charStream = new ANTLRFileStream("cg_tests/ez.x3");

//		CharStream charStream = new ANTLRFileStream("cg_tests/c_stage5_test2.x3");

		//CharStream charStream = new ANTLRFileStream("cg_tests/test8.x3");
		CubexLexer cubLexer = new CubexLexer(charStream);
		cubLexer.removeErrorListeners();

		ErrorListener listener = new ErrorListener();
		cubLexer.addErrorListener(listener);
		List<? extends Token> list1 = cubLexer.getAllTokens();
		if (lexedWithError) {  
			System.out.print("reject 1");
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
			System.out.print("reject 2");
			return;
		}
//		System.out.println(cubParser.programAST);
		try {
			cubParser.programAST.typeCheck(c);
			// replace all C keywords with a safe version
			cubParser.programAST.replaceCKeyWords();
			IrGenerationContext context = new IrGenerationContext();
			IrProgram program = cubParser.programAST.toIr(context, new IrProgram());
			
			// NOTE: if you turn off LVA, in IrProgram.java turn off the following variable: (48) context.lva = true;
			
			//program.removeCommonSubexpressions();
			//program.lva();
			CGenerationContext cgcontext = new CGenerationContext();
			ArrayList<String> programCode = program.toC(cgcontext);
			// first option for regular stuff, second for automated testing
			FileWriter writer = new FileWriter(new File("out.c"));
//			FileWriter writer = new FileWriter(new File("cg_tests/out.c"));
//			System.out.println("----------");
			int counter = 3;
			writer.write("#include \"cubex_lib.h\"\n");
			// TODO: REMOVE THIS BEFORE SUBMITTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			writer.write("#include \"stdio.h\"\n");
			for (String s : programCode){
				System.out.println(counter + "\t" + s);
				counter++;
				writer.write(s + "\n");
			}
			writer.close();
			
		} catch (SemanticException e) {
			// TODO GET RID OF e.toString() BEFORE WE SUBMIT
//			e.printStackTrace();
//			System.out.print("reject" + e.toString());
			System.out.print("reject");
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
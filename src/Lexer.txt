import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

public class Lexer {

	static boolean lexedWithError = false;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Create HashMap. ID number -> token name
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		Scanner sc = new Scanner(new BufferedReader(new FileReader("antlr/CubexLexer.tokens")));
		while(sc.hasNext()){
			String s = sc.nextLine();
			if(!s.contains("'")){
				String[] arr = (s.split("="));
				map.put(Integer.parseInt(arr[1]), arr[0]);
			}
		}
		
		//Lexing starts here
		CubexLexer lex = new CubexLexer(new ANTLRFileStream(args[0]));

		lex.removeErrorListeners();
		
		LexerErrorListener listener = new LexerErrorListener();
		lex.addErrorListener(listener);
		
		boolean firstTime = true;
		//Change tokens based on PA1 stuff
		List<? extends Token> list = lex.getAllTokens();
		if(lexedWithError){
			System.out.print("error");
			return;
		}
		
		for(Token t : list){
			//Need conditions for variable names and type names
			if(firstTime){
				firstTime = false;
			}
			else{
				System.out.print(" ");
			}
			if (map.get(t.getType()).equalsIgnoreCase("Integer")) {
				System.out.print(0);
			}
			else if (map.get(t.getType()).equalsIgnoreCase("false") || map.get(t.getType()).equalsIgnoreCase("true")){
				System.out.print("true");
			}
			else if(map.get(t.getType()).equalsIgnoreCase("String")){
				System.out.print("\"\"");
			}
			else if(map.get(t.getType()).equalsIgnoreCase("Comment") || map.get(t.getType()).equalsIgnoreCase("NestedComment") || map.get(t.getType()).equalsIgnoreCase("WS")){
				System.out.print("");
			}
			else if(map.get(t.getType()).equalsIgnoreCase("VARFUNID")){
				System.out.print("name");
			}
			else if(map.get(t.getType()).equalsIgnoreCase("TYPE") || 
					map.get(t.getType()).equalsIgnoreCase("THING") || 
					map.get(t.getType()).equalsIgnoreCase("NOTHING")){
				System.out.print("Name");
			}
			else{
				System.out.print(t.getText());
			}
		}
	}
	
	static class LexerErrorListener implements ANTLRErrorListener {
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
		
//		private class lexException extends Exception{
//			public lexException(){ super(); }
//			
//		}

		@Override
		public void syntaxError(Recognizer<?, ?> arg0, @Nullable Object arg1,
				int arg2, int arg3, String arg4, @Nullable RecognitionException arg5) {
			// TODO Auto-generated method stub
			lexedWithError = true;
		}
	}

}

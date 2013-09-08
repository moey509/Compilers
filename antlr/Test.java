import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;

public class Test {

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
//		if(lex.hasErred){ //Doesn't do anything right now
//			System.out.println("error");
//			return;
//		}
		boolean firstTime = true;
		//Change tokens based on PA1 stuff
		for(Token t : lex.getAllTokens()){
			//Need conditions for variable names and type names
			if(!firstTime){
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
			else if(map.get(t.getType()).equalsIgnoreCase("TYPEID")){
				System.out.print("Name");
			}
			else{
				System.out.print(t.getText());
			}
		}
	}

}

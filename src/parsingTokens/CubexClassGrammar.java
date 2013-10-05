package parsingTokens;

import parsingTokens.context.CubexTypeTuple;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionDef;
import parsingTokens.statements.CubexList;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class CubexClassGrammar {
	public String name;
	public CubexList<String> kindcontext;
	CubexList<CubexTypeTuple> typecontext;
	public CubexTypeGrammar type;
	CubexList<CubexStatement> statements;
	CubexList<CubexExpression> expressions;
	public CubexList<CubexFunctionDef> functions;
	
	public CubexClassGrammar(String n, CubexList<String> k, CubexList<CubexTypeTuple> typecont, CubexTypeGrammar t, 
			CubexList<CubexStatement> s, CubexList<CubexExpression> e, CubexList<CubexFunctionDef> f) {
		name = n;
		kindcontext = k;
		typecontext = typecont;
		type = t;
		statements = s;
		expressions = e;
		functions = f;
		
	}
	
	public String toString() {
		String kSpace = kindcontext.size() == 0 ? "" : " ";
		String tSpace = typecontext.size() == 0 ? "" : " ";
		String sSpace = statements.size() == 0 ? "" : " ";
		String eSpace = expressions.size() == 0 ? "" : " ";
		String fSpace = functions.size() == 0 ? "" : " ";
		
		StringBuilder build = new StringBuilder();
		build.append("class ");
		build.append(name);
		build.append(" < ");
		build.append(kindcontext.toString(","));
		build.append(kSpace);
		build.append("> ( ");
		build.append(typecontext.toString(","));
		build.append(tSpace);
		build.append(") extends ");
		build.append(type);
		build.append(" { ");
		CubexListStatement.flatten = true;
		build.append(statements.toString());
		CubexListStatement.flatten = false;
		build.append(sSpace);
		build.append("super ( ");
		build.append(expressions.toString(","));
		build.append(eSpace);
		build.append(") ; ");
		build.append(functions.toString());
		build.append(fSpace);
		build.append("}");
		
		return build.toString();
	}

}

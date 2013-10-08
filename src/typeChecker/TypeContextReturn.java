package typeChecker;
import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class TypeContextReturn {
	public TypeContext typeContext;
	public boolean guaranteedToReturn;
	public CubexTypeGrammar retType;
	
	public TypeContextReturn(TypeContext tc, boolean guarantee, CubexTypeGrammar rt) {
		typeContext = tc;
		guaranteedToReturn = guarantee;
		retType = rt;
	}
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException{
		throw new SemanticException("TypeContextReturn");
	}
}

package typeChecker;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class TypeContextReturn {
	TypeContext typeContext;
	boolean guaranteedToReturn;
	CubexTypeGrammar retType;
	
	public TypeContextReturn(TypeContext tc, boolean guarantee, CubexTypeGrammar rt) {
		typeContext = tc;
		guaranteedToReturn = guarantee;
		retType = rt;
	}

}

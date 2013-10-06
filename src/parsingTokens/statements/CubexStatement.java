package parsingTokens.statements;
<<<<<<< HEAD

public interface CubexStatement {
=======
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import typeChecker.CubexCompleteContext;
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f

public abstract class CubexStatement {
	public CubexExpression e;
	//Must return some expression. If unimplemented then returns false. Top rule  in program checking.
	public boolean typeCheck(CubexCompleteContext c, boolean b){
		return false;
	}
	//For returns, given true/false for return and a type t
	public boolean typeCheck(CubexCompleteContext c, boolean b, CubexTypeClass t) {
		return false;
	}
	public boolean typeCheck(CubexCompleteContext c) {
		// TODO Auto-generated method stub
		return false;
	}
}
package parsingTokens.typeGrammar;

import java.util.ArrayList;

import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import Exception.SemanticException;

// Represents single letter type params
public class CubexTypeName extends CubexTypeGrammar{	
	public CubexTypeName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	public void validate(CubexCompleteContext c, boolean canBeClass) throws SemanticException{
		if (name.equals("Thing") || name.equals("Nothing")) return;
		if (!c.kindContext.contains(name)){
			throw new SemanticException("Kind context does not contain generic");
		}
	}
	
	public CubexTypeGrammar replaceParams(TypeContext cont) {
		if (cont.containsKey(getName())) {
			return cont.get(getName());
		}
		
		return this;
	}
	
	public boolean equalType(CubexTypeGrammar t) throws SemanticException {
		if (getName().equals("Thing") && t.getName().equals("Thing")) return true;
		if (getName().equals("Nothing") && t.getName().equals("Nothing")) return true;

		if (t instanceof CubexTypeName) {
			return getName().equals(t.getName());
		}
		return false;
	}
	
	public ArrayList<CubexTypeClass> joinHelper(CubexCompleteContext c, CubexTypeGrammar t,
			ArrayList<CubexTypeClass> a) throws SemanticException {
		return new ArrayList<CubexTypeClass>();
	}
	
}

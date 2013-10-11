package parsingTokens.typeGrammar;

import Exception.SemanticException;
import parsingTokens.CubexList;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;

public class CubexTypeClass extends CubexTypeGrammar {
	public CubexList<CubexTypeGrammar> typeList;

	public CubexTypeClass(String name, CubexList<CubexTypeGrammar> typeList) {
		this.name = name;
		this.typeList = typeList;
	}
	
	public String getName(){
		return this.name;
	}
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return typeList;
	}

	public String toString() {
		String rightSpace = typeList.size() == 0 ? "" : " ";
		return name.toString() + " < " + typeList.toString(",") + rightSpace + ">";
	}

	public void validate(CubexCompleteContext c) throws SemanticException{
		if (!c.containsClassName(name)){
			throw new SemanticException("");
		}
	}
	
	public CubexTypeGrammar replaceParams(TypeContext cont){
		CubexList<CubexTypeGrammar> list = new CubexList<CubexTypeGrammar>();
		for (CubexTypeGrammar i : typeList.contextCollection) {
			list.add(i.replaceParams(cont));
		}
		return new CubexTypeClass(getName(), list);
	}
	
	
	

}

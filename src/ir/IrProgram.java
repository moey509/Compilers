package ir;

import java.util.ArrayList;

public class IrProgram {
	public ArrayList<IrProgramElem> components;
	
	public IrProgram(){
		components = new ArrayList<IrProgramElem>();
	}
	public IrProgram(ArrayList<IrProgramElem> c) {
		components = c;
	}
	
	public void addComponent(IrProgramElem elem){
		components.add(elem);
	}
	
	public ArrayList<String> toC(){
		ArrayList<String> newArrList = new ArrayList<String>();
		for (IrProgramElem elem : components){
			newArrList.addAll(elem.toC());
		}
		return newArrList;
	}
}

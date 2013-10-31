package ir;

import java.util.ArrayList;

public class IrProgramReturn implements IrProgramElem {
	String[] output;
	
	/*
	 * For the return output at the end of the program.
	 */
	public IrProgramReturn(String[] output){
		this.output = output;
	}
	
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		//TODO something
		return arrList;
	}
}

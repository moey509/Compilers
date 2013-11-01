package ir.program;

import ir.IrType;

public class IrTypeTuple {
	public IrType type;
	public String variableName;
	
	public IrTypeTuple(IrType type, String variableName) {
		this.type = type;
		this.variableName = variableName;
	}	
}

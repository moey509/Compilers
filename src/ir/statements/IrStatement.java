package ir.statements;

import java.util.ArrayList;

import ir.IrProgramElem;
import ir.expressions.IrExpression;

public abstract class IrStatement implements IrProgramElem{
	protected IrExpression e;

	public abstract ArrayList<String> toC();
	
}
package ir.statements;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import ir.CGenerationContext;
import ir.expressions.IrExpression;


public class IrFor implements IrStatement {
	private IrExpression condition;
	private List<IrStatement> statements;

	public IrFor(IrExpression condition) {
		this.condition = condition;
		this.statements = new ArrayList<IrStatement>();
	}

	public void addStatement(IrStatement statement){
		statements.add(statement);
	}
	
	public void addStatement(List<IrStatement> statement){
		statements.addAll(statement);
	}
	
	
//	it = new_iterator(i1);
//	  while (hasNext(it)) {
//	    temp = getNext(it);
//	    
//	    /*
//	     *  insert code here
//	     */
//	    
//	    printf ("==> %d\n", temp);
//	}
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> arr = new ArrayList<String>();
		//arr.add()
		
		// ADD SHIT HERE.
		
		arr.add("for(" + condition.toC(context) + "; " + "){");
		for(IrStatement s : statements){
			arr.addAll(s.toC(context));
		}
		arr.add("}");
		return arr;
	}
}



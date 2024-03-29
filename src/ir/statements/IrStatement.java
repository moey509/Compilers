package ir.statements;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.program.IrProgramElem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import optimization.LvaContext;

public abstract class IrStatement implements IrProgramElem{
	public ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();

	// useSet not populated before populateSets call
	public Set<String> useSet = new HashSet<String>();
	public Set<String> defSet = new HashSet<String>();
	protected Set<String> inSet = new HashSet<String>();
	protected Set<String> outSet = new HashSet<String>();
	// invariant: the nextSet should not contain any CubexListStatements
	// invariant: the nextSet is initially null before any populateNext calls,
	//			  and is nonnull after the first populateSets call
	protected Set<IrStatement> nextSet;
	// used to check that we've called getTop already
	// don't want to go to infinite loop on populateNext
	public boolean topAccessed = false;
	protected boolean afterLoop = false;
	protected boolean lastAfterLoop = false;
	protected boolean hasFreeAfter = false;
	protected boolean hasFreeBefore = false;
	protected IrStatement prevLoop;
	protected Set<String> freeAfter = new HashSet<String>();
	protected Set<String> freeBefore = new HashSet<String>();

	public abstract ArrayList<IrBind> getTemporaryVariables();
	public abstract void addDeclaration(ArrayList<String> arr, CGenerationContext context);
	public abstract void addInitialization(ArrayList<String> arr, CGenerationContext context);
	public abstract ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras);
	
	// use after lva to get the set of variables that need to be decremented
	public Set<String> inMinusOut() {
		Set<String> set = new HashSet<String>(inSet);
		set.removeAll(outSet);
		return set;
	}

	/*
	 * Instructions:
	 * after lva, inMinusOut() returns all variables that need to be 
	 *   decremented after the execution of each statement.
	 * these do not exclude variables in the
	 *   the return statements of a function
	 * if a statment is afterLoop, then the variables in freeBefore
	 *   have to in addition be decremented before that statement executes.
	 * if a statement is an irBind and it isDead(),
	 *   that statement must not be executed.
	 * this does not affect any of its temporaryBinds.
	 */
	// needs populateNext to be run before working
	public abstract void lva(LvaContext c);
	
	protected void lvaHelper(LvaContext c) {
		for (IrBind s : temporaryBinds) {
			s.lva(c);
		}
		
		HashSet<String> outTemp = getIns();
		boolean changeTemp0 = !outTemp.equals(outSet);
		outSet = outTemp;

		HashSet<String> inTemp = new HashSet<String>(outSet);
		inTemp.removeAll(defSet);
		inTemp.addAll(useSet);
		inTemp.removeAll(c.doNotDecrement);
		boolean changeTemp1 = !inTemp.equals(inSet);
		inSet = inTemp;

		if (changeTemp0 || changeTemp1) {
			c.changed = true;
		}
		
		if (afterLoop) {
			if (!lastAfterLoop) {
				freeBefore = new HashSet<String>(prevLoop.outSet);
				freeBefore.removeAll(inSet);
				hasFreeBefore = true;
			} else {
				prevLoop.freeAfter = new HashSet<String>(prevLoop.outSet);
				prevLoop.freeAfter.removeAll(inSet);
				prevLoop.hasFreeAfter = true;
			}
		}
	}
	
	protected void lvaDebugHelper(){
		System.out.println("  decrement: " + inMinusOut().toString());
		if (hasFreeAfter) {
			System.out.println("  freeAfter: " + freeAfter.toString());
		}
		if (hasFreeBefore) {
			System.out.println("  prevLoop: " + prevLoop.toString());
			System.out.println("  freeBefore: " + freeBefore.toString());
		}
		System.out.println("  inSet: " + inSet.toString());
		System.out.println("  outSet: " + outSet.toString());
		System.out.println("  useSet: " + useSet.toString());
		System.out.println("  defSet: " + defSet.toString());
		System.out.println("  nextSet: " + nextSet.toString());
	}
	
	// returns the set of "in" variables used by this CubexStatement
	public HashSet<String> getIns() {
		HashSet<String> out = new HashSet<String>();
		for (IrStatement i : nextSet) {
			for (String s : i.inSet) {
				out.add(s);
			}
		}
		return out;
	}
	
	// populates the nextSet and useSet for each statement
	// invariant: populateNext only functions once for each CubexStatement,
	// via a check for whether the nextSet is null
	public abstract void populateSets(LvaContext c);
	
	// helper function for populateNext
	protected void populateSetsTemps(LvaContext c) {
		// populateNext the temporary variables first
		if (temporaryBinds.size()>0) {
			c.nextList.add(0, this);
			c.nextList.addAll(0, temporaryBinds);
			c.nextList.removeFirst();
			for (IrStatement s : temporaryBinds) {
				s.populateSets(c);
			}
		}
	}
	
	// gets the top statement from each IrStatement, accounting for temporaryBinds
	// private because the expected behavior isn't achieved after calling for lva
	protected IrStatement getTop() {
		if (temporaryBinds.size() >0 && !topAccessed) {
			topAccessed = true;
			return temporaryBinds.get(0);
		}
		topAccessed = true;
		return this;
	}
	
	@Override
	public abstract String toString();
	
}
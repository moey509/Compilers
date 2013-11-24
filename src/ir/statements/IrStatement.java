package ir.statements;

import ir.CGenerationContext;
import ir.program.IrProgramElem;

import java.util.ArrayList;
import java.util.HashSet;

import optimization.LvaContext;

public abstract class IrStatement implements IrProgramElem{
	private ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
	// useSet not populated before populateSets call
	public HashSet<String> useSet = new HashSet<String>();
	public HashSet<String> defSet = new HashSet<String>();
	protected HashSet<String> inSet = new HashSet<String>();
	protected HashSet<String> outSet = new HashSet<String>();
	// invariant: the nextSet should not contain any CubexListStatements
	// invariant: the nextSet is initially null before any populateNext calls,
	//			  and is nonnull after the first populateSets call
	protected HashSet<IrStatement> nextSet;
	// used to check that we've called getTop already
	// don't want to go to infinite loop on populateNext
	protected boolean topAccessed = false;

	public abstract ArrayList<IrBind> getTemporaryVariables();
	public abstract void addDeclaration(ArrayList<String> arr, CGenerationContext context);
	public abstract void addInitialization(ArrayList<String> arr, CGenerationContext context);
	public abstract ArrayList<String> toC(CGenerationContext context, boolean isMain);
	
	// run after toIr, before toC
	// needs populateNext to be run before working
	public abstract void lva(LvaContext c);
	
	public void lvaHelper(LvaContext c) {
		for (IrBind s : temporaryBinds) {
			s.lva(c);
		}
		
		HashSet<String> outTemp = getIns();
		boolean changeTemp0 = outTemp.equals(outSet);
		outSet = outTemp;

		HashSet<String> inTemp = new HashSet<String>(outSet);
		inTemp.removeAll(defSet);
		inTemp.addAll(useSet);
		inTemp.removeAll(c.doNotDecrement);
		boolean changeTemp1 = inTemp.equals(inSet);
		inSet = inTemp;

		if (changeTemp0 || changeTemp1) {
			c.changed = true;
		}
	}
	
	// returns the set of "in" variables used by the first statement(s) of this CubexStatement
	public HashSet<String> getIns() {
		HashSet<String> out = new HashSet<String>();
		for (IrStatement i : nextSet) {
			for (String s : i.inSet) {
				out.add(s);
			}
		}
		return null;
	}
	
	// populates the nextSet and useSet for each statement
	// invariant: populateNext only functions once for each CubexStatement,
	// via a check for whether the nextSet is null
	public abstract void populateSets(LvaContext c);
	
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
}
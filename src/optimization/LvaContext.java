package optimization;

import ir.statements.IrStatement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LvaContext {
	// used by lva
	public boolean changed;
	public HashSet<String> doNotDecrement;

	// used by populateSets
	public LinkedList<IrStatement> nextList;
	public Map<String, Set<String>> functionUse;
	
	public LvaContext() {
		changed = true;
		nextList = new LinkedList<IrStatement>();
		doNotDecrement = new HashSet<String>();
		functionUse = new HashMap<String, Set<String>>();
	}
	
	public LvaContext clone() {
		LvaContext c = new LvaContext();
		c.changed = changed;
		c.nextList.addAll(nextList);
		return c;
	}
}

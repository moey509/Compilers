package typeChecker;

public class CubexCompleteContext {
	ClassContext classContext;
	KindContext kindContext;
	FunctionContext functionContext;
	TypeContext typeContext;
	TypeContext mutableTypeContext;
	CubexCompleteContext(ClassContext c, KindContext k, FunctionContext f, TypeContext t, TypeContext mt){
		classContext = c;
		kindContext = k;
		functionContext = f;
		typeContext = t;
		mutableTypeContext = mt;
	}
	//TODO: implement adding onto the complete context
//	CubexCompleteContext add(ClassContext c, KindContext k, FunctionContext f, TypeContext t, TypeContext mt){
//		CubexCompleteContext ccc = new CubexCompleteContext(c, k, f, t, mt);
//		
//		return null;
//	}
}

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class CubexFunctionCall extends CubexExpression {
	private String mName;
	private Collection<? extends CubexExpression> mArguments;
	public CubexFunctionCall(String name, Collection<? extends CubexExpression> args) {
		mName = name;
		mArguments = args;
	}
	protected CubexType calculateType(CubexContext context) throws NoSuchTypeException {
		CubexFunction function = context.getFunction(mName);
		if (function == null)
			throw new NoSuchTypeException();
		List<CubexType> types = new ArrayList<CubexType>(mArguments.size());
		for (CubexExpression arg : mArguments)
			types.add(arg.getType(context));
		Collection<? extends CubexType> returns = function.getTypes(types);
		if (returns.size() != 1)
			throw new NoSuchTypeException();
		return returns.iterator().next();
	}
}
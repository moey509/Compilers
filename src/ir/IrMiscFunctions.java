package ir;

import java.util.ArrayList;

import typeChecker.IrGenerationContext;

public class IrMiscFunctions {
	public static final String INTEGER = "Integer";
	public static final String BOOLEAN = "Boolean";
	public static final String ITERABLE = "Iterable";
	public static final String CHARACTER = "Character";
	public static final String STRING = "String";

	public static void increment_ref(CGenerationContext context, String str, ArrayList<String> lst) {
		// check if the context allows this to happen
		if (context.to_free) {
			lst.add("ref_increment((General_t)" + str + ");");
		}
	}

	public static void decrement_ref(CGenerationContext context, String str, ArrayList<String> lst) {
		// check if the context allows this to happen
		if (context.to_free) {
			lst.add("ref_decrement((General_t)" + str + ");");
		}
	}
	
	public static void no_free_decrement_ref(CGenerationContext context, String str, ArrayList<String> lst) {
		// check if the context allows this to happen
		if (context.to_free) {
			lst.add("ref_decrement_no_free((General_t)" + str + ");");
		}
	}

	
	public static void _increment_ref(IrGenerationContext context, String str, ArrayList<String> lst) {
		// check if the context allows this to happen
		if (context.to_free) {
			lst.add("ref_increment((General_t)" + str + ");");
		}
	}

	public static void _decrement_ref(IrGenerationContext context, String str, ArrayList<String> lst) {
		// check if the context allows this to happen
		if (context.to_free) {
			lst.add("ref_decrement((General_t)" + str + ");");
		}
	}
	
	public static void _no_free_decrement_ref(IrGenerationContext context, String str, ArrayList<String> lst) {
		// check if the context allows this to happen
		if (context.to_free) {
			lst.add("ref_decrement_no_free((General_t)" + str + ");");
		}
	}

	
	/*public static String getInteger() {
		return "integer";
	}
	public static String getBoolean() {
		return "boolean";
	}
	public static String getIterable() {
		return "i
	}*/
}

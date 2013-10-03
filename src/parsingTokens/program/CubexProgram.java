package parsingTokens.program;

public class CubexProgram {
	CubexProgramType programType;
	CubexProgram nextProgram;
	
	public CubexProgram (CubexProgramType programType, CubexProgram nextProgram) {
		this.programType = programType;
		this.nextProgram = nextProgram;
	}	
	
	public String toString() {
		if (nextProgram == null) {
			return programType.toString();
		}
		else {
			return programType.toString() + " " + nextProgram.toString();
		}
	}
}

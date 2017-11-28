package truthtableconstructor.operators;

import truthtableconstructor.Operator;

/**
 *
 * @author Mohamed Mashaal
 */
public class Not implements Operator{
	private static final int PRECEDENCE = 1;
	private static final String REPRESENTATION = "~";
	private static final int OPERANDS = 1;
	
	@Override
	public int precedenceLevel() {
		return PRECEDENCE;
	}

	@Override
	public boolean isOperator(String element) {
		return REPRESENTATION.equalsIgnoreCase(element);
	}

	@Override
	public int numberOfOperands() {
		return OPERANDS;
	}

	@Override
	public boolean apply(boolean operand) {
		return !operand;
	}

	@Override
	public boolean apply(boolean operand_1, boolean operand_2) {
		throw new UnsupportedOperationException();
	}
    
	@Override
    public Operator getInstance() {
    	return new Not();
    }

	@Override
	public String getRepresentation() {
		return REPRESENTATION;
	}
}

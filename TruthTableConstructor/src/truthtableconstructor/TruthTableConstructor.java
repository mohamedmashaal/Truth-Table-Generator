/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truthtableconstructor;

import java.util.ArrayList;
import java.util.Map;

import truthtableconstructor.operators.And;
import truthtableconstructor.operators.Implies;
import truthtableconstructor.operators.Nand;
import truthtableconstructor.operators.Nor;
import truthtableconstructor.operators.Not;
import truthtableconstructor.operators.Or;
import truthtableconstructor.operators.Xnor;
import truthtableconstructor.operators.Xor;

/**
 *
 * @author Mohamed Mashaal
 */
public class TruthTableConstructor {
	ArrayList <Operator> supportedOperators ;
    Evaluator evaluator ;
    Transformer transformer ;
	/**
     * @param args the command line arguments
     */
	public TruthTableConstructor() {
		initSupportedOperators();
		evaluator = new Evaluator(supportedOperators);
		transformer = new Transformer(supportedOperators);
	}
	
	public ArrayList<String> getOperands(String expression) throws Exception{
		String [] splittedExpression = expression.trim().replaceAll("\\(", "\\( ").replaceAll("\\)", " \\)").split("\\s+");
        ArrayList<String> postFix = new ArrayList<>() ;
        postFix = transformer.infixToPostfix(splittedExpression);
		return evaluator.getOperands(postFix);
	}
	
    public Map<String , Boolean> construct(String expression) throws Exception {
    	String [] splittedExpression = expression.trim().replaceAll("\\(", "\\( ").replaceAll("\\)", " \\)").split("\\s+");
    	ArrayList<String> postFix = new ArrayList<>() ;
        postFix = transformer.infixToPostfix(splittedExpression);
        return evaluator.evalute(postFix);
    }
    
	private void initSupportedOperators() {
		supportedOperators = new ArrayList<>();
		supportedOperators.add(new And());
		supportedOperators.add(new Or());
		supportedOperators.add(new Not());
		supportedOperators.add(new Nand());
		supportedOperators.add(new Nor());
		supportedOperators.add(new Xor());
		supportedOperators.add(new Xnor());
		supportedOperators.add(new Implies());
	}
}

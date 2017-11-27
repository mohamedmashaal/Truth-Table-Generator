package truthtableconstructor;

import java.util.ArrayList;
import java.util.Map;

public class Main {
	public static void main(String [] args) {
		TruthTableConstructor cst = new TruthTableConstructor();
		try {
			Map <String , Boolean> table = cst.construct("(p => q) AND (q => p)");
			ArrayList<String> operands = cst.getOperands("(p => q) AND (q => p)");
			for(String x : operands) {
				System.out.print(x);
			}
			System.out.println();
			for(java.util.Map.Entry<String, Boolean> x : table.entrySet()) {
				System.out.println(x.getKey() + " " + x.getValue());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

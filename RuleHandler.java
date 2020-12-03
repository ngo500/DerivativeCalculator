package DerivativeFunction;

public class RuleHandler {

	/**
	 * Function that takes the given input and applies a rule to it in order to get the derivative
	 * @param term - the String given from the parsed input
	 * @return result - the result of the derived term
	 */
	public String derive(String term) {
		
		//result of derivative to return
		String result = "";
		
		if(term.equals("")) {
			
			//empty input
			result = "";
			
		}//if
		else if(term.contains("/")) {
			
			//call quotient rule
			DivisionRule dr = new DivisionRule();
			result = dr.calculateRule(term);
			
		}//else if
		else if(term.contains("*")) {
			
			//first split input term
			String delimiter = "((?<=\\*)|(?=\\*))";	//split at the *
			String[] termSplit = term.split(delimiter);	//now, easy parsing
			
			//now, call product rule
			ProductRule pr = new ProductRule();
			result = pr.calculateRule(termSplit[0],termSplit[3]);
			
		}//else if
		else if(term.contains("sqrt")) {
			
			//call chain rule
			ChainRule cr = new ChainRule();
			result = cr.calculateRule(term);
			
		}//else if
		else {
			
			//call power rule
			PowerRule pr = new PowerRule();
			result = pr.calculateRule(term);
			
		}//else
		
		//result derived to return
		return result;
		
	}//derive
	
}//RuleHandler

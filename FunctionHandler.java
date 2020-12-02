package DerivativeFunction;

public class FunctionHandler {

	/**
	 * Function that takes the given input and applies a function to it in order to get the derivative
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
		else if(term.contains("sin")) {
			
			//call sin function
			SinFunction sf = new SinFunction();
			result = sf.returnDerivative();
			
		}//else if
		else if(term.contains("cos")) {
			
			//call cos function
			CosFunction cf = new CosFunction();
			result = cf.returnDerivative();
			
		}//else if
		else if(term.contains("tan")) {
			
			//call tan function
			TanFunction tf = new TanFunction();
			result = tf.returnDerivative();
			
		}//else if
		else if(term.contains("sxn")) {
			
			//call inv sin function
			InvSinFunction isf = new InvSinFunction();
			result = isf.returnDerivative();
			
		}//else if
		else if(term.contains("cxs")) {
			
			//call inv cos function
			InvCosFunction icf = new InvCosFunction();
			result = icf.returnDerivative();
			
		}//else if
		else if(term.contains("txn")) {
			
			//call inv tan function
			InvTanFunction itf = new InvTanFunction();
			result = itf.returnDerivative();
			
		}//else if
		else if(term.contains("e")) {
			
			//call e function
			EFunction ef = new EFunction();
			result = ef.returnDerivative();
			
		}//else if
		else if(term.contains("ln")) {
			
			//call ln function
			NaturalLogFunction lnf = new NaturalLogFunction();
			result = lnf.returnDerivative();
			
		}//else if
		else if(term.contains("sqrt")) {
			
			//call square root function
			SqrtFunction sqrtf = new SqrtFunction();
			result = sqrtf.returnDerivative();
			
		}//else if
		else {
			
			//probably is just an x or a number
			PowerRule pr = new PowerRule();
			result = pr.calculateRule(term);
			
		}//else
		
		//result derived to return
		return result;
		
	}//derive

}

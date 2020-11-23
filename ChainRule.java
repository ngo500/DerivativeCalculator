package DerivativeFunction;

/**
 * 
 * ChainRule: Class that Implements the Chain Rule
 * for 2 functions f(x) and g(x) that are both differentiable,
 * the derivative of F(x) is 
 * F'(x) = f'(g(x))g'(x)
 *
 */

public class ChainRule implements DerivativeRule{

	@Override
	public String calculateRule(String st) {
		return null;
	}//calculateRule

	@Override
	/**
	 * @param String out is for the outside function, String in is for the inside function
	 * @return String is the derivative resulting from the chain function
	 */
	public String calculateRule(String out, String in) {
		
		//string out = fx, string in = gx
		//result from rule
		String result = "";
		
		//first term- gx'
		//delimiters: +, -, *, /
		String temp = in;	//use a temp to not disturb the string- we will need it later
		temp = temp.replaceAll("\\s", "");	//get rid of any spaces just in case
		String delimiter = "((?<=\\+)|(?=\\+))|((?<=\\-)|(?=\\-))|((?<=\\*)|(?=\\*))|((?<=\\/)|(?=\\/))|((?<=cos)|(?=cos))|((?<=sin)|(?=sin))|((?<=tan)|(?=tan))|((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))";
		String[] arr = temp.split(delimiter);	//now the string is split between stuff for ease of use
		
		//if there is an array, go through it
		if(arr.length > 1) {
			result = "(";
			PowerRule pf = new PowerRule();
			for(int i=0; i<arr.length; i++) {
				if(i % 2 == 0 || i == 0) {
					result += pf.calculateRule(arr[i]);
				}//if
				else{
					result += arr[i];
				}//else
			}//for
			result += ")";
		}//if
		else {	//otherwise there is only 1 term, just use it as is
			PowerRule pf = new PowerRule();
			result = ("(" + pf.calculateRule(in) + ")");
		}//else
		
		//now we have (gx')
		
		
		//next term- fx'
		if(out.equals("sin")) {	//function is sin
			
			SinFunction sf = new SinFunction();
			result += sf.returnDerivative();
			
		
		}//if
		else if(out.equals("cos")) { //function is cos
			
			CosFunction sf = new CosFunction();
			result += sf.returnDerivative();
			
		}//else if
		else if(out.equals("tan")) { //function is tan
			
			TanFunction sf = new TanFunction();
			result += sf.returnDerivative();
			
		}//else if
		else if(out.equals("sxn")) { //function is sin^-1
			
			InvSinFunction sf = new InvSinFunction();
			result += sf.returnDerivative();
			
		}//else if
		else if(out.equals("cxs")) { //function is cos^-1
			
			InvCosFunction sf = new InvCosFunction();
			result += sf.returnDerivative();
			
		}//else if
		else if(out.equals("txn")) { //function is tan^-1
			
			InvTanFunction sf = new InvTanFunction();
			result += sf.returnDerivative();
			
		}//else if
		else {
			
			PowerRule pf = new PowerRule();
			result += pf.calculateRule(in);
			
		}//else
		
		//now we have gx'fx'(missing gx)
		
		//add in gx into the last spot in parenthesis
		result += ("(" + in + ")");
		
		return result;	//return gx' fx'(gx)
	}//calculateRule	

}//ChainRule

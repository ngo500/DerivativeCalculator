package DerivativeFunction;

/**
 * 
 * PowerRule: Class that Implements the Power Rule
 * (x^n)' = nx^(n-1)
 *
 */

public class PowerRule implements DerivativeRule{
	
	/**
	 * @param st Takes a string that is a simplified x value
	 * for example: 2x, x^4, 2x^4, etc
	 * @return String Returns an answer that is the derivative of the
	 * input String st value in String form
	 */
	@Override
	public String calculateRule(String st){
		
		//result to return as the answer
		String result = "";	
		//if there is a number before the x, true, otherwise flase
		boolean numBeforeX = false;
		
		//check for the case where just an x is given
		if(st.equals("x")) {
			result = "1";
		}// if
		//check for a - with no number
		else if(st.equals("-x")) {
			result = "-1";
		}//else if
		else {
			//check if there is a number before the x
			if(st.charAt(0) != 'x') {
				numBeforeX = true;	//there is a number before the x
			}//if
			else {}//else, there is not a number before the x
			//check if the x has no exponent
			
			if(st.indexOf('x') == (st.length()-1)){
				String[] temp = st.split("x");
				int tempInt = Integer.parseInt(temp[0]);
				result = tempInt + "";
			}//if
			else {//else, the x has an exponent
				
				//there was no number before the x
				if(!numBeforeX) {
					String[] temp = st.split("x|\\^");
					int tempInt = Integer.parseInt(temp[2]);
					result = (tempInt + "x^" + (tempInt-1));
				}//if
				else {//else, there is a number before the x
					String[] temp = st.split("x|\\^");
					
					int firstNum = Integer.parseInt(temp[0]);
					int tempInt = Integer.parseInt(temp[2]);
					result = ((firstNum*tempInt) + "x^" + (tempInt-1));
				}//else
				
			}//else
			
		}//else
		
		//final derivative
		return result;
		
	}//calculateRule

}//PowerRule

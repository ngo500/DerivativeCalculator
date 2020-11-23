package DerivativeFunction;

/**
 * 
 * ProductRule: Class that Implements the Product Rule
 * for 2 functions f(x) and g(x) that are both differentiable,
 * (fg)' = f'g + fg'
 *
 */

public class ProductRule implements DerivativeRule{

	@Override
	/**
	 * @param String fx- the first function, String gx- the second function
	 * @return the result String of their derivative
	 */
	public String calculateRule(String fx, String gx) {
		
		String result = "";	//final result
		String fxdx = "NONE";	//derivative of fx
		String gxdx = "NONE";	//derivative of gx
		
		fx = fx.replaceAll("\\s", "");	//get rid of any spaces just in case
		gx = gx.replaceAll("\\s", "");	//get rid of any spaces just in case
		String delimiter = "((?<=cos)|(?=cos))|((?<=sin)|(?=sin))|((?<=tan)|(?=tan))|((?<=cxs)|(?=cxs))|((?<=sxn)|(?=sxn))|((?<=txn)|(?=txn))";
		String[] arrFX = fx.split(delimiter);	//split for easy parsing
		String[] arrGX = gx.split(delimiter);	//split for easy parsing
		
		//check what function the fx is
		if(arrFX[0].equals("sin")) {
			
			SinFunction sf = new SinFunction();
			fxdx = (sf.returnDerivative() + arrFX[1]);
			
		}//if
		else if(arrFX[0].equals("cos")) {
			
			CosFunction sf = new CosFunction();
			fxdx = (sf.returnDerivative() + arrFX[1]);
			
		}//else if
		else if(arrFX[0].equals("tan")) {
			
			TanFunction sf = new TanFunction();
			fxdx = (sf.returnDerivative() + arrFX[1]);
			
		}//else if
		else if(arrFX[0].equals("sxn")) {
			
			InvSinFunction sf = new InvSinFunction();
			fxdx = (sf.returnDerivative() + arrFX[1]);
			
		}//else if
		else if(arrFX[0].equals("cxs")) {
			
			InvCosFunction sf = new InvCosFunction();
			fxdx = (sf.returnDerivative() + arrFX[1]);
			
		}//else if
		else if(arrFX[0].equals("txn")) {
			
			InvTanFunction sf = new InvTanFunction();
			fxdx = (sf.returnDerivative() + arrFX[1]);
			
		}//else if
		else{}//else
		
		//check what function the gx is
		if(arrGX[0].equals("sin")) {
			
			SinFunction sf = new SinFunction();
			gxdx = (sf.returnDerivative() + arrGX[1]);
			
		}//if
		else if(arrGX[0].equals("cos")) {
			
			CosFunction sf = new CosFunction();
			gxdx = (sf.returnDerivative() + arrGX[1]);
			
		}//else if
		else if(arrGX[0].equals("tan")) {
			
			TanFunction sf = new TanFunction();
			gxdx = (sf.returnDerivative() + arrGX[1]);
			
		}//else if
		else if(arrGX[0].equals("sxn")) {
			
			InvSinFunction sf = new InvSinFunction();
			gxdx = (sf.returnDerivative() + arrGX[1]);
			
		}//else if
		else if(arrGX[0].equals("cxs")) {
			
			InvCosFunction sf = new InvCosFunction();
			gxdx = (sf.returnDerivative() + arrGX[1]);
			
		}//else if
		else if(arrGX[0].equals("txn")) {
			
			InvTanFunction sf = new InvTanFunction();
			gxdx = (sf.returnDerivative() + arrGX[1]);
			
		}//else if
		else {}//else
		
		//calculate the inside fx () is there is something
		if(!(arrFX[1].equals("(x)"))) {
			arrFX[1] = arrFX[1].replaceAll("[()]", "");	//get rid of any ()
			PowerRule pf = new PowerRule();
			fxdx += "(" + pf.calculateRule(arrFX[1]) + ")";
		}//if
		else {}//else
		
		//calculate the inside gx () is there is something
		if(!(arrGX[1].equals("(x)"))){
			if(arrGX[1].contains(")")){
				arrGX[1] = arrGX[1].replaceAll("[()]", "");	//get rid of any ()
				PowerRule pf = new PowerRule();
				gxdx += "(" + pf.calculateRule(arrGX[1]) + ")";
			}//if
			else {}//else
		}//if
		else {}//else
		
		//final result
		result = ((fxdx + gx) + " + " + (fx + gxdx));
		
		return result;
		
	}//calculateRule

	@Override
	public String calculateRule(String st) {
		// TODO Auto-generated method stub
		return null;
	}//calculateRule no use
	
}//ProductRule

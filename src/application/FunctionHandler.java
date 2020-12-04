package application;

import derivativefunction.SinFunction;
import derivativefunction.CosFunction;
import derivativefunction.TanFunction;
import derivativefunction.InvSinFunction;
import derivativefunction.InvCosFunction;
import derivativefunction.InvTanFunction;
import derivativefunction.EFunction;
import derivativefunction.NaturalLogFunction;
import derivativefunction.ExponentialFunction;
import derivativefunction.SqrtFunction;

public class FunctionHandler {

	/**
	 * Function that takes the given input and applies a function to it in order to get the derivative
	 * @param term - the String given from the parsed input
	 * @return result - the result of the derived term
	 */
	
	public String sinDeriv() { return new SinFunction().returnDerivative(); }
	public int sinDisplace() { return new SinFunction().displace(); }
	
	public String cosDeriv() { return new CosFunction().returnDerivative(); }
	public int cosDisplace() { return new CosFunction().displace(); }
	
	public String tanDeriv() { return new TanFunction().returnDerivative(); }
	public int tanDisplace() { return new TanFunction().displace(); }
	
	public String invSinDeriv() { return new InvSinFunction().returnDerivative(); }
	public int invSinDisplace() { return new InvSinFunction().displace(); }
	
	public String invCosDeriv() { return new InvCosFunction().returnDerivative(); }
	public int invCosDisplace() { return new InvCosFunction().displace(); }
	
	public String invTanDeriv() { return new InvTanFunction().returnDerivative(); }
	public int invTanDisplace() { return new InvTanFunction().displace(); }
	
	public String eDeriv() { return new EFunction().returnDerivative(); }
	public int eDisplace() { return new EFunction().displace(); }
	
	public String lnDeriv() { return new NaturalLogFunction().returnDerivative(); }
	public int lnDisplace() { return new NaturalLogFunction().displace(); }
	
	public String expDeriv(String base) { return new ExponentialFunction(base).returnDerivative(); }
	public int expDisplace(String base) { return new ExponentialFunction(base).displace(); }
	
	public String sqrtDeriv() { return new SqrtFunction().returnDerivative(); }
	public int sqrtDisplace() { return new SqrtFunction().displace(); }
	
	/*
	public String derive(String term) {
		if(term.equals("+") || term.equals("-"))
			return term;
		
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
	*/
	
}

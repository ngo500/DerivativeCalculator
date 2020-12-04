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

/**
 * Encapsulates all derivative functions for class use
 */

public class FunctionHandler {
	
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
	
}

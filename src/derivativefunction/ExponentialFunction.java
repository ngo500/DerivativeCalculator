package derivativefunction;

public class ExponentialFunction implements DerivativeFunction {

	private static String base;
	
	public ExponentialFunction(String base) {
		this.base = base;
	}
	
	@Override
	public int displace() {
		// TODO Auto-generated method stub
		return 3 + base.length() + 4 + base.length() + 1;
	}

	@Override
	public String returnDerivative() {
		// TODO Auto-generated method stub
		return "ln(" + base + ") * " + base + "^";
	}

}

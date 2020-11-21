package DerivativeFunction;

public class ExponentialFunction implements DerivativeFunction {

	private static int base;
	
	public ExponentialFunction(int base) {
		this.base = base;
	}
	
	@Override
	public int displace() {
		// TODO Auto-generated method stub
		return 3 + String.valueOf(base).length() + 3 + String.valueOf(base).length() + 1;
	}

	@Override
	public String returnDerivative() {
		// TODO Auto-generated method stub
		return "ln " + base + " * " + base + "^";
	}

}

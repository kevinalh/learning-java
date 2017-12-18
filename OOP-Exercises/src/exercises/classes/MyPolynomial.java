package exercises.classes;

public class MyPolynomial {
	public final double[] coeffs;
	
	public MyPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}
	
	public int getDegree() {
		if(coeffs.length > 1 || coeffs[0] != 0) {
			return coeffs.length - 1;
		}
		return Integer.MIN_VALUE;
	}
	
	@Override
	public String toString() {
		String rt = "";
		if(coeffs.length == 0) return rt;
		for(int i = this.coeffs.length - 1; i > 0; --i) {
			rt += String.format("%.2f", coeffs[i]) + "x";
			if(i > 1) {
				rt += "^" + i;
			}
			rt += "+";
		}
		rt += String.format("%.2f", this.coeffs[0]);
		return rt;
	}
	
	public double evaluate(double x) {
		double result = 0;
		for(int i = 0; i < coeffs.length; ++i) {
			result += coeffs[i] * Math.pow(x, i);
		}
		return result;
	}
	
	public MyPolynomial add(MyPolynomial right) {
		int newDegree = Math.max(this.getDegree()+1, right.getDegree()+1);
		double[] newPol = new double[newDegree];
		for(int i = 0; i < this.coeffs.length; ++i) {
			newPol[i] = this.coeffs[i];
		}
		for(int i = 0; i < Math.min(newDegree, right.getDegree())+1; ++i) {
			newPol[i] += right.coeffs[i];
		}
		return new MyPolynomial(newPol);
	}
	
}

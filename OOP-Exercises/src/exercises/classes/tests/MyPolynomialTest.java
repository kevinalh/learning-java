package exercises.classes.tests;

import exercises.classes.MyPolynomial;

public class MyPolynomialTest {
	public static void main(String[] args) {
		MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
		MyPolynomial p2 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
		double[] coeffs = {1.2, 3.4, 5.6, 7.8};
		MyPolynomial p3 = new MyPolynomial(coeffs);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p3: " + p3);
		System.out.println("p1's Degree: " + p1.getDegree());
		System.out.println("p2's Degree: " + p2.getDegree());
		System.out.println("p3's Degree: " + p3.getDegree());
		System.out.println("p1 + p2: " + (p1.add(p2)));
		System.out.println("p2 + p1: " + (p2.add(p1)));
		System.out.println("p3 + p1: " + (p3.add(p1)));
		System.out.println("p1 + p3: " + (p1.add(p3)));
		System.out.println("p3(1) = " + p3.evaluate(1));
		System.out.println("(p1 + p2)(3.1) = " + (p1.add(p2).evaluate(3.1)));
	}
}
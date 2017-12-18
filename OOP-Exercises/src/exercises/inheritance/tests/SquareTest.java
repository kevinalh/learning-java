package exercises.inheritance.tests;

import exercises.inheritance.GeometricObject;
import exercises.inheritance.Square;

public class SquareTest {

	public static void main(String[] args) {
		Square square = new Square(3.2, "yellow", true);
		square.setSide(6.1);
		System.out.println(square);
		System.out.println("Area of square: " + square.getArea());
		System.out.println("Perimeter of square: " + square.getPerimeter());
		square.setWidth(10.5);
		System.out.println("Side, width and length after change: " + square.getSide() +
				' ' + square.getWidth() + ' ' + square.getLength());
		GeometricObject s2 = new Square(9, "purple", false);
		System.out.println(s2);
		System.out.println("Area of s2: " + s2.getArea());
	}

}

package exercises.inheritance.tests;

import exercises.inheritance.ResizableCircle;

public class ResizableCircleTest {

	public static void main(String[] args) {
		ResizableCircle circle = new ResizableCircle(10.0);
		System.out.println("Radius of circle: " + circle.getRadius());
		circle.resize(120);
		System.out.println("New radius of circle: " + circle.getRadius());
		System.out.println("Area of circle: " + circle.getArea());
	}

}

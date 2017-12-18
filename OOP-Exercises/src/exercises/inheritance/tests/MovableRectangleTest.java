package exercises.inheritance.tests;

import exercises.inheritance.*;

public class MovableRectangleTest {

	public static void main(String[] args) {
		Movable rec = new MovableRectangle(3, 2, 5, 7, 4, 10);
		System.out.println(rec);
		rec.moveRight();
		rec.moveDown();
		System.out.println(rec);
	}

}

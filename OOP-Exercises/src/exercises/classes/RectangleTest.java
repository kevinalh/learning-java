package exercises.classes;

public class RectangleTest {
	public static void main(String[] args) {
		Rectangle fig = new Rectangle(3, 4);
		System.out.println(fig);
		System.out.println("Area: " + fig.getArea());
		System.out.println("Perimeter: " + fig.getPerimeter());
	}
}

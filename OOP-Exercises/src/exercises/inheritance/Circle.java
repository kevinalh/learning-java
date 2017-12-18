package exercises.inheritance;

public class Circle extends Shape implements GeometricObject {
	private double radius = 1.0;
	
	public Circle() {
		super();
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI*Math.pow(this.radius, 2);
	}
	
	@Override
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	
	@Override
	public String toString() {
		String rt = String.format("Circle with radius=%.2f, which is a subclass of ", this.radius);
		rt += super.toString();
		return rt;
	}
}

package exercises.inheritance;

public class Rectangle extends Shape implements GeometricObject {
	private double length = 1.0;
	private double width = 1.0;
	
	public Rectangle() {}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public Rectangle(double length, double width, String color, boolean filled) {
		super(color, filled);
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double getArea() {
		return this.length*this.width;
	}
	
	@Override
	public double getPerimeter() {
		return 2*this.length + 2*this.width;
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle with length=%.2f and width=%.2f,"
				+ " which is a subclass of %s", this.length, this.width, super.toString());
	}
}

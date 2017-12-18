package exercises.inheritance;

public class Cylinder {
	private double height = 1.0;
	private Circle base;
	
	public Cylinder() {
		this.base = new Circle();
	}
	
	public Cylinder(double radius, double height) {
		this.base = new Circle(radius);
		this.height = height;
	}
	
	public Cylinder(double radius, double height, String color) {
		this.base = new Circle(radius, color, true);
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getVolume() {
		return this.height * this.base.getArea();
	}
	
	@Override
	public String toString() {
		String rt = String.format("Cylinder of height %.2f with base a ", this.height);
		rt += this.base.toString();
		return rt;
	}
}

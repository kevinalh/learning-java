package exercises.inheritance;

public class CenteredCircle extends Circle {
	private Point center;
	
	public CenteredCircle() {
		super();
		this.center = new Point();
	}
	
	public CenteredCircle(double radius) {
		super(radius);
		this.center = new Point();
	}
	
	public CenteredCircle(double radius, String color, boolean filled) {
		super(radius, color, filled);
		this.center = new Point();
	}
	
	public CenteredCircle(double x, double y) {
		super();
		this.center = new Point(x, y);
	}
	
	public CenteredCircle(double x, double y, double radius) {
		super(radius);
		this.center = new Point(x, y);
	}
	
	public CenteredCircle(double x, double y, double radius, String color, boolean filled) {
		super(radius, color, filled);
		this.center = new Point(x, y);
	}
	
	public CenteredCircle(Point center, double radius, String color, boolean filled) {
		super(radius, color, filled);
		this.center = center;
	}
	
	public CenteredCircle(Point center, double radius) {
		super(radius);
		this.center = center;
	}
	
	public CenteredCircle(Point center) {
		super();
		this.center = center;
	}
	
	public void setCenter(double x, double y) {
		this.center.setXY(x, y);
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public Point getCenter() {
		return this.center;
	}
	
	@Override
	public String toString() {
		return "Centered [" + this.center.toString() + "] " + super.toString();
	}
}

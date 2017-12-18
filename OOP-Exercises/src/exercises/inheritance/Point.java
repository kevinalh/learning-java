package exercises.inheritance;

public class Point {
	double x = 0.0;
	double y = 0.0;
	
	public Point() {}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double[] getXY() {
		double[] rt = new double[2];
		rt[0] = this.x;
		rt[1] = this.y;
		return rt;
	}
	
	public void setXY(double x, double y) {
		setX(x);
		setY(y);
	}
	
	@Override
	public String toString() {
		return String.format("Point (%.2f, %.2f)", this.getX(), this.getY());
	}
}

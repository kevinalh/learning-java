package exercises.inheritance;

public class ResizableCircle extends Circle implements Resizable {

	public ResizableCircle() {
		super();
	}
	
	public ResizableCircle(double radius) {
		this.setRadius(radius);
	}
	
	@Override
	public double resize(int percent) {
		this.setRadius((this.getRadius() * (double) percent)/100.0);		
		return this.getRadius();
	}
	
}

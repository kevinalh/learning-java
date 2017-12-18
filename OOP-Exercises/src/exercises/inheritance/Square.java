package exercises.inheritance;

public class Square extends Rectangle {
	public Square() {
		super();
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public double getSide() {
		return this.getWidth();
	}
	
	public void setSide(double side) {
		super.setWidth(side);
		super.setLength(side);
	}
	
	@Override
	public void setLength(double length) {
		this.setSide(length);
	}
	
	@Override
	public void setWidth(double width) {
		this.setSide(width);
	}
	
	@Override
	public String toString() {
		String rt = String.format("Square with side=%.2f, which is a subclass of ", this.getSide());
		rt += super.toString();
		return rt;
	}
}

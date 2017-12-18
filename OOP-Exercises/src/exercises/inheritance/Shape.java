package exercises.inheritance;

abstract public class Shape {
	private String color = "red";
	private boolean filled = true;
	
	public Shape() {
		this.color = "green";
	}
	
	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return this.filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	@Override
	public String toString() {
		String rt = String.format("Shape of color %s and ", this.color);
		if(this.filled) {
			rt += "is filled";
		} else {
			rt += "isn't filled";
		}
		return rt;
	}

}

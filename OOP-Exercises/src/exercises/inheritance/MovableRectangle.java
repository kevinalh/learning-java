package exercises.inheritance;

public class MovableRectangle extends Rectangle implements Movable {

	MovablePoint topLeft;
	MovablePoint bottomRight;

	public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	public MovableRectangle(double x1, double y1, double x2, double y2, double xSpeed, double ySpeed) {
		this(x1, y1, x2, y2, xSpeed, ySpeed, "green", true);
	}

	public MovableRectangle(double x1, double y1, double x2, double y2, double xSpeed, double ySpeed, String color, boolean filled) {
		super(x2-x1, y2-y1, color, filled);
		this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
		this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
	}
	
	@Override
	public void moveUp() {
		this.bottomRight.moveUp();
		this.topLeft.moveUp();
	}

	@Override
	public void moveDown() {
		this.bottomRight.moveDown();
		this.topLeft.moveDown();
	}

	@Override
	public void moveLeft() {
		this.bottomRight.moveLeft();
		this.topLeft.moveLeft();
	}

	@Override
	public void moveRight() {
		this.bottomRight.moveRight();
		this.topLeft.moveRight();
	}

	@Override
	public String toString() {
		return super.toString() + ", top left point: " + this.topLeft.toString() + ", down right point: " + this.bottomRight.toString();
	}
	
}

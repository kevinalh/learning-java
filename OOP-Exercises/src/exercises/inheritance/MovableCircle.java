package exercises.inheritance;

public class MovableCircle extends CenteredCircle implements Movable {
	private MovablePoint center;
	
	public MovableCircle() {
		super(new MovablePoint());
		this.center = (MovablePoint) super.getCenter();
	}

	public MovableCircle(double radius) {
		super(new MovablePoint(), radius);
		this.center = (MovablePoint) super.getCenter();
	}

	public MovableCircle(double radius, String color, boolean filled) {
		super(new MovablePoint(), radius, color, filled);
		this.center = (MovablePoint) super.getCenter();
	}

	public MovableCircle(double x, double y) {
		super(new MovablePoint(x, y));
		this.center = (MovablePoint) super.getCenter();
	}

	public MovableCircle(double x, double y, double radius) {
		super(new MovablePoint(x, y), radius);
		this.center = (MovablePoint) super.getCenter();
	}

	public MovableCircle(double x, double y, double radius, String color, boolean filled) {
		super(new MovablePoint(x, y), radius, color, filled);
		this.center = (MovablePoint) super.getCenter();
	}

	public MovableCircle(MovablePoint center, double radius, String color, boolean filled) {
		super(center, radius, color, filled);
		this.center = center;
	}

	public MovableCircle(MovablePoint center, double radius) {
		super(center, radius);
		this.center = center;
	}

	public MovableCircle(MovablePoint center) {
		super(center);
		this.center = center;
	}
	
	public MovableCircle(double x, double y, double xSpeed, double ySpeed) {
		super(new MovablePoint(x, y, xSpeed, ySpeed));
		this.center = (MovablePoint) super.getCenter();
	}
	
	public MovableCircle(double x, double y, double xSpeed, double ySpeed, double radius) {
		super(new MovablePoint(x, y, xSpeed, ySpeed), radius);
		this.center = (MovablePoint) super.getCenter();
	}
	
	public MovableCircle(double x, double y, double xSpeed, double ySpeed, double radius, String color, boolean filled) {
		super(new MovablePoint(x, y, xSpeed, ySpeed), radius, color, filled);
		this.center = (MovablePoint) super.getCenter();
	}

	@Override
	public void moveUp() {
		this.center.moveUp();
	}

	@Override
	public void moveDown() {
		this.center.moveDown();
	}

	@Override
	public void moveLeft() {
		this.center.moveLeft();
	}

	@Override
	public void moveRight() {
		this.center.moveRight();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}

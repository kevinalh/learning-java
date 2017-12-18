package exercises.inheritance;

public class MovablePoint extends Point implements Movable {
	private double xSpeed = 1.0;
	private double ySpeed = 1.0;
	
	public MovablePoint() {}
	
	public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public MovablePoint(double x, double y) {
		super(x, y);
	}
	
	@Override
	public void moveUp() {
		this.y -= this.ySpeed;
	}

	@Override
	public void moveDown() {
		this.y += this.ySpeed;
	}

	@Override
	public void moveLeft() {
		this.x -= this.xSpeed;
	}

	@Override
	public void moveRight() {
		this.x += this.xSpeed;		
	}

	public double getxSpeed() {
		return this.xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return this.ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public String toString() {
		return super.toString() + String.format(" with velocities (%.2f, %.2f)", this.getxSpeed(), this.getySpeed());
	}
}

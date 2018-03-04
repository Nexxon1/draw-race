package game.components;

import game.environment.ScreenEdge;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Ball {
	private PApplet p;
	private PVector location;
	private PVector velocity;
	private boolean isLeft, isRight, isUp, isDown;
	private int size;
	
	public Ball(PApplet p, float x, float y) {
		this.p = p;
		location = new PVector(x, y);
		velocity = new PVector(0, 0);
	}
	
	public PVector getLocation() {
		return (this.location);
	}

	public void display(int ballColor, int size) {
		p.fill(ballColor);
		this.size = size;
		p.ellipse(location.x, location.y, this.size, this.size);
	}

	public void move(int velocity) {
		ScreenEdge edge = new ScreenEdge();
		edge.checkEdges(p, this);
		int right = (isRight) ? 1 : 0;
		int left = (isLeft) ? 1 : 0;
		int down = (isDown) ? 1 : 0;
		int up = (isUp) ? 1 : 0;
		
		int xVelocity = velocity * (right - left);
		int yVelocity = velocity * (down - up);
		
		this.velocity = new PVector(xVelocity, yVelocity);
		location.add(this.velocity);
		//location.x = location.x + velocity * (right - left);
		//location.y = location.y + velocity * (down - up);
	}

	public boolean setMove(char left, char up, char right, char down, boolean b) {
		if (p.key == left || p.key == Character.toUpperCase(left)) {
			return isLeft = b;
		} else if (p.key == up || p.key == Character.toUpperCase(up)) {
			return isUp = b;
		} else if (p.key == right || p.key == Character.toUpperCase(right)) {
			return isRight = b;
		} else if (p.key == down || p.key == Character.toUpperCase(down)) {
			return isDown = b;
		}
		return b;
	}

	//For Arrow Movement
	public boolean setMove(int left, int up, int right, int down, boolean b) {
		if (p.key == PConstants.CODED) {
			if (p.keyCode == left) {
				return isLeft = b;
			} else if (p.keyCode == up) {
				return isUp = b;
			} else if (p.keyCode == right) {
				return isRight = b;
			} else if (p.keyCode == down) {
				return isDown = b;
			}
		}
		return b;
	}

}

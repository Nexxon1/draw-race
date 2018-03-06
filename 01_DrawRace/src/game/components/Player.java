package game.components;

import game.environment.ScreenEdge;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;

public class Player {
	private PApplet p;
	private PVector location;
	private PVector velocity;
	private boolean isLeft, isRight, isUp, isDown;
	private String name;
	private int ballColor;
	private int size;
	private int playerNumber;
	
	ScreenEdge edge;
	ColorEmitter painter;
	PlayerIcon playerIcon;
	
	public Player(PApplet p, float x, float y, String name) {
		this.p = p;
		location = new PVector(x, y);
		velocity = new PVector(0, 0);
		this.name = name;
		painter = new ColorEmitter(p);
		edge = new ScreenEdge(p);
		playerIcon = new PlayerIcon(p);
	}
	
	public PVector getLocation() {
		return (this.location);
	}
	
	public int getColor() {
		return (this.ballColor);
	}
	
	public int getSize() {
		return (this.size);
	}

	public String getName() {
		return (this.name);
	}
	
	public int getPlayerNumber() {
		return (this.playerNumber);
	}
	
	public void initialize(int ballColor, int size, int playerNumber) {
		this.ballColor = ballColor;
		this.size = size;
		this.playerNumber = playerNumber;
		//p.fill(ballColor);
		//p.stroke(192);
		//p.noStroke();
		//p.ellipse(location.x, location.y, this.size, this.size);
	}

	public void move(int velocity) {
		painter.emitColor(this);
		edge.checkEdges(this);

		int right = (isRight) ? 1 : 0;
		int left = (isLeft) ? 1 : 0;
		int down = (isDown) ? 1 : 0;
		int up = (isUp) ? 1 : 0;
		
		int xVelocity = velocity * (right - left);
		int yVelocity = velocity * (down - up);
		
		this.velocity = new PVector(xVelocity, yVelocity);
		location.add(this.velocity);
		
		//Dirty! Playericon rendered here so it can be overlapped by the color emitter
		playerIcon.setPlayerIcon(this, location.x, location.y);
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

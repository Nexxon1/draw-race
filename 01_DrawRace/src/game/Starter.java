package game;

import game.components.Ball;
import processing.core.PApplet;

public class Starter extends PApplet {
	public int counter;
	public Ball player1;
	public Ball player2;

	public void settings() {
		size(800, 550);

	}

	public void setup() {
		player1 = new Ball(this, width / 8, height / 2);
		player2 = new Ball(this, width / 2, height / 2);

	}

	public void draw() {
		background(255);
		player1.display(color(0, 255, 0), 30);
		player1.move(5);
		player2.display(color(210), 30);
		player2.move(5);
		/*
		 * loadPixels(); for (int i = 0; i < pixels.length; i++) { pixels[i] =
		 * color(random(255), random(255), random(255)); counter ++; }
		 * System.out.println(counter); System.out.println(1920*1080); updatePixels();
		 */
	}

	public void keyPressed() {
		player1.setMove('a', 'w', 'd', 's', true);
		player2.setMove(LEFT, UP, RIGHT, DOWN, true);
	}

	public void keyReleased() {
		player1.setMove('a', 'w', 'd', 's', false);
		player2.setMove(LEFT, UP, RIGHT, DOWN, false);
	}

	public static void main(String[] args) {
		PApplet.main("game.Starter");

	}

}

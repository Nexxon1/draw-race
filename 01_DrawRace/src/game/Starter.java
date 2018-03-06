package game;

import game.components.Player;
import game.components.ColorCounter;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Starter extends PApplet {
	public int counter;
	public Player player1;
	public Player player2;
	public Player player3;
	public ColorCounter status;

	public void settings() {
		size(800, 550);
		//fullScreen();
	}

	public void setup() {
		background(255);
		player1 = new Player(this, width / 8, height / 2, "Marian");
		player1.initialize(color(0, 255, 0), 60, 1);
		player2 = new Player(this, width / 2, height / 2, "Mino");
		player2.initialize(color(255, 0, 0), 60, 2);
		player3 = new Player(this, width - 50, height / 2, "Hurensohn");
		player3.initialize(color(0, 0, 255), 60, 3);
		status = new ColorCounter(this, player1, player2, player3);
	}

	public void draw() {
		player1.move(10);
		player2.move(10);
		player3.move(8);
		status.getCurrentState();

		/*
		 * loadPixels(); for (int i = 0; i < pixels.length; i++) { pixels[i] =
		 * color(random(255), random(255), random(255)); counter ++; }
		 * System.out.println(counter); System.out.println(1920*1080); updatePixels();
		 */
	}

	public void keyPressed() {
		player1.setMove('a', 'w', 'd', 's', true);
		player2.setMove(LEFT, UP, RIGHT, DOWN, true);
		player3.setMove('k', 'o', 'ö', 'l', true);
		if(key == 'c') {
			background(255);
		}
	}

	public void keyReleased() {
		player1.setMove('a', 'w', 'd', 's', false);
		player2.setMove(LEFT, UP, RIGHT, DOWN, false);
		player3.setMove('k', 'o', 'ö', 'l', false);
	}

	public static void main(String[] args) {
		PApplet.main("game.Starter");

	}

}

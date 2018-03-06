package game.components;

import processing.core.PApplet;

public class ColorCounter {
	PApplet p;
	Player player1;
	Player player2;
	Player player3;

	public ColorCounter(PApplet p, Player player1, Player player2, Player player3) {
		this.p = p;
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
	}

	// TODO: Fix issue with Border Color (about 30% from the screen).
	public void getCurrentState() {
		int color1 = player1.getColor();
		int color2 = player2.getColor();
		int color3 = player3.getColor();
		int color1Counter = 0;
		int color2Counter = 0;
		int color3Counter = 0;
		int screenPx = p.width * p.height;
		System.out.println(screenPx);

		p.loadPixels();
		for (int i = 0; i < p.pixels.length; i++) {
			if (p.pixels[i] == color1) {
				color1Counter++;
			} else if (p.pixels[i] == color2) {
				color2Counter++;
			} else if (p.pixels[i] == color3) {
				color3Counter++;
			} else {
				// System.out.println("andere Farbe");
			}
		}
		double p1 = (color1Counter * 100) / screenPx;
		double p2 = (color2Counter * 100) / screenPx;
		double p3 = (color3Counter * 100) /screenPx;
		checkForWinner(p1, p2, p3);
		
		System.out.println("1: " + color1Counter);
		System.out.println("1: " + p1);
		System.out.println("2: " + color2Counter);
		System.out.println("2: " + p2);
		System.out.println("3: " + color3Counter);
		System.out.println("3: " + p3);
	}

	public void checkForWinner(double p1, double p2, double p3) {
		if (p1 > 40) {
			getWinner(player1);
		} else if (p2 > 40) {
			getWinner(player2);
		} else if (p3 > 40) {
			getWinner(player3);
		}
	}

	public void getWinner(Player player) {
		p.noLoop();
		System.out.println("Gewonnen hat: " + player.getName());
	}

}

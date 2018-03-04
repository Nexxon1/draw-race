package game.environment;

import game.components.Ball;
import processing.core.PApplet;
import processing.core.PVector;

public class ScreenEdge {

	public void checkEdges(PApplet p, Ball ball) {
		PVector location = ball.getLocation();
		if (location.x > p.width) {
			location.x = 0;
		}
		if (location.x < 0) {
			location.x = p.width;
		}
		if (location.y > p.height) {
			location.y = 0;
		}
		if (location.y < 0) {
			location.y = p.height;
		}
	}

}

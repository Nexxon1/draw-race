package game.environment;

import game.components.Player;
import processing.core.PApplet;
import processing.core.PVector;

public class ScreenEdge {
	PApplet p;	
	
	public ScreenEdge (PApplet p) {
		this.p = p;		
	}

	public void checkEdges(Player player) {
		PVector location = player.getLocation();
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

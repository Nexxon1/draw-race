package game.components;

import processing.core.PApplet;
import processing.core.PVector;

public class ColorEmitter {
	PApplet p;	
	
	public ColorEmitter (PApplet p) {
		this.p = p;		
	}
	
	public void emitColor(Player player) {
		PVector location = player.getLocation();
		int color = player.getColor();
		int size = player.getSize();
		
		p.fill(color);
		p.stroke(color);
		//Dirty! this for the Color to overlap the Player Icon
		p.ellipse(location.x, location.y, size+5, size+5);
	}

}

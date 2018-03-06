package game.components;

import processing.core.PApplet;
import processing.core.PImage;


public class PlayerIcon {
	PApplet p;
	PImage playerImage;
	
	public PlayerIcon (PApplet p) {
		this.p = p;
	}
	
	public void setPlayerIcon(Player player, float x, float y) {
		int playerNumber = player.getPlayerNumber();
		playerImage = p.loadImage("../img/player/Player" + playerNumber + ".png");
		//For same positioning logic as rectangles/ellipses/...
		p.imageMode(PImage.CENTER);
		p.image(playerImage, x, y);
	}
}

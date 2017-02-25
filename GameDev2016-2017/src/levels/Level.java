package levels;

import sounds.Sound;
import sprites.Sprite;

/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 11 September 2016
 ****************************
 * A level abstract.
 */
public abstract class Level {
	//level objects
	private java.util.List<Sprite> $sprites;
	private java.util.List<Sound> $sounds;
	
	//these are our game loop methods
	
	//initialization
	public abstract void init();
	//draw our sprites and play our sounds
	public abstract void act();
	//polling and physics calculations
	public abstract void handle();
	
	//both assume lists are not null
	public void addSprite(Sprite $sprite){
		$sprites.add($sprite);
	}
	public void addSound(Sound $sound){
		$sounds.add($sound);
	}
	
	//getters and setters
	public java.util.List<Sprite> getSprites() {
		return $sprites;
	}
	public void setSprites(java.util.List<Sprite> $sprites) {
		this.$sprites = $sprites;
	}
	public java.util.List<Sound> getSounds() {
		return $sounds;
	}
	public void setSounds(java.util.List<Sound> $sounds) {
		this.$sounds = $sounds;
	}
}

package sounds;
/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 11 September 2016
 ****************************
 * A sound abstract.
 */
public abstract class Sound {
	//path to the sound file
	private String $path;

	//play the sound
	public abstract void playSound();
	
	//getters and setters for the path
	public String getFilePath() {
		return $path;
	}
	public void setFilePath(String $path) {
		this.$path = $path;
	}
}

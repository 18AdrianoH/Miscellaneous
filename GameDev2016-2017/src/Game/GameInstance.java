package Game;
import levels.Level;

/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 11 September 2016
 ****************************
 * An instance of a game.
 */
public abstract class GameInstance extends javafx.application.Application{
	
	private java.util.List<Level> $levels;
	
	//starts your instance of game, is called by "launch(args)"
	@Override
	public abstract void start(javafx.stage.Stage arg0) throws Exception;
	
	//game loop methods
	public abstract void init();
	public abstract void refresh();
	public abstract void draw();

	protected java.util.List<Level> getLevels() {
		return $levels;
	}
	protected void setLevels(java.util.List<Level> $levels) {
		this.$levels = $levels;
	}
	protected void setLevels(Level...$levels) {
		this.$levels = java.util.Arrays.asList($levels);
	}
}

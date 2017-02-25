package levels;

/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 15 September 2016
 ****************************
 * A level factory: any level factory can create a level using it's create level method.
 * A reader type level factory will have an instance of file reader which will read the lines
 * of the level file.
 */
public interface LevelFactory {
	public Level createLevel();
}

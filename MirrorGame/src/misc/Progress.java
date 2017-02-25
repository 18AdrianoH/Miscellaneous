package misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * @author Adriano
 * Reads a single line that tells you the level you are on.
 */
public class Progress {
	private final String PATH = "/misc/Progress.txt";
	private List<String> docText() throws IOException{
		return Files.readAllLines(Paths.get(PATH));
	}
	//never get rid of the space, since we read the number right after it
	public int getCurrentLevel() throws IOException{
		String str = docText().get(0);
		return Integer.parseInt(str.substring(str.indexOf(" ")+1,str.length()));
	}
	
}

package misc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import levels.Level;

/**
 * Remembers the game settings.
 * Ignore lines with "#" as they are comments.
 * @author Adriano
 *
 */
public class Settings {
	
	private final String PATH = "/misc/Settings.txt";
	//gets list of the lines in a file
	private List<String> docText() throws IOException{
		return Files.readAllLines(Paths.get(PATH));
	}
	//writes the given list to a file
	public void writeFile(List<String> lines) throws IOException{
		Path file = Paths.get(PATH);
		Files.write(file, lines , Charset.forName("UTF-8"));
	}
	//simplifies the lines by removing comments and empty lines
	//
	private void simplifyLines(List<String> ls){
		for(int i = ls.size()-1; i >1 ; i--){
			//remove comments
			String str = ls.get(i);
			ls.set(i, str.substring(0,str.indexOf("#")));
			//remove empty lines
			if(str.equals("")) ls.remove(i);
		}
	}
	private void parse(List<String> ls){
		simplifyLines(ls);
		
	}
	
	public int getResoX(){
		
	}
	public int getResoX(){
		
	}
	
	public void setReso(int x, int y) throws IOException{
		List<String> ls = docText();
		ls.set(5, "Resolution: " + Integer.toString(x) + " by " + Integer.toString(y) + "		#width, length");
	}
}

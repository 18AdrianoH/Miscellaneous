package util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 15 September 2016
 ****************************
 * A file writing class.
 * This can be instantiated inside a level writer class: one which would write level files
 * from a level object.  This can be implemented later.
 */
public class FileWriter {
	private String $path;
	private List<String> $lines;
	
	public FileWriter(String path, List<String> lines) {
		setPath(path);
		setLines(lines);
	}
	public void writeFile(){
		Path file = Paths.get(getPath());
		try {
			Files.write(file, getLines(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FAILED TO WRITE TO FILE");
			e.printStackTrace();
		}
	}
	
	public String getPath() {
		return $path;
	}
	public void setPath(String $path) {
		this.$path = $path;
	}
	public List<String> getLines() {
		return $lines;
	}
	public void setLines(List<String> $lines) {
		this.$lines = $lines;
	}
}

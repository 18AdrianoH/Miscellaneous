package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 15 September 2016
 ****************************
 * A file reading class.
 */
public class FileReader {

	private String $path;
	public FileReader(String path) {
		setPath(path);
	}
	public List<String> lines(){
		try {
			return Files.readAllLines(Paths.get(getPath()));
		} catch (IOException e) {
			System.out.println("FAILED TO READ FILE");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getPath() {
		return $path;
	}
	public void setPath(String $path) {
		this.$path = $path;
	}

}

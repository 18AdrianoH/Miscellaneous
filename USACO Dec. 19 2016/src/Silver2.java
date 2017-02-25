import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ID: 18AdrianoH
 * LANG: JAVA
 * TASK: 2nd Problem
 */
public class Silver2 {
	
	public static List<String> lines(String path) throws IOException{
		return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
	}
	public static void main(String[] args) throws IOException {
		List<String> lines = lines("citystate.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		StringTokenizer tokenizer = new StringTokenizer(lines.get(0));
		int n = Integer.parseInt(tokenizer.nextToken());
		HashMap<String,String> citystates = new HashMap<>();
		List<String> cities = new ArrayList<>();
		List<String> states = new ArrayList<>();
		
		for(int i = 1; i < lines.size(); i++){
			tokenizer = new StringTokenizer(lines.get(i));
			String city = tokenizer.nextToken();
			String state = tokenizer.nextToken();
			citystates.put(city.substring(0,2), state);
			cities.add(city);
			states.add(state);
		}

		int num = 0;
		for(int i = cities.size() -1; i >= 0; i--){
			if(citystates.containsKey(states.get(i))){
				if(citystates.get(states.get(i)).equals(cities.get(i).substring(0,2))){
					num++;
				}
			}
			citystates.remove(cities.get(i).substring(0,2));
			cities.remove(i);
			states.remove(i);
		}
		
		out.println(num);
		out.close();
	}
}

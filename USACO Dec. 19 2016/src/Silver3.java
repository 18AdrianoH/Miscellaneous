import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ID: 18AdrianoH
 * LANG: JAVA
 * TASK: 3rd Problem
 */
public class Silver3 {
	public static class Node{
		Cow cow;
		List<Cow> reached;
	}
	public static class Cow{
		int x;
		int y;
		int p;
	}
	//distance between two points
	public static double distance(int x1, int y1, int x2, int y2){
		if(y1 == y2) return Math.abs(x1-x2);
		if(x1 == x2) return Math.abs(y1-y2);
		else return Math.sqrt(Math.pow((double)(x1-x2), 2) + Math.pow((double)(y1-y2),2));
	}
	
	public static List<String> lines(String path) throws IOException{
		return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
	}
	
	
	public static void main(String[] args) throws IOException {
		List<String> lines = lines("moocast.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		StringTokenizer tokenizer = new StringTokenizer(lines.get(0));
		
		//number of cows
		int n = Integer.parseInt(tokenizer.nextToken());
		Node cows = new Node();
		
		for(int i = 1; i < lines.size(); i++){
			tokenizer = new StringTokenizer(lines.get(i));
			int x = Integer.parseInt(tokenizer.nextToken()); //x position
			int y = Integer.parseInt(tokenizer.nextToken()); //y position
			int p = Integer.parseInt(tokenizer.nextToken()); //power (radius)
			
			Cow c = new Cow();
			c.p = p;
			c.x = x;
			c.y = y;
			Node nd = new Node();
			nd .cow = c;
			
			
		}
		
		out.close();
	}
}

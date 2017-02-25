import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ID: 18AdrianoH
 * LANG: JAVA
 * TASK: 3rd Problem
 */

public class Problem3 {
	
	public static List<String> lines(String path) throws IOException{
		return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
	}
	
	public static String reformat(String line, int k){
		String nl = "";
		for(int i = 0; i < line.length(); i++){
			for(int r = 0; r < k; r++){
				nl += line.substring(i, i+1);
			}
		}
		return nl;
	}
	public static List<String> newLines(List<String> lines, int k){
		List<String> newLines = new ArrayList<String>();
		
		for(int i = 1; i < lines.size(); i++){
			String nl = reformat(lines.get(i),k);
			for(int r = 0; r < k; r++){
				newLines.add(nl);
			}
		}
		
		return newLines;
		
	}
	
	public static void main(String[] args) throws IOException{
		List<String> lines = lines("cowsignal.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		StringTokenizer firstLine = new StringTokenizer(lines.get(0));
		firstLine.nextToken();
		firstLine.nextToken();
		int k = Integer.parseInt(firstLine.nextToken());
		
		lines = newLines(lines,k);
		
		for(int i = 0; i < lines.size(); i++){
			out.println(lines.get(i));
		}
		out.close();
	}
}

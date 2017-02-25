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
 * TASK: 1st Problem
 */
public class Problem1 {

	public static List<String> lines(String path) throws IOException{
		return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
	}
	public static void main(String[] args) throws IOException {
		List<String> lines = lines("square.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		StringTokenizer firstLine = new StringTokenizer(lines.get(0));
		StringTokenizer secondLine = new StringTokenizer(lines.get(1));
		
		int r1x1 = Integer.parseInt(firstLine.nextToken());
		int r1y1 = Integer.parseInt(firstLine.nextToken());
		int r1x2 = Integer.parseInt(firstLine.nextToken());
		int r1y2 = Integer.parseInt(firstLine.nextToken());
		
		int r2x1 = Integer.parseInt(secondLine.nextToken());
		int r2y1 = Integer.parseInt(secondLine.nextToken());
		int r2x2 = Integer.parseInt(secondLine.nextToken());
		int r2y2 = Integer.parseInt(secondLine.nextToken());
		
		int width = Math.abs(Math.max(r1x2, r2x2) - Math.min(r1x1, r2x1));
		int length = Math.abs(Math.max(r1y2, r2y2) - Math.min(r1y1, r2y1));
		int area = (int) Math.pow(Math.max(length, width),2);
				
		out.println(area);
		out.close();
	} 

}
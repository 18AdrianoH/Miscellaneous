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
 * LANG: JAVA0
 * TASK: 1st Problem
 */
public class Silver1 {
	public static List<String> lines(String path) throws IOException{
		return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
	}
	public static void main(String[] args) throws IOException {
		List<String> lines = lines("haybales.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		
		//get from the first line
		StringTokenizer tokenizer = new StringTokenizer(lines.get(0));
		
		int n = Integer.parseInt(tokenizer.nextToken()); //number of haybales
		int q = Integer.parseInt(tokenizer.nextToken()); //number of queries
		
		//get from the second line
		tokenizer = new StringTokenizer(lines.get(1));
		List<Integer> locations = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			int c = Integer.parseInt(tokenizer.nextToken());
			locations.add(c);
		}
		//analyse rest of queries
		for(int i = 2; i < lines.size(); i++){
			//get the two endpoints
			tokenizer = new StringTokenizer(lines.get(i));
			int left = Integer.parseInt(tokenizer.nextToken());
			int right = Integer.parseInt(tokenizer.nextToken());
			int temp = Math.max(left, right); //right close
			left = Math.min(left, right);
			right = temp;
			
			int num = 0; //numhaybales
			for(int k = 0; k < locations.size(); k++){
				int l = locations.get(k);
				if(l >= left && l <= right){
					num+=1;
				}
			}
			out.println(num);
		}
		out.close();
	}
}
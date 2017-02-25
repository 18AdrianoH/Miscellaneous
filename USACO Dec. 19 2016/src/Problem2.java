import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * ID: 18AdrianoH
 * LANG: JAVA
 * TASK: 2nd Problem
 */
public class Problem2 {
	
	public static List<String> lines(String path) throws IOException{
		return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
	}
	public static void main(String[] args) throws IOException {
		List<String> lines = lines("blocks.in");
		int N = Integer.parseInt(lines.get(0));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		//each position +1 corresponds to that letter (since in java and many languages position goes from 0, not 1)
		//a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
		//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
		int[] letters = new int[26];
		for(int i = 1; i < lines.size(); i++){
			String line = lines.get(i);
			int[] lettersFront = new int[26];
			int[] lettersBack = new int[26];
			char letter;
			
			for(int l = 0; l < line.indexOf(" "); l++){
				letter = line.substring(l, l+1).charAt(0);
				if(letter == 'a') lettersFront[0] += 1;
				if(letter == 'b') lettersFront[1] += 1;
				if(letter == 'c') lettersFront[2] += 1;
				if(letter == 'd') lettersFront[3] += 1;
				if(letter == 'e') lettersFront[4] += 1;
				if(letter == 'f') lettersFront[5] += 1;
				if(letter == 'g') lettersFront[6] += 1;
				if(letter == 'h') lettersFront[7] += 1;
				if(letter == 'i') lettersFront[8] += 1;
				if(letter == 'j') lettersFront[9] += 1;
				if(letter == 'k') lettersFront[10] += 1;
				if(letter == 'l') lettersFront[11] += 1;
				if(letter == 'm') lettersFront[12] += 1;
				if(letter == 'n') lettersFront[13] += 1;
				if(letter == 'o') lettersFront[14] += 1;
				if(letter == 'p') lettersFront[15] += 1;
				if(letter == 'q') lettersFront[16] += 1;
				if(letter == 'r') lettersFront[17] += 1;
				if(letter == 's') lettersFront[18] += 1;
				if(letter == 't') lettersFront[19] += 1;
				if(letter == 'u') lettersFront[20] += 1;
				if(letter == 'v') lettersFront[21] += 1;
				if(letter == 'w') lettersFront[22] += 1;
				if(letter == 'x') lettersFront[23] += 1;
				if(letter == 'y') lettersFront[24] += 1;
				if(letter == 'z') lettersFront[25] += 1;
			}
			for(int l = line.indexOf(" "); l < line.length(); l++){
				letter = line.substring(l, l+1).charAt(0);
				if(letter == 'a') lettersBack[0] += 1;
				if(letter == 'b') lettersBack[1] += 1;
				if(letter == 'c') lettersBack[2] += 1;
				if(letter == 'd') lettersBack[3] += 1;
				if(letter == 'e') lettersBack[4] += 1;
				if(letter == 'f') lettersBack[5] += 1;
				if(letter == 'g') lettersBack[6] += 1;
				if(letter == 'h') lettersBack[7] += 1;
				if(letter == 'i') lettersBack[8] += 1;
				if(letter == 'j') lettersBack[9] += 1;
				if(letter == 'k') lettersBack[10] += 1;
				if(letter == 'l') lettersBack[11] += 1;
				if(letter == 'm') lettersBack[12] += 1;
				if(letter == 'n') lettersBack[13] += 1;
				if(letter == 'o') lettersBack[14] += 1;
				if(letter == 'p') lettersBack[15] += 1;
				if(letter == 'q') lettersBack[16] += 1;
				if(letter == 'r') lettersBack[17] += 1;
				if(letter == 's') lettersBack[18] += 1;
				if(letter == 't') lettersBack[19] += 1;
				if(letter == 'u') lettersBack[20] += 1;
				if(letter == 'v') lettersBack[21] += 1;
				if(letter == 'w') lettersBack[22] += 1;
				if(letter == 'x') lettersBack[23] += 1;
				if(letter == 'y') lettersBack[24] += 1;
				if(letter == 'z') lettersBack[25] += 1;
			}
			for(int l = 0; l < 26; l++){
				letters[l] += Math.max(lettersBack[l], lettersFront[l]);
			}
			
		}
		for(int i = 0; i < 26; i++){
			out.println(letters[i]);
		}
		out.close();
	}

}

package misc;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import utilities.BigInteger;

public class Problem13 {

	public Problem13() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		try{
			String temp = readFile("./src/misc/Problem13Numbers.txt", StandardCharsets.UTF_8);
			String file = new String("");
			BigInteger[] nums = new BigInteger[100];
			for(int i = 0; i < temp.length(); i++){
				if(isNumber(temp.substring(i, i+1))) file += temp.substring(i,i+1);
			}
			//System.out.print("file is " + file);
			int index = 0;
			for(int i = 0; i < file.length()-49; i+= 50){
				nums[index] = new BigInteger(file.substring(i, i+50));
				index++;
			}
			//testing - NVM
			BigInteger sum = new BigInteger(0);
			for(BigInteger bigInt: nums){
				//System.out.println(bigInt);
				sum = BigInteger.add(sum, bigInt);
				//System.out.println(bigInt.getLength());
			}
			System.out.println("sum is " + sum);
			System.out.println("first ten digits are " + sum.toString().substring(0, 10));
		}
		catch(Exception e){
			System.out.println("You fail");
			e.printStackTrace();
		}
	}
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	static boolean isNumber(String num){
		return ((num.equals("0")) || (num.equals("1")) || (num.equals("2")) || (num.equals("3")) ||
				(num.equals("4")) || (num.equals("5")) || (num.equals("6")) || (num.equals("7")) || 
				(num.equals("8")) || (num.equals("9")));
	}

}

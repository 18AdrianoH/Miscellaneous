package src;

import java.io.StringReader;

public class ScannerTester {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		StringReader reader = new StringReader("This is a string.  Blah blah blah.");
		Scanner scanner = new Scanner(reader); 
		
		while(scanner.hasNextToken())
		{
			System.out.println(scanner.nextToken().getValue());
		}
	}

}

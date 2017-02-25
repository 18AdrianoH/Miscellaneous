package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class Tester 
{
	/**
	public static void main(String[]args)
	{
		//StringReader reader = 
				//new StringReader("Hi there.  This is a String.  Blah blah blah.");
		//Scanner scanner = new Scanner(reader);
		//Document doc = new Document(scanner);
		//System.out.println();
		
		// The name of the file to open.
        String fileName = "mystery1.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	**/
	public static void main(String[]args){
		BufferedReader reader;
		try {
			//System.out.println("going to begin test...");
			reader = new BufferedReader(new FileReader("./src/src/Parsing_Test.txt"));
			//System.out.println("created buffer reader");
			Scanner scanner = new Scanner(reader); 
			//System.out.println("created scanner, is " + scanner);
			Document doc = new Document(scanner);
			//System.out.println("created document, is " + doc);
			doc.parseDocument();
			System.out.println("parsed through document, gonna print first sentence");
			System.out.println("Sentences: " + doc.getSentences());
			System.out.println("First Sentence: " + doc.getSentences().get(0).toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
}

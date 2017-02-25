package src;
import java.util.ArrayList;
/**
 * 
 */
import java.util.List;

import src.Scanner.TOKEN_TYPE;

/**
 * 
 * @author Adriano Hernandez
 * @version 1.0
 * @date 4 February 2016
 */
public class Document 
{
	/**
	 *  These are our instance variables.  We hold the current spot on the
	 *  document up from sentence to phrase and down to token.  We also remember
	 *  a list of all the sentences in the document and we hold an instance
	 *  of the scanner that will help scan through the documents.  The boolean
	 *  endOfFile helps more easily check for end of file since checking token type everytime
	 *  is not convenient.
	 */
	int n = 0;
	//current
	private Token currentToken;
	//sentence list
	private List<Sentence> sentences;
	//end of file and scanner
	private Scanner scanner;
	private boolean endOfFile;
	
	/**
	 * This is the constructor.  It takes in a scanner which we make our own
	 * and instantiates our current phrase and sentence to be nothing.  It also
	 * creates our list of sentences and sets endOfFile to false.  Then it advances one token
	 * to begin the scanning of the document.
	 */
	public Document(Scanner scanner){
		
		this.scanner = scanner;
		getNextToken();
		
		endOfFile = false;
		sentences = new ArrayList<Sentence>();
		
		
	}
	//this class is responsible for handling 
	//the scanning and parsing of the document
	
	/**
	 * Analogous to getNextChar() from scanner.  This function iterates us forward one token
	 * in the document.  If we reach the end of the file it will set endOfFile to true.
	 */
	private void getNextToken()
	{
		Token s = scanner.nextToken();
		if(s.getType() == TOKEN_TYPE.END_OF_FILE)
		{
			System.out.println("end of file");
			endOfFile = true;
		}
		else
		{
			System.out.println(s.getType());
			currentToken = s;
		}
	}
	/**
	 * check whether t and token are the same, and if so then move forward
	 * @param t is the token we are comparing to our current token
	 */
	public void eat(Token t)
	{
		if(t.equals(currentToken))
		{
			getNextToken();
		}
		else
		{
			throw new RuntimeException();
		}
	}
	
	
	
	/**
	 * parse through a phrase
	 * to our current phrase.
	 */
	//it can't tell if it's at the end of file
	public Phrase parsePhrase(){
		Phrase currentPhrase = new Phrase();
		while(!endOfFile && currentToken.getType() != TOKEN_TYPE.END_OF_FILE && 
				currentToken.getType() != TOKEN_TYPE.END_OF_PHRASE && 
				currentToken.getType() != TOKEN_TYPE.END_OF_SENTENCE)
		{
			//System.out.println("eating");
			if(currentToken.getType() == TOKEN_TYPE.WORD){
				currentPhrase.addToken(currentToken);
			}
			//System.out.println(currentToken);
			//System.out.println(currentToken.getType());
			eat(currentToken);
		}
		return currentPhrase;
	}
	/**
	 * parses through a sentence
	 * @return the new current sentence
	 */
	public Sentence parseSentence(){
		Sentence currentSentence = new Sentence();
		while(!endOfFile && !(currentToken.getType() == TOKEN_TYPE.END_OF_SENTENCE))
		{
			System.out.println("adding parse phrase");
			currentSentence.addPhrase(parsePhrase());
			if(currentToken.getType() == TOKEN_TYPE.END_OF_PHRASE) eat(currentToken);	
		}
		return currentSentence;
	}
	/**
	 * parses through the entire document by parsing all the sentences until
	 * we reach the end of the file.
	 */
	//fix to make it ignore leading tokens  that are not words
	public void parseDocument(){
		//if(currentToken == null)
		System.out.println(currentToken);
		while(!endOfFile && currentToken.getType() != TOKEN_TYPE.END_OF_FILE)
		{
			n++;
			//System.out.println("parsing sentence");
			//System.out.println(sentences);
			
			//this is for mystery1.txt
			
			if(currentToken.getType() == TOKEN_TYPE.WORD){
				//System.out.println(sentences);
				System.out.println("adding parse sentence to sentence" + "Sentence: " + n);
				sentences.add(parseSentence());
			}
			else{
				System.out.println("eat current token inside parse doc");
				eat(currentToken);
			}
		}
		//System.out.println(sentences);
	}
	/**
	 * @return all the sentences in the document that we have in our list
	 * as of now
	 */
	public List<Sentence> getSentences(){
		return sentences;
	}
}

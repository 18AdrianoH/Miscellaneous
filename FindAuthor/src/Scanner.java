package src;
/**
 * 
 */
import java.io.IOException;
import java.io.Reader;

/**
 * A Scanner is responsible for reading an input stream, one character at a
 * time, and separating the input into tokens.  A token is defined as:
 *  1. A 'word' which is defined as a non-empty sequence of characters that 
 *     begins with an alpha character and then consists of alpha characters, 
 *     numbers, the single quote character "'", or the hyphen character "-". 
 *  2. An 'end-of-sentence' delimiter defined as any one of the characters 
 *     ".", "?", "!".
 *  3. An end-of-file token which is returned when the scanner is asked for a
 *     token and the input is at the end-of-file.
 *  4. A phrase separator which consists of one of the characters ",",":" or
 *     ";".
 *  5. A digit.
 *  6. Any other character not defined above.
 * @author Mr. Page
 *
 */

public class Scanner
{
    private Reader in;
    private String currentChar;
    private boolean endOfFile;
    // define symbolic constants for each type of token
    public static enum TOKEN_TYPE{WORD, END_OF_SENTENCE, END_OF_FILE, 
        END_OF_PHRASE, DIGIT, UNKNOWN};
    /**
     * Constructor for Scanner objects.  The Reader object should be one of
     *  1. A StringReader
     *  2. A BufferedReader wrapped around an InputStream
     *  3. A BufferedReader wrapped around a FileReader
     *  The instance field for the Reader is initialized to the input parameter,
     *  and the endOfFile indicator is set to false.  The currentChar field is
     *  initialized by the getNextChar method.
     * @param in is the reader object supplied by the program constructing
     *        this Scanner object.
     */
    public Scanner(Reader in)
    {
        this.in = in;
        endOfFile = false;
        getNextChar();
    }
    /**
     * The getNextChar method attempts to get the next character from the input
     * stream.  It sets the endOfFile flag true if the end of file is reached on
     * the input stream.  Otherwise, it reads the next character from the stream
     * and converts it to a Java String object.
     * @postcondition: The input stream is advanced one character if it is not at
     * end of file and the currentChar instance field is set to the String 
     * representation of the character read from the input stream.  The flag
     * endOfFile is set true if the input stream is exhausted.
     */
    private void getNextChar()
    {
        try
        {
            int inp = in.read();
            if(inp == -1) 
                endOfFile = true;
            else 
                currentChar = "" + (char) inp;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    /**
     * Compare string to current char, if they are equal call getNextChar; otherwise,
     *         throw an illegal argument exception.
     * @param string is our parameter we are comparing to our currentChar
     */
    public void eat(String string)
    {
    	if(string.compareTo(currentChar) == 0)
    		getNextChar();
    	else
    		throw new IllegalArgumentException();
    }
    
    /**
     * check if the string is a letter
     * @param param is what we are checking
     * @return true if param is a letter; otherwise,
     *         false.
     */
    private boolean isLetter(String param){
    	if((param.compareTo("a") >= 0 && param.compareTo("z") <= 0)
    			|| (param.compareTo("A") >= 0 && param.compareTo("Z") <= 0))
    	{
    		return true;
    	}
    	return false;
    }
    /**
     * check if the string is a digit
     * @param param is what we are checking
     * @return true if param is a digit; otherwise,
     *         false.
     */
    private boolean isDigit(String param){
    	if(param.compareTo("0") >= 0 && param.compareTo("9") <= 0)
    	{
    		return true;
    	}
    	return false;
    }
    /**
     * check if the string is the end of a phrase (, or ;)
     * @param param is what we are checking
     * @return true if param is a phrase terminator; otherwise,
     *         false.
     */
    private boolean isPhraseTerminator(String param){
    	return param.equals(",") || param.equals(";");
    }
    /**
     * check if the string is the end of a sentence (! or ? or .)
     * @param param is what we are checking
     * @return true if param is a sentence terminator; otherwise,
     *         false.
     */
    private boolean isSentenceTerminator(String param){
    	return param.equals("!") || param.equals("?") || param.equals(".");
    }
    /**
     * check if the string is a white space
     * @param param is what we are checking
     * @return true if param is a white space; otherwise,
     *         false.
     */
    private boolean isWhiteSpace(String param){
    	return param.equals(" ") || param.equals("\t") || param.equals("\n");
    }
    /**
     * A special character consists of a single quote or a hyphen
     * @param param is what we are checking
     * @return true if param is a special character; otherwise,
     *         false.
     */
    private boolean isSpecialCharacter(String param){
    	return param.equals("-") || param.equals("\"");
    }
 /*   private boolean isUnknownToken(String param){
    	return !isLetter(param) && ! isDigit(param) && !isPhraseTerminator(param)
    			&& !isSentenceTerminator(param) && !isWhiteSpace(param);
    }*/
    
    /**
     * Find if there are more tokens in the input stream, when there
     * are no more tokens then we are at the end of the file.
     * @return true if there is a next token; otherwise,
     *         false.
     */
    public boolean hasNextToken()
    {
    	return !endOfFile;
    }
    /**
     * This is going to work how an iterator would work.  That is to say, that
     * if the token after our current char is null it doesn't matter, next is defined
     * as our current character.
     * @return current token.
     */
    //fix this
    public Token nextToken()
    {
    	//System.out.println("nextToken");
    	while(isWhiteSpace(currentChar))
    	{
    		//System.out.println("eating whitespaces");
    		eat(currentChar);
    		if(endOfFile) break;
    	}
    	
    	String next = currentChar;
    	if(endOfFile){
    		System.out.println("end of file");
    		return new Token(TOKEN_TYPE.END_OF_FILE,next);
    	}
    	
    	//else
    	TOKEN_TYPE t = TOKEN_TYPE.UNKNOWN;
    	
    	if(isLetter(next)){
    		t = TOKEN_TYPE.WORD;
        	//this is words or numbers where we need to pick up the entire thing
        	next = "";
        	while(isLetter(currentChar) || isDigit(currentChar) || isSpecialCharacter(currentChar))
        	{
        			next += currentChar;
            		eat(currentChar);
        	}
        	return new Token(t,next.toLowerCase());
    	}
    	if(isDigit(next)){
    		t = TOKEN_TYPE.DIGIT;
    		eat(currentChar);
    		return new Token(t,next);
    	}
    	//add special return statement
    	if(isPhraseTerminator(next)){
    		t = TOKEN_TYPE.END_OF_PHRASE;
    		eat(currentChar);
    		return new Token(t,next);
    	}
    	if(isSentenceTerminator(next)){
    		t = TOKEN_TYPE.END_OF_SENTENCE;
    		eat(currentChar);
    		return new Token(t,next);
    	}
    	next = currentChar;
    	eat(currentChar);
    	return new Token(t, next);
    }
}

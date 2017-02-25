package src;

import java.util.ArrayList;
/**
 * 
 */
import java.util.List;

/**
 * 
 * @author Adriano Hernandez
 * @version 1.0
 * @date 4 February 2016
 */
public class Phrase 
{
	//justification below
	private List<Token> tokens;
	
	/**
	 * ArrayLists are fast for accessing different indexed values;
	 * furthermore, iterating through them is easy.  
	 * This is why I chose an ArrayList.
	 */
	public Phrase()
	{
		tokens = new ArrayList<Token>();
	}
	/**
	 * adds a token to our list of tokens that make up this phrase
	 * @param token is the token we are adding to this phrase
	 */
	public void addToken(Token token)
	{
		tokens.add(token);
	}
	/**
	 * @return the list of tokens that make this up
	 */
	public List<Token> getTokens()
	{
		return tokens;
	}
	/**
	 * @return a string describing this phrase; it prints the toString
	 * for each token in it so it might be changed later due to alck of practicality, but
	 * it is very specific.
	 */
	public String toString()
	{
		String to = "";
		for(Token t: tokens)
		{
			to += t.toString() + " ";
		}
		return to;
	}
}

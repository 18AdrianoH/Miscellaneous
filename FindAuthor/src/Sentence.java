package src;
import java.util.ArrayList;
/**
 * 
 */
import java.util.List;

/**
 * @author Adriano Hernandez
 * @version 1.0
 * @date 4 February 2016
 */
public class Sentence 
{
	//justify
	private List<Phrase> phrases;
	/**
	 * ArrayLists are fast and easy for accessing different indexes.
	 */
	public Sentence(){
		phrases = new ArrayList<Phrase>();
	}
	/**
	 * add a phrase to this sentence
	 * @param phrase the phrase we add to the list of phrases
	 * that comprise this sentence.
	 */
	public void addPhrase(Phrase phrase){
		phrases.add(phrase);
	}
	/**
	 * @return the phrases in this sentence
	 */
	public List<Phrase> getPhrases(){
		return phrases;
	}
	/**
	 * @return the toString of this sentence.  I might change it later as
	 * it prints the toStrings of all the phrases in it which print the toString 
	 * of all the tokens it has within it which makes it somewhat impractical.
	 */
	public String toString(){
		String to = "";
		for(Phrase p: phrases)
		{
			to += p.toString() + " ";
		}
		return to;
	}
}

package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import src.Scanner.TOKEN_TYPE;
/**
 * a class that analyses everything
 * @author Adriano Hernandez
 * @date feb 25 2016
 * @version 1.0
 */
public class Analyser 
{
	/**
	 * here we test
	 */
	public static void main(String[] args){
		BufferedReader reader;
		try {
			//System.out.println("going to begin test...");
			//System.out.println("created buffer reader");
			reader = new BufferedReader(new FileReader("./src/src/mystery3.txt"));
			Scanner scanner = new Scanner(reader); 
			Analyser bob = new Analyser();
			Document doc = new Document(scanner);
			doc.parseDocument();
			//IT GOT STUCK HERE
			
			System.out.println(bob.findAuthor(doc));
			//System.out.println("created scanner, is " + scanner);
			//System.out.println("created document, is " + doc);
			//System.out.println("parsed through document, gonna print first sentence");
			//System.out.println("Sentences: " + doc.getSentences());
			//System.out.println(doc.getSentences().size() + " " + 
				//doc.getSentences().get(0).getPhrases().size());
			//System.out.println("Phrases: " + doc.getSentences().get(0).getPhrases());
			//System.out.println("Tokens for Phrase 1: " + 
					//doc.getSentences().get(0).getPhrases().get(0).getTokens());
			//System.out.println("Tokens for Phrase 2: " + 
					//doc.getSentences().get(0).getPhrases().get(1).getTokens());
			//sSystem.out.println("First Sentence: " + doc.getSentences().get(0).toString());
			
			/**
			reader = new BufferedReader(new FileReader("./src/src/mystery1.txt"));
			bob = new Analyser();
			doc = new Document(scanner);
			doc.parseDocument();
			System.out.println(doc);
			System.out.println(bob.findAuthor(doc));
			reader = new BufferedReader(new FileReader("./src/src/mystery2.txt"));
			bob = new Analyser();
			doc = new Document(scanner);
			doc.parseDocument();
			System.out.println(bob.findAuthor(doc));
			reader = new BufferedReader(new FileReader("./src/src/mystery3.txt"));
			bob = new Analyser();
			doc = new Document(scanner);
			doc.parseDocument();
			System.out.println(bob.findAuthor(doc));
			reader = new BufferedReader(new FileReader("./src/src/mystery4.txt"));
			bob = new Analyser();
			doc = new Document(scanner);
			doc.parseDocument();
			System.out.println(bob.findAuthor(doc));
			reader = new BufferedReader(new FileReader("./src/src/mystery5.txt"));
			bob = new Analyser();
			doc = new Document(scanner);
			doc.parseDocument();
			System.out.println(bob.findAuthor(doc));
		**/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 */
	//stores the data for the authors
	private List<AuthorData> data;
	
	/**
	 * constructor sets up all the data for different authors
	 */
	//set up different authors, etcetera
	public Analyser(){
		data = new ArrayList<>();
		data.add(new AuthorData("Agatha Christie",4.40212537354,0.103719383127,
				0.0534892315963,10.0836888743,1.90662947161));
		data.add(new AuthorData("Alexandre Dumas",4.38235547477,0.049677588873,
				0.0212183996175,15.0054854981,2.63499369483));
		data.add(new AuthorData("Brothers Grim",3.96868608302,0.0529378997714,
				0.0208217283571,22.2267197987,3.4129614094));
		data.add(new AuthorData("Charles Dickens",4.34760725241,0.0803220950584,
				0.0390662700499,10.0836888743,2.87721723105));
		data.add(new AuthorData("Douglas Adams",4.33408042189,0.238435104414,
				0.141554321967,13.2874354561,1.86574870912));
		data.add(new AuthorData("Emily Bronte",4.35858972311,0.089662598104,
				0.0434307152651,16.1531664212,2.93439550141));
		data.add(new AuthorData("Fyodor Dostoevsky",4.34066732195,0.0528571428571,
				0.0233414043584,12.8108273249,2.16705364781));
		data.add(new AuthorData("James Joyce",4.52346300961,0.120109917189,
				0.0682315429476,10.9663296918,1.79667373227));
		data.add(new AuthorData("Jane Austen",4.330690990469964,0.05457139983404159,
				0.026503055143453445,15.102629830057912,2.3796639134149813));
		data.add(new AuthorData("Lewis Carol",4.1688031258568685,0.10868522072936661,
				0.053742802303262956,14.087880251086432,2.3447609850313857));
		data.add(new AuthorData("Mark Twain",4.33272222298,0.117254215021,
				0.0633074228159,14.3548573631,2.43716268311));
		data.add(new AuthorData("Sir Arthor Conan Doyle",4.16808311494,0.0822989796874,
				0.0394458485444,14.717564466,2.2220872148));
		data.add(new AuthorData("William Shakespeare",4.16216957834,0.105602561171,
				0.0575348730848,9.34707371975,2.24620146314));
		System.out.println("Data: " + data);
		
	}
	
	/**
	 * finds the closest author to the one given
	 * @param current the author given
	 * @return the closest author to current
	 */
	public AuthorData findClosest(AuthorData current){
		//assume current.name = "unknown"
		System.out.println("Unknown document - " + current.getValue());
		int smallestIndex = 0; // arbitrary index
		double currentSmallest = 100000000.999; //really big number so we will start with
		//[0] being the smallest
		//
		
		//
		for(int i = 0; i < data.size(); i++){
			double contender = 0;
			contender += 11*data.get(i).averageWordLength;
			contender += 33*data.get(i).TTR;
			contender += 50*data.get(i).hapaxLegomanaRatio;
			contender += 0.4*data.get(i).averageSentenceLength;
			contender += 4*data.get(i).averageSentenceComplexity;
			System.out.println("" + data.get(i) + " - " + contender);
			if(Math.abs(contender-current.getValue())<Math.abs(currentSmallest-current.getValue())){
				currentSmallest = contender;
				smallestIndex = i;
			}
		}
		return data.get(smallestIndex);
	}
	/**
	 * find the author for this doc
	 * @param doc the document we will find the author for
	 * @return the author of the doc
	 */
	//return a string of the author we think wrote this
	public String findAuthor(Document doc){
		System.out.println("Ave Word Length: " + averageWordLength(doc));
		System.out.println("Type Token Ratio: " + typeTokenRatio(doc));
		System.out.println("Hapax Legomana Ratio: " + hapaxLegomanaRatio(doc));
		System.out.println("Average Number of Words Per Sentence: " 
				+ averageNumberOfWordsPerSentence(doc));
		System.out.println("Sentnece Complexity: " + sentenceComplexity(doc));
		return findClosest(new AuthorData("unknown", averageWordLength(doc), 
				typeTokenRatio(doc), hapaxLegomanaRatio(doc),
					averageNumberOfWordsPerSentence(doc),sentenceComplexity(doc))).name;
		
	}
	
	/**
	 * For all the following methods, if the ratio is -1.0 then
	 * that means that it tinks that the denominator is zero, in many cases
	 * that means it thinks there are either 0 words or zero sentences in the document
	 */
	
	
	/**
	 * find the average world length of the words in doc
	 * @param doc the document we are analysing
	 * @return the average world length of the words in doc; total words length combined/total words
	 */
	public double averageWordLength(Document doc){
		double sum = 0;
		double div = 0.0;
		//System.out.println(doc.getSentences().size());
		for(Sentence s: doc.getSentences()){
			//System.out.println(s.getPhrases().size());
			for(Phrase p: s.getPhrases()){
				//System.out.println(p.getTokens().size());
				for(Token t: p.getTokens()){
					//if(t.getType() == TOKEN_TYPE.WORD){ // this is implied so its not necessary
						div+=1.0;
						sum += t.getValue().length();
						//System.out.println(div);
					//}
				}
			}
		}
		if(div == 0.0) return -1;
		return sum/div;
	}
	/**
	 * number of different unique words used in a text/total words
	 * @param doc the document we analyse
	 * @return the type token ratio of the document doc
	 */
	public double typeTokenRatio(Document doc){
		HashSet<Token> uniqueWords = new HashSet<>();
		double totalWords = 0;
		for(Sentence s: doc.getSentences()){
			for(Phrase p: s.getPhrases()){
				for(Token t: p.getTokens()){
					if(t.getType() == TOKEN_TYPE.WORD){ //this is already taken care of
						if(!uniqueWords.contains(t)){
							uniqueWords.add(t);
						}
					}
					totalWords += 1.0;
				}
			}
		}
		//System.out.println(uniqueWords.size());
		//System.out.println(totalWords);
		return ((double)uniqueWords.size())/totalWords;
	}
	/**
	 * number of words that appear only once in the text/total words
	 * @param doc the thing we find hapax legomana for
	 * @return the hapax legomana ratio as defined above for this document
	 */
	public double hapaxLegomanaRatio(Document doc){
		HashMap<Token,Boolean> words = new HashMap<Token,Boolean>();
		double totalWords = 0;
		//add to words
		for(Sentence s: doc.getSentences()){
			for(Phrase p: s.getPhrases()){
				for(Token t: p.getTokens()){
					//if(t.getType() == TOKEN_TYPE.WORD){ //we know they are words due to parse functionality
						totalWords ++;
						if(words.containsKey(t)){ //fix this to make it make a map entry with each word
							//and if it has a false value for its key then it didn't appear
							//only once
							words.put(t, false);
							
						}
						else words.put(t,true);
					//}
				}
			}
		}
		
		Set<Entry<Token, Boolean>> mp = words.entrySet();
		Set<Entry<Token, Boolean>> mp2 = new HashSet<>();
		for(Entry<Token,Boolean> entry: mp){
			if(entry.getValue() == true){
				mp2.add(entry);
			}
		}
		return (double)mp2.size()/totalWords;
	}
	/**
	 * find the ave number of words per sentence
	 * @param doc the doc we are analysing
	 * @return total words/number of sentences
	 */
	public double averageNumberOfWordsPerSentence(Document doc){
		double sum = 0;
		for(Sentence sentence: doc.getSentences()){
			for(Phrase phrase: sentence.getPhrases()){
				for(Token token: phrase.getTokens()){
					//if(token.getType() == TOKEN_TYPE.WORD){ //not necessary to test
						sum+=1;
					//}
				}
			}
		}
		if(doc.getSentences().size() == 0) return -1;
		return sum/doc.getSentences().size();
	}
	/**
	 * find the sentence complexity of fthe document
	 * @param doc the document we analyse
	 * @return the total number of phrases divided by the total number of sentences
	 */
	public double sentenceComplexity(Document doc){
		double sum = 0;
		for(Sentence s: doc.getSentences()){
			for(Phrase p: s.getPhrases()){
				sum+=1;
			}
		}
		if(doc.getSentences().size() == 0) return -1;
		return sum/doc.getSentences().size();
	}
}

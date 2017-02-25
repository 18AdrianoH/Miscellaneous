package src;

/**
 * a class that stores the data for authors
 * @author Adriano Hernandez
 * @date feb 20
 * @version 1
 */
public class AuthorData 
{
	//to avoid writing so many getters I am making
	//these directly attainable
	String name; //0
	double averageWordLength; //11
	double TTR; //33
	double hapaxLegomanaRatio; //50
	double averageSentenceLength; //0.4
	double averageSentenceComplexity; //4
	
	//"importance" of each element
	double[] weights = {0,11,33,50,0.4,4};
	
	/**
	 * constructor
	 * @param name is the name of the author; unknown for the doc
	 * @param awl average world length
	 * @param ttr type token ratio
	 * @param hlr hapax legomana ratio
	 * @param asl average sentence length
	 * @param asc average sentence complexity
	 */
	public AuthorData(String name, double awl, double ttr, double hlr,
			double asl, double asc)
	{
		this.name = name;
		averageWordLength = awl;
		TTR = ttr;
		hapaxLegomanaRatio = hlr;
		averageSentenceLength = asl;
		averageSentenceComplexity = asc;
	}
	/**
	 * get the author
	 * @return the name
	 */
	public String toString(){
		return name;
	}
	/**
	 * get the value with is the weights times their respective values (they are in order)
	 * @return find the total value of this author's data
	 */
	public double getValue(){
		return averageWordLength*11 + TTR*33 + hapaxLegomanaRatio*50 + 
				averageSentenceLength*0.4 + averageSentenceComplexity*4;
	}
}

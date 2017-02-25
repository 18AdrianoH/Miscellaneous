//get some data structures to help efficiency
import java.util.*;
public class Problem12 {
	//store the triangle numbers
	public static List<Long> TriangleNumbers = new ArrayList<>();
	//find the solution
	public static void main(String[] args) 
	{
		TriangleNumbers.add(1L);
		double startTime = System.currentTimeMillis();
		for(long i = 1; true; i++){
			generateTriangleNumber();
			System.out.println(TriangleNumbers.get((int)i));
			if(numDivisors(TriangleNumbers.get((int)i)) > 500){
				System.out.println("found it to be " + i);
				break;
			}
		}
		System.out.println("time spent = " 
			+ ((double)((System.currentTimeMillis()-startTime))/1000) + " seconds");
	}
	//generate the next triangle number
	public static void generateTriangleNumber(){
		TriangleNumbers.add(TriangleNumbers.get(TriangleNumbers.size()-1)+(TriangleNumbers.size()+1));
	}
	//improved brute force
	public static long numDivisors(long num){
		long sum = 0;
		for(int i = 1; i < Math.sqrt(num); i++){
			if(num%i == 0){sum+=2;}
		}
		return sum;
		/*
		if(num == 1 )return 1;
		return 1 + numDivisors(num,2);
		*/
	}
	//return how many divisors num has recursivelly - doesn't work right now
	public static long numDivisors(long num, long div){
		if(num < div) return 0;
		if(num%div != 0) return numDivisors(num,div+1);
		else{
			return 1 + numDivisors(num,div+1);
		}
	}
}

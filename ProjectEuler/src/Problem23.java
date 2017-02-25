import java.util.*;
public class Problem23 {
	//store numers and all their divisors including the number: not necessarily in order
	public static Map<Integer,List<Integer>> divisors = new HashMap<>();
	
	public static void main(String[] args){
		for(int i = 1; i < 100; i ++){
			System.out.println(i + " has " + getDivisors(i));
		}
	}
	public static List<Integer> getDivisors(int num){
		if(num == 0){
			return null;
		}
		if(divisors.containsKey(num)){
			return divisors.get(num); //get the value for our num key
		}
		//THIS CAN USE MEMOIZATION OPTIMIZATION
		else{
			Set<Integer> add = new HashSet<>();
			for(int test = 1; test <= Math.sqrt(test); test ++){
				//works twice as fast this way :)
				if(num%test == 0){
					add.add(test);
					add.add(num/test);
				}
			}
			List<Integer> ls = new ArrayList<Integer>();
			ls.addAll(add);
			divisors.put(num, ls);
			return ls;
		}
	}
	//helpful util
	public static boolean isPrime(int num){
		List<Integer> divs = getDivisors(num);
		if(num == 0){
			return false;
		}
		if(divs.size() < 2){
			throw new RuntimeException("failed to add divisors correctly, has less than 1 divisor");
		}
		//true if less than 2 divisors (only 1 and the number)
		else return divs.size() == 2;
	}
}

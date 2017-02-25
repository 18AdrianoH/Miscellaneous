import java.util.HashSet;
import utilities.BigInteger;

public class Problem29 {

	static HashSet<BigInteger> numbers = new HashSet<>(); //so we won't repeat
	//this is too slow
	public static void main(String[] args) {
		int i = 0;
		for(int a = 2; a <= 100; a++){
			for(int b = 2; b <= 100; b++){
				System.out.println("iteration " + i);
				numbers.add(new BigInteger(pow(a,b)));
				i++;
			}
		}
		System.out.println(numbers.size());
	}
	//b^p
	public static BigInteger pow(int b, int p){
		BigInteger solution = new BigInteger(b);
		while(p>1){
			solution = BigInteger.multiply(solution, b);
			p--;
		}
		return solution;
	}
	//checks if a number is prime using improved brute force
	public static boolean isPrime(long num){
		if(num == 1) return false;
		if(num == 2 || num == 3) return true;
		if(num%2 == 0 || num%3 == 0) return false;
		for(long i = 5; i < num/2; i+=2){
			if(num%i == 0) return false;
		}
		return true;
	}
}

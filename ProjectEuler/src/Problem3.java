
public class Problem3 {
	//main
	public static void main(String[] args) {
		long number = 600851475143L;
		System.out.println(largestPrimeFactor(number));
		
	}
	//to find the largest prime factor
	public static long largestPrimeFactor(long num){
		return largestPrimeFactor(num,2,1);
	}
	//helper
	private static long largestPrimeFactor(long num, long test, long largest){
		if(isPrime(num))return num;
		
		System.out.println("num " + num + " " + "test " + test + " " + "largest " + largest);
		
		if(num%test == 0 && isPrime(test)){
			if(largest<test) largest = test;
			return largestPrimeFactor(num/test,2,largest);
		}
		
		return largestPrimeFactor(num,test+1,largest);
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

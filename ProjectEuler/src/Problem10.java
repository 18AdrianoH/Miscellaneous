import utilities.BigInteger;

public class Problem10 {

	public static void main(String[] args) {
		long sum = 2;
		for(long i = 3; i < 2000000; i+=2){
			if(isPrime(i)){
				System.out.println("i = " + i);
				System.out.println("sum = " + sum);
				sum += i;
			}
		}
		System.out.println(sum);
		System.out.println("done");
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

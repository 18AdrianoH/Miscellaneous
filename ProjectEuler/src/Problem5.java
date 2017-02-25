import java.util.ArrayList;

public class Problem5 {
	public static void main(String[] args) {
		long num;
		for(num = primesProduct(1,10);!works(num); num++){
			num++;
		}
		System.out.println(num);
	}
	public static boolean works(long num){
		for(int i = 1; i <= 20; i++){
			if(num%i != 0)return false;
		}
		return true;
	}
	public static long primesProduct(long start, long end){
		long sum = 1;
		for(long i = start; i <= end; i++){
			if(isPrime(i)){
				sum*=i;
			}
		}
		return sum;
	}
	private static boolean isPrime(long num){
		if(num == 1) return false;
		if(num == 2 || num == 3) return true;
		if(num%2 == 0 || num%3 == 0) return false;
		for(long i = 5; i < num/2; i+=2){
			if(num%i == 0) return false;
		}
		return true;
	}
}

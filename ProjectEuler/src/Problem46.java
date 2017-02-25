
public class Problem46 {

	public static void main(String[] args) {
		int i = 33;
		for(; !isPrime(i) && works(i); i+=2){
		}
		System.out.println(i);
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
	public static boolean works(int num){
		num-=2;
		if(isPrime(num)) return true;
		
		for(;num > 0; num-=2){
			if(isPrime(num)){
				return true;
			}
		}
		return false;
	}
}

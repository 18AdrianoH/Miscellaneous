
public class Problem7 {

	public static void main(String[] args){
		long number = 1;
		for(int position = 0; position < 10001; number++){
			if(isPrime(number)){
				position++;
				System.out.println(number + " at " + position);
			}
		}
	}
	//only positive ints
	public static boolean isPrime(long num){
		if(num < 0) return false;
		if(num == 1) return false;
		if(num == 2 || num == 3) return true;
		if(num%2 == 0 || num%3 == 0) return false;
		for(long i = 5; i < num/2; i+=2){
			if(num%i == 0) return false;
		}
		return true;
	}

}

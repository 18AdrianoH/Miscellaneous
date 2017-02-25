
public class Problem41 {
	public static final String[] digits = new String[]{"1","2","3","4","5","6","7","8","9"};
	//largest possible pandigital number must have 9 digits > 987654321
	public static void main(String[] args) {
		
		//obviouslytherre are no 1 digit or 2 digit prime pandigitals (1,12,21 are not prime)
		//for 3 digits we have 123, 132, 213, 231, 321, 312 of which none are prime since 
		//%3 = 0 (digits add up to 6)
		//4 DIGITS? > 1234, 1324, 1342, 1243, 1432, 1423 (completely possible) (10)
		//5 digits? impossible since %3 is == 0 (15), same for 6 (21), for 7 it's completely possible
		//for 8 it's impossible (36), and so is it for 9 (45)
		//therefore rlargest possible is 7654321
		for(int i = 7654321; i > 100000; i-=2){
			if(isPrime(i) && isPandigital(i)){
				System.out.println(i);
				return;
			}
		}
		// in case we haven't found it
		for(int i = 1001; i < 10000; i+=2){
			if(isPrime(i) && isPandigital(i)){
				System.out.println(i);
				return;
			}
		}
	}
	//num has to be smaller than 10 digits
	public static boolean isPandigital(int num){
		String str = String.valueOf(num);
		for(int i = 0; i < str.length(); i++){
			if(str.indexOf(digits[i]) == -1) return false; //if it's not there
		}
		return true; //otherwise all are there
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

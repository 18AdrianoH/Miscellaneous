
public class Problem4 {
	//just for practicality
	public static final long MAX = 999;
	public static final long MIN = 100;
	
	public static void main(String[] args) {
		long largest = 0;
		for(long x = MAX; x >= MIN; x--){
			for(long y = x; y >= MIN; y--){
				if(isPalindrome(x*y) && largest < x*y) largest = x*y;
			}
		}
		System.out.println(largest);
	}
	//some nifty helper methods
	public static boolean isPalindrome(long num){
		return num == reverse(num);
	}
	public static long reverse(long num){
		return reverse(num,0);
	}
	public static long reverse(long num, long sum){
		if(num <= 0) return sum;
		sum = sum*10 + num%10;
		return reverse(num/10,sum);
	}
}

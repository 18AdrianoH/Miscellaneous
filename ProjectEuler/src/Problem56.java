import utilities.BigInteger;
//this takes a while but it works; numbers are big enough to search for a vastly better solution
public class Problem56 {

	public Problem56() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[]args){
		BigInteger num = new BigInteger(0);
		for(int a = 90; a < 100; a ++){
			System.out.println("a iteration " + a);
			for(int b = 90; b < 100; b++){
				System.out.println("b iteration " + b);
				BigInteger current = pow(a,b);
				System.out.println(digitSum(current));
				System.out.println(digitSum(num));
				if(digitSum(current) > digitSum(num)) 
					num = new BigInteger(current);
			}
		}
		System.out.println(digitSum(num));
	}
	
	public static BigInteger pow(long base, long exponent){
		BigInteger b = new BigInteger(base);
		while(exponent > 0){
			b = BigInteger.multiply(b, (int)base);
			exponent--;
		}
		return b;
	}
	public static long digitSum(BigInteger num){
		long sum = 0L;
		for(int i = 0; i< num.toString().length(); i++){
			//System.out.println("sum adds up to " + sum + " in the " + i + " iteration");
			sum += Long.parseLong(num.toString().substring(i, i+1));
		}
		return sum;
	}
}

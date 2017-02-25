import utilities.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger num = new BigInteger(100);
		for(int i = 99; i > 0; i--){
			System.out.println("num is " + num);
			num = BigInteger.multiply(num, i);
		}
		//System.out.println(BigInteger.sumDigits(num));
		long sum = 0L;
		System.out.println(num);
		for(int i = 0; i< num.toString().length(); i++){
			System.out.println("sum adds up to " + sum + " in the " + i + " iteration");
			sum += Long.parseLong(num.toString().substring(i, i+1));
		}
		System.out.println("the sum is: " + sum);
	}

}

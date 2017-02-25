import utilities.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger num = new BigInteger(2);
		for(int i = 1; i < 1000; i++){
			System.out.println("iteration " + i);
			num = BigInteger.multiply(num, 2);
			System.out.println(num);
		}
		//System.out.println(BigInteger.sumDigits(num));
		long sum = 0L;
		for(int i = 0; i< num.toString().length(); i++){
			System.out.println("sum adds up to " + sum + " in the " + i + " iteration");
			sum += Long.parseLong(num.toString().substring(i, i+1));
		}
		System.out.println("the sum is: " + sum);
	}

}

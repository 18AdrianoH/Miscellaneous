package utilities;

public class UtilityTester {

	public UtilityTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//these work
		BigInteger integer = new BigInteger("102939485940293029182930433339382847293");
		BigInteger integer2 = new BigInteger("10299999994023029118293040192");
		
		System.out.println(BigInteger.max(integer, integer2));
		System.out.println(BigInteger.min(integer, integer2));
		System.out.println(integer.getDigitCount());
		System.out.println(integer2.getDigitCount());
		
		//doesn't work above 10 for now, but for our current purposes that is fine
		System.out.println(BigInteger.multiply(
				new BigInteger("33302930138827429342043724243295783"), 1029384019));
		
		//these fail
		//System.out.println(BigInteger.add(integer, integer2));
		//System.out.println(BigInteger.sumDigits(integer));
		//System.out.println(BigInteger.sumDigits(integer2));
	}

}

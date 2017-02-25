public class Problem92 {
	public static void main(String[] args) {
		//start time
		final double START_TIME = System.currentTimeMillis();
		//find the solution
		int number = 0;
		for(int i = 1; i <= 10000000; i++){if(reachOne(i))number++;}
		//answer
		System.out.println((10000000-number));
		
		//time ellapsed
		System.out.println("took " + 
			(((double)(System.currentTimeMillis()-START_TIME)/1000))
				+ " seconds");
	}
	//generates the next number in the chain
	public static long generateNext(long num){
		long sum = 0;
		while(num > 0){ sum+= ((num%10)*(num%10)); num/=10; }
		return sum;
	}
	//checks if a number will reach one
	public static boolean reachOne(long num){
		if(num == 1) return true;
		if(num == 89) return false;
		return reachOne(generateNext(num));
	}
}

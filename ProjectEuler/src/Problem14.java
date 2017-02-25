public class Problem14 {
	//bounds
	public static final long MAX = 1000000;
	public static final long MIN = 1;
	//the code
	public static void main(String[] args) {
		//remember the start time so we can measure how long it takes
		final double START_TIME = System.currentTimeMillis();
		//remember previous instances
		long maxChain = 0;
		long maxNum = 0;
		for(long i = MIN; i < MAX; i++){
			long currentChain = generateChain(i);
			if(currentChain > maxChain){
				maxNum = i;
				maxChain = currentChain;
			}
		}
		//get the speed of the program
		System.out.println("max chain is " + maxChain + " long with the number " + maxNum);
		System.out.println("took " + 
			( ((double)(System.currentTimeMillis()-START_TIME)/1000) )
				+ " seconds");
	}
	public static long generateChain(long num){
		//System.out.println(num);
		if(num == 1) return 1;
		return 1 + generateChain(generateNext(num));
	}
	//generate next digit of collatz sequence
	public static long generateNext(long num){
		if(num%2 == 0)return (num/2);
		else return ((3*num) + 1);
	}
}

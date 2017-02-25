
public class Problem97 {

	public Problem97() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		final long MAX_VALUE = Long.MAX_VALUE; //long max value here just for more ease of use
		final long MAX_POWER = 1000000000000L; //10^12 with two powers of 10 as a buffer
		final double START_TIME = System.currentTimeMillis();
		

		long num = 1;
		for(int i = 0; i < 7830457; i++){
			if(num > MAX_VALUE%MAX_POWER){
				num = num%MAX_POWER;
			}
			num*=2;
		}
		num *= 28433;
		num+=1;
		System.out.println(String.valueOf(num).substring(String.valueOf(num).length()-10));
		System.out.println("took " + (((double)(System.currentTimeMillis()-START_TIME))/1000) + " seconds");
	}

}

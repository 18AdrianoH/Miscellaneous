
public class Problem30 {

	public Problem30() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//it seems likely that only  5 digit numbers will work,
		//so we will begin our search there, then broaden it if we fail 
		//(this is just a hunch)
		long sum = 0;
		for(long i = 1000; i < 1000000; i++){
			if(works(i)){
				System.out.println(i);
				sum+=i;
			}
		}
		System.out.println("answer is " + sum);
	}
	//checks if it works for this problem
	public static boolean works(long num){
		long[] digits = digits(num);
		long sum = 0;
		for(long l: digits){
			sum+=(l*l*l*l*l);
		}
		return sum == num;
	}
	public static long[] digits(long num){
		String str = String.valueOf(num);
		long[] arr = new long[str.length()];
		for(int i = 0; i < str.length(); i++){
			arr[i] = Long.parseLong(str.substring(i,i+1));
		}
		return arr;
	}

}


public class Problem6 {
	public static void main(String[] args) {
		long squares = 0;
		for(long i = 1; i <= 100; i++){
			squares += (i*i);
		}
		long sum = 0;
		for(int i = 1; i <= 100; i++){
			sum+=i;
		}
		System.out.println((sum*sum)-squares);
	}
}

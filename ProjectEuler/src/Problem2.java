import java.util.ArrayList;

public class Problem2 {

	public static void main(String[]args){
		long sum = 0;
		for(long i = 1;; i++){
			long fib = fibonaci(i);
			System.out.println(fib);
			if(fib >= 4000000){
				break;
			}
			else{
				if(fib%2 == 0) sum+=fib;
			}
		}
		System.out.println("sum is " + sum);
	}
	public static long fibonaci(long i){
		if(i < 0) return 0;
		if(i == 0) return 1;
		return fibonaci(i-1) + fibonaci(i-2);
	}

}

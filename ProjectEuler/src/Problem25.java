import java.util.ArrayList;

import utilities.BigInteger;

public class Problem25 {
	public static ArrayList<BigInteger> fib = new ArrayList<BigInteger>();
	public static void main(String[] args) {
		fib.add(new BigInteger(0));
		fib.add(new BigInteger(1));
		fib.add(new BigInteger(1));
		// TODO Auto-generated method stub
		int i;
		for(i = 1; fibonacci(i).getLength() < 1000; i ++){
			System.out.println(fibonacci(i));
		}
		System.out.println("done");
		System.out.println("index is " + i);

	}
	//brute force fibonacci program
	public static BigInteger fibonacci(int index){
		if(index < 1) return fib.get(0);
		if(index == 1) return fib.get(1);
		if(index == 2) return fib.get(2);
		if(index < fib.size()) return fib.get(index);
		if(index == fib.size()){
			BigInteger sum = BigInteger.add(fib.get(index-1), fib.get(index-2));
			fib.add(sum);
			return sum;
		}
		else{
			int i = fib.size();
			while(index > fib.size()-1){
				BigInteger sum = BigInteger.add(fib.get(i-1), fib.get(i-2));
				fib.add(sum);
				i++;
			}
			return fib.get(index);
		}
	}

}

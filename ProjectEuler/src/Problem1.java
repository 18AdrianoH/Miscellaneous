
public class Problem1 
{
	public static void main(String[]args){
		long sum = 0;
		int MAX = 1000;
		for(int i = 0; i < MAX; i++){
			if((i%5 == 0 || i% 3 == 0)){
				System.out.println(sum);
				sum+=(long)i;
			}
		}
		System.out.println(sum);
	}
}

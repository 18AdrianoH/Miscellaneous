
public class Problem9 {

	public static void main(String[]args){
		int a, b, c;
		for(c = 1000; c >= 0; c--){
			for(b = c; b > 0; b--){
				for(a = b; a > 0; a--){
					if(isTriple(a,b,c) && meetsCondition(a,b,c)){
						System.out.println(a*b*c);
						return;
					}
				}
			}
		}
	}
	public static boolean isTriple(int a, int b, int c){
		return (a*a) + (b*b) == (c*c);
	}
	public static boolean meetsCondition(int a, int b, int c){
		return (a + b + c == 1000) && ((a < b) && (b < c));
	}
}

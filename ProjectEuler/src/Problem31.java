//I'm almost sure there is a 1 line answer using combinatronics, but I'm a noob rip
public class Problem31 {

	//different coinValues
	public static final int[] coinValues = new int[]{1,2,5,10,20,50,100,200};
	
	//THIS EITHER TAKES TOO LONG OR DOESN'T WORK
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(possibilities(200));
	}
	//basically fills it up and checks all possibilities
	//adds 1 for each step of the filling for each possibility tee
	//(each decision is "1 more way" of doing it in this program)
	public static int possibilities(int leftOver){
		System.out.println(leftOver);
		int[] works = workingCoinValues(leftOver);
		if(works == null)return 1;
		else{
			int sum = 0;
			for(int i: works){
				sum += possibilities(leftOver-i);
			}
			return 1 + sum;
		}
	}
	//returns the coin values that can be inserted into the left over space
	//(to reach 200p)
	public static int[] workingCoinValues(int leftOver){
		if(leftOver == 0) return null;
		if(leftOver == 1) return new int[]{1};
		if(leftOver < 5) return new int[]{1,2};
		if(leftOver < 10) return new int[]{1,2,5};
		if(leftOver < 20) return new int[]{1,2,5,10};
		if(leftOver < 50) return new int[]{1,2,5,10,20};
		if(leftOver < 100) return new int[]{1,2,5,10,20,50};
		if(leftOver < 200) return new int[]{1,2,5,10,20,50,100};
		return coinValues;
	}
}

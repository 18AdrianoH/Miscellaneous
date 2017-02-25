import java.util.List;
import java.util.ArrayList;
public class Problem24 {
	public static void main(String[] args) {
		List<String> ls = permutations("0123456789");
		System.out.println("done finding permutations");
		//here is the cheese, because of the way the permutation code works, they are already ordered
		System.out.println(ls.get(999999));
	}
	public static List<String> permutations(String str){
		List<String> ls = new ArrayList<String>();
		permutationsH("",str,ls);
		return ls;
	}
	//helper method, uses brute force
	private static void permutationsH(String current, String remaining, List<String> ls){
		if(remaining == null || current == null || ls == null){
			return;
		}
		if(remaining.equals("")){
			ls.add(current);
		}
		else{
			//for each of the items remaining append to one permutation 
			for(int i = 0; i < remaining.length(); i++){
				permutationsH(current+remaining.substring(i, i+1), 
						remaining.substring(0, i) + remaining.substring(i+1), ls);
			}
		}
	}
}

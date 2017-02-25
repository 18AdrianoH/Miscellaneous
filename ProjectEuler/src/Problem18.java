import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//find the largest value path in the given file
public class Problem18 {
	//io stuff
	public static List<String> docText(String PATH){
		try {
			return Files.readAllLines(Paths.get(PATH));
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[]args){
		//get the text
		List<String> lines = docText("src/misc/Problem18Text.txt");
		//2D Arraylist of numbers
		List<List<Integer>> nums = new ArrayList<>();
		for(String str: lines){
			List<Integer> th = new ArrayList<>();
			for(int i = 0, space = str.indexOf(" ", i); i < str.length();){
				if(space == -1){
					th.add(Integer.parseInt(str.substring(i)));
					break;
				}
				else{
					th.add(Integer.parseInt(str.substring(i, space)));
					i = space + 1;
					space = str.indexOf(" ", i);
				}
			}
			nums.add(th);
		}
		System.out.println(nums);
		System.out.println(max(nums));
	}
	public static int max(List<List<Integer>> ls){
		return maxHelper(0,0,0,ls);
	}
	//brute force recursion
	private static int maxHelper(int index, int currentSum, int height, List<List<Integer>> nums){
		if(height == nums.size()-1){
			return currentSum + nums.get(height).get(index);
		}
		else{
			int rightIndex = index+1;
			int leftIndex = index;
			
			//find the sums on the right and left
			int rightSum = currentSum + maxHelper(rightIndex,currentSum+nums.get(height).get(index), height+1, nums);
			int leftSum = currentSum + maxHelper(leftIndex,currentSum+nums.get(height).get(index), height+1, nums);
			
			if(leftSum < rightSum) return rightSum;
			else return leftSum;
		}
	}
}

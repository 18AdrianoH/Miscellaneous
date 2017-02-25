import java.util.ArrayList;
import java.util.List;

public class HeapUtils 
{
	public static void main(String[]args){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 12; i ++){
			nums.add((int)(Math.random()*100));
		}
		Integer[] numbers = new Integer[nums.size()];
		for(int i = 0; i < nums.size(); i++){
			numbers[i] = nums.get(i);
		}
		
		HeapDisplay display = new HeapDisplay();
		display.displayHeap(numbers, numbers.length-1);
	}
	
	//make an array from a list
	@SuppressWarnings("rawtypes")
	private static Comparable[] listToArray(List<Comparable> list){
		Comparable[] array = new Comparable[list.size()];
		int i = 0;
		for(Comparable c: list){
			array[i] = c;
			i++;
		}
		return array;
	}
	//make a list from an array
	@SuppressWarnings("rawtypes")
	private static List<Comparable> arrayToList(Comparable[] array){
		ArrayList<Comparable> ar = new ArrayList<>();
		for(int i = 0; i < array.length; i++){
			ar.add(array[i]);
		}
		return ar;
	}
	/**
	//make a heap from a list
	@SuppressWarnings({ "unused", "unchecked" })
	private static TreeNode createMaxHeap(@SuppressWarnings("rawtypes") List<Comparable> list, int size){
		if(size == 0){
			return null;
		}
		int maxIndex = 0;
		for(int i = 1; i < list.size(); i ++){
			if(list.get(i).compareTo(list.get(maxIndex)) > 0){
				maxIndex = i;
			}
		}
		return new TreeNode(list.remove(maxIndex),createMaxHeap(list,size-1),createMaxHeap(list,size-1));
	}
	//make a list from a heap
	@SuppressWarnings("rawtypes")
	private static List<Comparable> heapToList(TreeNode tree, List<Comparable> l){
		//if(){
			return null;
		//}
	}
	**/
	@SuppressWarnings("unchecked")
	public static TreeNode arrayToHeap(@SuppressWarnings("rawtypes") List<Comparable> heap, int size){
		if(size <= 0){
			return null;
		}
		int maxIndex = 0;
		for(int i = 1; i < heap.size(); i++){
			if(heap.get(i).compareTo(heap.get(maxIndex))>0) maxIndex = i;
		}
		@SuppressWarnings("rawtypes")
		Comparable c = heap.get(maxIndex);
		heap.remove(maxIndex);
		return new TreeNode(c,arrayToHeap(heap,size-1),arrayToHeap(heap,size-1));
	}
	
	public static TreeNode getNextItem(TreeNode root, TreeNode t){
		return null;
	}
	public static List<Comparable> heapToArray(TreeNode root, TreeNode t, List<Comparable> l){
		if(t == null){
			return l;
		}
		l.add((Comparable) t.getValue());
		return heapToArray(root, getNextItem(root,t),l);
	}
	@SuppressWarnings("unchecked")
	//FIX THIS METHOD
	public static void heapify(@SuppressWarnings("rawtypes") Comparable[] heap, int index, int size){
		List<Comparable> list = arrayToList(heap);
		TreeNode t = arrayToHeap(list,size);
		List<Comparable> heapified = heapToArray(t,t,new ArrayList<Comparable>());
		heap = (Comparable[]) heapified.toArray();
		
		
	}
	public static void buildHeap(Comparable[] heap, int heapSize){
		int end = heapSize;
		heapify(heap,end,heapSize-end);
		
	}
	public static Comparable remove(Comparable[] heap, int heapSize){
		return null;
	}
	public static Comparable[] insert(Comparable[] heap, Comparable item, int heapSize){
		return null;
	}
}

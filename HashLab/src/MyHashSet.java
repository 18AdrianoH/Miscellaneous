import java.util.*;
/**
 * This is a generic class for a Hash set
 * @author Adriano Hernandez
 * @version 12 January 2016
 * @param <E> is the type param
 */
public class MyHashSet<E>
{
	private static final int NUM_BUCKETS = 5;
	private LinkedList<E>[] buckets;
	private int size;

	/**
	 * Construct a new hashset.
	 */
	public MyHashSet()
	{
		buckets = new LinkedList[NUM_BUCKETS];
		size = 0;
		for(int i = 0; i < NUM_BUCKETS; i++)
		{
			buckets[i] = new LinkedList();
		}
	}
	/**
	 * returns the index of the bucket where obj might be found
	 * @param obj is the object we are finding the index of
	 * @return the index of this object
	 */
	private int toBucketIndex(Object obj)
	{
		int hash = obj.hashCode();
		return Math.abs(hash)%buckets.length;
	}

	/**
	 * @return size
	 * size is size of the hashSet
	 */
	public int size()
	{
		return size;
	}

	/**
	 * 
	 * @param obj the object we are checking for
	 * @return true if obj was in the hashSet; otherwise,
	 * 		   false.
	 */
	public boolean contains(Object obj)
	{
		int hashIndex = toBucketIndex(obj);
		if(buckets[hashIndex] == null)
		{
			return false;
		}
		return buckets[hashIndex].contains(obj);
	}
	/**
	 * if obj is not present in this set, adds obj and
	 * returns true; otherwise returns false
	 * @param obj is the object we are adding
	 * @return true if it wasn't already there and we added it; otherwise,
	 * 		   false.
	 */
	public boolean add(E obj)
	{
		if(!contains(obj))
		{
			int hashIndex = toBucketIndex(obj);
			buckets[hashIndex].add(obj);
			size++;
			return true;
		}
		return false;
	}
	/**
	 * if obj is present in this set, removes obj and
	 * returns true; otherwise returns false
	 * @param obj is the object we are removing
	 * @return true if it was there and we removed it; otherwise,
	 * 		   false.
	 */
	public boolean remove(Object obj)
	{
		if(!contains(obj))
		{
			return false;
		}
		
		int hashIndex = toBucketIndex(obj);
		int removeIndex = 0;
		while(!buckets[hashIndex].get(removeIndex).equals(obj))
		{
			removeIndex++;
		}
		buckets[hashIndex].remove(removeIndex);
		size--;
		return true;
	}

	/**
	 * @return the stuff in the bucket in string format
	 * this means, for a rectangle, returning length x width
	 */
	public String toString()
	{
		String s = "";
		for (int i = 0; i < buckets.length; i++)
			if (buckets[i].size() > 0)
				s += i + ":" + buckets[i] + " ";
		return s;
	}
	
	
	
	//iterator
	
	/**
	 * 
	 * @return this' iterator
	 */
	public java.util.Iterator iterator()
	{
		return new Iterator();
		
	}
	
	/**
	 * This is an iterator class for a hash set
	 * @author Adriano Hernandez
	 *
	 * @param <E> is the type parameter
	 */
	@SuppressWarnings("hiding")
	public class Iterator<E> implements java.util.Iterator
	{
		private E next;
		private ArrayList<E> iterated;
		
		/**
		 * @start the iterator
		 */
		public Iterator()
		{
			//System.out.println("calling constructor");
			iterated = new ArrayList<E>();
			
			next = (E) getNext();
			//iterated.add(next);
			
			//System.out.println("next is " + next);
		}
		
		//methods
		/**checks whether we have a next value to go to
		 * @return true if has a next value; otherwise.
		 * 		   false.
		 */
	    public boolean hasNext()
		{
	    	//System.out.println("calling hasNext");
			return getNext() != null; // getNext will return null when our array
			//is full with everything from the set; sizes are equal+ 1 iteration
		}
	    /**
	     * return the object which is now next and iterate forward
	     * @return next object
	     */
		public Object next()
		{
			//System.out.println("calling next");
			E n = next;
			
			next = (E) getNext();
			
			//System.out.println("next is " + next);
			
			iterated.add(n);
			
			return n;
		}
		/**
		 * remove the current object
		 */
		public void remove()
		{
			//System.out.println("calling remove");
			//since we are removing it it will get incremented anyway
			
			//we move numIterated down along with size to avoid an off by n error
			//System.out.println("next is " + next);
			MyHashSet.this.remove(next);
			next();
			
		}
		
		/**
		 * get the next object (due to the random placement can't assume
		 * sequentiality; thus I search for the first value we have not already found)
		 * @return next; if it is not there return null
		 */
		private Object getNext()
		{
			for(int i = 0; i < NUM_BUCKETS; i++)
			{
				for(Object e : buckets[i])
				{
					if(!iterated.contains(e))
					{
						return e;
					}
				}
			}
			
			return null;
		}
	}
}
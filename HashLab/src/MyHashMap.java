import java.util.*;

/**
 * A Hash Map
 * @author Adriano Hernandez
 * @version 14 January 2016
 * 
 * @param <K> is our key type param
 * @param <V> is our value type param
 */
public class MyHashMap<K,V> implements Map<K,V>
{
	private LinkedList<MapEntry<K,V>>[] buckets; 
	private int size;
	// an array of linked lists of map entries
	
	//by default sets length of the array to be 10
	public MyHashMap()
	{
		size = 0;
		buckets = new LinkedList[10];
		for(int i = 0; i < 10; i++)
		{
			buckets[i] = new LinkedList<MapEntry<K,V>>();
		}
	}

	/**
	 * Clear the entire map.  Here that means cleaning out all
	 * the buckets.
	 */
	@Override
	public void clear() 
	{
		size = 0;
		// TODO Auto-generated method stub
		for(int i = 0; i < buckets.length; i++)
		{
			while(buckets[i].size() > 0)
			{
				buckets[i].remove();
			}
		}
	}

	/**
	 * @param key is the key are testing for
	 * @return true if this contains key; otherwise,
	 *         false.
	 */
	@Override
	public boolean containsKey(Object key) 
	{
		for(LinkedList<MapEntry<K, V>> l : buckets)
		{
			for(MapEntry<K,V> m : l)
			{
				if(m.getKey().equals(key))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param value is the value we are searching for
	 * @return true if this contains value; otherwise,
	 *         false.
	 */
	@Override
	public boolean containsValue(Object value)
	{
		// TODO Auto-generated method stub
		for(LinkedList<MapEntry<K, V>> l : buckets)
		{
			for(MapEntry<K,V> m : l)
			{
				if(m.getValue().equals(value))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return a set of the map entries
	 */
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() 
	{
		// TODO Auto-generated method stub
		Set<java.util.Map.Entry<K, V>> set = new HashSet<>();
		for(LinkedList<MapEntry<K,V>> l : buckets)
		{
			for(MapEntry<K,V> m : l)
			{
				set.add(m);
			}
		}
		return set;
	}

	/**
	 * 
	 * @param key is the key who's value we want
	 * @return the value corresponding to this key
	 */
	//UNFINISHED
	@Override
	public V get(Object key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return true if the hashmap is empty
	 */
	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * @return a set of all the keys in the map
	 */
	@Override
	public Set<K> keySet() 
	{
		Set<K> set = new HashSet<K>();
		for(LinkedList<MapEntry<K, V>> l : buckets)
		{
			for(MapEntry<K,V> m : l)
			{
				set.add(m.getKey());
			}
		}
		return set;
	}

	/**
	 * put a value and key
	 * @param key the key we put; of already there we just change value
	 * @param value the value being put in with key
	 * @return the previous value of key, or null if it wasn't there
	 */
	//UNFINISHED
	@Override
	public V put(K key, V value) 
	{
		for(LinkedList<MapEntry<K, V>> l : buckets)
		{
			for(MapEntry<K,V> m : l)
			{
				if(m.getKey().equals(key))
				{
					
					V oldValue = m.getValue();
					m.setValue(value);
					return oldValue;
				}
			}
		}
		size++;
		//insert
		return null;
	}

	/**
	 * Copy all the entries from map onto this map
	 * @param map the map we are copying entries from
	 */
	//UNFINISHED
	@Override
	public void putAll(Map<? extends K,? extends V> map) 
	{
		Set newEntries = map.entrySet();
		Iterator i = newEntries.iterator();
		while(i.hasNext())
		{
			MapEntry<K,V> m = (MapEntry<K, V>) i.next();
			newEntries.add(m);
		}
		
	}

	/**
	 * @param key is the map entry we will remove
	 * @return the old value
	 */
	//UNFINISHED
	@Override
	public V remove(Object key) 
	{
		size--;
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the size of the hashmap
	 */
	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return this.size;
	}

	/**
	 * @return a collection of the values in this map
	 */
	@Override
	public Collection<V> values() 
	{
		Collection<V> values = new ArrayList<V>();
		for(LinkedList<MapEntry<K,V>> bucket: buckets)
		{
			for(MapEntry<K,V> entry : bucket)
			{
				values.add(entry.getValue());
			}
		}
		return values;
	}

}

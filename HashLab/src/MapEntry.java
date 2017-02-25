import java.util.Map.Entry;

/**
 * This is a class that has the entry for one spot on the map.  
 * Holds a key and its value.
 * 
 * @author Adriano Hernandez
 * @version 14 January 2016
 * 
 * @param <K> key type parameter
 * @param <V> value type parameter
 */
public class MapEntry<K,V> implements Entry<K,V>
{
	private K key;
	private V value;
	
	
	/**
	 * @return this entry's key
	 */
	@Override
	public K getKey() 
	{
		return key;
	}

	/**
	 * @return this entry's value
	 */
	@Override
	public V getValue() 
	{
		return value;
	}

	/**
	 * @param arg0 is the value we are setting
	 * @return the old value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V setValue(Object arg0) 
	{
		V temp = value;
		value = (V)arg0;
		return temp;
	}
	
}

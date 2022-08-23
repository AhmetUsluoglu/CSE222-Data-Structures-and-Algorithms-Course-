package question1;

/** An interface for a hashmap.*/ 
public interface KWHashMap<K,V> 
{
   /**
    * Returns the value to which the specified key is mapped, or null if this map contains no mapping
    * for the key.
    * 
    * @param key The key to search for.
    * @return The value associated with the key.
    */
    V get(K key);
    /**
     * // Java
     * boolean isEmpty();
     */
    boolean isEmpty();
    /**
     * // Java
     * V put(K key,V value);
     * 
     * @param key The key to be stored in the map
     * @param value The value to be stored in the map.
     * @return The value of the key that was just put.
     */
    V put(K key,V value);
    /**
     * // Java
     * V remove(K key);
     * 
     * @param key The key of the element to remove from the Map.
     * @return The value of the removed node.
     */
    V remove(K key);
    /**
     * // Java
     * int size();
     * 
     * @return The size of the list.
     */
    int size();

}
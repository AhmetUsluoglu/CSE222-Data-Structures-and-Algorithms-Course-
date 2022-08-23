package question1;

/**
 * It's a hash table that uses binary search trees as the underlying data structure
 */
public class HashtableBST<K extends Comparable<K> ,V extends Comparable<V>> implements KWHashMap<K,V>
{
    private BinarySearchTree<Entry<K,V>>[] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key‐value pairs for a hash table. */
    public static class Entry <K , V > implements Comparable<Entry<K,V>>
    {
        /** The key */
        private final K key;

        /** The value */
        private V value;

        /** Creates a new key‐value pair.
        @param key The key
        @param value The value
        */
        public Entry(K key, V value) 
        {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
        @return The key
        */
        public K getKey() {return key;}

        /** Retrieves the value.
        @return The value
        */
        public V getValue() {return value;}

        /** Sets the value.
        @param val The new value
        @return The old value
        */
        public V setValue(V val) 
        {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        @Override
        public int compareTo(Entry<K, V> o) {return 0;}

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }
   }


    @SuppressWarnings("unchecked")
    public HashtableBST()
    {
        table = new BinarySearchTree[CAPACITY];
    }

    /** Method get for class HashtableChain.
    @param key The key being sought
    @return The value associated with this key if found;
    otherwise, null
    */
    @Override
    public V get(K key) 
    {
        int index = key.hashCode() % table.length;
        
        if (index < 0)
            index += table.length;
        
        if (table[index] == null)
            return null; // key is not in the table.
        

        var entry = table[index].find(new Entry<K, V>(key, null));
        if (entry == null) {return null;}
        return entry.getValue();
    }

    /**
     * If the key is in the table, remove it and return its value. Otherwise, return null
     * 
     * @param key The key of the entry to remove.
     * @return The value of the key that was removed.
     */
    public V remove(K key)
    {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        if (table[index] == null) {return null;}
        
        var entry = table[index].find(new Entry<>(key, null));
        
        if (entry == null)  {return null;}
        
        V oldValue = entry.getValue();
        table[index].remove(entry);
        numKeys--;
        return oldValue;
    }

   /**
    * Returns true if the number of keys in the tree is 0, false otherwise.
    * 
    * @return The number of keys in the tree.
    */
    public boolean isEmpty(){return numKeys == 0;}

    /**
     * Return the number of keys in the tree.
     * 
     * @return The number of keys in the tree.
     */
    public int size(){return numKeys;}

    /**
     * If the key is already in the table, replace the value with the new value. Otherwise, add a new
     * entry to the table
     * 
     * @param key The key to be inserted into the hash table.
     * @param value The value to be associated with the specified key.
     * @return The old value associated with the key, or null if the key is not in the table.
     */
    @Override
    public V put(K key, V value) 
    {
        int index = key.hashCode() % table.length;
        
        if (index < 0)
            index += table.length;
        
        if (table[index] == null) 
        {
            // Create a new linked list at table[index].
            table[index] = new BinarySearchTree<Entry<K,V>>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) 
        {
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) 
            {
                // Replace value for this key.
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }   
        }
       
        // assert: key is not in the table, add new item.
        table[index].add(new Entry<>(key, value));
        numKeys++;
        
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        
        return null;
    }

    /**
     * It returns the next prime number after 2*CAPACITY
     * 
     * @return The next prime number after the current capacity.
     */
    public int nextPrime()
    {
        int start = 2*CAPACITY;
        boolean flag = true;

        for(int i = start;;i =+ 2)
        {
            for(int j = 2; j <= i/2; j++)
            {
                if(i%j == 0)
                {
                    j = i;
                    flag = false;
                }
            }
            if (flag) return i;
        }
    }

    /**
     * The above function rehashes the table.
     */
    @SuppressWarnings("unchecked")
    public void rehash()
    {
        BinarySearchTree<Entry<K, V>>[] prevTable = table;
        
        int NEWCAPACITY = nextPrime();
        numKeys = 0;
        table = new BinarySearchTree[NEWCAPACITY];

        for (var bst : prevTable) 
        {
            if(prevTable != null)
            {
                for (var element : bst) 
                {
                    put(element.key,element.value);
                }
            }    
        }
    }

    /**
     * The function iterates through the table and appends the toString() of each element to a
     * StringBuilder
     * 
     * @return The toString method is returning a string representation of the hash table.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        for (var element : table) 
        {
            if(element != null)
                sb.append(element.toString());
        }
        return sb.toString();
    }

}

package question2;

public class NewSort<T>
{
    /**
    * It's a class that holds two integers, one for the minimum index and one for the maximum index
    */
    public static class Pair
    {
        public int min;
        public int max;

        public Pair(){}
        public Pair(int minIndex, int maxIndex){min = minIndex; max = maxIndex;}

    }

    /**
     * The sort function takes an array of type T, where T is a class that implements the Comparable
     * interface, and sorts the array
     * 
     * @param table The array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T[] table) {
        // Sort the whole table.
        newSort(table, 0, table.length - 1);
    }

    /**
     * // Java
     * private static <T extends Comparable<T>> T[] newSort(T[] table, int head, int tail) 
     *     {
     *         if(head > tail) 
     *             return table;
     *         else
     *         {
     *             Pair min_max = min_max_finder(table,head, tail);
     *             
     *             swap(table, tail, min_max.max);
     *             min_max = min_max_finder(table,head, tail);
     *             swap(table, head, min_max.min);
     *             return newSort(table, head+1,tail-1);
     *         }
     *     }
     * 
     * @param table the array to be sorted
     * @param head the index of the first element in the array
     * @param tail the last index of the array
     * @return The method is returning the table.
     */
    private static <T extends Comparable<T>> T[] newSort(T[] table, int head, int tail) 
    {
        if(head > tail) 
            return table;
        else
        {
            Pair min_max = min_max_finder(table,head, tail);
            
            swap(table, tail, min_max.max);
            min_max = min_max_finder(table,head, tail);
            swap(table, head, min_max.min);
            return newSort(table, head+1,tail-1);
        }
    }

    /**
     * It takes an array of objects that implement the Comparable interface, and returns a Pair object
     * containing the indices of the minimum and maximum values in the array
     * 
     * @param table the array to be sorted
     * @param head the index of the first element in the array
     * @param tail the last index of the array
     * @return A pair of integers.
     */
    public static <T extends Comparable<T>> Pair min_max_finder(T[] table, int head, int tail)
    {

        int min = 0, max = 0;
        for(int i = head; i <= tail; i++)
        {
            if(table[i].compareTo(table[min]) <= 0)
            {
                min = i;
            }
            if(table[i].compareTo(table[max]) >= 0)
            {
                max = i;
            }
        }
        return new Pair(min,max);    
    }

    /**
     * Swap the values of two elements in an array
     * 
     * @param table The array to be sorted.
     * @param i the index of the first element to swap
     * @param j the index of the first element to be compared
     */
    public static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
}

import java.util.Arrays;
import java.util.Random;

import question1.*;
import question2.*;


/**
 * It creates a new empty hashtable, adds one element to it, removes it, adds six elements to it,
 * updates two of them, and then tests the performance of the class by adding 100, 1000, and 10000
 * elements to it
 */
public class App {
    /**
     * This function tests the HashtableBST class by creating a new empty hashtable, adding one element
     * to it, removing it, adding six elements to it, updating two of them, and then testing the
     * performance of the class by adding 100, 1000, and 10000 elements to it
     */
    public static void main(String[] args) throws Exception 
    {
        part1(100);

        System.out.println("Creating new empty hashtable");
        HashtableBST<String,String> hashtable = new HashtableBST<String,String>();
        
        System.out.println("This hashtable is empty ==> "+ hashtable.isEmpty());
        System.out.println("\nAdded one to hashtable");
        hashtable.put("1", "one");
        System.out.println(hashtable);
        System.out.println("This hashtable is empty ==> "+hashtable.isEmpty());

        System.out.println("\nRemoved one from hashtable");
        hashtable.remove("1");
        System.out.println("This hashtable is empty ==> "+ hashtable.isEmpty());
        System.out.println(hashtable);

        System.out.println("\nTrying to remove unexisting element from table");
        hashtable.remove("1");

        System.out.println("\nAdded one to six to hashtable");
        hashtable.put("1", "one");
        hashtable.put("2", "two");
        hashtable.put("3", "three");
        hashtable.put("4", "four");
        hashtable.put("5", "five");
        hashtable.put("6", "six");
        System.out.println(hashtable);


        System.out.println("\nAdded eight and nine to hashtable as 5 and 6 keys to update five and six");
        hashtable.put("5", "eight");
        hashtable.put("6", "nine");

        System.out.println(hashtable);
        
        part2(100);
        part2(1000);
        part2(10000);
    }

    /**
     * This function creates a new hashtable, and then adds a random number of elements to it
     * 
     * @param len the number of elements to be added to the hashtable
     */
    public static void part1(int len)
    {
        Random rd = new Random();
        long start = 0, end = 0, duration = 0;
        HashtableBST<Integer,String> hashtable = new HashtableBST<Integer,String>();

        start = System.currentTimeMillis();
        for(int i = 0; i < len; i++)
        {
            hashtable.put(rd.nextInt(), "null");
        }
        end = System.currentTimeMillis();
        duration += (end - start);

        System.out.println("\nAdded " + len + " elements to hashtable = " + duration + " ms" );
    }
    
    
    /**
     * It creates an array of random integers, then copies that array into three other arrays, then
     * sorts each of the three arrays using the three different sorting algorithms, then prints out the
     * time it took to sort each array
     * 
     * @param len the length of the array to be sorted
     */
    public static void part2(int len)
    {
        Random rd = new Random();
        long start = 0, end = 0, duration = 0, mergeSortTime = 0, quickSortTime = 0, newSortTime = 0;
        for(int x = 0; x < 100; x++)
        {
            Integer table[] = new Integer[len];
            for(int i = 0; i < len; i++)
            {
                table[i] = rd.nextInt();
            }

            Integer table1[] = Arrays.copyOf(table, len);
            Integer table2[] = Arrays.copyOf(table, len);



            start = System.currentTimeMillis();
            MergeSort.sort(table);
            end = System.currentTimeMillis();
            duration = (end - start);
            mergeSortTime += duration;

            start = System.currentTimeMillis();
            QuickSort.sort(table1);
            end = System.currentTimeMillis();
            duration = (end - start);
            quickSortTime += duration;

            start = System.currentTimeMillis();
            NewSort.sort(table2);
            end = System.currentTimeMillis();
            duration = (end - start);
            newSortTime += duration;
        }

        System.out.println("\n100 x " + len);
        System.out.println("Merge Sort =" + mergeSortTime + " ms");
        System.out.println("Quick Sort =" + quickSortTime + " ms");
        System.out.println("New Sort   =" + newSortTime   + " ms");
    }
}

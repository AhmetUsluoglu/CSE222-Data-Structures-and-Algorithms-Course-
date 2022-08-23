package pck;
import java.util.ArrayList;

/**
 * Part3 Class for the first problem
 * In the array find all possible combinations of integers that add up to a given integer
 */
public class Part3
{
   /**
     * Empty Constructor
     */
    public Part3()
    {
        // intentionally empty
    }

    /*
    *A constructor that takes two parameters, an array of integers and an integer.
    */
    public Part3(int[] arr, int num)
    {
        part3(arr, num);
    }

    /**
     * Given an array of integers, find all possible combinations of integers that add up to a given
     * number
     * 
     * @param arr the array to be partitioned
     * @param num The number to be partitioned.
     */
    public static void part3(int[] arr, int num)
    {
        ArrayList<Integer> sub = new ArrayList<>();
        part3(arr, num, num, 0, 0, sub);
    }
    
    /**
     * Given an array of integers, find all possible ways to add up to a given number
     * 
     * @param arr the array of integers
     * @param num The total you want to reach.
     * @param remain The number that we are trying to find a subset of.
     * @param start1 the starting index of the first array
     * @param start2 The start index of the second array.
     * @param sub the array that stores the sub-array
     */
    public static void part3(int[] arr, int num, int remain, int start1, int start2, ArrayList<Integer> sub)
    {   
        if(arr.length == 0) return;
        if(start2 == arr.length) return;
        
        if(start1 == arr.length)
        {
            sub.clear();
            start2++;
            start1 = start2;
            remain = num;
        }
        else
        {
            if(arr[start1] == remain) 
            {
               
                sub.add(arr[start1]);
                System.out.print("Total is " + num + " = ");
                System.out.println(sub);
                if(start1 < arr.length - 1 && 0 - arr[start1+1] >=0) part3(arr, num, remain- arr[start1], ++start1, start2, sub);
                sub.clear();
                start2++;
                start1 = start2;
                remain = num;
            }
            else if(arr[start1] < remain)
            {
                remain = remain - arr[start1];
                sub.add(arr[start1]);
                start1++;
            }
            else if(arr[start1] > remain)
            {
                sub.clear();
                start2++;
                start1 = start2;
                remain = num;
            }
        }
        part3(arr, num, remain, start1, start2, sub);
    }
 
}
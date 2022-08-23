package pck;
/**
 * Part2 Class for the first problem
 * Count number of items in the array between given integers.
 */
public class Part2
{
    /**
     * Empty Contructor
     */
    public Part2()
    {
        // intentionally empty
    }

    /**
     * This is the constructor for the class. It takes in an array of integers, and two numbers.
     * It then calls the method `part2(arr, num1, num2)` and prints the result.
     */
    public Part2(int[] arr, int num1, int num2)
    {
        System.out.println(part2(arr, num1, num2));
    }
        
    /**
     * Given an array of integers, find the pair of integers that have the smallest absolute difference
     * between them. 
     * Return the difference
     * 
     * @param arr the array to search
     * @param num1 The first number in the pair we're looking for.
     * @param num2 The number to be searched
     * @return The number of times the two numbers add up to 2020.
     */
    public static int part2(int[] arr, int num1, int num2)
    {
        return part2(arr,num1, num2, 0, arr.length);
    }

    /**
     * Given an array of integers, find the number of subarrays that satisfy the following conditions:
     * 
     * The integer at the middle of the subarray must be between two numbers num1 and num2
     * 
     * @param arr the array of integers
     * @param num1 the first number in the range
     * @param num2 The upper bound of the range.
     * @param min the minimum index of the array
     * @param max The maximum value of the array.
     * @return The number of times the number is found in the array.
     */
    public static int part2(int[] arr, int num1, int num2 ,int min, int max)
    {
        if(min == max) 
        {   
            if(min >= arr.length) return 0;
            if(arr[min] >= num1 && arr[max] <= num2) return 1;
            else return 0;
        }
        else if(max > min)
        {
            int mid = min + (max - min) / 2;
            if(arr[mid] >= num1 && arr[mid] <= num2)
            {
                return 1 + part2(arr, num1, num2, mid + 1, max) + part2(arr, num1, num2, min, mid - 1);
            } 
            else if(arr[mid] > num2) return part2(arr, num1, num2, min, mid - 1);
            else if(arr[mid] < num1) return part2(arr, num1, num2, mid + 1, max);
        }
        return 0;
    }

}
import java.time.Duration;

public class hw2{

    public static void main(String[] args) 
    {
        int[] arr1 = new int[25];
        int[] arr2 = new int[50];
        int[] arr3 = new int[100];

        long startTime, endTime, runTime;

        System.out.println("Iteration \n");
        startTime = System.nanoTime();
        Sum_Iteration(arr1, 0);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Array with n = 25 elements :" + runTime/100000f + "ms");

        startTime = System.nanoTime();
        Sum_Iteration(arr2, 0);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Array with n = 50 elements :" + runTime/100000f + "ms");

        startTime = System.nanoTime();
        Sum_Iteration(arr3, 0);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Array with n = 100 elements :" + runTime/100000f + "ms");


        System.out.println("\nRecursion\n");
        startTime = System.nanoTime();
        Sum_Recursive(arr1, 0,0,0);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Array with n = 25 elements :" + runTime/100000f + "ms");

        startTime = System.nanoTime();
        Sum_Recursive(arr2, 0,0,0);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Array with n = 50 elements :" + runTime/100000f + "ms");

        startTime = System.nanoTime();
        Sum_Recursive(arr3, 0,0,0);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Array with n = 100 elements :" + runTime/100000f + "ms");

    }

    /**
     * Given an array of integers, find the number of pairs of integers in the array that sum to a
     * given total
     * 
     * @param arr the array to be searched
     * @param total the sum of the two integers you're looking for
     */
    static void Sum_Iteration(int[] arr, int total)
    {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length; j++)
                if(arr[i] + arr[j] == total) 
                    count++;
    }

    /**
     * Given an array of integers, find the number of pairs of integers in the array that sum to a
     * given value
     * 
     * @param arr The array of integers.
     * @param total The sum we're looking for
     * @param index1 The index of the first element in the array.
     * @param index2 The index of the second element in the array.
     */
    static void Sum_Recursive(int[] arr, int total, int index1, int index2)
    {
        int count = 0;
        if (index1 == arr.length) return;

        if(index2 < arr.length)
        {
            if(arr[index1] + arr[index2] == total) count++;
            
            Sum_Recursive(arr, total, index1, index2 + 1);
        }
        else
        {
            index1++;
            index2 = index1;
            Sum_Recursive(arr, total, index1, index2);
        }
    }
}
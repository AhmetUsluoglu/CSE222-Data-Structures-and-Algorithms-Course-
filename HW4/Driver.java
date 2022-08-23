import pck.*;

/**
 * This class contains the main method that tests the other classes
 */
public class Driver
{
    /**
     * Main class to test the problems.
     * @param args Commad line argument is not used in this program.
     */
    public static void main(String[] args)
    {
        // TESTING PART1
        System.out.println("\n\t\tTesting Part1\n");

        String longStr = "aaaaaa";
        String shortStr = "aaa";
        System.out.println("Long string is = aaaaaa");
        System.out.println("Short string is = aaa");
        System.out.print("4th occurence of short string is at index = ");
        new Part1(longStr, shortStr, 4);
        System.out.println();

        longStr = "...aaa...aaa...aaa...";
        shortStr = "aaa";
        System.out.println("Long string is = ...aaa...aaa...aaa...");
        System.out.println("Short string is = aaa");
        System.out.print("4th occurence of short string is at index = ");
        new Part1(longStr, shortStr, 5);
        System.out.println();

/////////
        // TESTING PART2
        System.out.println("\n\t\tTesting Part2\n");

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println("Array = {1,2,3,4,5,6,7,8,9,10,11,12,13}");
        System.out.println("Search between -5 - 145 in the Array");
        System.out.print("Number of items between -5 - 145 in the Array = ");
        new Part2(arr, -5, 145);
        System.out.println();

        int[] arr0 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println("Array = {1,2,3,4,5,6,7,8,9,10,11,12,13}");
        System.out.println("Search between -5 - 145 in the Array");
        System.out.print("Number of items between 14 - 100 in the Array = ");
        new Part2(arr0, 14, 100);
        System.out.println();

        int[] arr01 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println("Array = {1,2,3,4,5,6,7,8,9,10,11,12,13}");
        System.out.println("Search between 4 - 10 in the Array");
        System.out.print("Number of items between 4 - 10 in the Array = ");
        new Part2(arr01, 4, 10);
        System.out.println();


////////
        // TESTING PART3
        System.out.println("\n\t\tTesting Part3\n");
        
        int[] arr1 = new int[]{5,2,3,8,6,4,2,7,9,1,3,5,4,2,4,9,1,3,4,2,6};
        System.out.println("Array = {5,2,3,8,6,4,2,7,9,1,3,5,4,2,4,9,1,3,4,2,6}");
        System.out.println("\tTarget is 28");
        new Part3(arr1, 28);
        System.out.println();

        int[] arr2 = new int[]{12,5,32,8,1,10,1,7,8,5,4,2,34,9,4,1,26,5,4};
        System.out.println("\nArray = {12,5,32,8,1,10,1,7,8,5,4,2,34,9,4,1,26,5,4}");
        System.out.println("\tTarget is 18");
        new Part3(arr2, 18);
        System.out.println();

        int[] arr3 = new int[]{1,1,1,1,1,-1,1,-1,1,0};
        System.out.println("\nArray = {1,1,1,1,1,-1,1,-1,1,0}");
        System.out.println("\tTarget is 5");
        new Part3(arr3, 5);
        System.out.println();

///////
        // BONUS: TESTING PART5
        System.out.println("\n\t\tTesting Part5\n");

        String str = ".......";
        System.out.println("Length = " + 7);
        System.out.println(str);
        new Part5(str);
        System.out.println();

        String str1 = "..........";
        System.out.println("Length = " + 10);
        System.out.println(str1);
        new Part5(str1);
        System.out.println();

    }

}

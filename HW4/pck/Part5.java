package pck;
/**
 * Part3 Class for the first problem
 * In the array find all possible combinations of integers that add up to a given integer
 */
public class Part5
{
    /**
     * Empty Contructor
     * 
     */
    public Part5()
    {
        // intentionally empty
    }
    /*
    * A constructor that calls the part5 method.
    */
    public Part5(String str)
    {
        part5(str);
    }


    /**
     * Given an array, print the array's all possible combinations of filled state with minimum of 3 sized blocks 
     * @param str The string to be converted.
     */
    public static void part5(String str)
    {
        part5(str, str.length(), 0, 3, 0);
    }

    /**
     * The function takes in a string, the length of the string, the starting index of the string, the
     * length of the substring, and the initial starting index of the substring. 
     * 
     * The function prints the substring if the length of the substring is equal to the length of the
     * string. 
     * 
     * If the length of the substring is less than the length of the string, the function prints the
     * substring and then calls itself recursively with the following parameters: 
     * 
     * The string, the length of the string, the starting index of the string, the length of the
     * substring + 1, and the initial starting index of the substring + the length of the substring. 
     * 
     * If the length of the substring is equal to the length of the string, the function prints the
     * substring and then calls itself recursively with the following parameters: 
     * 
     * The string, the length of the string, the starting index of
     * 
     * @param str the string to be printed
     * @param L The length of the string
     * @param start1 the starting index of the string to be printed
     * @param lenx the length of the string that has been printed so far
     * @param initialStart the starting index of the string
     */
    public static void part5(String str, int L, int start1, int lenx, int initialStart)
    {
        if(str.length()<3) return;
        if(L == lenx) 
        {
            printStr(str, initialStart, lenx);
            return;
        }
        if(start1 + lenx < L)
        {
            part5(printStr(str, start1, lenx),L, start1 + lenx + 1, 3 , start1 + lenx + 1);
            start1++; 
        }
        else if(start1 + lenx == L)
        {
            printStr(str, start1, lenx);
            start1 = initialStart;
            lenx++;
        }
        else
        {
            start1 = initialStart;
            lenx++;
        }
        part5(str, L, start1, lenx, initialStart);
    }

    /**
     * Given a string, print the string with the characters at the given indices replaced with 'O'
     * 
     * @param str the string to be printed
     * @param start1 the starting index of the string to be printed
     * @param lenx the length of the string to be printed
     * @return Nothing is being returned.
     */
    public static String printStr(String str, int start1, int lenx)
    {
        StringBuilder sb = new StringBuilder(str);
        if(start1 + lenx <= str.length())
        {
            for(int i = start1; i < start1 + lenx; i++)
            {
                sb.setCharAt(i, 'O');
            }
            System.out.println(sb);
        }

        return new String(sb);
    }


}

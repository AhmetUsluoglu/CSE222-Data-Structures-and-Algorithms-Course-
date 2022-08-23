package pck;

/**
 * Part1 Class for the first problem
 * Search nth occurence of substring in the main string
 */
public class Part1
{   
    /**
     * Empty Contructor
     */
    public Part1()
    {
        // intentionally empty
    }
    /**
     *  A constructor that takes 3 parameters and prints the result of `part1(lStr, sStr, occur)`
    */ 
    public Part1(String lStr, String sStr, int occur)
    {
        System.out.println(part1(lStr, sStr, occur));
    }

    /**
     * Given a long string and a short string, find the number of occurences of the short string in the
     * long string
     * 
     * @param longStr The string that is being searched.
     * @param shortStr The string that is being searched for.
     * @param occurence the number of occurences of the short string in the long string
     * @return The number of occurences of the short string in the long string.
     */
    public static int part1(String longStr, String shortStr, int occurence)
    {
        return part1(longStr, shortStr, occurence, 0, 0);
    }
    
    /**
     * Given a string, find the index of the first occurence of a substring
     * 
     * @param longStr The string that you want to search in.
     * @param shortStr The string we're looking for.
     * @param occurence The number of times the substring is to be found.
     * @param search The index of the first character of the substring to be searched.
     * @param count The number of times the substring has been found.
     * @return The index of the nth occurence of the short string in the long string.
     */
    public static int part1(String longStr, String shortStr, int occurence, int search, int count)
    {
        if(longStr.length() == 0) return -1;
        if(shortStr.length() == 0) return -1;
        if(occurence <= 0) return -1;
        
        search = longStr.indexOf(shortStr, search);

        if(search >= 0) count++;
        else return -1;
        if(count == occurence) return search;
        if(search + shortStr.length() == longStr.length()) return -1;
        
        return part1(longStr, shortStr, occurence, ++search, count);
    }

}
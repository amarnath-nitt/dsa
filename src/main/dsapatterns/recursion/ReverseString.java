package main.dsapatterns.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello World";
        String result = reverseString(input, 0, input.length()-1);
        System.out.println(input + " reversed is: " + result);
    }

    /**
     * Reverses a string using recursion.
     * @param str the string to reverse
     * @param start the starting index
     * @param end the ending index
     * @return the reversed string
     */
    public static String reverseString(String str, int start, int end) {
        return iterativeHelper(str, start, end);
    }

    /**
     * A helper method for recursively reversing a string.
     * @param str the string to reverse
     * @param start the starting index
     * @param end the ending index
     * @return the reversed string
     */
    private static String recursionHelper(String str, int start, int end) {
        if(start >= end) return str;
        char[] charArray = str.toCharArray();
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
        return recursionHelper(new String(charArray), start + 1, end - 1);
    }

    /**
     * A helper method for iteratively reversing a string.
     * @param str the string to reverse
     * @param start the starting index
     * @param end the ending index
     * @return the reversed string
     */
    private static String iterativeHelper(String str, int start, int end) {
        if(start >= end) return str;
        char []  charArray = str.toCharArray();
        while(start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }



}

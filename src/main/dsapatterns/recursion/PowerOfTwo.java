package main.dsapatterns.recursion;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        boolean result = isPowerOfTwo(n);
        System.out.println(n + " is a power of two: " + result);
    }

    /**
     * Checks if a given integer is a power of two.
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public static boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    /**
     * Checks if a given integer is a power of two using bit manipulation.
     * @param n the integer to check
     * @return true if n is a power of two, false otherwise
     */
    public static boolean isPowerOfTwo2(int n) {
        /**
         * A number is a power of two if it has exactly one bit set in its binary representation.
         * For example, 8 (1000) is a power of two.
         * Subtracting 1 from a power of two flips all the bits after the single set bit.
         * Therefore, n & (n - 1) will be 0 if n is a power of two.
         * Also, we need to ensure n is positive.
         */
        return n > 0 && (n & (n - 1)) == 0;
    }
}

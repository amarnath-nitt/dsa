package main.dsapatterns.recursion;

public class SumOfDigit {
    public static void main(String[] args) {
        int n = 12345;
        int result = sumOfDigit(n);
        System.out.println("Sum of digits in " + n + ": " + result);
    }

    public static int sumOfDigit(int n) {
        return recursionHelper(n);
    }

    /**
     * A recursive helper method to calculate the sum of digits of a given number.
     * @param n the number for which to calculate the sum of digits
     * @return the sum of digits of n
     */
    private static int recursionHelper(int n) {
        if(n < 10) return n;
        return n % 10 + recursionHelper(n / 10);
    }

    /**
     * An iterative helper method to calculate the sum of digits of a given number.
     * @param n the number for which to calculate the sum of digits
     * @return the sum of digits of n
     */
    private static int iterativeHelper(int n) {
        if(n < 10) return n;
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

}

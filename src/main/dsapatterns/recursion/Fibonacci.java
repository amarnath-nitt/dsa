package main.dsapatterns.recursion;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        int result = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
    }

    public static int fibonacci(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return memoizedFibonacci(n, memo);
    }

    /**
     * A recursive helper method to calculate the nth Fibonacci number.
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    private static int recursionHelper(int n) {
        if (n <= 1) {
            return n;
        }
        return recursionHelper(n - 1) + recursionHelper(n - 2);
    }

    /**
     * A memoized recursive method to calculate the nth Fibonacci number.
     * @param n the position in the Fibonacci sequence
     * @param memo an array to store previously computed Fibonacci numbers
     * @return the nth Fibonacci number
     */
    private static int memoizedFibonacci(int n, int [] memo) {
        if (n <= 1) {
            return n;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] = memoizedFibonacci(n - 1, memo) + memoizedFibonacci(n - 2, memo);
        return memo[n];
    }

    /**
     * A dynamic programming method to calculate the nth Fibonacci number.
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    private static int dpFibonacci(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

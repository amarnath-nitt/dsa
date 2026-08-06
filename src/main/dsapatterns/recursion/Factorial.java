package main.dsapatterns.recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = -1;
        try {
            int result = factorial(n);
            System.out.println("Factorial of " + n + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static int factorial(int n) {
        return dpFactorial(n);
    }

    /**
     * Calculates the factorial of a given number using recursion.
     * @param n the number for which to calculate the factorial
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    private static int recursionHelper(int n) {
        if(n < 0) throw new IllegalArgumentException("Provided input number should be positive.");
        if(n == 0 || n == 1) return 1;
        return n * recursionHelper(n - 1);
    }

    /**
     * Calculates the factorial of a given number using iteration.
     * @param n the number for which to calculate the factorial
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static int iterativeFactorial(int n) {
        if(n < 0) throw new IllegalArgumentException("Provided input number should be positive.");
        int result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates the factorial of a given number using dynamic programming.
     * @param n the number for which to calculate the factorial
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static int dpFactorial(int n) {
        if(n < 0) throw new IllegalArgumentException("Provided input number should be positive.");
        int []  dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        return dp[n];
    }
}

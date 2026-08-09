package main.dsapatterns.recursion;

public class DecodeWays {
    public static void main(String[] args) {
        String input = "226";
        int result = numDecoding(input);
        System.out.println("Number of ways to decode \"" + input + "\": " + result);
    }

    public static int numDecoding(String s) {
        return recursiveApproachDecoding(s);
    }

    private static int recursiveApproachDecoding(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        return decodeHelper(s, s.length());
    }

    private static int decodeHelper(String s, int index) {
        if (index == 0) {
            return 1;
        }
        int result = 0;

        // Take one digit
        if (s.charAt(index - 1) != '0') {
            result = decodeHelper(s, index - 1);
        }

        // Take two digits
        if (index >= 2) {
            int twoDigit = Integer.parseInt(s.substring(index - 2, index));

            if (twoDigit >= 10 && twoDigit <= 26) {
                result += decodeHelper(s, index - 2);
            }
        }

        return result;
    }

    private static int dynamicApproachDecoding(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one way to decode
        dp[1] = 1; // Base case: single character (not '0') has one way to decode

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            // Check if the last one digit is valid (1-9)
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check if the last two digits form a valid number (10-26)
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];


    }
}

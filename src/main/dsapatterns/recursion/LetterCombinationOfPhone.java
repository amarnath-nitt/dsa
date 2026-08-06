package main.dsapatterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {
    private static final String [] keyMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        String input = "23";
        List<String> result = letterCombinations(input);
        System.out.println("Letter combinations for input " + input + ": " + result);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        //backtrack(digits, 0, new StringBuilder(), result);
        iterativeApproach(digits, result);
        return result;
    }

    /**
     * A helper method for generating letter combinations using backtracking.
     * @param digits the input digits
     * @param index the current index
     * @param current the current combination being built
     * @param result the list to store the combinations
     */
    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = keyMap[Character.getNumericValue(digits.charAt(index))];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * An iterative approach for generating letter combinations.
     * @param digits the input digits
     * @param result the list to store the combinations
     */
    private static void iterativeApproach(String digits, List<String> result) {
        if(digits == null || digits.isEmpty()) return;
        result.add("");
        for(char digit : digits.toCharArray()) {
            String letters = keyMap[Character.getNumericValue(digit)];
            List<String> temp = new ArrayList<>();
            for(String combination : result) {
                for(char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }
            result.clear();
            result.addAll(temp);
        }
    }
}

package main.dsapatterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, new ArrayList<>(), result);
        System.out.println("Permutations: " + result);
    }

    private static void permutation(int[] nums, List<Integer> current, List<List<Integer>> result) {
        backtrack(nums, current, result);
    }

    /**
     * Generates all permutations of the given array using backtracking.
     * @param nums The input array of integers.
     * @param current The current permutation being built.
     * @param result The list to store all permutations.
     */
    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                permutation(nums, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    /**
     * Generates all permutations of the given array using an iterative approach.
     * @param nums The input array of integers.
     * @param index The current index being processed.
     * @param result The list to store all permutations.
     */
    public void iterativePermutation(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            iterativePermutation(nums, index + 1, result);
            swap(nums, index, i); // backtrack
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

}

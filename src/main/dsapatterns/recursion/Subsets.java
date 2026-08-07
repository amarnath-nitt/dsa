package main.dsapatterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println("Subsets of the array: ");
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        return iterativeApproach(nums);
    }

    /**
     * Generates all possible subsets of the given array using recursion.
     * */
    public static void recursionApproach(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        recursionApproach(nums, index + 1, current, result);
        current.remove(current.size() - 1);
        recursionApproach(nums, index + 1, current, result);
    }

    /**
     * Generates all possible subsets of the given array using an iterative approach.
     * */
    public static List<List<Integer>> iterativeApproach(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int totalMask = 1 << nums.length;
        for(int mask = 0; mask < totalMask; mask++){
            List<Integer> current = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((mask & (1 << i)) != 0){
                    current.add(nums[i]);
                }
            }
            result.add(current);
        }
        return result;
    }
}

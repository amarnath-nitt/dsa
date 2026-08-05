package main.dsapatterns.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySunEqualToK {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4,5};
        int k = 5;
        int count = subArraySumEqualToK(nums, k);
        System.out.println(count);
    }

    public static int subArraySumEqualToK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // Initialize with sum 0

        for (int num : nums) {
            prefixSum += num;
            if (sumMap.containsKey(prefixSum - k)) {
                count += sumMap.get(prefixSum - k);
            }
            sumMap.put(prefixSum, sumMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

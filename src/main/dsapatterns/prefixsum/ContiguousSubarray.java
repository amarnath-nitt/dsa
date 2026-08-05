package main.dsapatterns.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {
    public static void main(String[] args) {
        int [] nums = new int[]{0,1,1,1,1,1,0,0,0};
        int longestSubArray = findLongestContiguousSubarray(nums);
        System.out.println("Length of the longest contiguous subarray is: " + longestSubArray);
    }
    public static int findLongestContiguousSubarray(int[] nums) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1); // Initialize with sum 0 at index -1
        int prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 0 ? -1 : nums[i]);
            if (sumMap.containsKey(prefixSum)) {
                int currentLength = i - sumMap.get(prefixSum);
                maxLength = Math.max(maxLength, currentLength);
            }
            else {
                sumMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}

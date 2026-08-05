package main.dsapatterns.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
            int [] nums = new int[]{4,5,0,-2,-3,1};
            int k = 5;
            int count = subarraySumDivisibleByK(nums, k);
            System.out.println("Count of subarrays with sum divisible by " + k + " is: " + count);
    }
    public static int subarraySumDivisibleByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remainder = sum % k;
            if(remainder < 0 ) remainder += k;
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}

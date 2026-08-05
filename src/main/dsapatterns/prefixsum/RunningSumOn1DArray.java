package main.dsapatterns.prefixsum;

public class RunningSumOn1DArray {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};
        int [] result = runningSum(nums);
        System.out.println("Running sum of the array is: ");
        for (int j : result) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static int[] runningSum(int[] nums) {
        int [] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        return prefixSum;
    }
}

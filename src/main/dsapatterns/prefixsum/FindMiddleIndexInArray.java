package main.dsapatterns.prefixsum;

public class FindMiddleIndexInArray {
    public static void main(String[] args) {
        int [] nums = new int[]{2,3,-1,8,4};
        int index = findMiddleIndex(nums);
        System.out.println(index);
    }

    public static int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

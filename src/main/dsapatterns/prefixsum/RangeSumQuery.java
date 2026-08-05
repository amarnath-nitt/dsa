package main.dsapatterns.prefixsum;

public class RangeSumQuery {
    private int[] prefixSum;
    public RangeSumQuery(int[] nums) {
        this.prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
    }
    public static void main(String[] args) {
        int [] nums = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);
        System.out.println("Sum of elements between indices 0 and 2: " + rangeSumQuery.sumRange(0, 2));
        System.out.println("Sum of elements between indices 2 and 5: " + rangeSumQuery.sumRange(2, 5));
        System.out.println("Sum of elements between indices 0 and 5: " + rangeSumQuery.sumRange(0, 5));
    }

    public int sumRange(int i, int j) {
        return  prefixSum[j+1] - prefixSum[i];
    }
}

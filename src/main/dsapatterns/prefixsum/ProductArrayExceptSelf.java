package main.dsapatterns.prefixsum;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};
        int [] result = productExceptSelf(nums);
        System.out.println("Product array except self: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product *= nums[i];
        }
        return result;
    }
}

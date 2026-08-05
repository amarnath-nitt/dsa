package main.dsapatterns.prefixsum;

public class FindPivotIndex {
    public static void main(String[] args) {
        int [] numbs = new int[]{1,7,3,6,5,6};
        int index  = pivotIndex(numbs);
        System.out.println(index);
    }

    public static int pivotIndex(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        return totalSumApproach(nums);
    }

    private static int totalSumApproach(int[] numbs) {
        int totalSum = 0;
        for (int numb : numbs) {
            totalSum += numb;
        }
        int leftSum = 0;
        for(int i = 0; i< numbs.length; i++){
            if(leftSum == totalSum - leftSum - numbs[i]){
                return i;
            }
            leftSum += numbs[i];
        }
        return -1;
    }

    private static int prefixSumApproach(int[] numbs) {
        int [] prefixSum = new int[numbs.length+1];
        for(int i = 1; i<= numbs.length; i++){
            prefixSum[i] = prefixSum[i-1] + numbs[i-1];
        }
        for(int i = 1; i< numbs.length; i++){
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[numbs.length] - prefixSum[i+1];
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}

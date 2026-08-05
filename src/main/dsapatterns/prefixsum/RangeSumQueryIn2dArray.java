package main.dsapatterns.prefixsum;

public class RangeSumQueryIn2dArray {
    private int[][] prefixSum;
    public RangeSumQueryIn2dArray(int[][] matrix) {
        prefixSum = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                // current cell prefix sum = sum of prefix sum of cell above + sum of prefix sum of cell to the left - sum of prefix sum of cell diagonally above left + current cell value from matrix.
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RangeSumQueryIn2dArray rangeSumQueryIn2dArray = new RangeSumQueryIn2dArray(matrix);
        System.out.println("Sum of elements between (0,0) and (1,1): " + rangeSumQueryIn2dArray.sumRegion(0, 0, 1, 1));
        System.out.println("Sum of elements between (1,1) and (2,2): " + rangeSumQueryIn2dArray.sumRegion(1, 1, 2, 2));
        System.out.println("Sum of elements between (0,0) and (2,2): " + rangeSumQueryIn2dArray.sumRegion(0, 0, 2, 2));
    }

    public int sumRegion(int i, int j, int k, int l) {
        // region sum = total sum - top - left + top-left;
        return prefixSum[k+1][l+1] - prefixSum[i][l+1] - prefixSum[k+1][j] + prefixSum[i][j];
    }

}

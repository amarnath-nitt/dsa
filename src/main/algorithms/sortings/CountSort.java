package main.algorithms.sortings;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        countingSort(arr);
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }

    public static void countingSort(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int x : arr) max = Math.max(x, max);
        int [] freq = new int[max+1];
        for(int x : arr){
            freq[x]++;
        }
        int index = 0;
        for(int i=0; i<=max; i++){
            while(freq[i]-- > 0){
                arr[index++] = i;
            }
        }
    }
}

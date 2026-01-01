package dsa;

import java.util.Arrays;

public class ClosestThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 2, 4};
        int target = 4;
        System.out.println(closest3Sum(arr, target));
    }

    private static int closest3Sum(int[] arr, int target) {
        int n = arr.length;
        int res = 0;
        int sum = 0;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;
            while(j < k) {
                sum = arr[i] + arr[j] + arr[k];
                if(Math.abs(sum - target) < minDiff){
                    minDiff = Math.abs(sum - target);
                    res = sum;
                } // If multiple sums are closest, take maximum one
                else if(Math.abs(sum - target) == minDiff){
                    res = Math.max(sum, res);
                }

                if(sum > target)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}

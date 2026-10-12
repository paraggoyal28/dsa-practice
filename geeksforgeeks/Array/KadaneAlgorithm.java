/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/kadanes-algorithm-1587115620
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class KadaneAlgorithm {

    int maxSubarraySum(int[] arr) {
        // Code here
        if (arr == null || arr.length == 0) return 0;

        int maxSum = arr[0];
        int maxCurrentSum = arr[0];
        
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            maxCurrentSum = Math.max(arr[i], arr[i] + maxCurrentSum);
            maxSum = Math.max(maxSum, maxCurrentSum);
        }
        
        return maxSum;
    }
}




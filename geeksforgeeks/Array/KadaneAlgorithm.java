/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/kadanes-algorithm-1587115620
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {

    int maxSubarraySum(int[] arr) {
        // Code here
        int start = 0, end = 0, tempStart = 0;
        int maxSum = arr[0];
        int maxCurrentSum = arr[0];
        
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            if (arr[i] > maxCurrentSum + arr[i]) {
                maxCurrentSum = arr[i];
                tempStart = i;
            } else {
                maxCurrentSum += arr[i];
            }

            if (maxCurrentSum > maxSum) {
                maxSum = maxCurrentSum;
                start = tempStart;
                end = i;
            }
        }
        
        return maxSum;
    }
}




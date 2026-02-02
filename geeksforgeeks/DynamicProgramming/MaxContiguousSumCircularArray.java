/*
problem: https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int totalSum = arr[0];
        int currMax = arr[0], globalMax = arr[0];
        int currMin = arr[0], globalMin = arr[0];
        
        int n = arr.length;
        
        for (int i = 1; i < n; ++i) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            globalMax = Math.max(currMax, globalMax);
            currMin = Math.min(currMin + arr[i], arr[i]);
            globalMin = Math.min(currMin, globalMin);
            totalSum += arr[i];
        }
        
        // all negative return the max negative number
        if (globalMax < 0) {
            return globalMax;
        }
        
        return Math.max(globalMax, totalSum - globalMin);
    }
}

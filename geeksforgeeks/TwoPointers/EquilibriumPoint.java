/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/equilibrium-point-1587115620
author: parag kumar goyal
TC: O(n) where n is the length of array, SC: O(1)
*/

class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
        // calculate left prefix sum
        // calculate right prefix sum
        // at each index check for the left sum
        // and right sum equal
        int totalSum = 0;
        int n = arr.length;
        int prefSum = 0;
        for (int ele: arr) {
            totalSum += ele;
        }
        
        for (int pivot = 0; pivot < n; ++pivot) {
            int suffSum = totalSum - prefSum - arr[pivot];
            if (prefSum == suffSum) {
                return pivot;
            }
            prefSum += arr[pivot];
        }
        
        return -1;
    }
}

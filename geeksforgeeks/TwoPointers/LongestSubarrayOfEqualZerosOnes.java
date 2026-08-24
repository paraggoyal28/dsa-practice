/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/largest-subarray-of-0s-and-1s
author: parag kumar goyal
TC: O(n) SC: O(n)
*/

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        // convert 0s to -1s
        // and calculate sum of 0
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixSumIdx = new HashMap<>();
        int longestLen = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            prefixSum += (arr[i] == 0 ? -1 : 1);
            if (prefixSumIdx.containsKey(prefixSum)) {
                longestLen = Math.max(longestLen, 
                    i - prefixSumIdx.get(prefixSum));
            } else {
                prefixSumIdx.put(prefixSum, i);
            }
            if (prefixSum == 0) {
                longestLen = Math.max(longestLen, i + 1);
            }
        }
        return longestLen;
    }
}
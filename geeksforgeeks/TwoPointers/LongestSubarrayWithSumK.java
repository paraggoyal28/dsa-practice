/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/longest-sub-array-with-sum-k0809
author: parag kumar goyal
TC: O(n), SC: O(n)
*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> prefixSumIdx = new HashMap<>();
        int n = arr.length;
        int prefixSum = 0;
        int longestLength = 0;
        for (int i = 0; i < n; ++i) {
            prefixSum += arr[i];
            
            if (prefixSum == k) {
                longestLength = Math.max(longestLength, i + 1);
            }            
            
            if (prefixSumIdx.containsKey(prefixSum - k)) {
                longestLength = Math.max(longestLength,
                    i - prefixSumIdx.get(prefixSum - k));
            } 
            
            if (!prefixSumIdx.containsKey(prefixSum)) {
                prefixSumIdx.put(prefixSum, i);
            }
        }
        
        return longestLength;
    }
}
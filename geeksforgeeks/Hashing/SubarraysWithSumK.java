/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/subarrays-with-sum-k
author: parag kumar goyal
TC: O(N) SC: O(N)
*/

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> prefixSumMp = new HashMap<>();
        int prefixSum = 0;
        int n = arr.length;
        int cnt = 0;
        prefixSumMp.put(0, 1);
        for (int i = 0; i < n; ++i) {
            prefixSum += arr[i];
            cnt += prefixSumMp.getOrDefault(prefixSum - k, 0);
            prefixSumMp.put(prefixSum, 
                prefixSumMp.getOrDefault(prefixSum, 0) + 1);
        }
        
        return cnt;
    }
}
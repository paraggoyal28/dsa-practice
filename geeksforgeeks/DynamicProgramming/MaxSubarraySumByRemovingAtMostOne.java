/*
problem: https://www.geeksforgeeks.org/problems/max-sum-subarray-by-removing-at-most-one-element/1
author: parag kumar goyal
TC: O(n) where n is the length of the array
SC: O(1)
*/

class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here
        int n = arr.length;

        if (n == 0) return 0;

        int noDel = arr[0];
        int oneDel = 0;
        int ans = arr[0];

        for (int i = 1; i < n; ++i) {
            int newNoDel = Math.max(noDel + arr[i], arr[i]);
            int newOneDel = Math.max(oneDel + arr[i], noDel);

            noDel = newNoDel;
            oneDel = newOneDel;

            ans = Math.max(ans, Math.max(noDel, oneDel));
        }

        return ans;
    }
}
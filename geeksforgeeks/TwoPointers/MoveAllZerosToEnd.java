/*
problem: https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int start = 0;
        int n = arr.length;
        for (int end = 0; end < n; ++end) {
            if (arr[end] > 0) {
                arr[start] = arr[end];
                start++;
            }
        }
        
        for (int idx = start; idx < n; ++idx) {
            arr[idx] = 0;
        }
    }
}
/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/move-all-zeroes-to-end-of-array0751
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    void pushZerosToEnd(int[] arr) {
        // code here
        int start = 0;
        for (int end = 0, n = arr.length; end < n; ++end) {
            if (arr[end] != 0) {
                swap(arr, start, end);
                start++;
            }
        }
    }
}
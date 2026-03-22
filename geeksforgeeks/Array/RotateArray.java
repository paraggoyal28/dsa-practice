/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/rotate-array-by-n-elements-1587115621
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    static void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        d %= n;
        
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }
    
    private static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
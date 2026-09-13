/*
problem: https://www.geeksforgeeks.org/dsa/search-an-element-in-a-sorted-and-pivoted-array/
author: parag kumar goyal
TC: O(logn) SC: O(1)
*/

class Solution {
    int search(int[] arr, int key) {
        // code here
        int n = arr.length;
        
        int start = 0;
        int end = n-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == key) {
                return mid;
            }
            // if arr[mid] <= arr[end] then the 
            // array sorted from mid to end
            if (arr[mid] <= arr[end]) {
                if (arr[mid] <= key && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // array sorted from start to mid
                if (arr[start] <= key && key <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}


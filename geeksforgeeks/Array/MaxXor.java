/*
problem: https://www.geeksforgeeks.org/problems/max-xor-subarray-of-size-k/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int maxXorValue = 0;
        int xorValue = 0;
        int n = arr.length;
        for (int idx = 0; idx < n; ++idx) {
            if (idx >= k) {
                xorValue ^= arr[idx-k];
            } 
            xorValue ^= arr[idx];
            if (idx >= k - 1) { 
                maxXorValue = Math.max(maxXorValue, xorValue);
            }
        }
        
        return maxXorValue;
    }
}

/* Slightly more cleaner */
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0; // Edge case safety

        int currentXor = 0;
        // Calculate XOR of first window
        for (int i = 0; i < k; i++) {
            currentXor ^= arr[i];
        }

        int maxXor = currentXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            currentXor ^= arr[i - k]; // Remove leftmost element
            currentXor ^= arr[i];     // Add rightmost element
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}
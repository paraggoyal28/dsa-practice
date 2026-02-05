/*
problem: https://www.geeksforgeeks.org/problems/maximize-number-of-1s0905/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/



class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int maxOnesLength = 0;
        int n = arr.length;
        int zeroCnt = 0;
        int start = 0;
        for (int end = 0; end < n; ++end) {
            if (arr[end] == 0) {
               zeroCnt++; 
            }
            
            while (cnt > k) {
                if (arr[start] == 0) {
                    zeroCnt--;
                }
                start++;
            }
            
            // now the array has at most k zeros 
            // and all ones
            maxOnesLength = Math.max(maxOnesLength, 
                end - start + 1);
        }
        
        return maxOnesLength;
    }
}
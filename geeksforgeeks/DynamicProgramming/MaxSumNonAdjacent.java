/*
problem: https://www.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int prevPrev = arr[0];
        int prev = Math.max(arr[1], arr[0]);
        
        for (int idx = 2; idx < n; ++idx) {
            int current = Math.max(prevPrev + arr[idx], prev);
            prevPrev = prev;
            prev = current;
        }
        
        return prev;
    }
}


/*
problem: https://www.geeksforgeeks.org/problems/number-of-unique-paths5339/1
author: parag kumar goyal
TC: O(min(a, b))
SC: O(1)
*/

class Solution {
  public:
    // Function to find total number of unique paths.
    int NumberOfPath(int a, int b) {
    
        long long res = 1;
        int n = a + b - 2;
        int r = min(a, b) - 1;
        
        // r = a - 1
        // 1 to a - 1
        // a + b - 2 - a + 1 + 1
        // b
        // a + b - 2 - a + 1 + 2
        // b + 1
        // b * (b+1) * (b+2) * ... * (a + b - 2) 
        for (int i = 1; i <= r; ++i) {
            res = (res * (n - r + i))/i;
        } 
        
        return res;
    }
};
/*
problem: https://www.geeksforgeeks.org/problems/painting-the-fence3727/1
author: parag kumar goyal
TC: O(N)
SC: O(1)

*/

class Solution {
  public:
    int countWays(int n, int k) {
        // code here
        if (n == 0) return 0;
        
        if (n == 1) return k;
        
        int prevPrev = k;
        int prev = k*k;
        
        for (int num = 3; num <= n; ++num) {
            
            // if we choose two different colors 
            // for the last two poles then 
            // the number of ways to color is ways to color n-2 
            // * (k-1) as it should not be same as that of n-2th 
            // pole color or if we color last pole different 
            // from the previous then it is to be different from
            // previous so (n-1)*(k-1)
            
            int curr = (prev + prevPrev) * (k-1);
            prevPrev = prev;
            prev = curr;
        }
        
        
        return prev;
    }
};
/*
problem: https://www.geeksforgeeks.org/problems/maximize-dot-product2649/1
author: parag kumar goyal
TC: O(m*n)
SC: O(m*n)
*/



class Solution {
    public int maxDotProduct(int n, int m, int a[], int b[]) {
        
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 1; i <= m; ++i) {
            for (int j = i; j <= n - m + i; ++j) {
                
                // Option 1: Pair a[i-1] with b[j-1]
                int take = a[j-1] * b[i-1] + dp[i-1][j-1];
                
                // Option 2: Ignore if j > i
                int skip = (j > i) ? dp[i][j-1] : 0;
                
                
                dp[i][j] = Math.max(take, skip);
            }
        }
        
        
        return dp[m][n];
    }
    
}
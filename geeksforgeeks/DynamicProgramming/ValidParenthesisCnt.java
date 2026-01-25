/*
problem: https://www.geeksforgeeks.org/problems/valid-number-of-parenthesis/1
author: parag kumar goyal

*/

// TC: O(n)
// SC: O(1)
class Solution {
    int findWays(int n) {
        // code here
        if (n % 2 != 0) return 0;
        int k = n / 2;
        
        int res = 1;
        for (int i = 1; i <= k; ++i) {
            // Using the formula: C(n, i) = C(n, i-1) * (n-i+1) / i
            // Here we apply it to the Catalan product form
            res = res * (2 * k - i + 1) / i;
        }
        return res / (k + 1);
    }
}

// TC: O(n^2)
// SC: O(n)
// Formula C(n+1) = Summation (i = 0 to n) Ci*Cn-i
class Solution {
    int findWays(int n) {
        // If length is odd, no valid sequence exists
        if (n % 2 != 0) return 0;
        
        int pairs = n / 2;
        int dp[] = new int[pairs + 1];
        
        dp[0] = 1; // Base case: 1 way to arrange 0 pairs (empty string)
        
        for (int i = 1; i <= pairs; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        return dp[pairs];
    }
};

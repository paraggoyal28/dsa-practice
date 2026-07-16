/*
problem: https://www.geeksforgeeks.org/problems/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum0733/1
author: parag kumar goyal
*/

/*
Approach1: Recursively Try all - O(n*(9^n))
SC: O(n)
*/

class GFG {

    private static int countRec(int n, int sum) {
        
        // Base Case: If no digits left
        // 
        if (n == 0) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }

        // If sum is 0, there is exactly one valid number with all remaining digits as 0
        if (sum == 0) {
            return 1;
        }

        int ans = 0;

        // Traverse through digits 0-9 to calculate 
        // the count of numbers recursively
        for (int i = 0; i <= 9; ++i) {
            if (sum - i >= 0) {
                ans += countRec(n-1, sum - i);
            }
        }

        return ans;
    }

    static int countWays(int n, int sum) {
        int ans = 0;

        // Traverse through digits 1-9 as the first
        // digit cannot be zero for n-digit numbers
        for (int i = 1; i <= 9; ++i) {
            if (sum - i >= 0) {
                ans += countRec(n - 1, sum - i);
            }
        }

        if (ans == 0) return -1;
        return ans;
    }
}

/*
TC: O(n*sum)
SC: O(n*sum)
*/

class GFG {

    private static int countRec(int n, int sum, int[][] memo) {
        
        // Base Case: If no digits left
        // 
        if (n == 0) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }

        // If sum is 0, there is exactly one valid number with all remaining digits as 0
        if (sum == 0) {
            return 1;
        }

        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }

        int ans = 0;

        // Traverse through digits 0-9 to calculate 
        // the count of numbers recursively
        for (int i = 0; i <= 9; ++i) {
            if (sum - i >= 0) {
                ans += countRec(n-1, sum - i, memo);
            }
        }

        return memo[n][sum] = ans;
    }

    static int countWays(int n, int sum) {
        int[][] memo = new int[n+1][sum+1];

        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }

        int ans = 0;

        // Traverse through digits 1-9 as the first
        // digit cannot be zero for n-digit numbers
        for (int i = 1; i <= 9; ++i) {
            if (sum - i >= 0) {
                ans += countRec(n - 1, sum - i, memo);
            }
        }

        if (ans == 0) return -1;
        return ans;
    }
}

/*
Tabulation
TC: O(n*sum)
SC: O(n*sum)
*/

import java.util.Arrays;

class Solution {

    static int countWays(int n, int sum) {
        if (sum > 9 * n) return -1;

        // dp[len][s] = count of len-digit sequences
        // having digit sum equal to s
        int[][] dp = new int[n+1][sum + 1];

        dp[0][0] = 1;

        // Build the dp table
        for (int len = 1; len <= n; ++len) {
            for (int s = 0; s <= sum; ++s) {
                for (int digit = 0; digit <= 9; ++digit) {
                    if (s >= digit) {
                        dp[len][s] += dp[len-1][s - digit];
                    }
                }
            }
        }

        int ans = 0;

        // first digit should be non-zero
        for (int digit = 1; digit <= 9; ++digit) {
            if (digit <= sum) {
                ans += dp[n-1][sum - digit];
            }
        }

        return ans;
    }
}
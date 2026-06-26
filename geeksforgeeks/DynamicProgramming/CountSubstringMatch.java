/*
problem: https://www.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1
author: parag kumar goyal
TC: O(n*m)
SC: O(m)
*/

/*
Solution 1: 
Recursion
Time: O(2^n) and 
Space: O(n+m)
The idea is to recursively process the characters of s1. For each character, either skip it or include it
if it matches the current character of s2. Count all possible ways that successfully matches every character
of s2.
*/

import java.util.*;

public class GFG {

    static final int MOD = 1000000007;

    static int solve(String s1, String s2, int i, int j) {

        // All characters of s2 are matched
        if (j == s2.length()) {
            return 1;
        }

        // s1 is calculated before matching s2
        if (i == s1.length()) {
            return 0;
        }

        int ans = solve(s1, s2, i+1, j);

        if (s1.charAt(i) == s2.charAt(j)) {
            ans += solve(s1, s2, i+1, j+1);
        }
        
        return (int)(ans%MOD);
    }

    static int countWays(String s1, String s2) {
        return solve(s1, s2, 0, 0);
    }
}

/*
Solution 2: 
Using Bottom Up Dynamic Programming 
TC: O(n*m)
SC: O(n*m)

The idea is to use Dynamic Programming where dp[i][j] stores the number of ways to form the first j characters of s2
using the first i characters of s1. For each character of s1:
1. If it matches the current character of s2, either include it in the subsequence or skip it.
2. Otherwise, skip the current character of s1

*/

public class GFG {

    static int MOD = 1000000007;

    static int countWays(String s1, String s2) {

        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];

        // There is 0 way to find a subsequence inside an empty string
        for (int i = 0; i <= m; ++i) {
            dp[0][i] = 0;
        }

        // There is 1 way to find an empty subsequence inside a string
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%MOD;
                } else {
                    dp[i][j] = dp[i-1][j]%MOD;
                }
            }
        }


        return dp[n][m]%MOD;
    }
}

/*
Expected Approach - Space Optimized Dynamic Programming
TC: O(n*m)
SC: O(m)

The idea is to optimize the DP solution by using a simple array instead of a 2D array.
Here, dp[j] stores the number of ways to form the first j characters of s2. For each character of s1, 
we traverse s2 from right to left so that previous states are not overwritten. If the characters match, 
we either include the current character in the subsequence or skip it. This reduces the space requirement
while maintaining the same time complexity
*/

import java.util.*;

public class GFG {

    static int MOD = 1000000007;

    static int countWays(String s1, String s2) {

        int n = s1.length(), m = s2.length();

        int[] dp = new int[m+1];

        // 1 way to find empty subsequence
        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = m; j >= 1; --j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[j] = (dp[j-1] + dp[j])%MOD;
                }
            }
        }

        return dp[m]%MOD;
    }

}






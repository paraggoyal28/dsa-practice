/*
problem: https://www.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1
author: parag kumar goyal

*/

/*
TC: O(2^n), where n is the length of the floor
SC: O(n)
*/

import java.util.*;

public class GFG {

    public int countWays(int n, int m) {

        // for n < m, there is only one 1
        if (n < m) {
            return 1;
        }

        if (n == m) {
            return 2;
        }

        int horizontal = countWays(n - 1, m);

        int vertical = countWays(n - m, m);

        return horizontal + vertical;
    }
}

/*
count ways 
Dynamic Programming approach
TC: O(n)
SC: O(n)
*/

public class GFG {

    private static final int MOD = 1000000007;

    public int countWays(int n, int m) {

        int[] dp = new int[n+1];

        for (int i = 0; i <= n; ++i) {

            if (i < m) {
                dp[i] = 1;
            }

            else if (i == m) {
                dp[i] = 2;
            }

            else {
                dp[i] = (dp[i-1] + dp[i - m]) % MOD;
            }
        }

        return dp[n];
    }
}

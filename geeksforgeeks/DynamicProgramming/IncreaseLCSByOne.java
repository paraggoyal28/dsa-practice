/*
problem: https://www.geeksforgeeks.org/problems/count-ways-to-increase-lcs-length-of-two-strings-by-one2236/1
Given two strings s1 and s2 consisting of lowercase English letters of length n1 and n2 respectively, find the number of ways to insert exactly one character into string s1 such that the length of the Longest Common Subsequence (LCS) of both strings increases by exactly 1.
Author: parag kumar goyal
Brute Force
TC: O(26*n1*n1*n2)
SC: o(n1*n2)

Optimized:
TC: O(n1*n2) where n1 is the length of string s1 and n2 is the length of string s2
SC: O(n1*n2) 

*/

/*Brute Force*/

class Solution {

    private static int findLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[n][m];
    }

    int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int lcs = findLCS(s1, s2);
        int ways = 0;

        for (int i = 0; i <= n; ++i) {
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                String newS1 = s1.substring(0, i) + ch + s1.substring(i);
                if (findLCS(newS1, s2) == lcs + 1) {
                    ways++;
                }
            }
        }


        return ways;
    }
    
}

/* Optimized Solution */

class Solution {


    int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] forwardDP = new int[n+1][m+1];
        int[][] reversedDP = new int[n+1][m+1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    forwardDP[i][j] = forwardDP[i-1][j-1] + 1;
                } else {
                    forwardDP[i][j] = Math.max(forwardDP[i-1][j], forwardDP[i][j-1]);
                }
            }
        }

        for (int i = n-1; i >= 0; --i) {
            for (int j = m-1; j >= 0; --j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    reversedDP[i][j] = reversedDP[i+1][j+1] + 1;
                } else {
                    reversedDP[i][j] = Math.max(reversedDP[i+1][j], reversedDP[i][j+1]);
                }
            }
        }

        int lcsLength = forwardDP[n][m];
        int ways = 0;

        for (int i = 0; i <= n; ++i) {
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                for (int j = 0; j < m; ++j) {
                    if (s2.charAt(j) == ch && forwardDP[i][j] + 1 + reversedDP[i][j+1] == lcsLength + 1) {
                        ways++;
                        break;
                        // found a position in s2 for that character
                    }
                }
            }
        }

        return ways;

    }
}
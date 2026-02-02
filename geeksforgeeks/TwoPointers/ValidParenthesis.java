/*
problem: https://www.geeksforgeeks.org/problems/count-the-reversals0401/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    public int countMinReversals(String s) {
        int n = s.length();

        // An odd length string can never be balanced
        if (n % 2 != 0) {
            return -1;
        }

        int mismatchedOpen = 0;
        int mismatchedClosed = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                mismatchedOpen++;
            } else {
                // We found a '}'. Does it pair with a previous '{'?
                if (mismatchedOpen > 0) {
                    mismatchedOpen--;
                } else {
                    mismatchedClosed++;
                }
            }
        }

        // Each reversal can fix 2 brackets (e.g., "}}" to "{}" or "}{" to "{}")
        // Integer formula for ceil(n/2) is (n + 1) / 2
        int reversalsNeeded = (mismatchedOpen + 1) / 2 + (mismatchedClosed + 1) / 2;

        return reversalsNeeded;
    }
}
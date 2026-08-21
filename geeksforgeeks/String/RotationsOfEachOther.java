/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/check-if-strings-are-rotations-of-each-other-or-not-1587115620
author: parag kumar goyal
TC: O(n + m) where n is the size of original string and m is the size of pattern string 
*/

class Solution {
    private int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        for (int i = 1, len = 0; i < n;) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }
        return lps;
    }

    private boolean kmpContains(String text, String pattern) {
        if (pattern.isEmpty()) return true;

        int[] lps = computeLPS(pattern);

        for (int i = 0, j = 0; i < text.length();) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                if (++j == pattern.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.isEmpty()) return true;

        return kmpContains(s1 + s1, s2);
    }
}
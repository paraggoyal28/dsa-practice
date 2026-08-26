/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/longest-distinct-characters-in-string5848
author: parag kumar goyal
TC: O(n), SC: O(1)
*/

class Solution {
    
    public int longestUniqueSubstr(String s) {
        // code here
        int[] count = new int[256];
        int start = 0;
        int maxLen = 0;
        
        for (int end = 0, n = s.length(); end < n; ++end) {
            char current = s.charAt(end);
            count[current]++;
            
            while (count[current] > 1) {
                count[s.charAt(start)]--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}
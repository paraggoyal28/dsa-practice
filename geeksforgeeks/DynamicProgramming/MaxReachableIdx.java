/*
problem: https://www.geeksforgeeks.org/problems/maximum-reachable-index-difference/1
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    
    
    public int maxIndexDifference(String s) {
        // code here
        // base condition if no 'a' exists return -1
        int n = s.length();
        int startIdx = s.indexOf('a');

        if (startIdx == -1) {
            return -1;
        }

        boolean[] reachable = new boolean[26];
        reachable[0] = true;

        int maxDifference = 0;

        for (int i = startIdx + 1; i < n; i++) {
            int current = s.charAt(i) - 'a';

            if (current > 0 && reachable[current - 1]) {
                reachable[current] = true;
                maxDifference = Math.max(maxDifference, i - startIdx);
            }
        }

        return maxDifference;
    }
}
/*
problem: https://www.geeksforgeeks.org/problems/find-h-index--165609/1
author: parag kumar goyal
TC: O(N) where N is the size of papers
SC: O(N)
*/

class Solution {
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        int[] count = new int[n+1];
        
        for (int citation: citations) {
            if (citation >= n) count[n]++;
            else count[citation]++;
        }
        
        int totalPapers = 0;
        
        for (int i = n; i >= 0; --i) {
            totalPapers += count[i];
            if (totalPapers >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
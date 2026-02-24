/*
problem: https://www.geeksforgeeks.org/problems/longest-span-with-same-sum-in-two-binary-arrays5142/1
author: parag kumar goyal
TC: O(N)
SC: O(N) 
*/

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int len = a1.length;
        HashMap<Integer, Integer> diffSumOccurence = new HashMap<>();
        int longestSpan = 0;
        int continuousDiffSum = 0;
        
        for (int itr = 0; itr < len; ++itr) {
            continuousDiffSum += a1[itr] - a2[itr];
            
            if (continuousDiffSum == 0) {
                longestSpan = Math.max(longestSpan, 
                    itr + 1);
            }
            
            if (diffSumOccurence.containsKey(continuousDiffSum)) {
                longestSpan = Math.max(longestSpan,
                    itr - diffSumOccurence.get(continuousDiffSum));
            } 
               
            diffSumOccurence.putIfAbsent(continuousDiffSum, itr);
        }
        
        return longestSpan;
        
    }
}
/*
problem: https://www.geeksforgeeks.org/problems/last-moment-before-all-ants-fall-out-of-a-plank/1
author: parag kumar goyal
TC: O(n) where n is the size of array
SC: O(1)
*/

class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int lastMoment = 0;
        
        int leftSize = left.length;
        int rightSize = right.length;
        
        for (int itr = 0; itr < leftSize; ++itr) {
            lastMoment = Math.max(lastMoment, left[itr]);
        }
        
        for (int itr = 0; itr < rightSize; ++itr) {
            lastMoment = Math.max(lastMoment, n - right[itr]);
        }
        
        return lastMoment;
    }
}
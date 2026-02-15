/*
problem: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
author: parag kumar goyal
TC: O(NlogN) where N is the number of students
SC: O(1)
*/

class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        if (m == 0 || n == 0) return 0;
        
        Collections.sort(a);
        
        if (n < m) return -1;

        long minDiff = Long.MAX_VALUE;

        // Sliding window of size m
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = a.get(i + m - 1) - a.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
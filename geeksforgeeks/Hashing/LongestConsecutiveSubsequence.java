/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/longest-consecutive-subsequence2449
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

class Solution {
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> existingElements = new HashSet<>();
        int maxCnt = 0;
        for (int num: arr) {
            existingElements.add(num);
        }
        for (int num: arr) {
            if (existingElements.contains(num-1)) 
                continue;
            int cnt = 0;
            while (existingElements.contains(num)) {
                num++;
                cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}


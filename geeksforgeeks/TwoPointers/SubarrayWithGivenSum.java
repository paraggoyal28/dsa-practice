/*
Problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/subarray-with-given-sum-1587115621
author: parag kumar goyal
TC: O(n) SC: O(1)
*/


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int s = 0, e = 0;
        int curr = 0;
        for (int i = 0, n = arr.length; i < n; ++i) {
            curr += arr[i];
            
            if (curr >= target) {
                e = i;
                
                while (s < e && curr > target) {
                    curr -= arr[s];
                    s++;
                }
                
                if (curr == target) {
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }
            }
        }
        
        res.add(-1);
        return res;
    }
}

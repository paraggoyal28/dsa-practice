/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/count-distinct-elements-in-every-window
author: parag kumar goyal
TC: O(n) SC: O(k)
*/

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int s = 0;
        int n = arr.length;
        for (int idx = 0; idx < k; ++idx) {
            freq.put(arr[idx], freq.getOrDefault(arr[idx], 0) + 1);
        }
        
        ans.add(freq.size());
        
        for (int idx = k; idx < n; ++idx) {
            freq.put(arr[idx], freq.getOrDefault(arr[idx], 0) + 1);
            freq.put(arr[idx-k], freq.get(arr[idx - k]) - 1);
            
            if (freq.get(arr[idx - k]) == 0) {
                freq.remove(arr[idx - k]);
            }
            
            ans.add(freq.size());
        }
        
        return ans;
    }
}
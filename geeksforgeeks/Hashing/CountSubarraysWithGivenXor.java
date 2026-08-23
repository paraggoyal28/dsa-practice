/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/count-subarray-with-given-xor
author: parag kumar goyal
TC: O(N) where N is the number of elements in the array
SC: O(N) 
*/

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        // a1^a2^a3 = x
        // x^k = a1 
        // a2^a3 = k 
        
        HashMap<Integer, Integer> prefixXorMp = new HashMap<>();
        int prefixXor = 0;
        long cnt = 0;
        int n = arr.length;
        prefixXorMp.put(0, 1);
        for (int i = 0; i < n; ++i) {
            prefixXor ^= arr[i];
            cnt += prefixXorMp.getOrDefault(prefixXor^k, 0);
            prefixXorMp.put(prefixXor, 
                prefixXorMp.getOrDefault(prefixXor, 0) + 1);
        }
            
        return cnt;
    }   
}
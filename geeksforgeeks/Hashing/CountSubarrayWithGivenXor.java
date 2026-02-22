/*
problem: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
author: parag kumar goyal
TC: O(n) if HashMap operations are considered as O(1). In case of hash collisions, 
time complexity can increase to O(n^2)
SC: O(n) 
*/

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Long, Integer> prevXorValueCount = new HashMap<>();
        prevXorValueCount.put(0L, 1);
        
        long xorValue = 0;
        long subarrayCnt = 0;
        
        for (int num: arr) {
            xorValue ^= num;
            
            subarrayCnt += prevXorValueCount.getOrDefault(xorValue^k, 0);
            
            prevXorValueCount.put(xorValue, 
                prevXorValueCount.getOrDefault(xorValue, 0)+1);
        }
        
        return subarrayCnt;
    }
}
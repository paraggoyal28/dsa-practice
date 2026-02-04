/*
problem: https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        // if I find a sum occuring again
        // then all the numbers between the previous
        // occuring sum and this index constitute to zero sum
        // sliding window concept
        // if sum is greater than zero we start subtracting
        // negative number coming again then the sum 
        // 0 0 
        
        // count 
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        int sum = 0;
        int subarrayCnt = 0;
        sumCount.put(0, 1);
        for (int itr = 0, n = arr.length; itr < n; ++itr) {
            sum += arr[itr];
            
            if (sumCount.containsKey(sum)) {
                subarrayCnt += sumCount.get(sum);
            }
            
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        
        return subarrayCnt;
        
        // 1 + 2 + 1 + 2 
    }
}

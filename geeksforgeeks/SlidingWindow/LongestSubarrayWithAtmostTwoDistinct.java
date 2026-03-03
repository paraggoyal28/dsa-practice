/*
problem: https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int n = arr.length;
        int uniqueElements = 0;
        
        for (int end = 0; end < n; ++end) {
            freq.put(arr[end], freq.getOrDefault(arr[end], 0) + 1);
            if (freq.get(arr[end]) == 1) {
                uniqueElements++;
            }
            
            while (start < end && uniqueElements > 2) {
                freq.put(arr[start], freq.get(arr[start]) - 1);
                if (freq.get(arr[start]) == 0) {
                    uniqueElements--;
                }
                
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}


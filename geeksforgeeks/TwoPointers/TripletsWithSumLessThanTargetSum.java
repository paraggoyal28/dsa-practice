/*
problem: https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
author: parag kumar goyal
TC: O(N^2)
SC: O(1)
*/


class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        
        if (arr == null || n < 3) return 0;
        
        Arrays.sort(arr);
        
        long count = 0;
        
        for (int i = 0; i < n-2; ++i) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                long currentSum = arr[i] + arr[left] + arr[right];
                
                if (currentSum < sum) {
                   count += right - left;
                   left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        
        return count;
    }
}

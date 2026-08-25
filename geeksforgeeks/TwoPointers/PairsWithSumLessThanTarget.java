/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/count-pairs-whose-sum-is-less-than-target
author: parag kumar goyal
TC: O(nlogn) where n is the size of array
SC: O(1)
*/

class Solution {
    static int countPairs(int[] arr, int target) {
      
        // Sort the array to use two pointer technique
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int cnt = 0;

        // Two pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];

            // If the sum is less than target, then arr[left] 
            // will form a valid pair with every element 
            // from index left + 1 to right.
            if (sum < target) {
                cnt += right - left;
                left++;
            } 
          	else {
                right--;
            }
        }

        return cnt;
    }
}
/*
problem: https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
author: parag kumar goyal
TC: O(N) 
SC: O(1)
*/

class Solution {
public:
    int maxWater(vector<int> &arr) {
        int n = arr.size();
        if (n < 3) return 0; // Edge case: Not enough pillars to hold water

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                // We know there's a taller wall on the right, 
                // so water trapped depends on the leftMax.
                if (arr[left] >= leftMax) leftMax = arr[left];
                else waterTrapped += leftMax - arr[left];
                left++;
            } else {
                // Taller (or equal) wall on the left
                if (arr[right] >= rightMax) rightMax = arr[right];
                else waterTrapped += rightMax - arr[right];
                right--;
            }
        }
        return waterTrapped;
    }
};
/*
problem: https://www.geeksforgeeks.org/problems/koko-eating-bananas/1
author: parag kumar goyal
TC: O(NlogM), where M is the max pile size and N is the number of piles
SC: O(1) 
*/

class Solution {
    private long timeTakenToFinish(int[] arr, int speed) {
        long totalHours = 0;
        for (int pile : arr) {
            // Integer-based ceiling: (pile + speed - 1) / speed
            totalHours += (long) ((pile + speed - 1) / speed);
        }
        return totalHours;
    }

    public int kokoEat(int[] arr, int h) {
        int left = 1;
        int right = 0;

        // Find the maximum pile size for the upper bound
        for (int pile : arr) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if speed 'mid' allows Koko to finish in 'h' hours
            if (timeTakenToFinish(arr, mid) <= h) {
                result = mid;       // Potential answer found
                right = mid - 1;    // Try to find a smaller speed
            } else {
                left = mid + 1;     // Must eat faster
            }
        }
        
        return result;
    }
}
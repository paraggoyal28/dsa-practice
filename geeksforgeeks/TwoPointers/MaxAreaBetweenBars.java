/*
problem: https://www.geeksforgeeks.org/problems/dam-of-candies--141631/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    public int maxArea(List<Integer> height) {
        if (height == null || height.size() < 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.size() - 1;
        
        long maxAreaFormed = 0;
        
        while (left < right) {
            
            int width = right - left - 1;
            
            int minHeight = Math.min(height.get(left), height.get(right));
            
            long currentArea = (long) minHeight * width;
            
            if (currentArea > maxAreaFormed) {
                maxAreaFormed = currentArea;
            }
            
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        
        
        return maxAreaFormed;
    }
}
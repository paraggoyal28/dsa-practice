/*
problem: https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1
author: parag kumar goyal
TC: O(nlogn) where n is the size of array
The idea is to subtract the length of longest increasing sequence from the total length of array
SC: O(1)
*/

class Solution {
    
    
    private int findLISLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        List<Integer> tailList = new ArrayList<>();
        
        for (int num: nums) {
            // Find the position of num in tailList using binary search
            int pos = Collections.binarySearch(tailList, num);
            
            // element not found, binarySearch gives (-(insertionPosition) - 1)
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            if (pos == tailList.size()) {
                tailList.add(num);
            } else {
                tailList.set(pos, num);
            }
        }
        
        return tailList.size();
    }
    
    
    public int minDeletions(int[] arr) {
        // code here
        int n = arr.length;
        
        return n - findLISLength(arr);
    }
}
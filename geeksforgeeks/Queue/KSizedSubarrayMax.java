/*
problem: https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
author: parag kumar goyal
TC: O(N) where N is the size of array
SC: O(K) where K is the size of window
*/

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // Deque to store INDICES of array elements.
        // It helps us keep track of 'promising' candidates for the maximum.
        ArrayDeque<Integer> maxValueIdx = new ArrayDeque<>();
        
        ArrayList<Integer> maximumOfSubarrays = new ArrayList<>();
        
        int n = arr.length;
        
        // --- PHASE 1: Process the first window (indices 0 to k-1) ---
        for (int i = 0; i < k; ++i) {
            // Maintain the Monotonic Property:
            // Remove indices from the back if the current value (arr[i]) 
            // is greater than the value at those indices.
            // Why? Because those smaller values are now useless; they are 
            // older than the current element and smaller, so they will 
            // never be the maximum of any future window.
            while (!maxValueIdx.isEmpty() && 
                   arr[maxValueIdx.peekLast()] < arr[i]) {
                maxValueIdx.pollLast();            
            } 
            
            // Add the current index to the back of the deque
            maxValueIdx.add(i);
        }
        
        // The element at the front is always the maximum for the current window.
        // Record the max for the very first window (0 to k-1).
        maximumOfSubarrays.add(arr[maxValueIdx.peekFirst()]);
        
        // --- PHASE 2: Process the rest of the array (indices k to n-1) ---
        for (int i = k; i < n; ++i) {
            
            // 1. Remove Out-of-Bound Elements:
            // The window has moved. If the index at the front corresponds to 
            // an element that is no longer in the window (index <= i - k), remove it.
            while (!maxValueIdx.isEmpty() && 
                maxValueIdx.peekFirst() <= i - k) {
                maxValueIdx.pollFirst();        
            }
            
            // 2. Maintain Monotonic Property (same as Phase 1):
            // Remove smaller elements from the back to keep the deque sorted descendingly.
            while (!maxValueIdx.isEmpty() && 
                arr[maxValueIdx.peekLast()] < arr[i]) {
                maxValueIdx.pollLast();        
            }
            
            // 3. Add current element's index
            maxValueIdx.add(i);
            
            // 4. Record the result:
            // The front of the deque remains the index of the largest value 
            // for the current window ending at 'i'.
            maximumOfSubarrays.add(arr[maxValueIdx.peekFirst()]);
        }
        
        return maximumOfSubarrays;
    }
}
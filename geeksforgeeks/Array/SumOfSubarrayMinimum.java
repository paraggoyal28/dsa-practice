/*
problem: https://www.geeksforgeeks.org/problems/sum-of-subarray-minimum/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

public int sumSubMins(int[] arr) {
    // code here
    
    int n = arr.length;
    int sumMins = 0;
    // monotonic Stack
    Stack<Integer> leftValues = new Stack<>();
    Stack<Integer> rightValues = new Stack<>();
    
    ArrayList<Integer> leftBoundary = new ArrayList<>();
    ArrayList<Integer> rightBoundary = new ArrayList<>();
    
    // 1, 2, 3, 4
    // 1 
    // 2 
    // find the nearest minimum in the left 
    // and nearest minimum in the right
    // to find the nearest minimum in left
    // for current index
    // check the stack if it has greater values
    // if it has then remove those
    // similarly for right
    // if left is not found then -1
    // if right is not found then n 
    // n+1-1
    // n-0-1
    // what about duplicates
    // 1 1 2 
    // [1], [1], [1, 1], [1, 2]
    // [1, 1, 2]
    // [2]
    
    // 1 + 1 + 1 + 1 + 1 + 2 
    // n*1
    // (n-1)*1
    // (n-2)*2
    
    // so equality check will be for the 
    // right or left
    
    for (int idx = 0; idx < n; ++idx) {
        while (!leftValues.isEmpty() && arr[leftValues.peek()] >= arr[idx]) {
            leftValues.pop();
        }
        
        if (leftValues.isEmpty()) {
            leftBoundary.add(-1);
        } else {
            leftBoundary.add(leftValues.peek());
        }
        
        leftValues.push(idx);
    }
    
    for (int idx = n-1; idx >= 0; --idx) {
        while (!rightValues.isEmpty() && arr[rightValues.peek()] > arr[idx]) {
            rightValues.pop();
        }
        
        if (rightValues.isEmpty()) {
            rightBoundary.add(n);
        } else {
            rightBoundary.add(rightValues.peek());
        }
        
        rightValues.push(idx);
    }
    
    Collections.reverse(rightBoundary);
    
    for (int idx = 0; idx < n; ++idx) {
        
        sumMins += (rightBoundary.get(idx) - idx) 
                    * (idx - leftBoundary.get(idx))
                    * arr[idx];
    }
    
    return sumMins;
}



import java.util.*;

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007;
        
        // Using arrays instead of ArrayList for speed
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        
        // Using Deque as it is faster than Stack
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 1. Find Nearest Smaller to the Left (NSL)
        // Logic: Keep elements strictly smaller than arr[idx]
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            leftBoundary[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear(); // Reuse the stack
        
        // 2. Find Nearest Smaller to the Right (NSR)
        // Logic: Keep elements smaller than or equal to arr[idx]
        // This "strict on one side, non-strict on other" handles duplicates perfectly.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            rightBoundary[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // 3. Calculate the sum using long to prevent overflow
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - leftBoundary[i];
            long rightCount = rightBoundary[i] - i;
            
            // Formula: (Subarrays ending at i) * (Subarrays starting at i) * value
            long contribution = (leftCount * rightCount) % mod;
            contribution = (contribution * arr[i]) % mod;
            
            totalSum = (totalSum + contribution) % mod;
        }
        
        return (int) totalSum;
    }
}
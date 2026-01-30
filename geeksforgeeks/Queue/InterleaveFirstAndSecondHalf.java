/*
problem: https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

/* With aux stack */ 
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        
        int n = q.size();
        
        if (n == 0 || n%2 == 1) return;
        
        // q contains [1,2,3,4]
        Stack<Integer> firstHalf = new Stack<>();
        
        int halfSize = n/2;
        
        // firstHalf: [1, 2] 2 is top
        // q contains: [3, 4]
        for (int i = 0; i < halfSize; ++i) {
            firstHalf.push(q.poll());
        }
        
        // q: [3, 4, 2, 1]
        for (int i = 0; i < halfSize; ++i) {
            q.add(firstHalf.pop());
        }
        
        // q: [2, 1, 3, 4]
        for (int i = 0; i < halfSize; ++i) {
            q.add(q.poll());
        }
        
        // q: [3, 4] firstHalf: [2, 1] 1 is top
        for (int i = 0; i < halfSize; ++i) {
            firstHalf.push(q.poll());
        }
        
        // q: [1, 3, 2, 4]
        for (int i = 0; i < halfSize; ++i) {
            q.add(firstHalf.pop());
            q.add(q.poll());
        }
  
    }
}

/* With a aux queue */

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        
        // Basic safety checks
        if (n == 0 || n % 2 != 0) return;

        // In Java, we use LinkedList or ArrayDeque to implement the Queue interface
        Queue<Integer> firstHalf = new LinkedList<>();

        int halfSize = n / 2;

        // Step 1: Store the first half in the auxiliary queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(q.poll());
        }

        // Step 2: Interleave elements back into the original queue
        // poll() retrieves and removes the head; add() appends to the back
        while (!firstHalf.isEmpty()) {
            // Add element from the first half
            q.add(firstHalf.poll());
            
            // Move the current front of q (which is the second half) to the back
            q.add(q.poll());
        }
    }
}
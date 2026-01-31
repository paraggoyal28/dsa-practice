/*
problem: https://www.geeksforgeeks.org/problems/implement-k-queues-in-a-single-array/1
author: parag kumar goyal
TC: O(1) for each enqueue and dequeue operation
SC: O(N)
*/

import java.util.Arrays;

class KQueues {
    private final int[] data;       // The actual values
    private final int[] front;      // Front indices of k queues
    private final int[] rear;       // Rear indices of k queues
    private final int[] next;       // Links elements and free slots
    private int freeHead;           // Points to the start of the free list
    private final int capacity;
    private final int numQueues;

    public KQueues(int capacity, int numQueues) {
        this.capacity = capacity;
        this.numQueues = numQueues;
        
        data = new int[capacity];
        front = new int[numQueues];
        rear = new int[numQueues];
        next = new int[capacity];

        // Initialize all queues as empty
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);

        // Initialize the free list: each slot points to the next one
        freeHead = 0;
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1; // End of free list
    }

    public void enqueue(int item, int queueNum) {
        if (isFull()) {
            throw new RuntimeException("Global Array Overflow: No free space available.");
        }
        validateQueueIndex(queueNum);

        // 1. Grab a slot from the free list
        int targetIndex = freeHead;
        freeHead = next[targetIndex];

        // 2. If it's the first element in this queue
        if (isEmpty(queueNum)) {
            front[queueNum] = targetIndex;
        } else {
            // Link the old rear's 'next' to our new element
            next[rear[queueNum]] = targetIndex;
        }

        // 3. Update the rear and store data
        next[targetIndex] = -1; // New element is now the end of its queue
        rear[queueNum] = targetIndex;
        data[targetIndex] = item;
    }

    public int dequeue(int queueNum) {
        validateQueueIndex(queueNum);
        if (isEmpty(queueNum)) {
            System.out.println("Queue " + queueNum + " is empty.");
            return Integer.MIN_VALUE; 
        }

        // 1. Get the current front
        int targetIndex = front[queueNum];

        // 2. Move front to the next element in this queue
        front[queueNum] = next[targetIndex];
        
        // If queue is now empty, reset rear
        if (front[queueNum] == -1) {
            rear[queueNum] = -1;
        }

        // 3. Return the slot to the free list
        next[targetIndex] = freeHead;
        freeHead = targetIndex;

        return data[targetIndex];
    }

    public boolean isEmpty(int qn) { return front[qn] == -1; }
    public boolean isFull() { return freeHead == -1; }

    private void validateQueueIndex(int qn) {
        if (qn < 0 || qn >= numQueues) {
            throw new IllegalArgumentException("Invalid queue index: " + qn);
        }
    }
}
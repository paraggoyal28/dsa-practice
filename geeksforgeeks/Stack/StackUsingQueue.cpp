/*
problem: https://www.geeksforgeeks.org/problems/stack-using-two-queues/1
author: parag kumar goyal
TC: O(n) for push, O(1) for top and pop
*/

class myStack {
    queue<int> q;

  public:

    void push(int x) {
        // Inserts an element x at the top of the stack
        q.push(x);
        int sz = (int) q.size();
        for (int i = 0; i < sz - 1; ++i) {
            q.push(q.front());
            q.pop();
        }
    }

    void pop() {
        // Removes an element from the top of the stack
        if (!q.empty()) {
            q.pop();
        }
    }

    int top() {
        // Returns the top element of the stack
        // If stack is empty, return -1
        if (q.empty()) return -1;
        return q.front();
    }

    int size() {
        // Returns the current size of the stack
        return q.size();
    }
};

/*
problem: https://www.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1
author: parag kumar goyal
Given an array arr[ ] consisting of distinct integers, check if the given array can represent preorder traversal of a BST.
TC: O(N) where N is the size of arr 
SC: O(1)
*/

class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> stck = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int value: arr) {
            // If we find a node smaller than the current root,
            // it violates the BST property (it belongs to the left subtree incorrectly)
            if (value < root) {
                return false;
            }


            // If current value is greater than the stack top,
            // it means we are moving to the right subtree. Pop elements
            // to update the root. Lower bound
            while (!stck.isEmpty() && stck.peek() < value) {
                root = stack.pop();
            }


            stack.push(value);
        }

        return true;
    }
}



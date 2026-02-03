/*
problem: https://www.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1
author: parag kumar goyal
TC: O(N)
SC: O(N) 
where N is the size of tree
*/

class Solution {
    // Global variable to store the result
    int maxDiffValue;

    int calculateMaxDiff(Node root) {
        // Base case: if node is null, return a value that won't affect the min calculation
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Recursively find min values in left and right subtrees
        int leftMin = calculateMaxDiff(root.left);
        int rightMin = calculateMaxDiff(root.right);

        // Find the minimum value among all descendants
        int minDescendant = Math.min(leftMin, rightMin);

        // If we found a valid descendant, update the global max difference
        if (minDescendant != Integer.MAX_VALUE) {
            maxDiffValue = Math.max(maxDiffValue, root.data - minDescendant);
        }

        // Return the minimum value of the current subtree (current node vs its descendants)
        return Math.min(root.data, minDescendant);
    }

    int maxDiff(Node root) {
        // Initialize with lowest possible integer because the result can be negative
        maxDiffValue = Integer.MIN_VALUE;
        
        calculateMaxDiff(root);
        
        return maxDiffValue;
    }
}
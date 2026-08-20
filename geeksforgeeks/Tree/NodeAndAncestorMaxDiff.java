/*
problem: https://www.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1 
author: parag kumar goyal
TC: O(n) where n is the number of nodes in a tree, 
SC: O(h) where h is the height of tree. O(n) skewed tree, O(logn) balanced tree
*/

/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    
    int maxDiffUtil(Node root, int maxAncestor) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }



        return Math.max(maxDiffUtil(root.left, Math.max(root.data, maxAncestor)),
            Math.max(maxDiffUtil(root.right, Math.max(root.data, maxAncestor)),
            maxAncestor - root.data));
    
    }
    
    
    int maxDiff(Node root) {
        //  code here
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(maxDiffUtil(root.left, root.data), 
                                     maxDiffUtil(root.right, root.data));
    }
}
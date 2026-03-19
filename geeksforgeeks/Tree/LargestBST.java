/*
problem: https://www.geeksforgeeks.org/problems/largest-bst/1
author: parag kumar goyal
TC: O(N)
SC: O(H) where H is the height of tree
*/

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class NodeMeta {
    int max;
    int min;
    int size;
    boolean isBST;
    NodeMeta(int max, int min, int size, boolean isBST) {
        this.max = max;
        this.min = min;
        this.size = size;
        this.isBST = isBST;
    }
}

class Solution {

    private static NodeMeta largestBSTUtil(Node root, int[] ans) {
        if (root == null) {
            return new NodeMeta(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }
        
        NodeMeta leftMeta = largestBSTUtil(root.left, ans);
        NodeMeta rightMeta = largestBSTUtil(root.right, ans);
        
        // either the left child is null or left child max is less than
        // current root 
        if (leftMeta.isBST && rightMeta.isBST && leftMeta.max < root.data
                && rightMeta.min > root.data) {
            
            // means current subtree is bst
            int currentSize = rightMeta.size + leftMeta.size + 1;
            ans[0] = Math.max(ans[0], currentSize);
            
            return new NodeMeta(
                    Math.max(root.data, rightMeta.max),
                    Math.min(root.data, leftMeta.min),
                    currentSize, 
                    true
                );
        }
        
        
        // if it is not a bst with current root
        // return false
        return new NodeMeta(0, 0, 0, false);
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        int[] ans = new int[1];
        ans[0] = 1;
        largestBSTUtil(root, ans);
        return ans[0];
    }
}
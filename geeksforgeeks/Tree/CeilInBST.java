/*
Problem: https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
Author: parag kumar goyal
Time: O(h), space: O(1)
*/

/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    
    
    
    int findCeil(Node root, int x) {
        // code here
        int ceil = -1;

        while (root != null) {
            if (root.data == x) {
                return x;
            }

            if (root.data < x) {
                root = root.right;
            } else {
                ceil = root.data;   // current best candidate
                root = root.left;   // try to find a smaller valid one
            }
        }

        return ceil;
    }
}
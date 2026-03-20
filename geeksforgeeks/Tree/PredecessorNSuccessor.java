/*
problem: https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
author: parag kumar goyal
TC: O(H) where H is height of BST
SC: O(1)
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node predecessor = null;
        Node successor = null;
    
        Node curr = root;
        while (curr != null) {
            if (curr.data > key) {
                // this can be successor
                // explore in left
                successor = curr;
                curr = curr.left;
            } else {
                // current node too small
                curr = curr.right;
            }
        }
    
        curr = root;
        while (curr != null) {
            if (curr.data < key) {
                // explore in right
                predecessor = curr;
                curr = curr.right;
            } else {
                // current node too big
                curr = curr.left;
            }
        }
        
    
    
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }
}
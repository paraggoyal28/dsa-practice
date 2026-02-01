/*
problem: https://www.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
author: parag kumar goyal
*/

class Solution {
    
    static void findInorder(Node root, ArrayList<Integer> inorderSeq) {
        if (root != null) {
            findInorder(root.left, inorderSeq);
            inorderSeq.add(root.data);
            findInorder(root.right, inorderSeq);
        }
    }
    
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int minDiff(Node root, int K) {
        // Write your code here
        // store the inorder traversal
        ArrayList<Integer> inorderSeq = new ArrayList<>();
        findInorder(root, inorderSeq);
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0, n = inorderSeq.size(); i < n; ++i) {
            if (inorderSeq.get(i) == K) {
                return 0;
            } else if (inorderSeq.get(i) > K) {
                return Math.min(Math.abs(K - inorderSeq.get(i)), ans);
            }
            ans = Math.min(ans, Math.abs(inorderSeq.get(i) - K));
        }
        
        return ans;
    }
}

/* TC: O(H)
SC: O(1)
*/
class Solution {
    
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int minDiff(Node root, int K) {
        
        int minDifference = Integer.MAX_VALUE;
        Node curr = root;
        
        while (curr != null) {
            minDifference = Math.min(minDifference, Math.abs(curr.data - K));
            
            if (curr.data < K) {
                curr = curr.right;
            }
            
            else if (curr.data > K) {
                curr = curr.left;
            }
            
            else {
                return 0;
            }
        }
        
        return minDifference;
    }
}
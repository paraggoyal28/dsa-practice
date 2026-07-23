/*
problem: https://www.geeksforgeeks.org/problems/preorder-traversal/1
author: parag kumar goyal
TC: O(N)  where N is the number of nodes in the tree
SC: O(H) where H is the height of the tree
*/

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

Recursive Function
*/

class Solution {
    
    private void findPreorderTraversal(Node root, ArrayList<Integer> travArr) {
        if (root == null) {
            return;
        }
        
        travArr.add(root.data);
        
        findPreorderTraversal(root.left, travArr);
        
        findPreorderTraversal(root.right, travArr);
    }
    
    
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> preorderTrav = new ArrayList<>();
        
        findPreorderTraversal(root, preorderTrav);
        
        return preorderTrav;
    }
}


/*

Iterative Function

*/

class Solution {
    
    
    
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Node> stck = new Stack<>();

        
        // while left are there process them
        while (!stck.isEmpty() || root != null) {
            
            while (root != null) {
                ans.add(root.data);
                stck.push(root);
                root = root.left;
            }
             
            
            // root has no left child
            // put the left most child in arr and pop from stck
            root = stck.pop();
            root = root.right;
        }
        
        return ans;
    }
}

/*
Second Iterative Function
*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<Node> s = new Stack<>();
        Node curr = root;

        while (!s.isEmpty() && curr != null) {
            while (curr != null){ 
                ans.add(curr.data);
                if (curr.right != null) s.push(curr.right);
                curr = curr.left; 
            }

            if (!s.isEmpty()) {
                curr = s.pop();
            }
        }

        return ans;
    }
}

/*

Morris Traversal 
Allows us to traverse a binary tree without using recursion or stack. The Preorder Morris Traversal algorithm works by 
manipulating the tree's pointers, specifically by utilizing the inorder predecessor of each node

Algorithm for Morris Traversal
1. If the left child of the current node is NULL
Print the current node's data (since it is root of the subtree).
Move to the right child of the current node

2. If the left child of the current node is NOT NULL
Find the inorder predecessor of the current node. The inorder predecessor is the rightmost node of the 
left subtree of the current node
Two cases arise:
1. The right child of the inorder predecessor already points to the current node
This means we've already visited that node. So we can set the right child of the inorder predecessor to NULL
Move to the right child of the node.

2. THe right child of the inorder predecessor is NULL
Set the right child of the inorder predecessor to point to the current node.
Print the current node's data
Move to the left child of the current node 

*/

class Solution {

    public ArrayList<Integer> preOrder(Node root) {

        ArrayList<Integer> res = new ArrayList<>();

        while (root != null) {
            // if root left is null put current node to res and move to right
            if (root.left == null) {
                res.add(root.data);
                root = root.right;
            } else {
                // find the inorder predecessor of the current node
                Node inorderPredecessor = root.left;
                while (inorderPredecessor != null && inorderPredecessor.right != root && inorderPredecessor.right != null) {
                    inorderPredecessor = inorderPredecessor.right;
                }

                // we have already processed current node
                if (inorderPredecessor.right == root) {
                    inorderPredecessor.right = null;
                    root = root.right;
                } else {
                    res.add(root.data);
                    inorderPredecessor.right = root;
                    root = root.left;
                }
            }
        }

        return res;

    }
}

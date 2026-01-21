/*
problem: https://www.geeksforgeeks.org/problems/floor-in-bst/1
author: parag kumar goyal
TC: O(n) where n is the number of nodes in the tree
SC: O(h) where h is the height of tree (logn for balanced)
*/

class Solution {
  public:
    void greatestSmallerOrEqual(Node* root, int x, int &ans) {
        if (root) {
            greatestSmallerOrEqual(root->left, x, ans);
            if (root->data <= x) {
                ans = root->data;
            }
            greatestSmallerOrEqual(root->right, x, ans);
        }
    }
  
    int floor(Node* root, int x) {
        // code here
        // inorder 
        int ans = -1;
        greatestSmallerOrEqual(root, x, ans);
        return ans;
    }
};


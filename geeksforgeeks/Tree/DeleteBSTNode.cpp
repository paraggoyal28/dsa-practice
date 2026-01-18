/*
problem: Delete Node from BST
Description: Given the root of a binary search tree and a node value x. Delete the node with the given value x from the tree. If no node with value x exists, then do not make any change. 
Return the root of the tree after deleting the node with value x.
link: https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1
author: parag kumar goyal
TC: O(h)
SC: O(h) where h represents the height of the BST
*/


#include <iostream>
#include <vector>
using namespace std; 

class Node {
public:
    int data;
    Node* left;
    Node* right; 
    Node(int data) {
        this->data = data;
        this->left = NULL;
        this->right = NULL;
    }
};

class Solution {
    Node* findSuccessor(Node* root) {
        Node* curr = root;
        while (curr && curr->left) {
            curr = curr->left;
        }
        return curr;
    }

    Node* delNode(Node* root, int x) {
        if (!root) {
            return NULL;
        }

        // if x is less than root data, move to left subtree
        if (root->data > x) {
            root->left =  delNode(root->left, x);
        }  else if (root->data < x) {
            root->right = delNode(root->right, x);
        } else {
            // if root->data is equal to x 
            
            // if root has no left subtree
            if (!root->left) {
                Node* right = root->right;
                delete(root);
                return right;
            }

            // else if root has no right subtree
            else if (!root->right) {
                Node* left = root->left;
                delete(root);
                return left;
            }

            // else if both the left and right subtrees are present
            Node* successor = findSuccessor(root->right);

            root->data = successor->data; 

            root->right = delNode(root->right, successor->data);
        } 

        return root;
    }
};


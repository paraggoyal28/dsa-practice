/*
problem: https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1
author: parag kumar goyal
TC: O(h), SC: O(h) where h is the height of the tree
 */

import java.util.ArrayDeque;

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DeleteNodeInBST {

    private static TreeNode getSuccessor(TreeNode root) {
        TreeNode curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private static TreeNode delete(TreeNode root, int x) {
        if (root == null) {
            return null;
        } else if (root.data < x) {
            root.right = delete(root.right, x);
        } else if (root.data > x) {
            root.left = delete(root.left, x);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode succ = getSuccessor(root);
            root.data = succ.data;
            root.right = delete(root.right, succ.data);
        }

        return root;
    }

    private static void findLevelOrder(TreeNode node) {
        ArrayDeque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.add(node);
        int level = 0;
        while (!myQueue.isEmpty()) {
            System.out.println("Current level: " + level++);
            System.out.print("Current level nodes: ");
            int sz = myQueue.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode current = myQueue.pollFirst();
                System.out.print(" " + current.data + " ");
                if (current.left != null) {
                    myQueue.offerLast(current.left);
                }
                if (current.right != null) {
                    myQueue.offerLast(current.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(7);
        root.right.right = new TreeNode(17);
        root.left.left.left = new TreeNode(5);
        root.right.right.left = new TreeNode(15);
        System.out.println("Level order traversal of deleted node: ");
        findLevelOrder(delete(root, 10));
    }
}

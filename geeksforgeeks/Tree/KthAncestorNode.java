/*
problem: https://www.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
author: parag kumar goyal
TC: O(N) where N is the number of nodes
SC: O(H) where H is the height of tree
*/

class Solution {
    
    private boolean findPathToNode(Node root, int node, List<Integer> pathToNode) {
        if (root == null) {
            return false;
        }
        
        if (root.data == node) {
            return true;
        }
        
        pathToNode.add(root.data);
        
        
        if (findPathToNode(root.left, node, pathToNode) || 
            findPathToNode(root.right, node, pathToNode)) {
            return true;        
        }
        
        pathToNode.removeLast();
        return false;
    }
    
    public int kthAncestor(Node root, int k, int node) {
        // Write your code here
        List<Integer> pathToNode = new ArrayList<>();
        if (!findPathToNode(root, node, pathToNode)) {
            return -1;
        }
        
        if (k == 0 || pathToNode.size() < k) {
            return -1;
        }
        
        return pathToNode.get(pathToNode.size() - k);
    }
}
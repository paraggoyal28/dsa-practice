/*
problem: https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1 
author: parag kumar goyal
TC: O(n)
SC: O(n)
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
*/

class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}


class Solution {
    
    
    private static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        // maintain a track of horizontal levels
        // do level order traversal
        // and then add the nodes for a particular 
        // horizontal level
        ArrayList<ArrayList<Integer>> verticalOrderNodes = 
            new ArrayList<>();
        if (root == null) {
            return verticalOrderNodes;
        }
        
        Queue<Pair> levelOrder = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> 
            nodesByHd = new HashMap<>();
        int minHd = Integer.MAX_VALUE;
        int maxHd = Integer.MIN_VALUE;
        
        levelOrder.add(new Pair(root, 0));
        
        while (!levelOrder.isEmpty()) {
            Pair current = levelOrder.poll();
            int currentHd = current.hd;
            Node currentNode = current.node;
            maxHd = Math.max(maxHd, currentHd);
            minHd = Math.min(minHd, currentHd);
            nodesByHd.computeIfAbsent(currentHd, k -> new ArrayList<>()).add(currentNode.data);
            
            if (currentNode.left != null) {
                levelOrder.add(new Pair(currentNode.left, currentHd - 1));
            }
            
            if (currentNode.right != null) {
                levelOrder.add(new Pair(currentNode.right, currentHd + 1));
            }
             
        }
        
        
        for (int hd = minHd;  hd <= maxHd; ++hd) {
            verticalOrderNodes.add(nodesByHd.get(hd));
        }
        
        return verticalOrderNodes;
    }
}
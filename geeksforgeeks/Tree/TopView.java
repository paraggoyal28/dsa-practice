/*
problem: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
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
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> topViewNodes = new ArrayList<>();
        if (root == null) return topViewNodes;
        
        Queue<Pair> levelTrav = new LinkedList<>();
        HashMap<Integer, Integer> hdNodes = new HashMap<>();
        
        levelTrav.add(new Pair(root, 0));
        int maxHd = Integer.MIN_VALUE;
        int minHd = Integer.MAX_VALUE;
        
        while (!levelTrav.isEmpty()) {
            Pair topPair = levelTrav.poll();
            Node topNode = topPair.node;
            int horDis = topPair.hd;
            hdNodes.putIfAbsent(horDis, topNode.data);
            maxHd = Math.max(maxHd, horDis);
            minHd = Math.min(minHd, horDis);
            
            if (topNode.left != null) {
                levelTrav.add(new Pair(topNode.left, horDis - 1));
            }
            
            if (topNode.right != null) {
                levelTrav.add(new Pair(topNode.right, horDis + 1));
            }
        }
        
        for (int hd = minHd; hd <= maxHd; ++hd) {
            topViewNodes.add(hdNodes.get(hd));
        }
        
        return topViewNodes;
    }
}
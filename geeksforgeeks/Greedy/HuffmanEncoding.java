/*
problem: https://www.geeksforgeeks.org/problems/huffman-encoding3345/1
author: parag kumar goyal
TC: O(NlogN)
SC: O(N) where N is the number of keys
*/

class Solution {
    
    private static class Node {
        Node left, right;
        int data;
        int id; // Track the order of creation/occurrence
        Node(int data, int id) {
            this.data = data;
            this.id = id;
            this.left = null;
            this.right = null;
        }
        Node (Node l, Node r) {
            this.data = l.data + r.data;
            this.id = Math.min(l.id, r.id);
            left = l;
            right = r;
        }
    }
    
    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.data != b.data)
            return Integer.compare(a.data, b.data);
            else
            return Integer.compare(a.id, b.id);
        }
    }   
    
    
    private void preorder(Node root, ArrayList<String> huffmanEncoding, 
        StringBuilder code) {
        if (root!=null) {
            
            if (root.left==null && root.right==null) {
                huffmanEncoding.add(code.toString());
            }
            code.append("0");
            preorder(root.left, huffmanEncoding, code);
            code.setLength(code.length() - 1); 
            code.append("1");
            preorder(root.right, huffmanEncoding, code);
            code.setLength(code.length() - 1);
        }
    }
    
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        // Code here
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                new NodeComparator());
        ArrayList<String> huffmanEncoding = new ArrayList<>();
        int idCount = 0;
        for (int freq: f) {
            minHeap.add(new Node(freq, idCount++));
        }
        
        while (minHeap.size() > 1) {
            Node minFreq = minHeap.poll();
            Node secondMinFreq = minHeap.poll();
            
            Node root = new Node(minFreq.data + secondMinFreq.data, idCount++);
            root.left = minFreq;
            root.right = secondMinFreq;
            minHeap.add(root);
        }
        preorder(minHeap.poll(), huffmanEncoding, new StringBuilder());
        return huffmanEncoding;
    }
}
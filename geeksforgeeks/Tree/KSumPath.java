/*
problem: https://www.geeksforgeeks.org/problems/k-sum-paths/1
author: parag kumar goyal
TC: O(N)
SC: O(N)

*/

class Solution {
    
    public int countAllPaths(Node root, int k) {
        // code here
        Map<Long, Integer> prefixSumCnt = new HashMap<>();
        
        prefixSumCnt.put(0L, 1);
        
        return traverse(root, prefixSumCnt, 0L, k);
    }
    
    
    private int traverse(Node root, Map<Long, Integer> prefixSumCnt, 
        long currentSum, int k) {
        
        if (root == null) {
            return 0;
        }
        
        currentSum += root.data;
        
        int count = prefixSumCnt.getOrDefault(currentSum - k, 0);
        
        prefixSumCnt.merge(currentSum, 1, Integer::sum);
        
        count += traverse(root.left, prefixSumCnt, currentSum, k);
        
        count += traverse(root.right, prefixSumCnt, currentSum, k);
        
        prefixSumCnt.merge(currentSum, -1, Integer::sum);
        
        return count;
    }
}
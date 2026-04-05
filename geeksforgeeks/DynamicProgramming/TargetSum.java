/*
problem: https://www.geeksforgeeks.org/problems/target-sum-1626326450/1
author: parag kumar goyal
TC: O(N*Target)
SC: O(N*Target)
*/

class Solution {
    
    int[][] memo;
    int offset;
    
    private int totalWaysUtil(int[] arr, int index, int target, int sum, int n) {
        if (index == n) {
            return (target == sum ? 1 : 0);
        }
    
        int memCol = sum + offset;
        
        if (memo[index][memCol] != -1) {
            return memo[index][memCol];
        }
        
        // either add or subtract from total
          
        int waysOne = totalWaysUtil(arr, index + 1, target, sum - arr[index], n); 
        int waysSecond = totalWaysUtil(arr, index + 1, target, sum + arr[index], n);
        
        return memo[index][memCol] = waysOne + waysSecond;
    }
    
    
    public int totalWays(int[] arr, int target) {
        // code here
        int n = arr.length;
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        
        
        // not possible to reach target if its absolute
        // value is greater than sum
        if (Math.abs(target) > sum) {
            return 0;
        }
        
        offset = sum;
        memo = new int[n][2 * sum + 1];
        
        
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        return totalWaysUtil(arr, 0, target, 0, n);
    }
}
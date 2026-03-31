/*
problem: https://www.geeksforgeeks.org/problems/buy-stock-with-transaction-fee/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    public int maxProfit(int arr[], int k) {
        
        int n = arr.length;
        if (n <= 1) return 0;
        
        int buy = arr[0];
        int totalProfit = 0;
        
        for (int i = 1; i < n; ++i) {
            
            
            if (arr[i] > buy + k) {
                // Price is high enough to cover fee and make profit
                totalProfit +=  arr[i] - k - buy;
                
                // Key Greedy Step: Set buy price so that if
                // we "sell" again at a higher price tomorrow,
                // fee 'k' is not subtracted twice.
                buy = arr[i] - k;
            } else {
                // found a cheaper day to buy
                buy = Math.min(buy, arr[i]);
            } 
        }
        
        return totalProfit;
    }
}
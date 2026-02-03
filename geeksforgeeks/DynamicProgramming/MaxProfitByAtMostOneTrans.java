/*
problem: https://www.geeksforgeeks.org/problems/buy-stock-2/1
author: parag kumar goyal
TC: O(N) where N is the size of array
SC: O(1)
*/

/* finding max contiguous subarray sum of differences*/
class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int n = prices.length;
        if (n <= 1) return 0;
        int maximumProfit = 0;
        int maxCurrProfit = 0;
        for (int i = 1; i < n; ++i) {
            maxCurrProfit = Math.max(maxCurrProfit + prices[i] - prices[i-1],
                    prices[i] - prices[i-1]);
            maximumProfit = Math.max(maximumProfit, maxCurrProfit);
        }
        
        return maximumProfit;
    }
}

/* finding least price to buy and sell it at today */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        
        int minPrice = prices[0];
        int maximumProfit = 0;
        
        for (int i = 1; i < n; ++i) {
            // Update the minimum buy price encountered so far
            minPrice = Math.min(minPrice, prices[i]);
            // Calculate potential profit if we sell today and update max
            maximumProfit = Math.max(maximumProfit, prices[i] - minPrice);
        }
        
        return maximumProfit;
    }
}

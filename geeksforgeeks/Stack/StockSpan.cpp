/*
problem: https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
author: parag kumar goyal
*/

class Solution {
  public:
    vector<int> calculateSpan(vector<int>& arr) {
        // code here
        // span is defined as the number of 
        // consecutive days from 0 to i 
        // such that the price of stock is less or equal to 
        // the ith day price
        // monotonic stack is less than or equal to current
        // we pop and then take th
        int n = arr.size();
        stack<int> pricesSt;
        
        vector<int> span(n);
        
        for (int itr = 0, n = arr.size(); itr < n; ++itr) {
            while (!pricesSt.empty() && 
                    arr[pricesSt.top()] <= arr[itr]) {
                pricesSt.pop();            
            }
            
            span[itr] = pricesSt.empty() ? itr + 1 : 
                itr - pricesSt.top();
            
            pricesSt.push(itr);
        }
        
        return span;
    }
};
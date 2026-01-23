/*
problem: https://www.geeksforgeeks.org/problems/maximum-people-visible-in-a-line/1
author: parag kumar goyal
TC: O(n) where n is the size of array
SC: O(n) where n is the size of array
*/

class Solution {
  public:
    void clear(stack<int>& greaterHeightIdx) {
        while (!greaterHeightIdx.empty()) {
            greaterHeightIdx.pop();
        }
    }
  
    int maxPeople(vector<int> &arr) {
        // find the people visible on right
        // find the people visible on left
        // sum them up
        stack<int> greaterHeightIdx;
        int n = (int) arr.size();
        int maxPeopleVisible = 0;
        vector<int> rightMaxPeopleVisible(n, 0);
        for (int idx = n-1; idx >= 0; --idx) {
            while (!greaterHeightIdx.empty() && 
                    arr[greaterHeightIdx.top()] < arr[idx]) {
                greaterHeightIdx.pop();            
            }
            
        
            rightMaxPeopleVisible[idx] = greaterHeightIdx.empty() ? 
                    n - idx : 
                    greaterHeightIdx.top() - idx;
            
            greaterHeightIdx.push(idx);    
        }
        clear(greaterHeightIdx);
        
        
        for (int idx = 0; idx < n; ++idx) {
            while (!greaterHeightIdx.empty() && 
                    arr[greaterHeightIdx.top()] < arr[idx]) {
                greaterHeightIdx.pop();            
            }
            
        
            int leftMaxPeopleVisible = greaterHeightIdx.empty() ? 
                    idx + 1 : 
                    idx - greaterHeightIdx.top();
            
            maxPeopleVisible = max(maxPeopleVisible, 
                leftMaxPeopleVisible + 
                rightMaxPeopleVisible[idx] - 1);
            
            greaterHeightIdx.push(idx);    
        }
        
        
        
        return maxPeopleVisible;
    }
};
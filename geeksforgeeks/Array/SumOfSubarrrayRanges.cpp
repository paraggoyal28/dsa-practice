/*
problem: https://www.geeksforgeeks.org/problems/sum-of-subarray-ranges/1
author: parag kumar goyal
TC: O(n) where n is the size of array
approach: 
calculate for each indexes the range in which it is the largest and the smallest
calculate the prev minimum index and  
*/

class Solution {
  public:
    void clear(stack<int>& st) {
        while (!st.empty()) {
            st.pop();
        }
    }
    
    void print(vector<int> st) {
        for (int num: st) {
            cout << num << " ";
        }
        cout << endl;
    }
  
    int subarrayRanges(vector<int>& arr) {
        // code here
        // for two it would be just the abs difference
        // for three 
        // for each range we find the largest and smallest
        // an element how many 
        
        // -32-32-32-32
        // -128
        // +2+2+2=8
        // next smallest left, next smallest right
        // next greatest left, next greatest right
        
        // stack 
        // for each pos
        // find the prev pos which is smaller
        // [-1, 0, ]
        // 
        // 3
        
        // [-1, -1, 1, -1]
        // [1,n,n,n]
        // 
        int n = arr.size();
        stack<int> idxPos;
        vector<int> prevSmallerIdx(n, -1);
        vector<int> nextSmallerIdx(n, n);
        vector<int> prevGreaterIdx(n, -1);
        vector<int> nextGreaterIdx(n, n);
        
        
        // find prev min index for current index
        for (int idx = 0; idx < n; ++idx) {
            while (!idxPos.empty() && arr[idxPos.top()] > arr[idx]) {
                idxPos.pop();
            }
            
            if (!idxPos.empty())
            prevSmallerIdx[idx] = idxPos.top();
            idxPos.push(idx);
        }
        clear(idxPos);
        
        // find prev max index for current index
        for (int idx = 0; idx < n; ++idx) {
            while (!idxPos.empty() && arr[idxPos.top()] < arr[idx]) {
                idxPos.pop();
            }
            
            if (!idxPos.empty())
            prevGreaterIdx[idx] = idxPos.top();
            idxPos.push(idx);
        }
        clear(idxPos);
        
        // find next min index for current index
        for (int idx = n-1; idx >= 0; --idx) {
            while (!idxPos.empty() && arr[idxPos.top()] >= arr[idx]) {
                idxPos.pop();
            }
            
            if (!idxPos.empty())
            nextSmallerIdx[idx] = idxPos.top();
            idxPos.push(idx);
        }
        clear(idxPos);
        
        // find next max index for current index
        for (int idx = n-1; idx >= 0; --idx) {
            while (!idxPos.empty() && arr[idxPos.top()] <= arr[idx]) {
                idxPos.pop();
            }
            
            if (!idxPos.empty())
            nextGreaterIdx[idx] = idxPos.top();
            idxPos.push(idx);
        }
        clear(idxPos);
        

        int totalSum = 0;
        for (int idx = 0; idx < n; ++idx) {
            totalSum += (nextGreaterIdx[idx] - idx) * (idx - prevGreaterIdx[idx])
            * arr[idx] - 
            (nextSmallerIdx[idx] - idx) * (idx - prevSmallerIdx[idx]) 
            * arr[idx];
        }
        
        return totalSum;
    }
};
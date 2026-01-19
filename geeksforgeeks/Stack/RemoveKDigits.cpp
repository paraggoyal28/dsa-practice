/*
problem: Remove K Digits
description: Given a non-negative integer s represented as a string and an integer k, remove exactly k digits from the string so that the resulting number is the smallest possible, while maintaining the relative order of the remaining digits.

Note : The resulting number must not contain any leading zeros.
If the resulting number is an empty string after the removal, return "0".
Examples:
Input: s = "4325043", k = 3
Output: 2043
Explanation: Remove the three digits 4, 3, and 5 to form the new number "2043" 
which is smallest among all possible removal.

author: parag kumar goyal
*/

#include <vector>
#include <iostream>
using namespace std; 

class Solution {
  public:
    
  
    string removeKdigits(string &s, int k) {
        
        
        int n = s.length();
        if (k >= n) return "0";
        if (n == 0) return "0";
        
        int windowEndOffset = k;
        
        deque<int> minValuesIdx;
 
        // the first digit in the answer could be from 0 to k
        // similary second in the answer could be from first idx + 1, to k + 1
        // ... last index will be from second_last_idx + 1, n
        
        for (int idx = 0; idx < windowEndOffset; ++idx) {
            // remove the previous larger values
            while (!minValuesIdx.empty() && 
                s[minValuesIdx.back()] > s[idx]) {
                minValuesIdx.pop_back();
            }
            minValuesIdx.push_back(idx);
        }
        
        string ans = "";
        int prevIdx = -1;

        for (int idx = windowEndOffset; idx < n; ++idx) {
            while (!minValuesIdx.empty() 
                && minValuesIdx.front() <= prevIdx) {
                minValuesIdx.pop_front();        
            }
            
            while (!minValuesIdx.empty()
                && s[minValuesIdx.back()] > s[idx]) {
                minValuesIdx.pop_back();
            }
            
            minValuesIdx.push_back(idx);
            if (!ans.empty() || s[minValuesIdx.front()] != '0') {
                ans += s[minValuesIdx.front()];
            }
            prevIdx = minValuesIdx.front();
        }
        
        return ans == "" ? "0": ans;
    }
};
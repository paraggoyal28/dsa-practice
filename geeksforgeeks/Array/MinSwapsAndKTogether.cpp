/*
problem: Minimum swaps and K together
author: parag kumar goyal
Given an array arr and a number k. One can apply a swap operation on the array any number of times, i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring all the numbers less than or equal to k together, i.e. make them a contiguous subarray.
Examples:
Input: arr[] = [2, 1, 5, 6, 3], k = 3
Output: 1
Explanation: To bring elements 2, 1, 3 together, swap index 2 with 4 (0-based indexing), i.e. element arr[2] = 5 with arr[4] = 3 such that final array will be- arr[] = [2, 1, 3, 6, 5]
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ k ≤ 106

TC: O(n) where n is arr.size()
SC: O(1)
*/

class Solution {
  public:
    int countLessOrEqual(vector<int>& arr, int k) {
        int cnt = 0;
        for (int num: arr) {
            if (num <= k) {
                cnt++;
            }
        }
        
        return cnt;
    }
  
    int minSwap(vector<int>& arr, int k) {
        
        int cntLessOrEqualToK = countLessOrEqual(arr, k);
        // no need for further code if no element is less or equal to k
        if (cntLessOrEqualToK == 0) {
            return 0;
        }
        int sz = (int) arr.size();
        int currentCnt = 0;
        int maxCnt = 0;
        for (int end = 0; end < cntLessOrEqualToK; ++end) {
            if (arr[end] <= k) {
                currentCnt++;
            } 
        }
        maxCnt = max(maxCnt, currentCnt);
        
        for (int end = cntLessOrEqualToK; end < sz; ++end) {
            if (arr[end - cntLessOrEqualToK] <= k) {
                currentCnt--;
            } 
            if (arr[end] <= k) {
                currentCnt++;
            }
            maxCnt = max(maxCnt, currentCnt);
        }
        
        return cntLessOrEqualToK - maxCnt; 
    }
};

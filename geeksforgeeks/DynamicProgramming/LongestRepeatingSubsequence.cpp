/*
problem: https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
author: parag kumar goyal
*/

class Solution {
  public:
    int LongestRepeatingSubsequence(string &s) {
        // Code here
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        vector<int> prevLongestLen(len+1, 0);

        int maxRepeatingLen = 0;

        for (int st = 1; st <= len; ++st) {

            vector<int> currLongestLen(len + 1, 0);

            for (int end = 1; end <= len; ++end) {

                if (st != end && s[st-1] == s[end-1]) {
                    currLongestLen[end] = 1 + prevLongestLen[end-1];
                } else {
                    currLongestLen[end] = max(currLongestLen[end-1], prevLongestLen[end]);
                }

                maxRepeatingLen = max(maxRepeatingLen, currLongestLen[end]);
            }

            prevLongestLen = currLongestLen;
        }

        return maxRepeatingLen;
    }
};
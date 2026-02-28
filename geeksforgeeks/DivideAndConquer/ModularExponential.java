/*
problem; https://www.geeksforgeeks.org/problems/modular-exponentiation-for-large-numbers5537/1
author: parag kumar goyal
TC: O(logn)
SC: O(1)
*/


class Solution {
  public:
    int powMod(int x, int n, int M) {
        // code here
        int res = 1;
        while (n > 0) {
            if (n&1) {
                res = ((res%M) * 1LL * (x%M)) % M;
            }
            
            x = ((x%M) * 1LL * (x%M)) % M;
            n /= 2;
        }
        
        return res;
    }
};
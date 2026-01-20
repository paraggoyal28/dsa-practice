/*
problem: https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

#include <iostream>
#include <vector>
using namespace std; 

class Solution {
  public:
    int countFriendsPairings(int n) {
        
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; ++i) {
            int c = b + (i-1) * a;
            a = b;
            b = c;
        }
        return b;
    }
};
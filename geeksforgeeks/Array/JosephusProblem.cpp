/*
problem: https://www.geeksforgeeks.org/problems/josephus-problem/1 
author: parag kumar goyal
TC: O(n) where n is the number of people
SC: O(1)
*/


/* Recursive Version */
class Solution {
  public:
    int findSurvivor(int n, int k) {
        if (n == 1) {
            return 0;
        }
        
        return (findSurvivor(n-1, k) + k) % n;
    } 
  
    int josephus(int n, int k) {
        return findSurvivor(n, k) + 1;
    }
};

/* Recursive Version */
class Solution {
  public:
    int findSurvivor(int n, int k) {
        int survivor = 0;
        
        for (int i = 2; i <= n; ++i) {
            survivor = (survivor + k) % i;
        }

        return survivor;
    } 
  
    int josephus(int n, int k) {
        return findSurvivor(n, k) + 1;
    }
};
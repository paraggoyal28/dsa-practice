/*
problem; https://www.geeksforgeeks.org/problems/modular-exponentiation-for-large-numbers5537/1
author: parag kumar goyal
TC: O(logn)
SC: O(1)
*/


public class ModularExponential {
  public long powMod(long x, long n, long M) {
        // code here
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = ((res%M) * (x%M)) % M;
            }
            
            x = ((x%M) * (x%M)) % M;
            n /= 2;
        }
        
        return res;
    }
};
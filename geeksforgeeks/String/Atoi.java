/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/implement-atoi
author: parag kumar goyal
TC: O(n) where n is the length of string
SC: O(1) 
*/

class Solution {
    
    private boolean nonDigitChar(char ch) {
        return ch < '0' || ch > '9';
    }
    
    public int myAtoi(String s) {
        // code here
        int itr = 0;
        int n = s.length();
        int sign = 1;
        int res = 0;
        
        while (itr < n && s.charAt(itr) == ' ') itr++;
        
        if (itr == n) return 0;
        
        // check for sign
        if (s.charAt(itr) == '-') {
            sign = -1;
            itr++;
        }
        
        // skip leading zeros
        while (itr < n && s.charAt(itr) == '0') itr++;
        
        if (itr == n) return 0;
        
        for (int i = itr; i < n; ++i) {
            char currentChar = s.charAt(i);
            
            if (nonDigitChar(currentChar)) break;
            
            int digit = currentChar - '0';
            
            if (res > Integer.MAX_VALUE/10 || 
                (res == Integer.MAX_VALUE/10 && digit > 7)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            res = res * 10 + digit;
        }
        
        return res * sign;
    }
}


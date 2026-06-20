/*
problem: https://www.geeksforgeeks.org/problems/find-last-digit-of-ab-for-large-numbers1936/1
Given two integers a and b in the form of strings. Return the last digit of a^b.
author: parag kumar goyal
TC: O(len_b) where len_b is the length of b which is the exponent
*/

class Solution {

    private int module(String base, int exp) {
        int ans = 0;

        for (int idx = 0, n = base.length(); idx < n; ++idx) {
            ans = (ans * 10 + (base.charAt(idx) - '0'))%exp;
        }

        return ans;
    }

    public int getLastDigit(String a, String b) {

        int len_a = a.length(), len_b = b.length();

        // if exp is 0
        if (len_b == 1 && b.charAt(0) == '0') {
            return 1;
        } 

        if (len_a == 1 && a.charAt(0) == '0') {
            return 0;
        }

        // get the modulo 4 of b
        int exp = (modulo(b, 4) == 0) ? 4 : modulo(b, 4);

        int res = (int)(Math.pow(a.charAt(len_a - 1)-'0', exp));

        return res%10;
    }

    
}
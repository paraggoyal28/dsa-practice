/*
problem: https://www.geeksforgeeks.org/problems/largest-number-in-one-swap1520/1
author: parag kumar goyal
TC: O(n)
SC: O(n) because of use of string builder
*/

class Solution {
    public String largestSwap(String s) {
        
        int l = -1, r = -1;
        int len = s.length();
        char maxChar = '0';
        int maxCharIdx = len - 1;
        // start from the end
        // keep tracking of max character
        // if found a character less than
        // the max character
        // update the left and right pointers for swap
        
        for (int idx = len - 1; idx >= 0; --idx) {
            if (s.charAt(idx) > maxChar) {
                maxChar = s.charAt(idx);
                maxCharIdx = idx;
            } else if (s.charAt(idx) < maxChar) {
                l = idx;
                r = maxCharIdx;
            }
        }
        
        if (l == -1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, temp);
        
        return sb.toString();
    }
}
/*
problem: https://www.geeksforgeeks.org/problems/anagram-1587115620/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/
import java.util.Arrays;

class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        int[] s1Freq = new int[256];
        int[] s2Freq = new int[256];
        
        for (char ch: s1.toCharArray()) {
            s1Freq[ch]++;
        }
        
        for (char ch: s2.toCharArray()) {
            s2Freq[ch]++;
        }
        
        return Arrays.equals(s1Freq, s2Freq);
    }
}
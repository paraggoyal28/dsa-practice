/*
problem: https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
author: parag kumar goyal
TC: O(n) SC: O(n)
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    private static String reverse(String myStr) {
        if (myStr == null) return myStr;

        String[] words = myStr.strip().split("\\s+");
        List<String> wordsList = Arrays.asList(words);
        Collections.reverse(wordsList);
        return String.join(" ", wordsList);
    }
    public static void main(String[] args) {
        String myStr = "the cat is sleeping with the     dog";
        String reversed = reverse(myStr);
        System.out.println(reversed);
    }
}
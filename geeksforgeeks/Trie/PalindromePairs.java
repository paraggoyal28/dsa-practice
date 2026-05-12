/*
problem: https://www.geeksforgeeks.org/problems/palindrome-pairs/1
author: parag kumar goyal

*/

/*
Solution 1: Brute Force (Using Nested Loops)
TC: O(n*n*k) where n is the length of array and k is the maximum length of a string
SC: O(1) 
*/

import java.util.*;

class GFG {
    static boolean isPalindrome(String s) {
        int n = s.length();

        for (int start = 0, end = n-1; start <= end; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

    static boolean palindromePair(String[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i+1; j < arr.length; ++j) {
                // Add arr[i] then arr[j]
                String first = arr[i] + arr[j];

                if (isPalindrome(first)) {
                    return true;
                }

                String second = arr[j] + arr[i];

                if (isPalindrome(second)) {
                    return true;
                }
            }
        }

        return false;
    }
}

/*
TC: Using Trie data structure. O(n*k*k)
SC: O(n*k)
Trie data structure to store all the strings and efficiently search for 
palindrome pairs. The intuition behind the Trie approach is to efficiently 
match each word with the reverse of another word to form a palindrome, 
without checking all pairs. We insert all words in reversed form into a Trie,
while also storing information about prefixes that are palindromes. Then, 

*/


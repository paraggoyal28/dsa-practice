/*
problem: https://www.geeksforgeeks.org/problems/choose-and-swap0531/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

class Solution {

    String chooseandswap(String str) {
        // Code Here
        // if we store the first occurences of every character
        // from the start if I found a 
        // store all unique characters in the order of string
        // now for each character from the start if it can be 
        // replaced by a smaller character
        // HashSet 
        // then
        // bool array of 26
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);
        
        int n = str.length();
        for (int itr = 0; itr < n; ++itr) {
            char currentChar = str.charAt(itr);
            if (firstOccurrence[currentChar-'a'] == -1) {
                firstOccurrence[currentChar-'a'] = itr;
            }
        }
        
        char toReplaceFirst = 'a', toReplaceSecond = 'a';
        boolean replacementFound = false;
        
        for (int itr = 0; itr < n; ++itr) {
            char currentChar = str.charAt(itr);
            
            for (char ch = 'a'; ch < currentChar; ++ch) {
                
                if (firstOccurrence[ch-'a'] != -1 && 
                    firstOccurrence[ch - 'a'] > itr) {
                    toReplaceFirst = ch;
                    toReplaceSecond = currentChar;
                    replacementFound = true;
                    break;
                } 
            }
            
            if (replacementFound) {
                break;
            }
        }
        
        if (!replacementFound) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        for (int itr = 0; itr < n; ++itr) {
            if (str.charAt(itr) == toReplaceFirst) {
                result.append(toReplaceSecond);
            } else if (str.charAt(itr) == toReplaceSecond) {
                result.append(toReplaceFirst);
            } else {
                result.append(str.charAt(itr));
            }
        }
        
        return result.toString();
        
    }
}
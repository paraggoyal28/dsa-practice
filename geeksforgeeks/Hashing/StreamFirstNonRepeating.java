/*
problem: https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/

class Solution {
    public String firstNonRepeating(String s) {
        // code here
        // keep track of freq of elements in 
        // sequential order
        // how to find the first element with 1 freq
        Deque<Character> nonRepeatingChars = new ArrayDeque<>();
        int[] freq = new int[26];
        
        StringBuilder nonRepeatingForEachChar = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; ++i) {
            
            char ch = s.charAt(i);
            // remove the elements from nonRepeatingChars which have 
            // frequency greater than 1
            nonRepeatingChars.addLast(ch);
            freq[ch-'a']++;
            while (!nonRepeatingChars.isEmpty() 
                && freq[nonRepeatingChars.peekFirst() - 'a'] > 1) {
                nonRepeatingChars.removeFirst();        
            }
            
            if (!nonRepeatingChars.isEmpty()) {
                nonRepeatingForEachChar.append(nonRepeatingChars.peekFirst());
            } else {
                nonRepeatingForEachChar.append('#');
            }
        }
        
        return nonRepeatingForEachChar.toString();
    }
}

/* A more optimized version */
/*
TC: O(N)
SC: O(1)
*/

class Solution {
    public String firstNonRepeating(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int[] firstIndex = new int[26];
        java.util.Arrays.fill(firstIndex, -1);
        
        char[] result = new char[n];
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            freq[idx]++;
            if (firstIndex[idx] == -1) firstIndex[idx] = i;
            
            int minIdx = Integer.MAX_VALUE;
            char firstChar = '#';
            
            // Check all 26 possible characters
            for (int j = 0; j < 26; j++) {
                if (freq[j] == 1 && firstIndex[j] < minIdx) {
                    minIdx = firstIndex[j];
                    firstChar = (char)(j + 'a');
                }
            }
            result[i] = firstChar;
        }
        
        return new String(result);
    }
}
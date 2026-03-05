/*
problem: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
author: parag kumar goyal
*/.

/*
TC: O(n)
SC: O(n)
*/
class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int uniqueCharacters = 0;
        int start = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int len = s.length();
        int maxLenKSubstr = 0;
        for (int end = 0; end < len; ++end) {
            freq.put(s.charAt(end), freq.getOrDefault(s.charAt(end), 0) + 1);
            
            if (freq.get(s.charAt(end)) == 1) {
                uniqueCharacters += 1;
            }
            
            while (start < end && uniqueCharacters > k) {
                freq.put(s.charAt(start), freq.get(s.charAt(start)) - 1);
                if (freq.get(s.charAt(start)) == 0) {
                    uniqueCharacters -= 1;
                }
                
                start += 1;
            }
            
            if (uniqueCharacters == k) {
                maxLenKSubstr = Math.max(maxLenKSubstr, end - start + 1);
            }
        
        }
        
        return maxLenKSubstr == 0 ? -1 : maxLenKSubstr;
    }
}

/*
TC: O(n)
SC: O(1)
*/

class Solution {
    public int longestKSubstr(String s, int k) {

        int uniqueChars = 0;
        int[] freq = new int[26];
        int start = 0;
        int len = s.length();
        int maxLen = -1;

        for (int end = 0; end < len; ++end) {
            char ch = s.charAt(end);
            if (freq[ch-'a'] == 0) uniqueChars += 1;
            freq[ch-'a'] += 1;

            while (uniqueChars > k) {
                char startCh = s.charAt(start);
                freq[startCh-'a']--;
                if (freq[startCh-'a'] == 0) {
                    uniqueChars -= 1;
                }
                start++;
            }

            if (uniqueChars == k) {
                maxLen = Math.max(maxLen, end - start + 1); 
            }
        }

        return maxLen;
    }
}
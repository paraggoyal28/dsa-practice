/*
problem: https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
author: parag kumar goyal
*/

/*
TC: O(n^3)
SC: O(1)
*/

class Solution {
    /*
    TC: O(n^3)
    
    */
    static boolean hasAllChars(String sub, String p) {
        int[] count = new int[256];
        
        // Count the frequency of each
        // character in the pattern
        for (int i = 0; i < p.length(); ++i) {
            count[p.charAt(i)]++;
        }
        
        
        // For each character in the substring
        // decrement the count
        for (int i = 0; i < sub.length(); ++i) {
            if (count[sub.charAt(i)] > 0) {
                count[sub.charAt(i)]--;
            }
        }
        
        for (int i = 0; i < 256; ++i) {
            // some character is present in p which is not present in the
            // sub
            if (count[i] > 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static String minWindow(String s, String p) {
        // code here
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        
        // Generate all substrings
        // of given string
        // to get a substring from i to j 
        // s.substring(i, j + 1) is the formula
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                String sub = s.substring(i, j + 1);
                
                if (hasAllChars(sub, p)) {
                    
                    int currLen = sub.length();
                    
                    if (currLen < minLen) {
                        minLen = currLen;
                        res = sub;
                    }
                }
            }
        }
        
        return res;
    }
}

/*
TC: O(nlogn)
SC: O(1)
*/

private static boolean isValid(String s, String p, int mid, int[] start) {

    int[] count = new int[256];
    int distinct = 0;
    int currCount = 0;

    for (char ch: p.toCharArray()) {
        if (count[ch] == 0) {
            distinct++;
        }
        count[ch]++;
    }

    for (int i = 0, n = s.length(); i < n; ++i) {
        count[s.charAt(i)]--;
        if (count[s.charAt(i)] == 0) {
            currCount++;
        }
        // currCount increment specify that the frequency of s.charAt(i)
        // is satisfied

        if (i >= mid) {
            count[s.charAt(i - mid)]++;
            if (count[s.charAt(i - mid)] == 1) {
                currCount--;
            }
        }

        if (i >= mid - 1 && currCount == distinct) {
            start[0] = i - mid + 1;
            return true;
        }

        return false;
    }
}



public static String minWindow(String s, String p) {
    // code here
    int m = s.length();
    int n = p.length();
    
    // If s is smaller than p, its impossible
    if (m < n) {
        return "";
    }
    
    int minLength = Integer.MAX_VALUE;
    int low = n, high = m;
    int[] start = new int[1];
    
    // Perform binary search to find the minimum window
    // size
    while (low <= high) {
        int mid = (low + high) / 2;
        
        if (isValid(s, p, mid, start)) {
            minLength = mid;
            high = mid - 1; // find the lowest size so we decrement high
        } else {
            low = mid + 1;
        }
    } 
    
    if (minLength == Integer.MAX_VALUE) {
        return "";
    }
    
    return s.substring(start[0], start[0] + minLength);
}

/*
TC: O(n)
SC: O(1)
*/


public static String minWindow(String s, String p) {
    int n = s.length();
    int m = p.length();

    int[] countP = new int[256];
    int[] countS = new int[256];

    int cnt = 0;
    int start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;

    // count all the frequency of characters of string p
    for (char ch: p.toCharArray()) {
        countP[ch]++;
    }

    // 
    for (int idx = 0; idx < n; ++idx) {
        char currentChar = s.charAt(idx);

        countS[currentChar]++;

        if (countP[currentChar] > 0 && countS[currentChar] <= countP[currentChar]) {
            cnt++;
        }

        // if the cnt matches the length of pattern
        if (cnt == m) {
            char startCh;
            while (countS[startCh = s.charAt(start)] > countP[startCh]
                    || countP[startCh] == 0) {
                if (countS[startCh] > countP[startCh]) {
                    countS[startCh]--;
                }

                start++;
            }

            int len = idx - start + 1;
            if (min_len > len) {
                min_len = len; 
                start_idx = start;
            }
        }
    }

    if (start_idx == -1) {
        return "";
    }

    return s.substring(start_idx, start_idx + min_len);
}
/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tries-gfg-160/problem/maximum-xor-of-two-numbers-in-an-array
author: parag kumar goyal
TC: O(n), SC: O(n)

Input: arr[] = [25, 10, 2, 8, 5, 3]
Output: 28
Explanation: The maximum possible XOR is 5 ^ 25 = 28.
Input: arr[] = [1, 2, 3, 4, 5, 6, 7]
Output: 7
Explanation : The maximum possible XOR is 1 ^ 6 = 7.
*/

class TrieNode {
    TrieNode one, zero;

    public TrieNode() {
        one = null;
        zero = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode curr = root;
        
        for (int i = 31; i >= 0; --i) {
            int bit = (num >> i) & 1;

            if (bit == 1) {
                if (curr.one == null) {
                    curr.one = new TrieNode();    
                }
                curr = curr.one;
            } else {
                if (curr.zero == null) {
                    curr.zero = new TrieNode();
                }
                curr = curr.zero;
            }            
        }
    }

    public int getMaxXor(int num) {
        TrieNode curr = root;
        int res = 0;
        for (int i = 31; i >= 0; --i) {

            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (curr.one != null) {
                    res += (1 << i);
                    curr = curr.one;
                } else {
                    curr = curr.zero;
                }
            } else {
                if (curr.zero != null) {
                    res += (1 << i);
                    curr = curr.zero;
                } else {
                    curr = curr.one;
                }
            }
        }
        return res;
    }
}


public class MaxXor {
    public int maxXor(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) return 0;

        Trie t = new Trie();
        int n = arr.length;
        t.insert(arr[0]);

        int maxXorValue = 0;
        for (int i = 1; i < n; ++i) {
            maxXorValue = Math.max(maxXorValue, t.getMaxXor(arr[i]));
            t.insert(arr[i]);
        }

        return maxXorValue;
    }
}
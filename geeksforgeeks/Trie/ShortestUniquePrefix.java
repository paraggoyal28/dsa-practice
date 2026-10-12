/*
problem: https://www.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/1
author: parag kumar goyal
TC: O(n) where n is the sum of length of all strings
SC: O(n) where n is the sum of length of all strings
*/


import java.util.ArrayList;

class MyTrieNode {
    public MyTrieNode[] children;
    int count;

    MyTrieNode() {
        children = new MyTrieNode[26];
        for (int i = 0; i < 26; ++i) {
            children[i] = null;
        }
        count = 0;
    }
    
    void incrementCount() {
        this.count += 1;
    }
    
    int getCount() {
        return this.count;
    }
}

class MyTrie {
    MyTrieNode root;

    MyTrie() {
        this.root = new MyTrieNode();
    }
    
    void insert(String word) {
        MyTrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new MyTrieNode();
            }
            curr = curr.children[ch - 'a'];
            curr.incrementCount();
        }
    }
    
    String findPrefix(String word) {
        MyTrieNode curr = root;
        StringBuilder prefixSb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            curr = curr.children[ch - 'a']; // the character already present
            prefixSb.append(ch);
            if (curr.getCount() == 1) {
                return prefixSb.toString();
            }
        }
        return prefixSb.toString();
    }
}

class ShortestUniquePrefix {
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        MyTrie trie = new MyTrie();
        for (String word: arr) {
            trie.insert(word);
        }
        
        for (String word: arr) {
           ans.add(trie.findPrefix(word)); 
        }
        
        return ans;
    }
}
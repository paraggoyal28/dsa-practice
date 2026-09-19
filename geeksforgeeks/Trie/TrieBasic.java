/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tries-gfg-160/article/MTMwNjc%3D
author: parag kumar goyal
TC: O(n), SC: O(n)
*/

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase letters a-z
        isEndOfWord = false;
    }
}

public class TrieBasic {
    TrieNode root;

    public TrieBasic() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new TrieNode();
            }
            current = current.children[ch-'a'];
        }
        current.isEndOfWord = true;
    }

    // Checks if a word is present 
    public boolean isWordPresent(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                return false;
            }
            current = current.children[ch-'a'];
        }

        return current != null && current.isEndOfWord;
    }

    // Checks if the word is a prefix of another word present in trie
    public boolean isWordPrefix(String word)  {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (current.children[ch-'a'] == null) {
                return false;
            }
            current = current.children[ch-'a'];
        }
        return current != null;
    }

    public static void main(String[] args)
    {
        TrieBasic trie = new TrieBasic();
        String[] arr
            = {"and", "ant", "do", "dad"};
        for (String s : arr) {
            trie.insert(s);
        }
        String[] searchKeys = { "do", "gee", "bat" };
        for (String s : searchKeys) {
            if (trie.isWordPresent(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
        System.out.println();
        String[] prefixKeys = { "ge", "ba", "do", "de" };
        for (String s : prefixKeys) {
            if (trie.isWordPrefix(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
}
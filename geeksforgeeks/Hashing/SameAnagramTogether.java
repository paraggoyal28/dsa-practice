/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/print-anagrams-together
author: parag kumar goyal
TC: O(N.LlogL) where N is the number of strings in the array and L is the maximum length of a string in the array
*/

import java.util.stream.Collectors;

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> groupedAnagrams = 
            new ArrayList<>();
            
        HashMap<String, List<String>> sameAnagrams = new HashMap<>();
        
        for (String str: arr) {
            String sortedStr = str.chars()
                                  .sorted()
                                  .mapToObj(c -> 
                                    String.valueOf((char) c))
                                  .collect(Collectors.joining());
            
            
            sameAnagrams.computeIfAbsent(sortedStr, 
                k -> new ArrayList<>()).add(str);
        }
        
        for (Map.Entry<String, List<String>> anagramEntry: 
            sameAnagrams.entrySet()) {
            groupedAnagrams.add(new ArrayList<>(anagramEntry.getValue()));        
        }
        
        return groupedAnagrams;
    }
}
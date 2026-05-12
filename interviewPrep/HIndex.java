/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/find-h-index--165609
author: parag kumar goyal


*/

/* 
TC: O(n)
SC: O(n)
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n+1];
        
        // count the frequencies of citations
        for (int i = 0; i < n; ++i) {
            if (citations[i] >= n) {
                freq[n] += 1;
            } else {
                freq[citations[i]] += 1;
            }
        }
        
        int idx = n;
        
        int s = freq[idx];
        
        // while the number of papers having 
        // citations is less than the current 
        // citation add the papers of the current
        // citation to the paper count
        
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        
        return idx;
    }
}

/*
TC: O(nlogn)
SC: O(1)
*/

class Solution {
    private int citationsGreaterOrEqual(int[] citations, int target) {
        int noOfGreaterOrEqual = 0;

        for (int citation: citations) {
            if (citation >= target) {
                noOfGreaterOrEqual += 1;
            }
        }

        return noOfGreaterOrEqual;
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int minHIndex = 0;
        int maxHIndex = n;
        int resHIndex = 0;

        while (minHIndex <= maxHIndex) {
            int midHIndex = minHIndex + (maxHIndex - minHIndex)/2;
            if (citationsGreaterOrEqual(citations, midHIndex) >= midHIndex) {
                resHIndex = midHIndex;
                minHIndex = midHIndex + 1;
            } else {
                maxHIndex = midHIndex - 1;
            }
        }

        return resHIndex;
    }
}
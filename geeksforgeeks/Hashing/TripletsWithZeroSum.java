/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/find-all-triplets-with-zero-sum
author: parag kumar goyal
TC: O(n^2logn + K) where n is the size of input list and K is the total number of possible pairs
*/

import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = arr.length;

        HashMap<Integer, List<Integer>> idxMp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            idxMp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Iterate through each unique pair (i, j) where i < j
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int target = -arr[i] - arr[j];

                List<Integer> indices = idxMap.get(target);

                // target found
                if (indices != null) {
                    // find the indices greater than j
                    int pos = Collections.binarySearch(indices, j + 1);

                    // means j + 1 not found, the position just greater than it found
                    if (pos < 0) {
                        pos = -pos - 1;
                    }

                    for (int k = pos; k < indices.size(); ++k) {

                        int idx = indices.get(k);

                        triplets.add(Arrays.asList(i, j, idx));
                    }
                }
            }
        }
        return triplets;
    }
}
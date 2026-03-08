/*
problem: https://www.geeksforgeeks.org/problems/pythagorean-triplet3018/1
author: parag kumar goyal
TC: O(N)
SC: O(1)
*/

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length();
        int maxEle = 0;
        boolean[] vis = new boolean[maxEle + 1];

        for (int i = 0; i < n; ++i) {
            maxEle = Math.max(maxEle, arr[i]);
            vis[arr[i]] = true;
        }   

        for (int a = 0; a < maxEle + 1; ++a) {
            if (!vis[a]) {
                continue;
            }

            for (int b = 0; b < maxEle + 1; ++b) {
                if (!vis[b]) {
                    continue;
                }
                
                int c = (int) Math.sqrt(a * a + b * b);

                if ((c * c) != a * a + b * b || (c > maxEle)) {
                    continue;
                }

                if (vis[c]) {
                    return true;
                }
            }
        }

        return false;
    }
}
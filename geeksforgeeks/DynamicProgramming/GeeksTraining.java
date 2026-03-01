/*
problem: https://www.geeksforgeeks.org/problems/geeks-training/1
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        if (n == 0) return 0;

        // Use two fixed-size arrays to avoid repeated allocations in the loop
        int[] prev = new int[3];
        int[] curr = new int[3];

        // Initialize for day 0
        prev[0] = mat[0][0];
        prev[1] = mat[0][1];
        prev[2] = mat[0][2];

        for (int day = 1; day < n; day++) {
            // Task 0: Max of previous Task 1 or Task 2
            curr[0] = mat[day][0] + Math.max(prev[1], prev[2]);
            
            // Task 1: Max of previous Task 0 or Task 2
            curr[1] = mat[day][1] + Math.max(prev[0], prev[2]);
            
            // Task 2: Max of previous Task 0 or Task 1
            curr[2] = mat[day][2] + Math.max(prev[0], prev[1]);

            // Update prev to be curr for the next iteration
            // We copy values or swap references
            prev[0] = curr[0];
            prev[1] = curr[1];
            prev[2] = curr[2];
        }

        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}

// if there are variable activities
// O(n*m*m) where n is the number of days and m is the number of activities
// space: O(m)
class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length; // Variable number of activities
        
        int[] prev = new int[m];
        
        // Initializing for Day 0
        for (int j = 0; j < m; j++) {
            prev[j] = mat[0][j];
        }

        for (int day = 1; day < n; day++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) { // Current activity
                int maxFromPrev = 0;
                for (int k = 0; k < m; k++) { // Previous activity
                    if (j != k) { // Constraint: Cannot repeat activity
                        maxFromPrev = Math.max(maxFromPrev, prev[k]);
                    }
                }
                curr[j] = mat[day][j] + maxFromPrev;
            }
            prev = curr; // Move to next day
        }

        // Find max in the final array
        int res = 0;
        for (int val : prev) res = Math.max(res, val);
        return res;
    }
}

// O(n*m) where n is the number of days and m is the number of activities
// space: O(m)
class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        int[] prev = mat[0];

        for (int day = 1; day < n; ++day) {
            // Step 1: Find the first and second maximum of prev day
            int prevSecondMax = -1, prevMax = -1;
            int prevMaxIdx = -1;

            for (int actIdx = 0; actIdx < m; ++actIdx) {
                if (prev[actIdx] > prevMax) {
                    prevSecondMax = prevMax;
                    prevMax = prev[actIdx];
                    prevMaxIdx = actIdx;
                } else if (prev[actIdx] > prevSecondMax) {
                    prevSecondMax = prev[actIdx];
                }
            }

            for (int actIdx = 0; actIdx < m; ++actIdx) {
                if (actIdx == prevMaxIdx) {
                    prev[actIdx] = mat[day][actIdx] + prevSecondMax;
                } else {
                    prev[actIdx] = mat[day][actIdx] + prevMax;
                }
            }
        }
    }

    int res = -1;
    for (int val: prev) {
        res = Math.max(res, val);
    }
    return res;
}

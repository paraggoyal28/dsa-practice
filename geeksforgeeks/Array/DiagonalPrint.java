/*
problem: https://www.geeksforgeeks.org/problems/print-diagonally4331/1
author: parag kumar goyal
TC: O(N * M) where N is number of rows and M is number of cols
SC: O(1)
*/

class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int rows = mat.length;
        if (rows == 0) return ans;
        int cols = mat[0].length;

        // Total diagonals = rows + cols - 1
        for (int sum = 0; sum < rows + cols - 1; sum++) {
            // For each diagonal, find the starting row
            // The row starts at 0 but cannot exceed sum or the last row index
            for (int r = 0; r <= sum; r++) {
                int c = sum - r;
                // Check if the calculated row and column are within bounds
                if (r < rows && c < cols) {
                    ans.add(mat[r][c]);
                }
            }
        }
        return ans;
    }
}
/*
problem: https://www.geeksforgeeks.org/problems/coverage-of-all-zeros-in-a-binary-matrix4024/1
author: parag kumar goyal
TC: O(N*M) where N is the number of rows and M is the number of columns
SC: O(N*M) where N is the number of rows and M is the number of columns

Given a binary matrix mat[][] containing only 0s and 1s, find the total coverage of all 0's. The coverage of a particular 0 cell is defined by checking 1's in its four directions (left, right, up, and down). For each direction, if there is at least one 1 anywhere between the 0 and the boundary of the matrix, the coverage increases by one.

Return the sum of the coverage values for all 0 cells in the matrix.

Input : mat[][] = [[1, 1, 1, 0],
                  [1, 0, 0, 1]]
Output : 8
Explanation: Coverage of first zero is 2. Coverages of other two zeros is 3 Total coverage = 2 + 3 + 3 = 8

Input: mat[][] = [[0, 1, 0],
               [0, 1, 1],
               [0, 0, 0]]
Output: 6
Explanation: Total Coverage is 1 + 2 + 1 + 0 + 1 + 1 = 6 

Input: mat[][] = [[0, 1]]
Output: 1
Explanation: There are only 1 coverage. Therefore answer for this test case is 1
*/

class Solution {
    public int findCoverage(int[][] mat) {

        int rows = mat.length;

        if (rows == 0) return 0;
        
        int cols = mat[0].length;

        int[][] prefRows = new int[rows][cols+1];
        int[][] prefCols = new int[cols][rows+1];

        // The idea is we calculate prefix sums row wise and column wise
        // now for each zero we want to get if there is ones present above zero and below that zero in same column
        // same for the column if there are 1 present left and right in same row

        // calculate prefix sum row wise
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                prefRows[row][col+1] = prefRows[row][col] + mat[row][col]; 
            }
        }

        // calculate prefix sum column wise
        for (int col = 0; col < cols; ++col) {
            for (int row = 0; row < rows; ++row) {
                prefCols[col][row+1] = prefCols[col][row] + mat[row][col];
            }
        }

        int totalCoverage = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (mat[row][col] == 0) {

                    // check for 1s in same row left and right
                    int left = prefRows[row][col];
                    int right = prefRows[row][cols] - prefRows[row][col+1];

                    // check for 1s in same col up and below
                    int up = prefCols[col][row];
                    int down = prefCols[col][rows] - prefCols[col][row+1];

                    totalCoverage += (left > 0 ? 1 : 0) + (right > 0 ? 1 : 0) + (up > 0 ? 1 : 0) + (down > 0 ? 1 : 0);
                }
            }
        }

        return totalCoverage;

    }

}


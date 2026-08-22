/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/set-matrix-zeroes
author: parag kumar goyal
TC: O(n*m) where n is the number of rows and m is the number of columns
*/

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int row = 0; row < rows; ++row) {
            if (mat[row][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
        
        for (int col = 0; col < cols; ++col) {
            if (mat[0][col] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        
        for (int row = 1; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                if (mat[row][col] == 0) {
                    mat[row][0] = 0;
                    mat[0][col] = 0;
                }
            }
        }
        
        
        for (int row = 1; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                if (mat[row][0] == 0 || mat[0][col] == 0) {
                    mat[row][col] = 0;
                }
            }
        }
        
        
        if (isFirstColZero) {
            for (int row = 0; row < rows; ++row) {
                mat[row][0] = 0;
            }
        }
        
        if (isFirstRowZero) {
            for (int col = 0; col < cols; ++col) {
                mat[0][col] = 0;
            }
        }
        
    }
}
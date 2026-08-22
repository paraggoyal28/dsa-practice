/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/rotate-by-90-degree-1587115621
author: parag kumar goyal
TC: O(n^2) where n is the size of matrix
SC: O(1)
*/

class Solution {
    
    private void swap(int[][] mat, int row1, int col1, int row2, int col2) {
        int temp = mat[row1][col1];
        mat[row1][col1] = mat[row2][col2];
        mat[row2][col2] = temp;
    }
    
    private void transposeMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int row = 0; row < rows; ++row) {
            for (int col = row+1; col < cols; ++col) {
                swap(mat, row, col, col, row);
            }
        }
    }
    
    private void reverseColumnWise(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int col = 0; col < cols; ++col) {
            for (int sRow = 0, eRow = rows - 1; sRow < eRow; 
                ++sRow, --eRow) {
                swap(mat, sRow, col, eRow, col);
            }
        }
    }
    
    
    public void rotateMatrix(int[][] mat) {
        // code here
        // column wise reverse the transpose of the matrix
        transposeMatrix(mat);
        
        reverseColumnWise(mat);
    }
}
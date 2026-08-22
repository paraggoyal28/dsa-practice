/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/search-in-a-matrix-1587115621
author: parag kumar goyal
TC: O(logn + logm) where n is the number of rows and m is the number of columns of matrix
SC: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int startRow = 0;
        int endRow = mat.length - 1;
        int cols = mat[0].length;
        int foundRow = -1;
        
        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow)/2;
            if (mat[midRow][0] <= x && mat[midRow][cols-1] >= x) {
                foundRow = midRow;
                break;
            } else if (mat[midRow][cols-1] < x) {
                startRow = midRow + 1;
            } else {
                endRow = midRow - 1;
            }
        }
        
        if (foundRow == -1) {
            return false;
        }
        
        
        int startCol = 0;
        int endCol = cols - 1;
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol)/2;
            if (mat[foundRow][midCol] == x) {
                return true;
            } else if (mat[foundRow][midCol] < x) {
                startCol = midCol + 1;
            } else {
                endCol = midCol - 1;
            }
        }
        
        return false;
        
    }
}

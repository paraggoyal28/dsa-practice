/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/search-in-a-row-wise-sorted-matrix
author: parag kumar goyal
TC: O(nlogm) where n is the number of rows and m is the number of columns in matrix
SC: O(1)
*/

class Solution {
    private boolean binarySearch(int[] row, int x) {
        int start = 0;
        int end = row.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] == x) {
                return true;
            } else if (row[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public boolean searchRowMatrix(int[][] mat, int x) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][0] <= x && x <= mat[row][mat[row].length - 1]) {
                if (binarySearch(mat[row], x)) {
                    return true;
                }
            }
        }

        return false;
    }
}
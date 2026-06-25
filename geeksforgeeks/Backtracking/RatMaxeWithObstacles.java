/*
problem: https://www.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1
author: parag kumar goyal
*/

/*
Approach 1:  Recursion + Backtracking - O(2^(n^2)) Time and O(n^2) Space
*/

import java.util.*;

class GFG {

    static boolean isSafe(int row, int col, int n, int[][] mat) {
        return (row >= 0 && row < n && col >= 0 && col < n && mat[row][col] != 0);
    }


    static boolean findPath(int[][] mat, ArrayList<ArrayList<Integer>> path, int row, int col, int n) {

        // if current row and current col out of bounds return false
        // or if mat[row][col] = 0
        if (row < 0 || row >= n || col < 0 || col >= n || mat[row][col] == 0) {
            return false;
        }

        // if reached to destination
        if (row == n-1 && col == n-1) {
            path.get(row).set(col, 1);
            return true;
        }

        // Check if curent cell is valid and not visited (equals 0)
        if (isSafe(row, col, n, mat) && path.get(row).get(col) == 0) {

            // Mark cell
            path.get(row).set(col, 1);

            // Try moving right first
            for (int jump = 1; jump <= mat[row][col] && jump < n; ++jump) {
                if (col + jump < n && findPath(mat, path, row, col + jump, n)) {
                    return true;
                }

                if (row + jump < n && findPath(mat, path, row + jump, col, n)) {
                    return true;
                }
            }

            // backtrack
            path.get(row).set(col, 0);

            return true;
        }

        return false;
    }



    // Function to get the shortest path matrix
    static ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        int n = mat.length;

        ArrayList<ArrayList<Integer>> path = new ArrayList<>();

        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(-1);
        noPath.add(row);

        // check for the base condition
        if (n == 0 || mat[n-1][n-1] == 0 || mat[0][0] == 0) {
            return noPath;
        }


        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, 0));

            path.add(row);
        }

        // Call the helper function
        // if no path exist return {{-1}}
        if (!findPath(mat, path, 0, 0, n)) {
            return noPath;
        }

        return path;
    }


    public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 0}, {3, 0, 0, 1}, {0, 1,  0, 1}, {0, 0, 0, 1}};

        // Get shortest path matrix
        ArrayList<ArrayList<Integer>> result = shortestDist(mat);
    }
}

/*
Another Approach: Finding Shortest Valid Path - O(n^2*maxJump) and space - O(n^2) 
Use memoization
*/

public class GFG {

    static boolean findPath(int[][] mat, ArrayList<ArrayList<Integer>> path, boolean[][] dp,
        int row, int col, int n) {

        // if current cell is out of bounds or current cell is blocked return false
        if (row < 0 || row >= n || col < 0 || col >= n || mat[row][col] == 0) {
            return false;
        }


        // if reached the end then return true
        if (row == n-1 && col == n-1) {
            path.get(row).set(col, 1);
            return true;
        }

        if (dp[row][col] != -1) {
            return (dp[row][col] == 1);
        }

        int jumps = mat[row][col];

        // mark current cell as visited
        path.get(row).set(col, 1);
        

        for (int jump = 1; jump <= jumps && jump < n; ++jump) {

            // Check for the right side first
            if (jump + col < n && findPath(mat, path, dp, row, col + jump, n)) {
                dp[row][col] = 1;
                return true;
            }

            if (row + jump < n && findPath(mat, path, dp, row + jump, col, n)) {
                dp[row][col] = 1;
                return true;
            }

        }


        path.get(row).set(col, 0);

        // mark the current path as not feasible
        dp[row][col] = 0;

        return false;
    }


    static ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        ArrayList<ArrayList<Integer>> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> noPathRow = new ArrayList<>();
        noPathRow.add(-1);
        noPath.add(noPathRow);



        int n = mat.length;
        int[][] dp = new int[n][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // if there are no rows or first cell is unreachable or last cell is unreachable
        if (n == 0 || mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            return noPath;
        }

        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, 0));
            path.add(row);
        }

        // Call the helper method
        // if no path exists return {{-1}}
        if (!findPath(mat, path, dp, 0, 0, n)) {
            return noPath;
        }

        return path;
    }



    public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 0}, {3, 0, 0, 1}, {0, 1,  0, 1}, {0, 0, 0, 1}};

        // Get shortest path matrix
        ArrayList<ArrayList<Integer>> result = shortestDist(mat);
    }

}


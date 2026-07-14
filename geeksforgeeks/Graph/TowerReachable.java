/*
problem: https://www.geeksforgeeks.org/problems/geeks-island--170646/1
author: parag kumar goyal

*/

/*
Brute Force Approach: DFS/BFS from each cell: 
TC: O(n*m*n*m), SC: O(n*m)
*/

import java.util.Arrays;

public class GFG {

    static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static void dfs(int row, int col, int[][] mat, boolean[][] visited, boolean[] station) {

        int rows = mat.length;
        int cols = mat[0].length;

        visited[row][col] = true;

        if (row == 0 || col == 0) {
            station[0] = true;
        }

        if (row == rows - 1 || col == cols - 1) {
            station[1] = true;
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int dir = 0; dir < 4; ++dir) {
            int newRow = row + dr[dir];
            int newCol = col + dc[dir];

            if (isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol] && mat[newRow][newCol] <= mat[row][col]) {
                visited[newRow][newCol] = true;
                dfs(newRow, newCol, mat, visited, station); 
            }
        }
    }

    public int countCoordinates(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) return 0;
        int cols = mat[0].length;

        int count = 0;

        for (int row = 0; row < rows; ++row) [
            for (int col = 0; col < cols; ++col) {
                boolean[][] visited = new boolean[rows][cols];

                boolean[] station = {false, false};

                dfs(row, col, mat, visited, station);

                if (station[0] && station[1]) {
                    count++;
                }
            }
        ]

        return count;
    }

}

/*
TC: O(n*m)
SC: O(n*m)
*/

import java.util.Arrays;

public class GFG {

    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


    private static void bfs(int rows, int cols, int[][] mat, Queue<int[]> stations, boolean[][] reachable) {
        while (!stations.isEmpty()) {
            int[] curr = stations.poll();
            int row = curr[0];
            int col = curr[1];

            // Visit all neighboring towers
            for (int dir = 0; dir < 4; ++dir) {
                int newRow = row + dx[dir];
                int newCol = col + dy[dir];

                if (isValid(newRow, newCol, rows, cols) && mat[newRow][newCol] >= mat[row][col] && !reachable[newRow][newCol]) {
                    reachable[newRow][newCol] = true;
                    stations.offer(new int[] {newRow, newCol});
                }
            }
        }
    }


    public int countCoordinates(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) {
            return 0;
        }
        int cols = mat[0].length;
        int count = 0;

        Queue<int[]> stationP = new LinkedList<>();
        Queue<int[]> stationQ = new LinkedList<>();

        boolean[][] reachP = new boolean[n][m];
        boolean[][] reachQ = new boolean[n][m];

        // Towers adjacent to station P (top boundary)
        // and to station Q (bottom boundary)
        for (int col = 0; col < cols; ++col) {
            stationP.offer(new int[] {0, col});
            reachP[0][col] = true;

            stationQ.offer(new int[] {rows - 1, col});
            reachQ[rows-1][col] = true;
        }

        // Towers adjacent to station P (left boundary)
        // and to station Q (right boundary)
        for (int row = 0; row < rows; ++row) {
            stationP.offer(new int[] {row, 0});
            reachP[row][0] = true;

            stationQ.offer(new int[] {row, cols - 1});
            reachQ[row][cols - 1] = true;
        }


        bfs(rows, cols, mat, stationP, reachP);
        bfs(rows, cols, mat, stationQ, reachQ);


        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (reachP[row][col] && reachQ[row][col]) {
                    count++;
                }
            }
        }

        return count;
    }
}

/*
problem: https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
author: parag kumar goyal
TC: O(N*M) where N is number of rows and M is number of columns
SC: O(N*M)
*/




class Solution {
    private static class Coordinate {
        int row;
        int col;
        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    int []dr = {0, 0, 1, -1};
    int []dc = {1, -1, 0, 0};
    
    private static boolean isValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }
    
    public int orangesRot(int[][] mat) {
        // code here
        // take all rotten oranges in a queue
        // pick each and make all neighbor if fresh to rotten
        // 
        int rows = mat.length;
        if (rows == 0) return 0;
        int cols = mat[0].length;
        
        Queue<Coordinate> rottenOranges = new LinkedList<>();
        
        boolean[][] visited = new boolean[rows][cols];
        
        int freshOrangesCnt = 0;
        
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (!visited[row][col] && mat[row][col] == 2) {
                    visited[row][col] = true;
                    rottenOranges.add(new Coordinate(row, col));
                } else if (mat[row][col] == 1) {
                    freshOrangesCnt += 1;
                }
            }
        }
        
        // no fresh oranges so time taken is 0
        if (freshOrangesCnt == 0) return 0;
        
        int timeTaken = 0;
        
        while (!rottenOranges.isEmpty()) {
            int sz = rottenOranges.size();
            boolean rottenAtThisLevel = false;
            for (int i = 0; i < sz; ++i) {
                Coordinate current = rottenOranges.poll();
                int current_row = current.row;
                int current_col = current.col;
                for (int dir = 0;dir < 4; ++dir) {
                    int new_row = current_row + dr[dir];
                    int new_col = current_col + dc[dir];
                    
                    if (isValid(new_row, new_col, rows, cols) 
                        && mat[new_row][new_col] == 1
                        && !visited[new_row][new_col]) {
                        visited[new_row][new_col] = true;
                        rottenOranges.add(new Coordinate(new_row, new_col));
                        freshOrangesCnt--;
                        rottenAtThisLevel = true;
                    }
                }
            }
            
            if (rottenAtThisLevel) {
                timeTaken++;
            }
        }
        
    
        
        return freshOrangesCnt == 0 ? timeTaken : -1;
        
    }
}
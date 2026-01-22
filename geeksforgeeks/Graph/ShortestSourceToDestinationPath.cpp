/*
problem: https://www.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1
author: parag kumar goyal
TC: O(N*M) where N is the number of rows and M is the number of columns in a matrix
SC: O(N*M) 
*/

class Cell {
public:
    int row, col, distance;
    Cell(int row, int col, int distance) {
        this->row = row;
        this->col = col;
        this->distance = distance;
    }
};

class Solution {
    public:

    int dr[4] = {0, 0, 1, -1};
    int dc[4] = {1, -1, 0, 0};

    bool isWithinRange(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    int shortestDistanceToTarget(vector<vector<int>>& A, int startRow, int startCol, 
            int endRow, int endCol, int rows, int cols) {
        
        // bfs 
        queue<Cell*> nearestFirst;
        nearestFirst.push(new Cell(startRow, startCol, 0));

        // keep track of visited cells
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));

        while (!nearestFirst.empty()) {
            Cell* nearest = nearestFirst.front();
            nearestFirst.pop();

            int currentRow = nearest->row;
            int currentCol = nearest->col;
            int currentDistance = nearest->distance;

            // if current cell is the end cell, then return the distance
            if (currentRow == endRow && currentCol == endCol) {
                return currentDistance;
            }
            
            // explore all directions 
            for (int dir = 0; dir < 4; ++dir) {
                int newRow = currentRow + dr[dir];
                int newCol = currentCol + dc[dir];

                if (isWithinRange(newRow, newCol, rows, cols) 
                    && !visited[newRow][newCol] && A[newRow][newCol] == 1) {
                    visited[newRow][newCol] = true;
                    nearestFirst.push(new Cell(newRow, newCol, currentDistance + 1));
                }
            }

        }
        return -1;
    }

    int shortestDistance(int N, int M, vector<vector<int>>& A, int X, int Y) {
        //
        if (N == 0 || M == 0) return -1;

        if (X >= N || X < 0 || Y >= M || Y < 0) return -1;

        if (A[X][Y] == 0 || A[0][0] == 0) return -1;

        return shortestDistanceToTarget(A, 0, 0, X, Y, N, M);
    }
};
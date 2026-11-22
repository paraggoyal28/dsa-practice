/*
https://leetcode.com/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150
author: parag kumar goyal
TC: O(R*C) where R is the number of rows and C is the number of cols
SC: O(R*C) for the bfs queue
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class CaptureSurroundedRegions {

	static int[] DR = {1, -1, 0, 0};
	static int[] DC = {0, 0, 1, -1};

	private void enqueueSafe(Deque<Integer> bfsDeque, int row, int col, int cols, char[][] board) {
		if (board[row][col] == 'O') {
			board[row][col] = '#'; // mark the cells cannot be captured as '#'
			bfsDeque.offerLast(row * cols + col);
		}
	}

	private boolean isWithinBounds(int row, int col, int rows, int cols) {
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}

	public void solve(char[][] board) {

		// handle border cases
		if (board == null || board.length == 0 || board[0].length == 0) return;

		int rows = board.length;
		int cols = board[0].length;

		Deque<Integer> bfsDeque = new ArrayDeque<>();

		for (int row = 0; row < rows; ++row) {
			enqueueSafe(bfsDeque, row, 0, cols, board);
			enqueueSafe(bfsDeque, row, cols - 1, cols, board);
		}

		for (int col = 0; col < cols; ++col) {
			enqueueSafe(bfsDeque, 0, col, cols, board);
			enqueueSafe(bfsDeque, rows - 1, col, cols, board);
		}

		while (!bfsDeque.isEmpty()) {
			int currentCell = bfsDeque.pollFirst();
			int currentRow = currentCell/cols;
			int currentCol = currentCell%cols;

			for (int dir = 0; dir < 4; ++dir) {
				int newRow = currentRow + DR[dir];
				int newCol = currentCol + DC[dir];
				if (isWithinBounds(newRow, newCol, rows, cols) &&
					board[newRow][newCol] == 'O') {
					board[newRow][newCol] = '#';
					bfsDeque.offerLast(newRow * cols + newCol);
				}
			}
		}

		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (board[row][col] == '#') {
					board[row][col] = 'O';
				} else if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
			}
		}
	}
}

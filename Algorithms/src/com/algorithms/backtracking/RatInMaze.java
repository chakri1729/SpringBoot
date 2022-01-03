package com.algorithms.backtracking;

public class RatInMaze {

	private static final int MAX_MOVES = 2;

	private static final int[] VALID_X_MOVES = { 1, 0 };
	private static final int[] VALID_Y_MOVES = { 0, 1 };

	public static void main(String[] args) {
		final int N = 4;
		int[][] input = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int[][] output = new int[N][N];
		if (getPath(input, output)) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(output[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	private static boolean getPath(int[][] input, int[][] output) {
		output[0][0] = 1;
		return pathHelper(0, 0, input, output, input[0].length);
	}

	private static boolean pathHelper(int x, int y, int[][] input, int[][] output, int n) {
		if (x == n - 1 && y == n - 1) {
			return true;
		}
		for (int i = 0; i < MAX_MOVES; i++) {
			int nx = x + VALID_X_MOVES[i];
			int ny = y + VALID_Y_MOVES[i];
			if (isValidMove(nx, ny, input, n)) {
				output[nx][ny] = 1;
				if (pathHelper(nx, ny, input, output, n)) {
					return true;
				} else {
					output[nx][ny] = 0;
				}
			}
		}
		return false;
	}

	private static boolean isValidMove(int x, int y, int[][] input, int n) {
		return x < n && y < n && input[x][y] == 1;
	}

}

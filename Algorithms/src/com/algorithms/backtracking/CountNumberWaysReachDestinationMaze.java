//https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
package com.algorithms.backtracking;

public class CountNumberWaysReachDestinationMaze {

	private static final int MAX_MOVES = 2;

	private static final int[] VALID_X_MOVES = { 1, 0 };
	private static final int[] VALID_Y_MOVES = { 0, 1 };

	public static void main(String[] args) {
		int[][] input = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(getNumberOfWays(input));

	}

	private static int getNumberOfWays(int[][] input) {
		return getNumberOfWaysHelper(0, 0, input[0].length, input, new int[1]);
	}

	private static int getNumberOfWaysHelper(final int x, final int y, final int n, final int[][] input,
			final int[] count) {
		if (x == n - 1 && y == n - 1) {
			return ++count[0];
		}
		for (int i = 0; i < MAX_MOVES; i++) {
			int nx = x + VALID_X_MOVES[i];
			int ny = y + VALID_Y_MOVES[i];
			if (isValidMove(nx, ny, n, input)) {
				getNumberOfWaysHelper(nx, ny, n, input, count);
			}
		}
		return count[0];
	}

	private static boolean isValidMove(final int x, final int y, final int n, final int[][] input) {
		return x >= 0 && y >= 0 && x < n && y < n && input[x][y] == 0;
	}
}

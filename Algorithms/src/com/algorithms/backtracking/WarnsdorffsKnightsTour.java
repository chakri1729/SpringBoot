package com.algorithms.backtracking;

public class WarnsdorffsKnightsTour {

	private static final int[] VALID_X_MOVES = { 1, 1, 2, 2, -1, -1, -2, -2 };
	private static final int[] VALID_Y_MOVES = { 2, -2, 1, -1, 2, -2, 1, -1 };

	public static void main(String[] args) {
		int n = 8;
		int[][] tour = getKnightsTour(n);
		if (tour[0][0] == -1) {
			System.out.println("Impossible!!!");
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.printf("%4d ", tour[i][j]);
				}
				System.out.println();
			}
		}

	}

	public static int[][] getKnightsTour(int n) {
		int[][] tour = new int[n][n];

		// initialization
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tour[i][j] = -1;
			}
		}
		tour[0][0] = 0;
		final int max = n * n;
		int x = 0, y = 0;
		for (int i = 1; i < max; i++) {
			int nx = 0, ny = 0, noOfUnvisitedAdjacents = 9;
			for (int j = 0; j < 8; j++) {
				int tx = x + VALID_X_MOVES[j];
				int ty = y + VALID_Y_MOVES[j];
				if (isSafe(tx, ty, n, tour)) {
					int tempNoOfUnvisitedAdjacents = getNoOfUnvisitedAdjacents(tx, ty, n, tour);
					if ( tempNoOfUnvisitedAdjacents < noOfUnvisitedAdjacents) {
						nx = tx;
						ny = ty;
						noOfUnvisitedAdjacents = tempNoOfUnvisitedAdjacents;
					}
				}
			}

			if (noOfUnvisitedAdjacents == 9) {
				tour[0][0] = -1;
				return tour;
			} else {
				tour[nx][ny] = tour[x][y] + 1;
				x = nx;
				y = ny;
			}

		}
		return tour;
	}

	private static boolean isSafe(int x, int y, int n, int[][] tour) {
		return x >= 0 && x < n && y >= 0 && y < n && tour[x][y] == -1;
	}

	private static int getNoOfUnvisitedAdjacents(int x, int y, int n, int[][] tour) {

		int count = 0;
		for (int j = 0; j < 8; j++) {
			int tx = x + VALID_X_MOVES[j];
			int ty = y + VALID_Y_MOVES[j];
			if (isSafe(tx, ty, n, tour)) {
				count++;
			}
		}

		return count;
	}

}

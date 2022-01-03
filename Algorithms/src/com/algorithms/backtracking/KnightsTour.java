package com.algorithms.backtracking;

public class KnightsTour {

	static final int[] VALID_X_MOVES = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static final int[] VALID_Y_MOVES = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		int n = 9;
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
		tour[0][0] = 0;
		if (!knightsTourHelper(0, 0, tour, n)) {
			tour[0][0] = -1;
		}
		return tour;

	}

	private static boolean knightsTourHelper(int a, int b, int[][] tour, int n) {
		if (tour[a][b] == ((n * n) - 1)) {
			return true;
		}

		for (int i = 0; i < 8; i++) {
			int x = a + VALID_X_MOVES[i], y = b + VALID_Y_MOVES[i];
			if (x >= 0 && x < n && y >= 0 && y < n && (x != 0 || y != 0) && tour[x][y] == 0) {
				tour[x][y] = tour[a][b] + 1;
				if (knightsTourHelper(x, y, tour, n)) {
					return true;
				}
				tour[x][y] = 0;
			}
		}

		return false;

	}

}

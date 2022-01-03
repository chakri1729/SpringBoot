//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
package com.algorithms.backtracking;

public class NQueen {

	private static final int[] VALID_X_MOVES = { -1, -1, -1 };
	private static final int[] VALID_Y_MOVES = { 0, 1, -1 };

	public static void main(String[] args) {
		int n = 8;
		int[][] solution = getNQueenSolution(n);
		for (int[] a : solution) {
			for (int i : a) {
				System.out.printf("%4d", i);
			}
			System.out.println();
		}

	}

	private static int[][] getNQueenSolution(int n) {
		int[][] solution = new int[n][n];
		nQueenSolutionHelper(0, n, solution);
		return solution;
	}

	private static boolean nQueenSolutionHelper(int i, int n, int[][] solution) {

		if (i == n) {
			return true;
		}

		for (int j = 0; j < n; j++) {
			if (isAvailable(i, j, n, solution)) {
				solution[i][j] = 1;
				if (nQueenSolutionHelper(i + 1, n, solution)) {
					return true;
				} else {
					solution[i][j] = 0;
				}
			}

		}

		return false;
	}
	
	// TBD: It has to be improved.
	private static boolean isAvailable(int i, int j, int n, int[][] solution) {
		for (int a = 0, x = i, y = j; a < VALID_X_MOVES.length; a++, x = i, y = j) {
			while (true) {
				x += VALID_X_MOVES[a];
				y += VALID_Y_MOVES[a];
				if (x >= 0 && x < n && y >= 0 && y < n) {
					if (solution[x][y] == 1) {
						return false;
					}

				} else {
					break;
				}
			}
		}

		return true;

	}
}

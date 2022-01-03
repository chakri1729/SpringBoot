//https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1#
package com.algorithms.backtracking;

public class SolveSudoku {

	public static void main(String args[]) {
		int[][] grid = { { 3, 0, 0, 0, 0, 0, 0, 0, 0 }, { 5, 2, 9, 1, 3, 4, 7, 6, 8 }, { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
				{ 2, 6, 3, 4, 1, 5, 9, 8, 7 }, { 9, 7, 4, 8, 6, 3, 1, 2, 5 }, { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
				{ 1, 3, 8, 9, 4, 7, 2, 5, 6 }, { 6, 9, 2, 3, 5, 1, 8, 7, 4 }, { 7, 4, 5, 2, 8, 6, 3, 1, 9 } };

		/*
		 * {{3,0,6,5,0,8,4,0,0}, {5,2,0,0,0,0,0,0,0}, {0,8,7,0,0,0,0,3,1,},
		 * {0,0,3,0,1,0,0,8,0}, {9,0,0,8,6,3,0,0,5}, {0,5,0,0,9,0,6,0,0},
		 * {1,3,0,0,0,0,2,5,0}, {0,0,0,0,0,0,0,7,4}, {0,0,5,2,0,6,3,0,0}};
		 */ if (solveSudoku(grid)) {
			printGrid(grid);
		} else {
			System.out.println("Solution does not exist!!!");
		}
	}

	private static boolean solveSudoku(int grid[][]) {
		for (int m = 0; m < 9; m++)
			for (int n = 0; n < 9; n++)
				if (grid[m][n] == 0) {
					for (int i = 1; i <= 9; i++)
						if (isValid(grid, m, n, i)) {
							grid[m][n] = i;
							if (solveSudoku(grid))
								return true;
							else
								grid[m][n] = 0;
						}

					return false;
				}

		return true;
	}

	static private boolean isValid(int grid[][], int m, int n, int v) {
		for (int k = 0; k < 9; k++) {
			if (grid[m][k] == v || grid[k][n] == v)
				return false;

			if (grid[k / 3 + (m - m % 3)][k % 3 + (n - n % 3)] == v)
				return false;
		}

		return true;
	}

	private static void printGrid(int grid[][]) {
		for (int[] m : grid) {
			for (int a : m) {
				System.out.print(a + " ");
			}
		}
	}
}

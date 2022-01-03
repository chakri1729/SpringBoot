//https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
package com.algorithms.dynamicprogramming;

public class CountNumberWaysReachDestinationMaze {

	public static void main(String[] args) {
		int[][] input = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(getNumberOfWays(input));
	}

	private static int getNumberOfWays(int[][] input) {
		int n = input[0].length;
		int[][] count = new int[n][n];
		getNumberOfWaysHelper(input[0].length, input, count);
		
		//for debugging
		for(int[] a : count) {
			for(int i:a) {
				System.out.printf("%4d", i);
			}
			System.out.println();
		}
		
		return count[n - 1][n - 1];
	}

	private static void getNumberOfWaysHelper(int n, int[][] input, int[][] count) {
		count[0][0] = 1;
		for (int i = 0, j = 1; j < n; j++) {
			if (input[i][j] == -1) {
				break;
			} else {
				count[i][j] = 1;
			}
		}

		for (int i = 1, j = 0; i < n; i++) {
			if (input[i][j] == -1) {
				break;
			} else {
				count[i][j] = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (input[i][j] != -1) {
					count[i][j] = count[i - 1][j] + count[i][j - 1];
				}
			}
		}
	}

}

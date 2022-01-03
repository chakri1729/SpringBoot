package com.algorithms.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class AllStringPermutations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] input = s.toCharArray();
		Arrays.sort(input);
		printPermutations(input, 0, s.length() - 1);

	}

	private static void printPermutations(char[] input, int start, int end) {
		if (start >= end) {
			System.out.println(input);
			return;
		}
		char s = input[start];
		for (int i = start; i <= end; i++) {
			input[start] = input[i];
			input[i] = s;
			printPermutations(input, start + 1, end);
			input[i] = input[start];
		}
		input[start] = s;

	}

}

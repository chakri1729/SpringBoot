package com.jpmc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		generateBook("input.txt", "output.txt");

	}

	public static Map<Key, List<String>> generateTrigrams(String inputFile) {
		Map<Key, List<String>> trigrams = new HashMap<>();
		Scanner scan = null;
		try {

			scan = new Scanner(new FileReader(inputFile));

			List<String> values = null;
			String first = null, second = null, third = null;
			while (scan.hasNext()) {
				if (first == null) {
					first = scan.next();
					continue;
				} else if (second == null) {
					second = scan.next();
					continue;
				} else {
					third = scan.next();
				}
				Key k = new Key(first, second);

				if (trigrams.containsKey(k)) {
					values = trigrams.get(k);
				} else {
					values = new ArrayList<>();
					trigrams.put(k, values);
				}
				values.add(third);
				first = second;
				second = third;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
		return trigrams;
	}

	public static void generateBook(String inputFile, String outputFile) {
		FileWriter outputFileWriter = null;
		try {
			Map<Key, List<String>> trigrams = generateTrigrams(inputFile);
			outputFileWriter = new FileWriter(outputFile);
			Random rand = new Random();
			List<Key> keysList = new ArrayList<>(trigrams.keySet());
			int n = keysList.size();

			Key start = keysList.get(rand.nextInt(n - 1));
			outputFileWriter.write(start.getFirst());
			outputFileWriter.write(" ");
			outputFileWriter.write(start.getSecond());

			for (int i = 0; i < 10000; i++) {
				if (trigrams.containsKey(start)) {
					List<String> values = trigrams.get(start);
					int s = values.size();
					String next = null;

					if (s == 1) {
						next = values.get(0);
					}
					if (s > 1) {
						next = values.get(rand.nextInt(s - 1));
					}
					outputFileWriter.write(" ");
					outputFileWriter.write(next);
					start = new Key(start.getSecond(), next);

				} else {
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outputFileWriter != null)
					outputFileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

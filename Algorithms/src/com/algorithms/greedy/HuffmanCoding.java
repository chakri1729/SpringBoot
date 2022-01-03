package com.algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

	public static void main(String[] args) {
		Node<Character> huffmanTreeRoot = buildHuffmanTree("aadddffeccaaddbdced");
		System.out.println(huffmanTreeRoot);

		generateCodes(huffmanTreeRoot).forEach((k, v) -> System.out.println(k + " --> " + v));

	}

	public static Node<Character> buildHuffmanTree(String str) {
		PriorityQueue<Node<Character>> pq = new PriorityQueue<>();
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		map.forEach((k, v) -> pq.add(new Node<>(k, v)));

		while (pq.size() > 1) {
			Node<Character> m = pq.poll();
			Node<Character> n = pq.poll();
			pq.add(new Node<>(m, n));
		}

		return pq.poll();
	}

	public static Map<Character, String> generateCodes(Node<Character> root) {
		Map<Character, String> generatedCodes = new HashMap<>();

		if (root != null) {
			generateCodeHelper(root, generatedCodes, "0");
		}

		return generatedCodes;

	}

	private static void generateCodeHelper(Node<Character> root, Map<Character, String> generatedCodes, String encodedString) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			generatedCodes.put(root.data, encodedString);
		}
		generateCodeHelper(root.left, generatedCodes, encodedString + "0");
		generateCodeHelper(root.right, generatedCodes, encodedString + "1");
	}

	private static class Node<T> implements Comparable<Node<T>> {

		int priority;
		T data;
		Node<T> left;
		Node<T> right;

		Node(T data, int priority) {
			this.data = data;
			this.priority = priority;
			left = null;
			right = null;
		}

		Node(Node<T> left, Node<T> right) {
			priority = left.priority + right.priority;
			data = null;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node<T> o) {
			return priority - o.priority;
		}

		@Override
		public String toString() {
			return "Node [priority=" + priority + ", data=" + data + ", \nleft=" + left + ", \nright=" + right + "]";
		}

	}

}

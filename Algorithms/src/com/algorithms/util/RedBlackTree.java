package com.algorithms.util;

public class RedBlackTree<T extends Comparable<T>> {
	private Node<T> root;

	private static final boolean RED = false;
	private static final boolean BLACK = true;

	public RedBlackTree() {
		super();
		root = null;
	}

	class Node<T extends Comparable<T>> {
		Node<T> left;
		Node<T> right;
		T data;
		// false -> RED
		// true -> BLACK
		boolean color;

		Node<T> parent;

		Node(T data) {
			super();
			this.data = data;
			color = RED;
			left = null;
			right = null;
			parent = null;
		}

	}

	public boolean insert(T t) {
		Node<T> x = new Node<T>(t);
		if (root == null) {
			root = x;
			root.color = RED;
			return true;
		}

		if (isContains(t))
			return false;

		Node<T> p = getParent(x);
		if (x.data.compareTo(p.data) < 0) {
			p.left = x;
		} else {
			p.right = x;
		}

		// if parent color is BLACK
		if (p.color == BLACK)
			return true;

		// if parent color is RED
		// Need implement the logic
		root = insertHelp(root, t);
		return true;

	}

	public Node<T> insertHelp(Node<T> root, T t) {

		// f is true when RED RED conflict is there.
		boolean conflictFlag = false;

		// recursive calls to insert at proper position according to BST properties.
		if (root == null)
			return (new Node<T>(t));

		if (t.compareTo(root.data) < 0) {
			root.left = insertHelp(root.left, t);
			root.left.parent = root;

			if (root.left.color == RED && root.color == RED) {
				conflictFlag = true;
			}
		} else {
			root.right = insertHelp(root.right, t);
			root.right.parent = root;

			if (root.right.color == RED && root.color == RED) {
				conflictFlag = true;
			}
		}

		if (conflictFlag) {
			// Code need to be implemented
			return null;
		}
		// Code need to be implemented
		return null;
	}

	public Node<T> getParent(Node<T> x) {
		Node<T> n = root;
		Node<T> p = root;
		while (n != null) {
			p = n;
			n = x.data.compareTo(n.data) < 0 ? n.left : n.right;
		}

		return p;

	}

	public boolean isContains(T t) {
		Node<T> n = root;
		while (true) {
			if (n == null)
				return false;

			if (t.equals(n.data))
				return true;

			n = t.compareTo(n.data) < 0 ? n.left : n.right;

		}

	}

}

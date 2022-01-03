package com.algorithms.util;

public class DoublyLinkedList<T> {

	private static class Node<T> {
		T data;
		Node<T> prev, next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> root;
	private Node<T> end;

	public void add(T t) {
		addLast(t);
	}

	public void addLast(T t) {
		Node<T> n = new Node<T>(t);
		if (end == null) {
			root = end = n;
		} else {
			end.next = n;
			n.prev = end;
			end = n;
		}
	}

	public void addFirst(T t) {
		Node<T> n = new Node<T>(t);
		if (root == null) {
			root = end = n;
		} else {
			n.next = root;
			root.prev = n;
			root = n;
		}
	}

	public void insert(int index, T t) {
		if (index == 0) {
			addFirst(t);
		} else {
			Node<T> p = root;
			for (int i = 1; p != null && i < index; i++, p = p.next)
				;
			if (p == null) {
				throw new IndexOutOfBoundsException();
			} else {
				Node<T> n = new Node<T>(t);
				n.prev = p;
				n.next = p.next;
				p.next = n;
				if (n.next != null) {
					n.next.prev = n;
				}
			}
		}
	}

	public boolean contains(T t) {
		if (root == null || t == null) {
			return false;
		}

		Node<T> n = root;
		for (; n != null && !t.equals(n.data); n = n.next);

		return n != null;

	}
}

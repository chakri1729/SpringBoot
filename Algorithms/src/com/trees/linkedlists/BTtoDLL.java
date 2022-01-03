//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

package com.trees.linkedlists;

public class BTtoDLL {

	public static void main(String[] args) {

	}

	Node bToDLL(Node root) {
		if(root == null)
			return null;
		
		return helper(root)[0];
	}

	Node[] helper(Node root) {
		if (root == null) {
			return null;
		}
		Node[] ht = new Node[2];
		ht[0] = root;
		ht[1] = root;
		if (root.left != null) {
			Node[] t = helper(root.left);
			ht[0] = t[0];
			t[1].right = root;
			root.left = t[1];
		}
		if (root.right != null) {
			Node[] t = helper(root.right);
			root.right = t[0];
			t[0].left = root;
			ht[1] = t[1];
		}
		return ht;
	}

}

class Node {
	Node left, right;
	int data;

	Node(int d) {
		data = d;
		left = right = null;
	}
}

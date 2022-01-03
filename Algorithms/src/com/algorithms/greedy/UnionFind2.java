package com.algorithms.greedy;

import java.util.Arrays;

import com.algorithms.util.Edge;
import com.algorithms.util.Graph;

public class UnionFind2 {

	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(3, 2);
		//g.addEdge(0, 3);

		System.out.println(hasCycle(g));

	}

	public static boolean hasCycle(Graph g) {

		int[] parents = new int[g.getNoOfVertices()];
		Arrays.fill(parents, -1);

		for (Edge e : g.getEdges()) {
			int s = e.getSource();
			int d = e.getDestination();

			int a = find(parents, s);
			int b = find(parents, d);
			if (a == b)
				return true;

			union(parents, a, b);

		}

		return false;

	}

	private static int find(int[] parents, int i) {
		if (parents[i] == -1)
			return i;
		return find(parents, parents[i]);
	}

	private static void union(int[] parents, int s, int d) {
		parents[s] = d;
	}

}

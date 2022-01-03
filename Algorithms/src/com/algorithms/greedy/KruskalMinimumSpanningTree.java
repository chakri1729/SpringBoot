package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KruskalMinimumSpanningTree {

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(1, 2, 8), new Edge(3, 4, 9), new Edge(5, 4, 10), new Edge(1, 7, 11),
				new Edge(3, 5, 14), new Edge(7, 6, 1), new Edge(8, 2, 2), new Edge(6, 5, 2), new Edge(0, 1, 4),
				new Edge(2, 5, 4), new Edge(8, 6, 6), new Edge(2, 3, 7), new Edge(7, 8, 7), new Edge(0, 7, 8));
		Set<Integer> vertices = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
		Graph g = new Graph(edges, vertices);
		getMSTusingKruskalAlgorithm(g).forEach(System.out::println);

	}

	public static List<Edge> getMSTusingKruskalAlgorithm(Graph graph) {
		List<Edge> mst = new ArrayList<>();
		Map<Integer, Set<Integer>> vertexSets = new HashMap<>();
		List<Edge> allEdges = graph.edges;
		Collections.sort(allEdges, (a, b) -> a.weight - b.weight);
		for (Edge e : allEdges) {
			if (!isCycle(vertexSets, e)) {
				updateVertexSets(vertexSets, e);
				mst.add(e);
				if (mst.size() == graph.vertices.size() - 1)
					return mst;
			}
		}
		return mst;
	}

	private static boolean isCycle(Map<Integer, Set<Integer>> vertexSets, Edge e) {

		if (e.source == e.destination)
			return true;

		Set<Integer> s1 = vertexSets.get(e.source);
		Set<Integer> s2 = vertexSets.get(e.destination);

		if (s1 == null || s2 == null)
			return false;

		return s1 == s2;
		
	}

	private static void updateVertexSets(Map<Integer, Set<Integer>> vertexSets, Edge e) {
		Set<Integer> s1 = vertexSets.get(e.source);
		Set<Integer> s2 = vertexSets.get(e.destination);

		if (s1 == null) {
			s1 = new HashSet<>();
			s1.add(e.source);
			vertexSets.put(e.source, s1);
		}

		if (s2 == null) {
			s1.add(e.destination);
			vertexSets.put(e.destination, s1);
		} else {
			s1.addAll(s2);
			for (Integer v : s2)
				vertexSets.put(v, s1);
		}

	}

	static class Graph {
		List<Edge> edges;
		Set<Integer> vertices;
		
		public Graph(List<Edge> edges, Set<Integer> vertices) {
			super();
			this.edges = edges;
			this.vertices = vertices;
		}

		@Override
		public String toString() {
			return "Graph [edges=" + edges + ", vertices=" + vertices + "]";
		}

	}

	private static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			super();
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
		}

	}

}

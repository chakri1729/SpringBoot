package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.algorithms.util.Edge;

public class UnionFind {

	public static void main(String args[]) {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1));
		edges.add(new Edge(1, 2));
		edges.add(new Edge(3, 2));
		System.out.println(hasCycle(edges));

	}

	public static boolean hasCycle(List<Edge> edges) {

		Map<Integer, Set<Integer>> parents = new HashMap<>();

		for (Edge e : edges) {
			int s = e.getSource();
			int d = e.getDestination();

			if (!parents.containsKey(s)) {
				Set<Integer> s1 = new HashSet<>();
				parents.put(s, s1);
				s1.add(s);

			}

			if (!parents.containsKey(d)) {
				Set<Integer> s2 = new HashSet<>();
				parents.put(d, s2);
				s2.add(d);
			}

			if (parents.get(s).contains(d) || parents.get(d).contains(s)) {
				return true;
			}

			Set<Integer> union = parents.get(s);
			union.addAll(parents.get(d));
			for(int i: parents.get(d)) {
				parents.put(i,union);
			}

		}

		return false;

	}

}

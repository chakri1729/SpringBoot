package com.algorithms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Graph {

	private int noOfVertices;

	// collection of all edges
	List<Edge> edges;

	public Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		edges = new ArrayList<Edge>();
	}

	public void addEdge(int source, int destination) {
		if (source >= noOfVertices || destination >= noOfVertices)
			return;
		edges.add(new Edge(source, destination));
	}

	public Collection<Edge> getEdges() {
		return Collections.unmodifiableCollection(edges);
	}
	
	public int getNoOfVertices() {
		return noOfVertices;
	}

}

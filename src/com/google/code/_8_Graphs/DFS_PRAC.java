package com.google.code._8_Graphs;

import java.util.ArrayList;
import java.util.List;

class PVertex {
	int data;
	List<PVertex> edges;

	boolean isVisited; // for dfs

	public PVertex(int data) {
		this.data = data;
		this.edges = new ArrayList<PVertex>();
		this.isVisited = false;
	}

	public void addEdge(PVertex edge) {
		this.edges.add(edge);
	}

	public List<PVertex> getEdges() {
		return this.edges;
	}
}

public class DFS_PRAC {

	public static void dfs(PVertex vertex) {
		System.out.print(vertex.data + " ");
		vertex.isVisited = true;
		for (PVertex v : vertex.getEdges()) {
			if (!v.isVisited) {
				dfs(v);
			}
		}
	}

	public static void main(String[] args) {

		PVertex v1 = new PVertex(10);
		PVertex v2 = new PVertex(20);
		PVertex v3 = new PVertex(30);
		PVertex v4 = new PVertex(40);

		v1.addEdge(v2);
		v1.addEdge(v4);
		v2.addEdge(v3);
		v3.addEdge(v4);

		dfs(v1);
	}
}

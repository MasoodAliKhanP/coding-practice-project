package com.google.code._8_Graphs;

import java.util.ArrayList;
import java.util.List;

class GraphVertex {//taken from baeldung: https://www.baeldung.com/java-graph-has-a-cycle
    boolean visited;
    int data;
    List<GraphVertex> edges;

    boolean isBeingVisited;//Only for cycle problem
    public GraphVertex() {
        super();
    }

    public GraphVertex(int data) {
        this.visited = false;
        this.isBeingVisited = false;
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
    public void addEdge(GraphVertex edge) {
        this.edges.add(edge);
    }

    public List<GraphVertex> getEdges() {
        return this.edges;
    }

    public void setEdges(List<GraphVertex> edges) {
        this.edges = edges;
    }
}

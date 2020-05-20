package com.google.code._8_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GraphVertex {
    boolean visited;
    int data;
    List<GraphVertex> edges;

    public GraphVertex() {
        super();
    }

    public GraphVertex(int data) {
        this.visited = false;
        this.data = data;
        this.edges = new ArrayList<>();
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

public class _GFG_1_DFS {
    public static void main(String[] args) {
        System.out.println("hello");

        GraphVertex v1 = new GraphVertex(10);
        GraphVertex v2 = new GraphVertex(20);
        GraphVertex v3 = new GraphVertex(30);
        GraphVertex v4 = new GraphVertex(40);

        List<GraphVertex> allVertices = new ArrayList<>();
        allVertices = Arrays.asList(v1, v2, v3, v4);
        System.out.println(allVertices);

        v1.addEdge(v2);
        v1.addEdge(v4);
        v2.addEdge(v3);
        v3.addEdge(v4);
        dfs(v1);
    }

    public static void dfs(GraphVertex v) {
        System.out.println(v.data);
        v.visited = true;
        for (GraphVertex edge : v.edges) {
            if (!edge.visited) {
                dfs(edge);
            }
        }
    }
}

package com.google.code._8_Graphs;

import java.util.Arrays;
import java.util.List;

public class _GFG_2_ComponentsInForest {

//  2
//  ^
//  |
//  1 - > 3   4 -> 5
    public static void main(String[] args) {
        System.out.println("hello");

        GraphVertex v1 = new GraphVertex(10);
        GraphVertex v2 = new GraphVertex(20);
        GraphVertex v3 = new GraphVertex(30);
        GraphVertex v4 = new GraphVertex(40);
        GraphVertex v5 = new GraphVertex(50);

        List<GraphVertex> allVertices = Arrays.asList(v1, v2, v3, v4, v5);
        System.out.println(allVertices);

        v1.addEdge(v2);
        v1.addEdge(v3);
        v4.addEdge(v5);

        connectedComponents(allVertices);
    }

    public static void connectedComponents(List<GraphVertex> g) {
        int components = 0;
        for (GraphVertex vertex : g) {
            if (!vertex.visited) {
                System.out.println("Root vertex: " + vertex.data);
                dfsUtil(vertex);
                components++;
            }
        }
        System.out.println("Components: " + components);
    }

    public static void dfsUtil(GraphVertex v) {
        System.out.println(v.data);
        v.visited = true;
        for (GraphVertex edge : v.edges) {
            if (!edge.visited) {
                dfsUtil(edge);
            }
        }
    }
}

package com.google.code._8_Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _GFG_4_TopologicalSorting {

    public static void main(String[] args) {
        System.out.println("test1");
        test1();
        System.out.println("test2");
        test2();
    }

    public static void topologicalOrder(List<GraphVertex> graph) {
        Stack<Integer> stack = new Stack<>();
        for (GraphVertex vertex : graph) {
            if (!vertex.visited)
                topologicalOrderUtil(vertex, stack);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void topologicalOrderUtil(GraphVertex v, Stack<Integer> stack) {
        v.visited = true;
        for (GraphVertex vertex : v.edges) {
            if (!vertex.visited) {
                topologicalOrderUtil(vertex, stack);
            }
        }
        stack.push(v.data);
    }

//  2 <- 4
//  ^
//  |
//  1 - > 3 <- 5 -> 6
    public static void test1() {
        GraphVertex v1 = new GraphVertex(10);
        GraphVertex v2 = new GraphVertex(20);
        GraphVertex v3 = new GraphVertex(30);
        GraphVertex v4 = new GraphVertex(40);
        GraphVertex v5 = new GraphVertex(50);
        GraphVertex v6 = new GraphVertex(60);

        v1.addEdge(v2);
        v1.addEdge(v3);
        v4.addEdge(v2);
        v5.addEdge(v3);
        v5.addEdge(v6);

        List<GraphVertex> allVertices = Arrays.asList(v1, v2, v3, v4, v5);

        topologicalOrder(allVertices);
    }

    
    public static void test2() {
        GraphVertex v0 = new GraphVertex(00);
        GraphVertex v1 = new GraphVertex(10);
        GraphVertex v2 = new GraphVertex(20);
        GraphVertex v3 = new GraphVertex(30);
        GraphVertex v4 = new GraphVertex(40);
        GraphVertex v5 = new GraphVertex(50);

//        v2.addEdge(v3);
        v3.addEdge(v2);
        v4.addEdge(v1);
        v4.addEdge(v0);
        v5.addEdge(v2);
        v5.addEdge(v0);

        List<GraphVertex> allVertices = Arrays.asList(v1, v2, v3, v4, v5, v0);

        topologicalOrder(allVertices);
    }
}

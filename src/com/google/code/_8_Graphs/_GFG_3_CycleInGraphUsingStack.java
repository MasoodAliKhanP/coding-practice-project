package com.google.code._8_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _GFG_3_CycleInGraphUsingStack {
//              3
//            ^
//            / |
//  1 - > 2 <- 4
    public static void main(String[] args) {
        System.out.println("hello");

        GraphVertex v1 = new GraphVertex(10);
        GraphVertex v2 = new GraphVertex(20);
        GraphVertex v3 = new GraphVertex(30);
        GraphVertex v4 = new GraphVertex(40);

        List<GraphVertex> allVertices = new ArrayList<>();
        allVertices = Arrays.asList(v1, v2, v3);
        System.out.println(allVertices);

        v1.addEdge(v2);
        v2.addEdge(v3);
        v3.addEdge(v4);
        v4.addEdge(v2);

        Stack<Integer> stack = new Stack<>();
        boolean isCyclic = isGraphCyclic(v1, stack);

        System.out.println(isCyclic);
    }

    public static boolean isGraphCyclic(GraphVertex v, Stack<Integer> stack) {
        if (stack.contains(v.data)) {
            return true;
        }
        v.visited = true;
        stack.push(v.data);

        for (GraphVertex edge : v.edges) {
            if (isGraphCyclic(edge, stack)) {
                return true;
            }
        }
        stack.pop();
        return false;
    }

}

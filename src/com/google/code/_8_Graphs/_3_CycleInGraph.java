package com.google.code._8_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _3_CycleInGraph {
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

		Stack<GraphVertex> stack = new Stack<>();
//		boolean isCyclic = isGraphCyclic(v1, stack);
		boolean isCyclic = isCyclic(v1);

		System.out.println(isCyclic);
//        printCycle(stack);

	}

	//Using stack
	public static boolean isGraphCyclic(GraphVertex v, Stack<GraphVertex> stack) {
		if (stack.contains(v)) {
			return true;
		}
		stack.push(v);
		for (GraphVertex edge : v.edges) {
			if (isGraphCyclic(edge, stack) && !edge.isVisited()) {
				return true;
			}
		}
		v.visited = true;
		stack.pop();
		return false;
	}

	public static void printCycle(Stack<GraphVertex> stack) {
		while (!stack.empty()) {
			System.out.print(stack.pop().getData() + "<-");
		}
	}

	
	//without stack
	public static boolean isCyclic(GraphVertex v) {
		v.isBeingVisited = true;
//		System.out.println("vertex start: " + v.data);
		for (GraphVertex ver : v.getEdges()) {
			if (ver.isBeingVisited == true) {
				return true;	// backward edge exists
			} else if (ver.visited == false && isCyclic(ver)) {
				return true;
			}
		}
		v.isBeingVisited = false;
		v.visited = true;
//		System.out.println("vertex: " + v.data);
		return false;
	}

}

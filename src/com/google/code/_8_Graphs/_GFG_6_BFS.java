package com.google.code._8_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class _GFG_6_BFS {
    public static void main(String[] args) {
        System.out.println("hello");

        GraphVertex v1 = new GraphVertex(10);
        GraphVertex v2 = new GraphVertex(20);
        GraphVertex v3 = new GraphVertex(30);
        GraphVertex v4 = new GraphVertex(40);

//        List<GraphVertex> allVertices = new ArrayList<>();
//        allVertices = Arrays.asList(v1, v2, v3, v4);
//        System.out.println("All vertices: " + allVertices);

        v1.addEdge(v2);
        v1.addEdge(v4);
        v2.addEdge(v3);
        v3.addEdge(v4);
        
//        printGraph(v1);
        bfs(v1);   
    }

    public static void printGraph(GraphVertex vertex) {
    	for(GraphVertex v: vertex.getEdges()) {
    		System.out.println(vertex.data + " -> " + v.data);
    		if(v.getEdges() != null || v.getEdges().size() != 0) {
    			printGraph(v);
    		}
    	}
    }
    
    
    public static void bfs(GraphVertex v) {
        Queue<GraphVertex> q = new LinkedList<GraphVertex>();
        q.add(v);
        
        while(!q.isEmpty()) {
        	GraphVertex ver = q.poll();
        	System.out.print(ver.data + " ");
        	
        	ver.visited = true;
        	
        	for(GraphVertex gv: ver.getEdges()) {
        		if(gv.visited == false) {
        			q.add(gv);
        		}	
        	}
        }
        
    }
}

package com.google.code._8_Graphs;

public class _1_DFS {
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
//        dfs(v1);
        
        System.out.println(dfs(v1, 20));
    }

    //traversing all graph
    public static void dfs(GraphVertex v) {
        System.out.println(v.data);
        v.visited = true;
        for (GraphVertex edge : v.edges) {
            if (!edge.visited) {
                dfs(edge);
            }
        }
    }
    
    //searching for element
    public static boolean dfs(GraphVertex v, int x) {
        System.out.println(v.data);
        v.visited = true;
        if(v.data == x) {
        	return true;
        }
        for (GraphVertex edge : v.edges) {
            if (!edge.visited) {
                return dfs(edge, x);
            }
        }
        return false;
    }
    
    public static void printGraph(GraphVertex vertex) {
    	for(GraphVertex v: vertex.getEdges()) {
    		System.out.println(vertex.data + " -> " + v.data);
    		if(v.getEdges() != null || v.getEdges().size() != 0) {
    			printGraph(v);
    		}
    	}
    }
    
}

package com.graph;

import java.util.Iterator;

public class DepthFirstSearch {

    private static boolean[] visited;

    static Graph dfs(Graph graph){
        int N = graph.getNumberOfNodes();
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            if(!visited[i])
                dfsUtil(graph, visited, i);
        }
        return graph;
    }

    static void dfsUtil(Graph graph, boolean[] visited, int start){
        Iterator neighbours = graph.adjList[start].listIterator();
        System.out.println(start);
        visited[start] = true;
        while(neighbours.hasNext()){
            int node = (int) neighbours.next();
            if(!visited[node]){
                visited[node] = true;
                dfsUtil(graph, visited, node);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = Graph.createGraph(6);
        dfs(graph);
    }
}

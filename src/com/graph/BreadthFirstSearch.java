package com.graph;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BreadthFirstSearch {

    static Queue queue;

    static void bfs(Graph graph, int start){
        queue = new ArrayDeque();
        boolean[] visited = new boolean[graph.getNumberOfNodes()];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = (int) queue.poll();
            System.out.print(node+" ");
            Iterator<Integer> neighbours = graph.adjList[node].listIterator();
            while (neighbours.hasNext()) {
                int adjNode = neighbours.next();
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = Graph.createGraph(6);
        bfs(graph, 0);
    }
}

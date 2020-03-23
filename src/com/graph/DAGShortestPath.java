package com.graph;

import java.util.List;
import java.util.Stack;

public class DAGShortestPath {

    static Integer[] findShortestPathDAG(WeightedGraph graph, int start){

         Integer[] distance = new Integer[graph.V];
         int[] topologicalSort = TopologicalSort.topologicalSort(graph);
         distance[start] = 0;
         for(int i = 0; i < topologicalSort.length; i++){
             int node = topologicalSort[i];


             if(distance[node]!= null){
                 List<Edge> adjacencyNodes = graph.adjList[i];
                 if(adjacencyNodes != null){
             for(Edge e: adjacencyNodes){

                    int newDist = e.weight + distance[node];
                 if(distance[e.to] == null)
                     distance[e.to] = newDist;
                 else
                     distance[e.to] = Math.min(newDist,distance[e.to]);
                 }
                 }
             }
         }
        for(int i : distance) System.out.println(i);
        return distance;
    }

    public static void main(String[] args) {
        WeightedGraph graph = WeightedGraph.createWeightedGraph(6);
       Integer[] result  = findShortestPathDAG(graph, 0);

    }
}

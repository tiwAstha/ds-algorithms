package com.graph;

//Sorting on direct acyclic graph such that for u -> v, u should always come before v

import java.util.*;

public class TopologicalSort {

    static Set set;
    static Stack stack;
    static int[] topologicalSort(WeightedGraph graph){
        set = new HashSet();
        stack = new Stack();
        int[] result = new int[graph.V];
        for(int i = 0; i < graph.V; i++){
            if(!set.contains(i))
                topologicalSortDFS(graph,i,set,stack);
        }
        int i = 0;
        while(!stack.empty()){
            result[i] = (int) stack.pop();
            i++;
        }
        return result;
    }

    static void topologicalSortDFS(WeightedGraph graph, int start, Set set, Stack stack){
/*      //for non-weighted graph
        Iterator adjNodes = graph.adjList[start].listIterator();
        set.add(start);
        while(adjNodes.hasNext()){
            int node = (int) adjNodes.next();
            if(!set.contains(node)){
                topologicalSortDFS(graph, node, set, stack);
            }
        }
        stack.push(start);*/

        //for weighted graph
        List<Edge> listOfAdjNodes = graph.adjList[start];
        set.add(start);
        for(Edge e: listOfAdjNodes){
            int node = e.to;
            if(!set.contains(node))
                topologicalSortDFS(graph,node,set,stack);
        }
        stack.push(start);
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(6);
        graph.addEdge(5, 2,1);
        graph.addEdge(5, 0,0);
        graph.addEdge(4, 0, 0);
        graph.addEdge(4, 1, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1,1);
        int[] result = topologicalSort(graph);
        for(int i: result)
            System.out.print(i+" ");
    }

}

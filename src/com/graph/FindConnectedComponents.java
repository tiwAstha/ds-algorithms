package com.graph;

import java.util.Iterator;

public class FindConnectedComponents {

    static int findConnectedComponents(Graph graph){
        int count = 0;
        int n = graph.getNumberOfNodes();
        boolean[] visited = new boolean[n];
        int[] components = new int[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                components = findConnectedComponentsDFS(graph, i, visited, components, count);
            }

        }

        int j = count;
        System.out.println("The "+count+" components are ");
        while(j>0){
            iterateComponents(components, j);
            j--;
        }
        return count;
    }

    static void iterateComponents(int[] components, int color){
        for(int i = 0; i < components.length; i++){
            if(components[i] == color)
                System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] findConnectedComponentsDFS(Graph graph, int node, boolean[] visited, int[] components, int j){

        Iterator<Integer> adjNodes = graph.adjList[node].listIterator();
        while(adjNodes.hasNext()){
            int i = adjNodes.next();
            if(!visited[i]){
                visited[i] = true;
                components[i] = j;
                findConnectedComponentsDFS(graph, i, visited, components, j);
            }
        }
        return components;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8, "adj list");
        graph.addEdgeAdjList(0,1);
        graph.addEdgeAdjList(0,2);
        graph.addEdgeAdjList(1,2);
        graph.addEdgeAdjList(3,4);
        graph.addEdgeAdjList(5,5);
        graph.addEdgeAdjList(6,7);

        findConnectedComponents(graph);
    }
}

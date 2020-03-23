package com.graph;

import java.util.LinkedList;
import java.util.List;

class Edge {


    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class WeightedGraph {

    int V;
    List<Edge>[] adjList;

    WeightedGraph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adjList[i] = new LinkedList<>();

    }

    void addEdge(int s, int d, int w) {
        Edge edge = new Edge(d, w);
        adjList[s].add(edge);
    }

    void printGraph() {
        for(int i = 0; i < V; i++){
            List<Edge> list = adjList[i];
            for(Edge e: list){
                System.out.println("node "+i+" is connected to "+e.to+" with weight "+e.weight);
            }
        }
    }

    static WeightedGraph createWeightedGraph(int vertices){
        WeightedGraph g = new WeightedGraph(vertices);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        return g;
    }
    public static void main(String[] args) {
        int vertices = 6;
        createWeightedGraph(vertices).printGraph();
    }
}

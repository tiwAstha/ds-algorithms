package com.graph;

import java.util.LinkedList;
import java.util.List;

//graph representation

public class Graph {

    private int V;
    List<Integer>[] adjList;
    int[][] adjMatrix;

    Graph(int V, String typeOfGraph){
        this.V = V;
        if(typeOfGraph.equalsIgnoreCase("adj matrix")){
            adjMatrix = new int[V][V];
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++)
                    adjMatrix[i][j] = 0;
            }
        }
        else{
            adjList = new LinkedList[V];
            for(int i = 0; i < V; i++){
                adjList[i] = new LinkedList<>();
            }
        }
    }

    void addEdgeAdjMat( int u, int v){
        adjMatrix[u][v] = 1;
        //for undirected graph uncomment the below line
        //adjMatrix[v][u] = 1;
    }

    void addEdgeAdjList( int u, int v){
        adjList[u].add(v);
        //for undirected graph uncomment the below line
        //adjList[v].add(u);
    }

    void printGraphAdjList(){
        for(int i = 0; i < V; i++){
            System.out.print("vertex "+i+" is connected to ");
            for(Integer j: adjList[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    void printGraphAdjMatrix(){
        for(int i = 0; i < V; i++){
            System.out.print("vertex "+i+" is connected to ");
            for(int j = 0; j < V; j++){
                if(adjMatrix[i][j] == 1){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }

    int getNumberOfNodes(){
        return V;
    }

    static Graph createGraph(int V){

        Graph graph = new Graph(V, "adj list");

        graph.addEdgeAdjList(5, 2);
        graph.addEdgeAdjList(5, 0);
        graph.addEdgeAdjList(4, 0);
        graph.addEdgeAdjList(4, 1);
        graph.addEdgeAdjList(2, 3);
        graph.addEdgeAdjList(3, 1);

        return graph;
    }

    public static void main(String[] args) {
        int V = 6;
        Graph graphList = createGraph(V);
        graphList.printGraphAdjList();

        Graph graphMat = new Graph(V, "adj matrix");

        graphMat.addEdgeAdjMat( 0,1);
        graphMat.addEdgeAdjMat(0,2);
        graphMat.addEdgeAdjMat(1,3);
        graphMat.addEdgeAdjMat(2,4);
        graphMat.addEdgeAdjMat(3,4);
        graphMat.addEdgeAdjMat(3,5);
        graphMat.addEdgeAdjMat(4,5);
        graphMat.printGraphAdjMatrix();

    }
}

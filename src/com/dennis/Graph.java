package com.dennis;

import java.util.ArrayList;
import java.util.List;

public class Graph {
     class Node{
        int val, weight;
        Node(int val, int weight){
            this.val = val;
            this.weight = weight;
        }
    }

    //define a adjacency list
    static List<List<Node>> adj_list = new ArrayList<>();
    public Graph(List<Edge> edges){
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());

        // add edges to the graph
        for (Edge e : edges) {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.dest, e.weight));
        }
    }

    //print graph
    public static void printGraph(Graph graph){
        int vertex = 0;
        int list_size = adj_list.size();

        System.out.println("These are the contents of the graph");
        while (vertex < list_size){
            for(Node edge: adj_list.get(vertex)){
                System.out.print("Vertex "+ vertex + " ==> " + edge.val + " ("+ edge.weight+ ")\t");

            }
            System.out.println();
            vertex+=1;
        }
    }
    /*

    //Traversal of the graph
    void DFS(int point){
        boolean[] visited = new boolean[adj_list.size()];
        DFS_Helper(point, visited);
    }

    private void DFS_Helper(int point, boolean[] visited) {

    }

     */
}

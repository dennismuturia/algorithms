package com.dennis;

import java.util.*;

public class GraphNode {
    int vertices;
    List<List<Integer>> neighbors;

    public GraphNode(){
        this.vertices = 0;
        neighbors = new ArrayList<>();

    }

    public GraphNode(int val){
        this.vertices = val;
        neighbors = new ArrayList<>();
        for (int i = 0; i < val; i++) {
            neighbors.add(new ArrayList<>());
        }

    }



    //Add items to the graph
    void addEdge(int source, int dest){
        neighbors.get(source).add(dest);
        neighbors.get(dest).add(source);
    }

    //print graph
    public void printGraphNodes(){
        for (int i=0; i < vertices; i++){
            System.out.print(" Node  " +i + " : " );
            for (int j : neighbors.get(i)) {
                System.out.print(" -> "+ j);
            }
        }
    }

    //do a dfs serch in the graph
    public List<Integer> dfsGraph(GraphNode g){
        boolean[] visited = new boolean[vertices];
        List<Integer>itemsInGraph = new ArrayList<>();
        dfsUtil(g, visited, itemsInGraph, 0);
        return itemsInGraph;
    }

    private void dfsUtil(GraphNode g, boolean[] visited, List<Integer> itemsInGraph, int position) {
        visited[position] = true;
        itemsInGraph.add(position);
        Iterator<Integer>i = neighbors.get(position).listIterator();
        while (i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                dfsUtil(g, visited, itemsInGraph, n);
            }
        }
    }

    public List<Integer>bfs(GraphNode g){
        List<Integer>myList = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        Queue<Integer>q = new LinkedList<>();
        visited[0] = true;
        myList.add(0);
        q.add(0);
        while (!q.isEmpty()){
            int val = q.poll();

            Iterator<Integer>i = neighbors.get(val).listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    myList.add(n);
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        return myList;
    }


}

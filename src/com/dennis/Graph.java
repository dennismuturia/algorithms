package com.dennis;

import java.util.*;

public class Graph {

    public int val;
    public List<Graph>list;

    public Graph(){
        this.val = 0;
        this.list = new ArrayList<>();
    }
    public Graph(int val){
        this.val = val;
        this.list = new ArrayList<>();
    }

    public Graph(int val, List<Graph> neighbors){
        this.val = val;
        this.list = neighbors;
    }

    public Graph cloneGraph(Graph node){
        HashMap<Integer, Graph> map = new HashMap<>();
        if(node == null) return null;

        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Graph clone = new Graph(node.val);
        map.put(clone.val, clone);
        for (Graph neighbor: node.list){
            clone.list.add( cloneGraph(neighbor));
        }
        return  clone;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //use dfs
        if(prerequisites.length == 0 || numCourses == 0) return true;

        //use adjacenclist
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int i =0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int []req : prerequisites){
            map.get(req[1]).add(req[0]);
        }

        //create a visited array where 0 is unvisited, -1 is visiting and 1 is visited
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dfs(map, visited, i)) return false;
        }

        return true;
    }

    boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int i){
        if(visited[i] == -1){
            return false;
        }
        if(visited[i] == 1){
            return true;
        }

        visited[i] = -1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!dfs(map, visited, j)) return false;
            }
        }
        visited[i] = 1;
        return true;
    }
    List<Integer>res1 = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return new int[0];
        int[]res = new int[numCourses];
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }


        for(int[] req: prerequisites){
            map.get(req[0]).add(req[1]);
        }
        //This takes 0 as unvisited, -1 as currently visiting and any other number as visited;
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
           dfs1(map, visited, i);
        }
        int []results = new int[list.size()];
        int i = 0;
        for (int p:res1) {
            results[i] = p;
            i++;
        }


        return results;
    }

    void dfs1(Map<Integer, List<Integer>> map, int[] visited, int i){
        if(visited[i] == -1){
            return;
        }
        if(visited[i] == 1){
            return;
        }
        visited[i] = -1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                dfs1(map, visited, j);
            }
        }

        visited[i] = 1;
        if(map.get(i).isEmpty() ){
            res1.add(0);
        }else{
            res1.add(map.get(i).get(0));
        }

    }

}

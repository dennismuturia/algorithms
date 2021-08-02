package com.dennis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


}

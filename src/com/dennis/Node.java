package com.dennis;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}


    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> items = new LinkedList<>();
        items.add(root);
        while(!items.isEmpty()){
            while(!items.isEmpty()){
                Node ref = items.poll();
                if(!items.isEmpty()){
                    ref.next = items.poll();
                }
                items.add(ref.left);
                items.add(ref.right);
            }
        }
        return root;
    }
}

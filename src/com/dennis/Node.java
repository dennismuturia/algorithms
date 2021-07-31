package com.dennis;

import java.util.HashMap;
import java.util.Map;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> hashTable = new HashMap<>();

        //first clone the list
        Node ref = head;
        while (ref!= null){
            hashTable.put(ref, new Node(ref.val));
            ref = ref.next;
        }

        //assign next and random pointers
        ref = head;
        while (ref!=null){
            hashTable.get(ref).next = hashTable.get(ref.next);
            hashTable.get(ref).random = hashTable.get(ref.random);
            ref = ref.next;
        }

        return hashTable.get(head);
    }
}

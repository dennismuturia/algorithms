package com.dennis;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ListNode {
    Integer val;
    ListNode next;

    public ListNode(Integer val){
        this.val = val;
        this.next = null;
    }

    ListNode addItem(int item, ListNode head){
        ListNode p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = new ListNode(item);
        return head;
    }
    ListNode removeItem(ListNode head, int item){
        ListNode current = head;
        ListNode newHead = new ListNode(null);
        ListNode previous = newHead;
        while (current != null){
            if(current.val == item){
                previous.next = current.next;
                current = current.next;
            }else {
                previous = current;
                current = current.next;
            }
        }
        return newHead;
    }

    //remove elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode r = head;
        while(r.next.next!= null){
            if(r.val == val){

                r.val = r.next.val;
                r.next = r.next.next;


            }
            r= r.next;
        }
        if(r.next.val ==val ){
            r.next = null;
        }
        return head;
    }

    //reverse a linked list
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    //printing values
    void printNodes(ListNode l){
        while(l!= null){
            System.out.print(l.val + " ");
            if (l.next!= null){
                System.out.print(" => ");
            }
            l = l.next;
        }
    }

}


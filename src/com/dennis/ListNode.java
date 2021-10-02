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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer>myList = new ArrayList<>();
        while(head != null){
            myList.add(head.val);

            head = head.next;
        }

        myList.remove(myList.size() - n );
        if(myList.size() != 0){
            head = new ListNode(myList.get(0));
            myList.remove(0);
        }


        ListNode p = head;
        int i = 0;

        while (p != null && !myList.isEmpty()){
            p.next = new ListNode(myList.get(i));
            p = p.next;
            myList.remove(i);

        }

        return head;
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


    //merge k sorted listnodes
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode ref = lists[0];
        ListNode res = null;

        for (int i = 1; i <lists.length ; i++) {
            if(lists[i] == null){
                continue;
            }
            else{
                while (ref != null){
                    ref = ref.next;
                }
                if(lists[0] == null){
                    lists[0] = lists[i];
                    lists[i] = null;
                }
                if(ref == null){
                    ref = lists[0];
                }
                if(ref.next != null){
                    ref.next = lists[i];
                }

                res = lists[0];
                //perform merge sort;
                ref = mergesort(res);
            }

        }
        return lists[0];
    }

    private ListNode mergesort(ListNode ref) {
        if(ref == null || ref.next == null) return ref;
        ListNode middle = getMiddle(ref);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        ListNode left = mergesort(ref);
        ListNode right = mergesort(nextOfMiddle);

        ListNode sorted = sortedMergedList(left, right);
        return sorted;
    }

    private ListNode sortedMergedList(ListNode left, ListNode right) {
        ListNode result = null;
        if(left == null) return right;
        if(right == null) return left;

        if(left.val <= right.val){
            result = left;
            result.next = sortedMergedList(left.next, right);
        }else{
            result = right;
            result.next = sortedMergedList(left, right.next);
        }
        return result;
    }

    private ListNode getMiddle(ListNode ref) {
        if(ref == null) return ref;
        ListNode slow = ref;
        ListNode fast = ref;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}


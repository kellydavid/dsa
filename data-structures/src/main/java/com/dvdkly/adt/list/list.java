package com.dvdkly.adt.list;

import com.dvdkly.dsa.core.Node;

public class List {

    private Node head = null;

    void add(Node item) {
        if(head == null){
            head = item;
        }else{
            item.setNext(head);
            head = item;
        }
    }

    Node last(){
        Node it = head;
        Node last = null;
        while(it != null){
            last = it;
            it = it.getNext();
        }
        return last;
    }

    Node tail(){
        Node result = null;
        if(head != null) {
            result = head.getNext();
        }
        return result;
    }

    Node getHead() {
        return head;
    }
}
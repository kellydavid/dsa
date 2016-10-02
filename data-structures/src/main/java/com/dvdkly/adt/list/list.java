package com.dvdkly.adt.list;

import com.dvdkly.dsa.core.Node;

public class List {

    private Node head = null;

    boolean remove(Node pointer) {
        Node it = head;
        Node prev = it;
        while (it != null) {
            if (it == pointer) {
                // found a match now remove
                prev.setNext(it.getNext());
                return true;
            }
            prev = it;
            it.setNext(it.getNext());
        }
        return false;
    }

    boolean remove(String data) {
        Node it = head;
        Node prev = it;
        while(it != null){
            if(it.getData().equals(data)){
                prev.setNext(it.getNext());
                return true;
            }
        }
        return false;
    }

    void add(Node item) {
        Node last = last();
        if(last == null) {
            head = item;
        }else{
            last.setNext(item);
            item.setNext(null);
        }
    }

    Node last() {
        Node it = head;
        Node last = null;
        while (it != null) {
            last = it;
            it = it.getNext();
        }
        return last;
    }

    Node getHead() {
        return head;
    }

    public String toString(){
        String str = "{";
        Node ptr = head;
        while(ptr != null){
            str += ptr.getData() + ", ";
            ptr = ptr.getNext();
        }
        str = str.substring(0, str.length() - 2);
        str += "}";
        return str;
    }

}
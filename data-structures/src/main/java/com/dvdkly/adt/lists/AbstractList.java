package com.dvdkly.adt.lists;

import com.dvdkly.adt.node.Node;

abstract class AbstractList<T> implements List<T> {

    protected Node<T> head = null;

    public T getHead(){
        if(head == null)
            return null;
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String printList(){
        String str = "{";
        Node ptr = head;
        while(ptr != null){
            str += ptr.getData() + ", ";
            ptr = ptr.getNext();
        }
        if(head != null) {
            str = str.substring(0, str.length() - 2);
        }
        str += "}";
        return str;
    }

}

package com.dvdkly.adt.list;

import com.dvdkly.adt.node.Node;

public abstract class AbstractList<T> implements List<T> {

    protected Node<T> head = null;

    public T getHead(){
        if(head == null)
            return null;
        return head.getData();
    }

    protected Node<T> getHeadNode(){
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    protected Node<T> getLastNode(){
        Node<T> it = head;
        Node<T> last = null;
        while(it != null){
            last = it;
            it = it.getNext();
        }
        return last;
    }

    public String printList(){
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

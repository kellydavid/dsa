package com.dvdkly.adt.node;

public class Node<T>{

    private T data = null;
    private Node next = null;

    public Node(T data){
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

}

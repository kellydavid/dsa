package com.dvdkly.adt.node;

public class DNode<T> {

    private T data = null;
    private DNode next = null;
    private DNode prev = null;

    public DNode(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }
}

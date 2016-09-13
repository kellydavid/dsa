package com.dvdkly.dsa.core;

public class Node{

    private String data = null;
    private Node next = null;

    public Node(String data){
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * TODO: Implement this method
     *
     * @return Printable string representation of node
     */
    public static String printableString(){
        return "";
    }
}
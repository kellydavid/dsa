package com.dvdkly.adt.lists;

import com.dvdkly.adt.node.Node;

public class SinglyList<T> implements List<T> {

    private Node<T> head = null;

    public int getSize() {
        int size = 0;
        Node it = head;
        while (it != null) {
            size++;
            it = it.getNext();
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean find(T data) {
        Node it = head;
        while (it != null) {
            if (it.getData().equals(data))
                return true;
            it = it.getNext();
        }
        return false;
    }

    public void insertFirst(T data) {
        Node<T> newHead = new Node<>(data);
        newHead.setNext(head);
        head = newHead;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> it = head.getNext();
            Node<T> last = head;
            while (it != null) {
                last = it;
                it = it.getNext();
            }
            last.setNext(newNode);
        }
    }

    public T get(int index) {
        Node<T> it = head;
        for (int i = 0; i <= index && it != null; i++, it = it.getNext()) {
            if (i == index) {
                return it.getData();
            }
        }
        return null;
    }

    public T getFirst() {
        if(head == null)
            return null;
        return head.getData();
    }

    public T getLast() {
        return get(getSize() - 1);
    }

    public boolean remove(T data) {
        Node it = head;
        Node prev = it;
        while (it != null) {
            if (it.getData().equals(data)) {
                if (it == head) {
                    head = it.getNext();
                } else {
                    prev.setNext(it.getNext());
                }
                return true;
            }
            prev = it;
            it = it.getNext();
        }
        return false;
    }

    public boolean remove(int index) {
        Node<T> it = head;
        Node<T> prev = it;
        for (int i = 0; i <= index && it != null; i++) {
            if (i == index) {
                // we now have a pointer `it` to the Node at index i
                if (it == head) {
                    head = it.getNext();
                } else {
                    prev.setNext(it.getNext());
                }
                return true;
            }
            prev = it;
            it = it.getNext();
        }
        return false;
    }

    public void clear() {
        head = null;
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
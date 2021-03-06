package com.dvdkly.adt.lists;

import com.dvdkly.adt.node.DNode;

public class DoublyList<T> implements List<T> {

    private DNode<T> head;

    public int getSize() {
        if (head == null)
            return 0;
        int count = 1;
        DNode<T> it = head;
        while (it.getNext() != null) {
            count++;
            it = it.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean find(T data) {
        if (head == null)
            return false;
        DNode<T> it = head;
        while (it != null) {
            if (it.getData().equals(data)) {
                return true;
            }
            it = it.getNext();
        }
        return false;
    }

    public void insertFirst(T data) {
        DNode<T> newNode = new DNode<>(data);
        if (head == null)
            head = newNode;
        else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertLast(T data) {
        DNode<T> newNode = new DNode<>(data);
        if (head == null)
            head = newNode;
        else {
            DNode<T> it = head;
            while (it.getNext() != null) {
                it = it.getNext();
            }
            it.setNext(newNode);
            newNode.setPrev(it);
        }
    }

    public T get(int index) {
        if (head == null)
            return null;
        DNode<T> it = head;
        int i = 0;
        for (; i < index && it.getNext() != null; i++, it = it.getNext()) {
        }
        if (i == index) {
            return it.getData();
        } else {
            return null;
        }
    }

    public T getFirst() {
        if (head == null)
            return null;
        else
            return head.getData();
    }

    public T getLast() {
        if (head == null)
            return null;
        DNode<T> it = head;
        while (it.getNext() != null) {
            it = it.getNext();
        }
        return it.getData();
    }

    public boolean remove(T data) {
        DNode<T> it = head;
        while (it != null) {
            if (it.getData().equals(data)) {
                if (it == head) {
                    head = head.getNext();
                } else {
                    // fix previous pointer
                    if (it.getPrev() != null) {
                        it.getPrev().setNext(it.getNext());
                    }
                    // fix next pointer
                    if (it.getNext() != null) {
                        it.getNext().setPrev(it.getPrev());
                    }
                }
                return true;
            }
            it = it.getNext();
        }
        return false;
    }

    public boolean remove(int index) {
        if (head == null)
            return false;
        if (index == 0) {
            head = head.getNext();
            return true;
        }
        DNode<T> it = head;
        for (int i = 0; i <= index && it != null; i++, it = it.getNext()) {
            if (i == index) {
                // fix previous pointer
                if (it.getPrev() != null) {
                    it.getPrev().setNext(it.getNext());
                }
                // fix next pointer
                if (it.getNext() != null) {
                    it.getNext().setPrev(it.getPrev());
                }
                return true;
            }
        }
        return false;
    }

    public void clear() {
        head = null;
    }

    public String printList() {
        String str = "{";
        DNode<T> ptr = head;
        while (ptr != null) {
            str += ptr.getData() + ", ";
            ptr = ptr.getNext();
        }
        if (head != null) {
            str = str.substring(0, str.length() - 2);
        }
        str += "}";
        return str;
    }
}

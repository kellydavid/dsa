package com.dvdkly.adt.lists;


public interface List<T> {

    int getSize();

    boolean isEmpty();

    boolean find(T data);

    void insertFirst(T data);

    void insertLast(T data);

    T get(int index);

    T getFirst();

    T getLast();

    boolean remove(T data);

    boolean remove(int index);

    String printList();

}

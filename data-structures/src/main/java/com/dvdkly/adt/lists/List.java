package com.dvdkly.adt.lists;


public interface List<T> {

    int getSize();

    boolean find(T data);

    T get(int index);

    boolean remove(T data);

    boolean remove(int index);

    void insertFirst(T data);

    void insertLast(T data);

    T getHead();

    T last();

    boolean isEmpty();

    String printList();

}

package com.dvdkly.adt.list;

import junit.framework.TestCase;

public class SinglyListTest extends TestCase {

    public SinglyListTest(String name) {
        super(name);
    }

    public void testListCreation() throws Exception {
        SinglyList list = new SinglyList();
        assertTrue(list.getHead() == null);
    }

    public void testInsertFirst() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertTrue(list.getHead() != null);
        assertEquals("{sample data here}", list.printList());
    }

    public void testInsertLast() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertLast("sample data here");
        assertTrue(list.getHead() != null);
        assertEquals("{sample data here}", list.printList());
    }

    public void testMultipleInsertFirst() throws Exception{
        SinglyList<String> list = new SinglyList<>();
        list.insertFirst("sample1");
        list.insertFirst("sample2");
        list.insertFirst("sample3");
        assertEquals("{sample3, sample2, sample1}", list.printList());
    }

    public void testMultipleInsertLast() throws Exception{
        SinglyList<String> list = new SinglyList<>();
        list.insertLast("sample1");
        list.insertLast("sample2");
        list.insertLast("sample3");
        assertEquals("{sample1, sample2, sample3}", list.printList());
    }

}
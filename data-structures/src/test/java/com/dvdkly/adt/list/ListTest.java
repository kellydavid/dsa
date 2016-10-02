package com.dvdkly.adt.list;

import com.dvdkly.dsa.core.Node;
import junit.framework.TestCase;

public class ListTest extends TestCase {

    public ListTest(String name) {
        super(name);
    }

    public void testListCreation() throws Exception {
        List list = new List();
        assertTrue(list.getHead() == null);
    }

    public void testAddingToList() throws Exception {
        List list = new List();
        list.add(new Node("sample data here"));
        assertTrue(list.getHead() != null);
        assertEquals("{sample data here}", list.toString());
    }

    public void testAddingMultipleToList() throws Exception{
        List list = new List();
        list.add(new Node("sample1"));
        list.add(new Node("sample2"));
        list.add(new Node("sample3"));
        assertEquals("{sample1, sample2, sample3}", list.toString());
    }


}
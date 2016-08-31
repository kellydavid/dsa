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
    }

}
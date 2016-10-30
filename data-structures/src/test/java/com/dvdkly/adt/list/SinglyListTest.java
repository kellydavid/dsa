package com.dvdkly.adt.list;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SinglyListTest {

    @Test
    public void testListCreation() throws Exception {
        SinglyList list = new SinglyList();
        assertTrue(list.getHead() == null);
    }

    @Test
    public void testInsertFirst() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertTrue(list.getHead() != null);
        assertEquals("{sample data here}", list.printList());
    }

    @Test
    public void testRemoveData() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertEquals("{sample data here}", list.printList());
        assertTrue(list.remove("sample data here"));
        assertEquals("{}", list.printList());
    }

    @Test
    public void testRemoveIndex() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertEquals("{sample data here}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{}", list.printList());
    }

    @Test
    public void testInsertLast() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertLast("sample data here");
        assertTrue(list.getHead() != null);
        assertEquals("{sample data here}", list.printList());
    }

    @Test
    public void testMultipleInsertFirst() throws Exception{
        SinglyList<String> list = new SinglyList<>();
        list.insertFirst("sample1");
        list.insertFirst("sample2");
        list.insertFirst("sample3");
        assertEquals("{sample3, sample2, sample1}", list.printList());
    }

    @Test
    public void testMultipleInsertLast() throws Exception{
        SinglyList<String> list = new SinglyList<>();
        list.insertLast("sample1");
        list.insertLast("sample2");
        list.insertLast("sample3");
        assertEquals("{sample1, sample2, sample3}", list.printList());
    }

    @Test
    public void testMultipleRemoveIndex() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertLast("sample1");
        list.insertLast("sample2");
        list.insertLast("sample3");
        list.insertLast("sample4");
        list.insertLast("sample5");
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertFalse(list.remove(70));
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertFalse(list.remove(-5));
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertTrue(list.remove(3));
        assertEquals("{sample1, sample2, sample3, sample5}", list.printList());
        assertTrue(list.remove(3));
        assertEquals("{sample1, sample2, sample3}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{sample2, sample3}", list.printList());
        assertTrue(list.remove(1));
        assertEquals("{sample2}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{}", list.printList());
        assertFalse(list.remove(0));
        assertEquals("{}", list.printList());
    }

    @Test
    public void testMultipleRemoveData() throws Exception {
        SinglyList<String> list = new SinglyList<>();
        list.insertLast("sample1");
        list.insertLast("sample2");
        list.insertLast("sample3");
        list.insertLast("sample4");
        list.insertLast("sample5");
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertFalse(list.remove("wahwah"));
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertTrue(list.remove("sample4"));
        assertEquals("{sample1, sample2, sample3, sample5}", list.printList());
        assertTrue(list.remove("sample5"));
        assertEquals("{sample1, sample2, sample3}", list.printList());
        assertTrue(list.remove("sample1"));
        assertEquals("{sample2, sample3}", list.printList());
        assertTrue(list.remove("sample3"));
        assertEquals("{sample2}", list.printList());
        assertTrue(list.remove("sample2"));
        assertEquals("{}", list.printList());
        assertFalse(list.remove("wahwah"));
        assertEquals("{}", list.printList());
    }

}
package com.dvdkly.adt.lists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ListStringTest {

    private List list;

    public ListStringTest(List list){
        this.list = list;
    }

    @Parameters(name= "{index}: list implementation({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[] {new SinglyList<String>()}, new Object[] {new DoublyList<String>()});
    }

    @Test
    public void testListCreation() throws Exception {
        new SinglyList();
        assertTrue(list.getFirst() == null);
    }

    @Test
    public void testInsertFirst() throws Exception {
        list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertTrue(list.getFirst() != null);
        assertEquals("{sample data here}", list.printList());
    }

    @Test
    public void testRemoveData() throws Exception {
        list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertEquals("{sample data here}", list.printList());
        assertTrue(list.remove("sample data here"));
        assertEquals("{}", list.printList());
    }

    @Test
    public void testIsEmpty() throws Exception {
        list = new SinglyList();
        assertTrue(list.isEmpty());
        list.insertFirst("dasf");
        list.remove("dasf");
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetSize() throws Exception {
        list = new SinglyList();
        assertEquals(list.getSize(), 0);
        list.insertFirst("dasf");
        assertEquals(list.getSize(), 1);
        list.insertFirst("asdf");
        assertEquals(list.getSize(), 2);
        list.remove("dasf");
        assertEquals(list.getSize(), 1);
        list.remove("asdf");
        assertEquals(list.getSize(), 0);
    }

    @Test
    public void testFind() throws Exception{
        list = new SinglyList<>();
        list.insertFirst("sample1");
        assertTrue(list.find("sample1"));
        list.insertFirst("sample2");
        assertTrue(list.find("sample2"));
        assertTrue(list.find("sample1"));
        list.insertFirst("sample3");
        assertTrue(list.find("sample3"));
        assertTrue(list.find("sample2"));
        assertTrue(list.find("sample1"));
        assertEquals("{sample3, sample2, sample1}", list.printList());
        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemoveIndex() throws Exception {
        list = new SinglyList<>();
        list.insertFirst("sample data here");
        assertEquals("{sample data here}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{}", list.printList());
        assertTrue(list.isEmpty());
        assertEquals(list.getSize(), 0);
    }

    @Test
    public void testInsertLast() throws Exception {
        list = new SinglyList<>();
        list.insertLast("sample data here");
        assertTrue(list.getFirst() != null);
        assertEquals("{sample data here}", list.printList());
    }

    @Test
    public void testMultipleInsertFirst() throws Exception{
        list = new SinglyList<>();
        list.insertFirst("sample1");
        assertEquals("{sample1}", list.printList());
        list.insertFirst("sample2");
        assertEquals("{sample2, sample1}", list.printList());
        list.insertFirst("sample3");
        assertEquals("{sample3, sample2, sample1}", list.printList());
        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testMultipleInsertLast() throws Exception{
        list = new SinglyList<>();
        list.insertLast("sample1");
        assertEquals("{sample1}", list.printList());
        list.insertLast("sample2");
        assertEquals("{sample1, sample2}", list.printList());
        list.insertLast("sample3");
        assertEquals("{sample1, sample2, sample3}", list.printList());
        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testGet() throws Exception{
        list = new SinglyList<>();
        list.insertFirst("sample1");
        assertEquals(list.get(0), "sample1");
        list.insertFirst("sample2");
        assertEquals(list.get(0), "sample2");
        assertEquals(list.get(1), "sample1");
        list.insertFirst("sample3");
        assertEquals(list.get(0), "sample3");
        assertEquals(list.get(1), "sample2");
        assertEquals(list.get(2), "sample1");
    }

    @Test
    public void testGetFirst() throws Exception{
        list = new SinglyList<>();
        list.insertFirst("sample1");
        assertEquals(list.getFirst(), "sample1");
        list.insertFirst("sample2");
        assertEquals(list.getFirst(), "sample2");
        assertNotEquals(list.getFirst(), "sample1");
        list.insertFirst("sample3");
        assertEquals(list.getFirst(), "sample3");
        assertNotEquals(list.getFirst(), "sample2");
    }

    @Test
    public void testGetLast() throws Exception{
        list = new SinglyList<>();
        list.insertLast("sample1");
        assertEquals(list.getLast(), "sample1");

        list.insertLast("sample2");
        assertEquals("{sample1, sample2}", list.printList());
        assertEquals(list.getLast(), "sample2");
        assertNotEquals(list.getLast(), "sample1");

        list.insertLast("sample3");
        assertEquals(list.getLast(), "sample3");
        assertNotEquals(list.getLast(), "sample2");
    }

    @Test
    public void testMultipleRemoveIndex() throws Exception {
        list = new SinglyList<>();
        list.insertLast("sample1");
        list.insertLast("sample2");
        list.insertLast("sample3");
        list.insertLast("sample4");
        list.insertLast("sample5");
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertEquals(list.getSize(), 5);
        assertFalse(list.isEmpty());
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
        assertEquals(list.getSize(), 0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testMultipleRemoveData() throws Exception {
        list = new SinglyList<>();
        list.insertLast("sample1");
        list.insertLast("sample2");
        list.insertLast("sample3");
        list.insertLast("sample4");
        list.insertLast("sample5");
        assertEquals("{sample1, sample2, sample3, sample4, sample5}", list.printList());
        assertEquals(list.getSize(), 5);
        assertFalse(list.isEmpty());
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
        assertEquals(list.getSize(), 0);
        assertTrue(list.isEmpty());
    }

}

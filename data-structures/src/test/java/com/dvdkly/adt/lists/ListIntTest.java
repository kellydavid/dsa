package com.dvdkly.adt.lists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ListIntTest {

    private List<Integer> list;

    public ListIntTest(List list){
        this.list = list;
    }

    @Parameters(name= "{index}: list implementation({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[] {new SinglyList<Integer>()}, new Object[] {new DoublyList<Integer>()});
    }

    @Test
    public void testListCreation() throws Exception {
        list.clear();
        assertTrue(list.getFirst() == null);
    }

    @Test
    public void testInsertFirst() throws Exception {
        list.clear();
        list.insertFirst(23);
        assertTrue(list.getFirst() != null);
        assertEquals("{23}", list.printList());
    }

    @Test
    public void testRemoveData() throws Exception {
        list.clear();
        list.insertFirst(23);
        assertEquals("{23}", list.printList());
        assertTrue(list.remove(new Integer(23)));
        assertEquals("{}", list.printList());
    }

    @Test
    public void testIsEmpty() throws Exception {
        list.clear();
        assertTrue(list.isEmpty());
        list.insertFirst(3);
        list.remove(new Integer(3));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetSize() throws Exception {
        list.clear();
        assertEquals(list.getSize(), 0);
        list.insertFirst(3);
        assertEquals(list.getSize(), 1);
        list.insertFirst(5);
        assertEquals(list.getSize(), 2);
        list.remove(new Integer(3));
        assertEquals(list.getSize(), 1);
        list.remove(new Integer(5));
        assertEquals(list.getSize(), 0);
    }

    @Test
    public void testFind() throws Exception{
        list.clear();
        list.insertFirst(1);
        assertTrue(list.find(1));
        list.insertFirst(2);
        assertTrue(list.find(2));
        assertTrue(list.find(1));
        list.insertFirst(3);
        assertTrue(list.find(3));
        assertTrue(list.find(2));
        assertTrue(list.find(1));
        assertEquals("{3, 2, 1}", list.printList());
        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemoveIndex() throws Exception {
        list.clear();
        list.insertFirst(23);
        assertEquals("{23}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{}", list.printList());
        assertTrue(list.isEmpty());
        assertEquals(list.getSize(), 0);
    }

    @Test
    public void testInsertLast() throws Exception {
        list.clear();
        list.insertLast(23);
        assertTrue(list.getFirst() != null);
        assertEquals("{23}", list.printList());
    }

    @Test
    public void testMultipleInsertFirst() throws Exception{
        list.clear();
        list.insertFirst(1);
        assertEquals("{1}", list.printList());
        list.insertFirst(2);
        assertEquals("{2, 1}", list.printList());
        list.insertFirst(3);
        assertEquals("{3, 2, 1}", list.printList());
        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testMultipleInsertLast() throws Exception{
        list.clear();
        list.insertLast(1);
        assertEquals("{1}", list.printList());
        list.insertLast(2);
        assertEquals("{1, 2}", list.printList());
        list.insertLast(3);
        assertEquals("{1, 2, 3}", list.printList());
        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testGet() throws Exception{
        list.clear();
        list.insertFirst(1);
        assertEquals(list.get(0).intValue(), 1);
        list.insertFirst(2);
        assertEquals(list.get(0).intValue(), 2);
        assertEquals(list.get(1).intValue(), 1);
        list.insertFirst(3);
        assertEquals(list.get(0).intValue(), 3);
        assertEquals(list.get(1).intValue(), 2);
        assertEquals(list.get(2).intValue(), 1);
    }

    @Test
    public void testGetFirst() throws Exception{
        list.clear();
        list.insertFirst(1);
        assertEquals(list.getFirst().intValue(), 1);
        list.insertFirst(2);
        assertEquals(list.getFirst().intValue(), 2);
        assertNotEquals(list.getFirst().intValue(), 1);
        list.insertFirst(3);
        assertEquals(list.getFirst().intValue(), 3);
        assertNotEquals(list.getFirst().intValue(), 2);
    }

    @Test
    public void testGetLast() throws Exception{
        list.clear();
        list.insertLast(1);
        assertEquals(list.getLast().intValue(), 1);
        list.insertLast(2);
        assertEquals("{1, 2}", list.printList());
        assertEquals(list.getLast().intValue(), 2);
        assertNotEquals(list.getLast().intValue(), 1);
        list.insertLast(3);
        assertEquals(list.getLast().intValue(), 3);
        assertNotEquals(list.getLast().intValue(), 2);
    }

    @Test
    public void testMultipleRemoveIndex() throws Exception {
        list.clear();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        assertEquals("{1, 2, 3, 4, 5}", list.printList());
        assertEquals(list.getSize(), 5);
        assertFalse(list.isEmpty());
        assertFalse(list.remove(70));
        assertEquals("{1, 2, 3, 4, 5}", list.printList());
        assertFalse(list.remove(-5));
        assertEquals("{1, 2, 3, 4, 5}", list.printList());
        assertTrue(list.remove(3));
        assertEquals("{1, 2, 3, 5}", list.printList());
        assertTrue(list.remove(3));
        assertEquals("{1, 2, 3}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{2, 3}", list.printList());
        assertTrue(list.remove(1));
        assertEquals("{2}", list.printList());
        assertTrue(list.remove(0));
        assertEquals("{}", list.printList());
        assertFalse(list.remove(0));
        assertEquals("{}", list.printList());
        assertEquals(list.getSize(), 0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testMultipleRemoveData() throws Exception {
        list.clear();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        assertEquals("{1, 2, 3, 4, 5}", list.printList());
        assertEquals(list.getSize(), 5);
        assertFalse(list.isEmpty());
        assertFalse(list.remove(new Integer(45)));
        assertEquals("{1, 2, 3, 4, 5}", list.printList());
        assertTrue(list.remove(new Integer(4)));
        assertEquals("{1, 2, 3, 5}", list.printList());
        assertTrue(list.remove(new Integer(5)));
        assertEquals("{1, 2, 3}", list.printList());
        assertTrue(list.remove(new Integer(1)));
        assertEquals("{2, 3}", list.printList());
        assertTrue(list.remove(new Integer(3)));
        assertEquals("{2}", list.printList());
        assertTrue(list.remove(new Integer(2)));
        assertEquals("{}", list.printList());
        assertFalse(list.remove(new Integer(45)));
        assertEquals("{}", list.printList());
        assertEquals(list.getSize(), 0);
        assertTrue(list.isEmpty());
    }

}

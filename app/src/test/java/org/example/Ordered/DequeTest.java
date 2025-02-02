package org.example.Ordered;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DequeTest {

    @Test
    public void insertIncreasesSize() {
        Deque deque = new Deque();
        deque.insert(10);
        assertEquals(deque.getSize(), 1);
    }

    @Test
    public void extractMinDecreasesSize() {
        Deque deque = new Deque();
        deque.insert(10);
        deque.extractMin();
        assertEquals(deque.getSize(), 0);
    }

    @Test
    public void extractMaxDecreasesSize() {
        Deque deque = new Deque();
        deque.insert(10);
        deque.extractMax();
        assertEquals(deque.getSize(), 0);
    }

    @Test
    public void getMinReturnsCorrectElement() {
        Deque deque = new Deque();
        deque.insert(10);
        deque.insert(20);
        assertEquals(deque.getMin(), 10);
    }

    @Test
    public void getMaxReturnsCorrectElement() {
        Deque deque = new Deque();
        deque.insert(10);
        deque.insert(20);
        assertEquals(deque.getMax(), 20);
    }

    @Test
    public void isEmptyReturnsTrueForEmptyDeque() {
        Deque deque = new Deque();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseForNonEmptyDeque() {
        Deque deque = new Deque();
        deque.insert(10);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void emptyClearsTheDeque() {
        Deque deque = new Deque();
        deque.insert(10);
        deque.insert(20);
        deque.empty();
        assertTrue(deque.isEmpty());
        assertEquals(deque.getSize(), 0);
    }

    @Test(expectedExceptions = IllegalStateException.class, expectedExceptionsMessageRegExp = "UnderFlow")
    public void extractMinFromEmptyDeque() {
        Deque deque = new Deque();
        deque.extractMin();
    }

    @Test(expectedExceptions = IllegalStateException.class, expectedExceptionsMessageRegExp = "UnderFlow")
    public void extractMaxFromEmptyDeque() {
        Deque deque = new Deque();
        deque.extractMax();
    }

    @Test
    public void getMinFromEmptyDeque() {
        Deque deque = new Deque();
        assertEquals(deque.getMin(), -1);
    }

    @Test
    public void getMaxFromEmptyDeque() {
        Deque deque = new Deque();
        assertEquals(deque.getMax(), -1);
    }
}
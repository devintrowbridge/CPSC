import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedSetTest {
    @org.junit.jupiter.api.Test
    void addReverse() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        assertTrue(actual.add(3));
        assertTrue(actual.add(2));
        assertTrue(actual.add(1));

        Set<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void addForward() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        assertTrue(actual.add(1));
        assertTrue(actual.add(2));
        assertTrue(actual.add(3));

        Set<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void addRandom() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        assertTrue(actual.add(2));
        assertTrue(actual.add(3));
        assertTrue(actual.add(1));

        Set<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void addBad() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        assertTrue(actual.add(2));
        assertTrue(actual.add(3));
        assertTrue(actual.add(1));
        assertFalse(actual.add(1));

        Set<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void addNone() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        assertNull(actual.front);
        assertNull(actual.rear);
        assertEquals(0, actual.size);
    }

    @org.junit.jupiter.api.Test
    void alot() {
        LinkedSet<Integer> actual = new LinkedSet<>();

        for (int i = 0; i <= 100; ++i){
            assertTrue(actual.add(i));
        }

        for (int i = 0; i <= 100; ++i){
            assertTrue(actual.contains(i));
        }

        for (int i = 0; i <= 100; ++i){
            assertFalse(actual.add(i));
        }

        for (int i = 0; i <= 100; ++i){
            assertTrue(actual.remove(i));
        }
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);
        assertTrue(actual.remove(1));

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void removeMid() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);
        assertTrue(actual.remove(2));

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);
        actual.remove(3);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void removeFalse() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);
        assertFalse(actual.remove(4));

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);
        assertTrue(actual.contains(2));
        assertFalse(actual.contains(4));
    }

    @org.junit.jupiter.api.Test
    void testEqualsLinked() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
        expected.add(4);
        assertFalse(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void testEqualsSet() {
        LinkedSet<Integer> actual = new LinkedSet<>();
        actual.add(2);
        actual.add(3);
        actual.add(1);

        Set<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
        expected.add(4);
        assertFalse(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void unionLinked() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);

        LinkedSet<Integer> set2 = new LinkedSet<>();
        set2.add(2);
        set2.add(3);

        Set<Integer> actual = set1.union(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void unionLinkedNull() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        LinkedSet<Integer> set2 = new LinkedSet<>();

        Set<Integer> actual = set1.union(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void untionSetOutOfOrder() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        LinkedSet<Integer> set2 = new LinkedSet<>();
        set2.add(6);
        set2.add(4);
        set2.add(5);

        Set<Integer> actual = set1.union(set2);
        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void unionSet() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);

        Set<Integer> set2 = new LinkedSet<>();
        set2.add(2);
        set2.add(3);

        Set<Integer> actual = set1.union(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void intersectionLinked() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);

        LinkedSet<Integer> set2 = new LinkedSet<>();
        set2.add(2);
        set2.add(3);

        Set<Integer> actual = set1.intersection(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(2);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void intersectionSet() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);

        Set<Integer> set2 = new LinkedSet<>();
        set2.add(2);
        set2.add(3);

        Set<Integer> actual = set1.intersection(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(2);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void complementLinked() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);

        LinkedSet<Integer> set2 = new LinkedSet<>();
        set2.add(2);
        set2.add(3);

        Set<Integer> actual = set1.complement(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void complementLinkedSet() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        LinkedSet<Integer> set2 = new LinkedSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);

        Set<Integer> actual = set1.complement(set2);
        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void complementSet() {
        LinkedSet<Integer> set1 = new LinkedSet<>();
        set1.add(1);
        set1.add(2);

        Set<Integer> set2 = new LinkedSet<>();
        set2.add(2);
        set2.add(3);

        Set<Integer> actual = set1.complement(set2);

        LinkedSet<Integer> expected = new LinkedSet<>();
        expected.add(1);

        assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void iteratorNormal() {
        LinkedSet<Integer> set = new LinkedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> it = set.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());

        boolean caught = false;
        try {
            it.next();
        } catch (NoSuchElementException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @org.junit.jupiter.api.Test
    void iteratorNullSet() {
        LinkedSet<Integer> set = new LinkedSet<>();
        Iterator<Integer> it = set.iterator();
        assertFalse(it.hasNext());

        boolean caught = false;
        try {
            it.next();
        } catch (NoSuchElementException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @org.junit.jupiter.api.Test
    void descendingIterator() {
        LinkedSet<Integer> set = new LinkedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> it = set.descendingIterator();
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertEquals(1, it.next());

        boolean caught = false;
        try {
            it.next();
        } catch (NoSuchElementException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @org.junit.jupiter.api.Test
    void powerSetIterator() {
        LinkedSet<Integer> set = new LinkedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        Iterator<Set<Integer>> it = set.powerSetIterator();
        for (int i = 0; i < 32; ++i) {
            assertTrue(it.hasNext());
            it.next();
        }

        boolean caught = false;
        try {
            it.next();
        } catch (NoSuchElementException e) {
            caught = true;
        }
        assertTrue(caught);
    }
}
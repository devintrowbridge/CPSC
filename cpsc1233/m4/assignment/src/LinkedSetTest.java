import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedSetTest {

    @org.junit.jupiter.api.Test
    void add() {
        LinkedSet<Integer> actual = new LinkedSet<Integer>();
        actual.add(3);
        actual.add(2);
        actual.add(1);
        assertEquals(1, actual.front.element);
        assertEquals(3, actual.size);
        assertEquals(3, actual.rear.element);
        assertEquals(2, actual.front.next.element);
        assertEquals(2, actual.rear.prev.element);
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void testEquals1() {
    }

    @org.junit.jupiter.api.Test
    void union() {
    }

    @org.junit.jupiter.api.Test
    void testUnion() {
    }

    @org.junit.jupiter.api.Test
    void intersection() {
    }

    @org.junit.jupiter.api.Test
    void testIntersection() {
    }

    @org.junit.jupiter.api.Test
    void complement() {
    }

    @org.junit.jupiter.api.Test
    void testComplement() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        LinkedSet<Integer> set = new LinkedSet<Integer>();
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
        } catch (Exception e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @org.junit.jupiter.api.Test
    void descendingIterator() {
    }

    @org.junit.jupiter.api.Test
    void powerSetIterator() {
    }
}
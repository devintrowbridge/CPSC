import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectorTest {

    static Comparator<Integer> ascendingInteger =
            new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return i1.compareTo(i2);
                }
            };

    @org.junit.jupiter.api.Test
    void minTest() {
        List<Integer> a = new ArrayList<Integer>(List.of(2, 4, 6, 8, 10));
        int expected = 2;
        int actual = Selector.min(a, ascendingInteger);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void maxTest() {
        List<Integer> a = new ArrayList<Integer>(List.of(2, 4, 6, 8, 10));
        int expected = 10;
        int actual = Selector.max(a, ascendingInteger);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void kminTest1() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4)); // 2,3,4,7,8
        int k = 3;
        int expected = 4;
        int actual = Selector.kmin(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest2() {
        List<Integer> a = new ArrayList<Integer>(List.of(7));
        int k = 1;
        int expected = 7;
        int actual = Selector.kmin(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest3() {
        List<Integer> a = new ArrayList<Integer>(List.of(4,4));
        int k = 1;
        int expected = 4;
        int actual = Selector.kmin(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest4() {
        List<Integer> a = new ArrayList<Integer>(List.of(1,3,5,7,9));
        int k = 5;
        int expected = 9;
        int actual = Selector.kmin(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest5() {
        List<Integer> a = new ArrayList<Integer>(List.of(-4,-4));
        int k = 2;
        boolean caught = false;
        try {
             Selector.kmin(a, k, ascendingInteger);
        } catch (NoSuchElementException e) {
            caught = true;
        }
        assertTrue(caught);
    }
    @org.junit.jupiter.api.Test
    void kminTest6() {
        List<Integer> a = new ArrayList<Integer>(List.of(3,7,3,3,1,9,1,1,1,5));
        int k = 5;
        int expected = 9;
        int actual = Selector.kmin(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void kmaxTest1() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4)); // {2,3,4,7,8}
        int k = 3;
        int expected = 4;
        int actual = Selector.kmax(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest2() {
        List<Integer> a = new ArrayList<Integer>(List.of(7));
        int k = 1;
        int expected = 7;
        int actual = Selector.kmax(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest3() {
        List<Integer> a = new ArrayList<Integer>(List.of(5,7));
        int k = 1;
        int expected = 7;
        int actual = Selector.kmax(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest4() {
        List<Integer> a = new ArrayList<Integer>(List.of(1,3,5,7,9));
        int k = 4;
        int expected = 3;
        int actual = Selector.kmax(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest5() {
        List<Integer> a = new ArrayList<Integer>(List.of(-4,-4));
        int k = 2;
        boolean caught = false;
        try {
            Selector.kmax(a, k, ascendingInteger);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest6() {
        List<Integer> a = new ArrayList<Integer>(List.of(3,7,3,3,1,9,1,1,1,5)); // {1,3,5,7,9}
        int k = 5;
        int expected = 1;
        int actual = Selector.kmax(a, k, ascendingInteger);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void rangeTest() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
        Integer low = 3;
        Integer high = 7;
        Collection<Integer> expected = new ArrayList<Integer>(List.of(7,3,3,4));
        Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void rangeTest1() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
        Integer low = 7;
        Integer high = 3;
        boolean actual = false;
        try {
            Selector.range(a, low, high, ascendingInteger);
        }
        catch (NoSuchElementException e) {
            actual = true;
        }
        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void rangeTest2() {
        List<Integer> a = new ArrayList<Integer>(List.of(1,9,7,5,3));
        Integer low = 0;
        Integer high = 0;
        boolean actual = false;
        try {
            Selector.range(a, low, high, ascendingInteger);
        }
        catch (NoSuchElementException e) {
            actual = true;
        }
        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void ceilingTest1() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a, key, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void ceilingTest2() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a, key, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void ceilingTest3() {
        List<Integer> a = new ArrayList<Integer>(List.of(7));
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a, key, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void ceilingTest4() {
        List<Integer> a = new ArrayList<Integer>(List.of(9,7));
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a, key, ascendingInteger);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void floorTest1() {
        List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
        int key = 5;
        int expected = 4;
        int actual = Selector.floor(a, key, ascendingInteger);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void floorTest2() {
        List<Integer> a = new ArrayList<Integer>(List.of(-3, 3,9,7,0));
        int key = -3;
        int expected = -3;
        int actual = Selector.floor(a, key, ascendingInteger);
        assertEquals(expected, actual);
    }

}
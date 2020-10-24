import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectorTest {

    @org.junit.jupiter.api.Test
    void minTest() {
        int[] a = {2, 4, 6, 8, 10};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void maxTest() {
        int[] a = {2, 4, 6, 8, 10};
        int expected = 10;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void kminTest1() {
        int[] a = {8, 2, 8, 7, 3, 3, 4}; // 2,3,4,7,8
        int k = 3;
        int expected = 4;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest2() {
        int[] a = {7};
        int k = 1;
        int expected = 7;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest3() {
        int[] a = {4,4};
        int k = 1;
        int expected = 4;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest4() {
        int[] a = {1,3,5,7,9};
        int k = 5;
        int expected = 9;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kminTest5() {
        int[] a = {-4,-4};
        int k = 2;
        boolean caught = false;
        try {
             Selector.kmin(a, k);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
    @org.junit.jupiter.api.Test
    void kminTest6() {
        int[] a = {3,7,3,3,1,9,1,1,1,5};
        int k = 5;
        int expected = 9;
        int actual = Selector.kmin(a,k);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void kmaxTest1() {
        int[] a = {8, 2, 8, 7, 3, 3, 4}; // {2,3,4,7,8}
        int k = 3;
        int expected = 4;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest2() {
        int[] a = {7};
        int k = 1;
        int expected = 7;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest3() {
        int[] a = {5,7};
        int k = 1;
        int expected = 7;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest4() {
        int[] a = {1,3,5,7,9};
        int k = 4;
        int expected = 3;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest5() {
        int[] a = {-4,-4};
        int k = 2;
        boolean caught = false;
        try {
            Selector.kmax(a, k);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
    @org.junit.jupiter.api.Test
    void kmaxTest6() {
        int[] a = {3,7,3,3,1,9,1,1,1,5}; // {1,3,5,7,9}
        int k = 5;
        int expected = 1;
        int actual = Selector.kmax(a,k);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void rangeTest() {
        int[] a = {8, 2, 8, 7, 3, 3, 4};
        int low = 3;
        int high = 7;
        int[] expected = {7,3,3,4};
        int[] actual = Selector.range(a,low,high);
        assertTrue(Arrays.equals(expected,actual));
    }

    @org.junit.jupiter.api.Test
    void ceilingTest1() {
        int[] a = {8, 2, 8, 7, 3, 3, 4};
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void ceilingTest2() {
        int[] a = {8, 2, 8, 7, 3, 3, 4};
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void ceilingTest3() {
        int[] a = {7};
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void ceilingTest4() {
        int[] a = {9,7};
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a,key);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void floorTest1() {
        int[] a = {8, 2, 8, 7, 3, 3, 4};
        int key = 5;
        int expected = 4;
        int actual = Selector.floor(a,key);
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void floorTest2() {
        int[] a = {-3, 3,9,7,0};
        int key = -3;
        int expected = -3;
        int actual = Selector.floor(a,key);
        assertEquals(expected, actual);
    }

}
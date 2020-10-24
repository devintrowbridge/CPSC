import org.junit.Test;

import static org.junit.Assert.*;

public class MinOfThreeTest {
    // MIN1 TESTS
    /** Test case for the search method. */
    @Test
    public void min1Test1() {
        int[] a = {0,1,2};
        int expected = 0;
        int actual = MinOfThree.min1(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void min1Test2() {
        int[] a = {2,0,1};
        int expected = 0;
        int actual = MinOfThree.min1(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void min1Test3() {
        int[] a = {1,2,0};
        int expected = 0;
        int actual = MinOfThree.min1(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void min1Test4() {
        int[] a = {0,0,1};
        int expected = 0;
        int actual = MinOfThree.min1(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    // MIN2 TESTS
    /** Test case for the search method. */
    @Test
    public void min2Test1() {
        int[] a = {0,1,2};
        int expected = 0;
        int actual = MinOfThree.min2(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void min2Test2() {
        int[] a = {2,0,1};
        int expected = 0;
        int actual = MinOfThree.min2(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void min2Test3() {
        int[] a = {1,2,0};
        int expected = 0;
        int actual = MinOfThree.min2(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void min2Test4() {
        int[] a = {0,0,1};
        int expected = 0;
        int actual = MinOfThree.min2(a[0], a[1], a[2]);
        assertEquals(expected, actual);
    }
}
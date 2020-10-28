package recursion;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumTest {

    @org.junit.jupiter.api.Test
    void sumTest1() {
        int[] array = {0};
        int actual = ArraySum.sum(array, 0,array.length - 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumTest2() {
        int[] array = {2,1,5,3,4};
        int actual = ArraySum.sum(array, 0,array.length - 1);
        int expected = 15;
        assertEquals(expected, actual);
    }
}
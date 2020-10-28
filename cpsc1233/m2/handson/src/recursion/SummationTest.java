package recursion;

import static org.junit.jupiter.api.Assertions.*;

class SummationTest {
    @org.junit.jupiter.api.Test
    void sumRTest1() {
        int expected = 0;
        int actual = Summation.sumR(0);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumRTest2() {
        int expected = 15;
        int actual = Summation.sumR(5);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumRTest3() {
        int expected = 1;
        int actual = Summation.sumR(1);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumRTest4() {
        int expected = 55;
        int actual = Summation.sumR(10);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumATest1() {
        int[] a = {};
        int expected = -1;
        int actual = Summation.sumA(a, 0 , 0);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumATest2() {
        int[] a = {2,3,1,4,5};
        int expected = 15;
        int actual = Summation.sumA(a, 0 , a.length-1);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumATest3() {
        int[] a = {1};
        int expected = 1;
        int actual = Summation.sumA(a, 0 , a.length-1);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumATest4() {
        int[] a = {1,5,8,2,7,9,10,3,6,4};
        int expected = 55;
        int actual = Summation.sumA(a, 0 , a.length-1);
        assertEquals(expected, actual);
    }
}
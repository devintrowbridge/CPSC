import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermTest {

    @Test
    void byDescendingWeightOrder() {
    }

    @Test
    void byPrefixOrder() {
        Term t1 = new Term("queryA", 1);
        Term t2 = new Term("queryB", 0);
        int expected = 0;
        int actual = Term.byPrefixOrder(1).compare(t1, t2);
        assertEquals(expected, actual);
    }

    @Test
    void compareTo() {
    }
}
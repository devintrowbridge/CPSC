import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AutocompleteTest {

    @Test
    void allMatches() {
        Term[] arr = {new Term("a", 1),
                      new Term("b", 2),
                      new Term("ac", 3),
                      new Term("d", 4),
                      new Term("ae", 5),
                      new Term("af", 6),
                      new Term("g", 7),
                      new Term("h", 8),
                      new Term("", 9)};
        Autocomplete ac = new Autocomplete(arr);
        String prefix = "a";

        Term[] expected = {new Term("af", 6),
                           new Term("ae", 5),
                           new Term("ac", 3),
                           new Term("a", 1)};
        Term[] actual = ac.allMatches(prefix);
        assertEquals(expected[0].m_weight, actual[0].m_weight);
        assertEquals(expected[0].m_query,  actual[0].m_query);
        assertEquals(expected[1].m_weight, actual[1].m_weight);
        assertEquals(expected[1].m_query,  actual[1].m_query);
        assertEquals(expected[2].m_weight, actual[2].m_weight);
        assertEquals(expected[2].m_query,  actual[2].m_query);
        assertEquals(expected[3].m_weight, actual[3].m_weight);
        assertEquals(expected[3].m_query,  actual[3].m_query);
    }
}
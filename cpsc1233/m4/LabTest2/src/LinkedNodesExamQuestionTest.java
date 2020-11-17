import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedNodesExamQuestionTest {

    @Test
    void maxTest() {
        LinkedNodesExamQuestion.SinglyLinked<Integer> sl = new LinkedNodesExamQuestion.SinglyLinked<Integer>();

        sl.add(10);
        sl.add(12);
        sl.add(8);
        sl.add(2);
        sl.add(6);
        sl.add(4);

        Integer expected = 12;
        Integer actual = sl.max();

        assertEquals(expected, actual);
    }
}
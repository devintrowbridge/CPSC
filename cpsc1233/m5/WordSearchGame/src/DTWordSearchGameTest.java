import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.*;

class DTWordSearchGameTest {
    @org.junit.jupiter.api.Test
    void isOnBoard1() {
        WordSearchGame game = WordSearchGameFactory.createGame();
        game.loadLexicon("wordfiles/words.txt");
        game.setBoard(new String[]{"TIGER"});

        assertFalse(game.isOnBoard("TIGER").isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isOnBoard2() {
        WordSearchGame game = WordSearchGameFactory.createGame();
        game.loadLexicon("wordfiles/words.txt");
        game.setBoard(new String[]{"CAT","X","FISH","XXXX"});

        assertFalse(game.isOnBoard("CATFISH").isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isOnBoard3() {
        WordSearchGame game = WordSearchGameFactory.createGame();
        game.loadLexicon("wordfiles/words_medium.txt");
        game.setBoard(new String[]{"P","R","D","E","O","T","L","J","E","I","E","A","C","O","R","N"});

        SortedSet<String> list = game.getAllValidWords(3);
        assertTrue(list.contains("PROTEAN"));
    }

    @org.junit.jupiter.api.Test
    void prefix1() {
        WordSearchGame game = WordSearchGameFactory.createGame();
        game.loadLexicon("wordfiles/words_medium.txt");

        assertFalse(game.isValidPrefix("XXX"));
    }
}
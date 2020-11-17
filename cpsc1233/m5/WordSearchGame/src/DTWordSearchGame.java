import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class DTWordSearchGame implements WordSearchGame{
    private boolean isLexLoaded = false;
    private TreeSet<String> lexicon = new TreeSet<>();

    @Override
    /**
     * Loads the lexicon into a data structure for later use.
     *
     * @param fileName A string containing the name of the file to be opened.
     * @throws IllegalArgumentException if fileName is null
     * @throws IllegalArgumentException if fileName cannot be opened.
     */
    public void loadLexicon(String fileName) {
        if (fileName == null) throw new IllegalArgumentException();
        File file = new File(fileName);

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                lexicon.add(sc.next().toUpperCase());
            }

            isLexLoaded = true;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    /**
     * Stores the incoming array of Strings in a data structure that will make
     * it convenient to find words.
     *
     * @param letterArray This array of length N^2 stores the contents of the
     *     game board in row-major order. Thus, index 0 stores the contents of board
     *     position (0,0) and index length-1 stores the contents of board position
     *     (N-1,N-1). Note that the board must be square and that the strings inside
     *     may be longer than one character.
     * @throws IllegalArgumentException if letterArray is null, or is  not
     *     square.
     */
    public void setBoard(String[] letterArray) {
        if (letterArray == null) throw new IllegalArgumentException();
        if (!isPerfectSquare(letterArray.length)) throw new IllegalArgumentException();

    }

    @Override
    /**
     * Creates a String representation of the board, suitable for printing to
     *   standard out. Note that this method can always be called since
     *   implementing classes should have a default board.
     */
    public String getBoard() {
        return null;
    }

    @Override
    /**
     * Retrieves all valid words on the game board, according to the stated game
     * rules.
     *
     * @param minimumWordLength The minimum allowed length (i.e., number of
     *     characters) for any word found on the board.
     * @return java.util.SortedSet which contains all the words of minimum length
     *     found on the game board and in the lexicon.
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public SortedSet<String> getAllValidWords(int minimumWordLength) {
        if (minimumWordLength < 1) throw new IllegalArgumentException();
        if (!isLexLoaded) throw new IllegalStateException();
        return null;
    }

    @Override
    /**
     * Computes the cummulative score for the scorable words in the given set.
     * To be scorable, a word must (1) have at least the minimum number of characters,
     * (2) be in the lexicon, and (3) be on the board. Each scorable word is
     * awarded one point for the minimum number of characters, and one point for
     * each character beyond the minimum number.
     *
     * @param words The set of words that are to be scored.
     * @param minimumWordLength The minimum number of characters required per word
     * @return the cummulative score of all scorable words in the set
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
        if (minimumWordLength < 1) throw new IllegalArgumentException();
        if (!isLexLoaded) throw new IllegalStateException();
        return 0;
    }

    @Override
    /**
     * Determines if the given word is in the lexicon.
     *
     * @param wordToCheck The word to validate
     * @return true if wordToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public boolean isValidWord(String wordToCheck) {
        if (wordToCheck == null) throw new IllegalArgumentException();
        if (!isLexLoaded) throw new IllegalStateException();
        return false;
    }

    @Override
    /**
     * Determines if there is at least one word in the lexicon with the
     * given prefix.
     *
     * @param prefixToCheck The prefix to validate
     * @return true if prefixToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if prefixToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public boolean isValidPrefix(String prefixToCheck) {
        if (prefixToCheck == null) throw new IllegalArgumentException();
        if (!isLexLoaded) throw new IllegalStateException();
        return false;
    }

    @Override
    /**
     * Determines if the given word is in on the game board. If so, it returns
     * the path that makes up the word.
     * @param wordToCheck The word to validate
     * @return java.util.List containing java.lang.Integer objects with  the path
     *     that makes up the word on the game board. If word is not on the game
     *     board, return an empty list. Positions on the board are numbered from zero
     *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
     *     board, the upper left position is numbered 0 and the lower right position
     *     is numbered N^2 - 1.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public List<Integer> isOnBoard(String wordToCheck) {
        if (wordToCheck == null) throw new IllegalArgumentException();
        if (!isLexLoaded) throw new IllegalStateException();
        return null;
    }

    private boolean isPerfectSquare(double x) {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }
}

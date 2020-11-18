import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Provides an implementation of the word search game, Boggle.
 *
 * @author Devin Trowbridge (dkt0003@auburn.edu)
 * @version 20201117
 */
public class DktWordSearchGame implements WordSearchGame {
   // Flag for if a lexicon has been loaded
   private boolean isLexLoaded = false;

   // Lexicon storing valid words
   private final TreeSet<String> lexicon = new TreeSet<>();

   // 2d area to search
   private String[][] board;

   // visited positions in the search area
   private boolean[][] visited;

   // dimensions of the search area
   private int width;

   DktWordSearchGame(){
       setBoard(new String[]{"E", "E", "C", "A",
                             "A", "L", "E", "P",
                             "H", "N", "B", "O",
                             "Q", "T", "T", "Y"});
   }

   @Override
   public void loadLexicon(String fileName) {
       if (fileName == null) throw new IllegalArgumentException();
       File file = new File(fileName);
       try {
           Scanner sc = new Scanner(file);
           lexicon.clear();
           isLexLoaded = false;
           while (sc.hasNext()){
               lexicon.add(sc.next().toUpperCase());
           }
           isLexLoaded = !lexicon.isEmpty();
       } catch (Exception e) {
           throw new IllegalArgumentException();
       }
   }

   @Override
   public void setBoard(String[] letterArray) {
       if (letterArray == null) throw new IllegalArgumentException();
       // Check for perfect square
       double wide = Math.sqrt(letterArray.length);
       if ((wide - Math.round(wide)) > 0.000001) throw new IllegalArgumentException();
       width = (int) Math.round(wide);
       board = new String[width][width];
       visited = new boolean[width][width];
       for (int i = 0; i < letterArray.length; ++i) {
           board[i / width][i % width] = letterArray[i];
       }
       clearVisits();
   }

   @Override
   public String getBoard() {
       StringBuilder rtn_str = new StringBuilder();
       int fieldWidth = 4;
       for (String[] row : board) {
           for (String entry : row) {
               rtn_str.append(String.format("%" + fieldWidth + "s", entry));
           }
           rtn_str.append("\n");
       }
       return rtn_str.toString();
   }

   @Override
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
       if (minimumWordLength < 1) throw new IllegalArgumentException();
       if (!isLexLoaded) throw new IllegalStateException();
       SortedSet<String> validWords = new TreeSet<>();
       for (String word : lexicon) {
          if (word.length() >= minimumWordLength) {
             if (isOnBoard(word).size() != 0) validWords.add(word);
             clearVisits();
          }
       }
       return validWords;
   }

   @Override
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
       if (minimumWordLength < 1) throw new IllegalArgumentException();
       if (!isLexLoaded) throw new IllegalStateException();
       int score = 0;
       for (String word : words) {
          score += 1 + (word.length() - minimumWordLength);
       }
       return score;
   }

   @Override
   public boolean isValidWord(String wordToCheck) {
       if (wordToCheck == null) throw new IllegalArgumentException();
       if (!isLexLoaded) throw new IllegalStateException();
       return lexicon.contains(wordToCheck);
   }

   @Override
   public boolean isValidPrefix(String prefixToCheck) {
       if (prefixToCheck == null) throw new IllegalArgumentException();
       if (!isLexLoaded) throw new IllegalStateException();
       String word = lexicon.ceiling(prefixToCheck);
       if (word == null) return false;
       return word.startsWith(prefixToCheck);
   }

   @Override
   public List<Integer> isOnBoard(String wordToCheck) {
      if (wordToCheck == null) throw new IllegalArgumentException();
      if (!isLexLoaded) throw new IllegalStateException();
      List<Integer> rtnList = new ArrayList<>();
      Position pos;

      // Search for the word to check using each position on the board
      // as a starting position
      for (int row = 0; row < width; ++row) {
         for (int col = 0; col < width; ++col) {
            pos = new Position(row, col);
            rtnList = dfsFindWord(pos, wordToCheck);
            clearVisits();
            // The search function guarantees an empty list if
            // the word is not found. Break out of the double loop
            // so we don't waste cycles continuing to search
            if (!rtnList.isEmpty()) break;
         }
         if (!rtnList.isEmpty()) break;
      }
      return rtnList;
   }

   /**
    * Performs a depth first search of the word to check starting from
    * the passed position.
    * @param pos position to center depth first search from
    * @param wordToCheck The word to validate
    * @return The path that makes up the word on the game board. If word is not
    * on the game board, return an empty list.
    */
   private List<Integer> dfsFindWord(Position pos, String wordToCheck) {
       List<Integer> rtnList = new ArrayList<>();

       // If we get to the end of the word, break the recursion
       if (wordToCheck.isEmpty()) return rtnList;

       // Check to make sure the string at the position is the prefix to the
       // word to check
       String posStr = getString(pos);
       if (wordToCheck.startsWith(posStr)) {
           rtnList.add(pos.flatIndex());

           // Generate the next substring to search for
           String subStr = wordToCheck.substring(posStr.length());
           if (subStr.isEmpty()) return rtnList;

           // For each of this position's neighbors,
           // try to search for the rest of the word recursively
           visit(pos);
           for (Position neighbor : pos.neighbors()) {
               // Only check positions that have not been consumed by the list yet
               if (!isVisited(neighbor)) {
                   // Find the list
                   List<Integer> foundList = dfsFindWord(neighbor, subStr);

                   // If the list we found is the same size as the searched substr
                   // break out of the loop since we found a solution
                   if (!foundList.isEmpty()) {
                       rtnList.addAll(foundList);
                       return rtnList;
                   }
               }
           }

           // If we couldn't find all of the letters return an empty list
           // and unvisit this spot since its still available
           rtnList.clear();
           unvisit(pos);
       }
       return rtnList;
   }

   /**
    * Sets all of the positions in the visited array to false
    */
   private void clearVisits() {
       visited = new boolean[width][width];
       for (boolean[] row : visited) {
           Arrays.fill(row, false);
       }
   }

   /**
    * Helper class to manage position data.
    */
   private class Position {
       int x;
       int y;
       public Position(int x, int y) {
           this.x = x;
           this.y = y;
       }
       @Override
       public String toString() {
           return "<" + x + ", " + y + ">";
       }
       public Integer flatIndex() {
           return x * width + y;
       }
       public Position[] neighbors() {
           // number of neighbors, degrees of motion
           int MAX_NEIGHBORS = 8;
           Position[] neighbors = new Position[MAX_NEIGHBORS];
           int count = 0;
           Position p;
           // Generate neighbors around this point adding to
           // the return array if they're valid
           //
           //  1  2  3
           //  4  p  5
           //  6  7  8
           //
           for (int i = -1; i <=1; ++i) {
               for (int j = -1; j <=1; ++j) {
                   if (!((i == 0) && (j == 0))) {
                       p = new Position(x + i, y + j);
                       if (isValid(p)) neighbors[count++] = p;
                   }
               }
           }
           return Arrays.copyOf(neighbors, count);
       }
   }

   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.x < width) &&
             (p.y >= 0) && (p.y < width);
   }

   private boolean isVisited(Position p) {
      return visited[p.x][p.y];
   }

   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }

   private void unvisit(Position p) {
      visited[p.x][p.y] = false;
   }

   private String getString(Position p) {
      return board[p.x][p.y];
   }
}

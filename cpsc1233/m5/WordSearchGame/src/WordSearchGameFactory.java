
/**
 * Provides a factory method for creating word search games. 
 *
 * @author Devin Trowbridge (dkt0003@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 20201117
 */
public class WordSearchGameFactory {
   /**
    * Returns an instance of a class that implements the WordSearchGame
    * interface.
    */
   public static WordSearchGame createGame() {
      return new DktWordSearchGame();
   }
}

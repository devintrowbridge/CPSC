/** 
 * Class for keeping scores.
 *
 * @author Devin Trowbridge
 * @version 2020-08-30
 */
public class Scores {
   private int[] numbers;
   
   /**
   * Ctor.
   *
   * @param numbersIn Array of scores
   */
   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   }
   
   /**
   * Finds and returns all of the even numbered scores.
   *
   * @return array of oddevennumbered scores
   */
   public int[] findEvens() {
      int numberEvens = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      
      int[] evens = new int[numberEvens];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         } 
      }
      
      return evens;
   }
   
   /**
   * Finds and returns all of the odd numbered scores.
   *
   * @return array of odd numbered scores
   */
   public int[] findOdds() {
      int numberOdds = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 != 0) {
            numberOdds++;
         }
      }
      
      int[] odds = new int[numberOdds];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 != 0) {
            odds[count] = numbers[i];
            count++;
         } 
      }
      
      return odds;
   }
   
   /**
   * Calculates average scores.
   *
   * @return average of scores
   */
   public double calculateAverage() {
      int sum = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
      
      return ((double) sum) /  numbers.length;
   }
   
   /**
   * Creates a string representation of the object.
   *
   * @return string representation of object
   */
   public String toString() {
      String result = "";
      
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      
      return result;
   }
   
   /**
   * Creates a reverse string representation of the object.
   *
   * @return reverse string representation of object
   */
   public String toStringInReverse() {
      String result = "";
      
      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      }
      
      return result;
   }
}
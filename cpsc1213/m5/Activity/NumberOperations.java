 /**
 * Class that performs standard operations on a passed number.
 *
 * Activity 5
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-21
 */
public class NumberOperations {
   private int number;
   
  /**
    * Class constructor.
    * 
    * @param numberIn number to perform operations on
    */
   public NumberOperations(int numberIn) {
      number = numberIn;
   }
   
   /**
    * Getter for the number.
    * 
    * @return the number used to construct the class
    */
   public int getValue() {
      return number; 
   }
   
   /**
    * Returns a string containing the positive odd integers less than the 
    * value of the number.
    * 
    * @return string containing the positive odd integers less than the 
    * value of the number.
    */
   public String oddsUnder() {
      String output = "";
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++;
      }
      return output;
   }
    
   /**
    * Returns a string containing the positive powers of two less than the 
    * value of number.
    * 
    * @return string containing the positive powers of two less than the 
    * value of number.
    */ 
   public String powersTwoUnder() {
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t";
         powers = powers * 2;
      }
      return output;
   }
    
   /**
    * Returns {1,0,-1} if number is {greater than, equal to, less than} the 
    * compare number.
    * 
    * @param compareNumber integer to compare number to
    * @return the result of the comparison
    */
   public int isGreater(int compareNumber) {
      if (number < compareNumber) {
         return -1;
      } 
      else if (number > compareNumber) {
         return 1;
      }
      else {
         return 0;
      }
   }
    
   /**
    * Returns the string representation of the NumberOperations object.
    * 
    * @return whether the age was set successfully
    */
   public String toString() {
      return number + "";
   }
}
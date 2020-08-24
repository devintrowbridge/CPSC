import java.util.Scanner;

/** 
 * Converts a user entered binary value to decimal. 
 *
 * @author Devin Trowbridge
 * @version 2020-08-16
 */
public class Exercise1 {

  /**
    * Converts a user entered binary value to decimal.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
   
      // Prompt for input
      System.out.print("Enter a 16-bit binary number: ");
      String input = in.next();
      int value = binToDec(input.trim());
      if (value == -1) {
         System.out.println("Input not valid, please try again");
      }
      else {
         System.out.println(value);
      }
   }
   
   /**
    * Converts a user entered binary value to decimal.
    *
    * @param binaryString string to convert
    * @return value of binary string in decimal
    */
   public static int binToDec(String binaryString) {
      char c = ' ';
      int result = 0;
      int factor = (int) Math.pow(2,binaryString.length()-1);
      
      for (int i = 0; i < binaryString.length(); i++) {
         c = binaryString.charAt(i);
      
            // Check to make sure we have a bona fide binary string
         if (c == '1' || c == '0') { 
            result += (c - '0') * factor;
            factor /= 2;
         }
         else {
            result = -1;
            break;
         }
      }
      
      return result;
   }
}
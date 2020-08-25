import java.util.Scanner;

/** 
 * Converts a user entered decimal number to binary. 
 *
 * @author Devin Trowbridge
 * @version 2020-08-16
 */
public class Exercise3 {

  /**
    * Converts a user entered decimal value to binary.
    *
    * @param hexString string to convert
    * @return value in decimal
    */
   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
   
      // Prompt for input
      System.out.print("Enter a positive number below 2^32-1: ");
      String input = in.next();
      long myUInt = Long.parseLong(input);
      String binString = decToBin(myUInt);
      if (binString == null) {
         System.out.println("Please enter a valid number");
      }
      else {
         System.out.println(binString);
      }
   }
   
   /**
    * Converts a user entered decimal value to a binary string.
    *
    * @param decVal decimal value to convert
    * @return binary string
    */
   public static String decToBin(long decVal) {
     // Limit bounds 
      if (decVal < 0 || decVal > Math.pow(2.0,32.0)) 
         return null;
      
      // Main loop: Mask the number with 1, shift right and repeat
      // outputting result of each mask to a string
      String result = "";
      for (int i = 0; i < 32; i++) {
         result = (decVal & 1) + result;
         decVal = decVal >> 1;
         if (decVal == 0) 
            break;
      }
      
      return result;
   }
}
import java.util.Scanner;

/** 
 * Converts a user entered hex value to decimal. 
 *
 * @author Devin Trowbridge
 * @version 2020-08-16
 */
public class Exercise2 {

  /**
    * Converts a user entered hex value to decimal.
    *
    * @param args Command line arguments (not used)
    */
   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
   
      // Prompt for input
      System.out.print("Enter a 16-bit hexadecimal number: ");
      String input = in.next();
      int value = hexToDec(input.trim());
      if (value == -1) {
         System.out.println("Input not valid, please try again");
      }
      else {
         System.out.println(value);
      }
   }
   
   /**
    * Converts a user entered hex value to decimal.
    *
    * @param hexString string to convert
    * @return value in decimal
    */
   public static int hexToDec(String hexString) {
      char c = ' ';
      int result = 0;
      int factor = (int) Math.pow(16, hexString.length()-1);
      
      for (int i = 0; i < hexString.length(); i++) {
            // Check to make sure we have a bona fide hex string
         int val = convertCharToHex(hexString.charAt(i));
      
         if (val != -1) { 
            result += val * factor;
            factor /= 16;
         }
         else {
            result = -1;
            break;
         }
      }
      
      return result;
   }
   
   /**
    * Converts a character to its equivalent hex value
    *
    * @param c character to check
    * @return value of character in hex 
    */
   public static int convertCharToHex(char c) {
      int value;
      if (c >= '0' && c <='9')
      {
         value = c - '0';
      }
      else if (c >= 'A' && c <= 'F')
      {
         value = c - 'A' + 10;
      }
      else if (c >= 'a' && c <= 'f')
      {
         value = c - 'a' + 10;
      }
      else 
      {
         value = -1;
      }
      return value;
   }
}
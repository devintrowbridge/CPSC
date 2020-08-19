import java.util.Scanner;

/** 
 * Converts a user entered binary value to decimal. 
 *
 * @author Devin Trowbridge
 * @version 2020-08-16
 */
public class btd
{
   /**
    * Converts a user entered binary value to decimal.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
   
      // Prompt for input
      System.out.print("Enter a binary digit (0 or 1): ");
      String input = in.next();
      char inputChar = input.charAt(0);
      int value = bin2dec(inputChar);
      if (value == -1) {
         System.out.println("The character " + inputChar + " is invalid: " + inputChar + " is not a bit.");
      }
      else {
         System.out.println(value);
      }
   }
   
   public static int bin2dec(char c) {
      int value = -1;
      switch (c)
      {
         case '1':
            value = 1;
            break;
         case '0':
            value = 0;
            break;
         default:
            break;
      }
      return value;
   }
}
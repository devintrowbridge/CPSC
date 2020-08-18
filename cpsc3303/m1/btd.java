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
      
      switch (inputChar)
      {
         case '1':
            System.out.println(1);
            break;
         case '0':
            System.out.println(0);
            break;
         default:
            System.out.println("The character " + inputChar + " is invalid: " + inputChar + " is not a bit.");
            break;
      }
   }
}
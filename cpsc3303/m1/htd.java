import java.util.Scanner;

/** 
 * Converts a user entered hex value to decimal. 
 *
 * @author Devin Trowbridge
 * @version 2020-08-16
 */
public class htd
{
   /**
    * Converts a user entered hex value to decimal.
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
   
      // Prompt for input
      System.out.print("Enter a hexadecimal digit (0 thru F): ");
      String input = in.next();
      char inputChar = input.charAt(0);
      
      if (inputChar >= '0' && inputChar <='9')
      {
         System.out.println(inputChar - '0');
      }
      else if (inputChar >= 'A' && inputChar <= 'F')
      {
         System.out.println(inputChar - 'A' + 10);
      }
      else if (inputChar >= 'a' && inputChar <= 'f')
      {
         System.out.println(inputChar - 'a' + 10);
      }
      else 
      {
         System.out.println("The character " + inputChar + " is invalid: " + inputChar + " is not a hexadecimal digit.");
      }
      
   }
}
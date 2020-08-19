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
      int value = hex2dec(inputChar);
      
      if (value != -1) {
         System.out.print(value);
      }
      else
      {
         System.out.println("The character " + inputChar + " is invalid: " 
                            + inputChar + " is not a a hexadecimal digit.");
      }
            
   }
   
   /**
    * Converts a hex character to decimal.
    *
    * @param c character to convert
    * @return hex value in base 10
    */
   public static int hex2dec(char c) {
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
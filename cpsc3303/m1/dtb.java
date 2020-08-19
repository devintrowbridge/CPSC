import java.util.Scanner;
import java.lang.Long;

/** 
 * Converts a user entered decimal value to binary. 
 *
 * @author Devin Trowbridge
 * @version 2020-08-16
 */
public class dtb
{
   /**
    * Converts a user entered decimal value to binary. 
    *
    * @param args Command line arguments (not used).
    */
   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
   
      // Prompt for input
      System.out.print("\nEnter a positive integer less than 2^32-1: ");
      String input = in.next();
      long myUInt = Long.parseLong(input);
      String value = dec2bin(myUInt);
      if (value == null) {
         System.out.println(myUInt + " is not a positive integer below 2^32-1.");
      }
      else {
         System.out.println(value);
      }
   }
   
   public static String dec2bin(long input)
   {
      String result = "";
      if (input < 0) {
         return null;
      }
      else if (input == 0) {
         result = "0";
      }
      else {
         while (input > 1) {
            result = (input % 2) + result;
            input = input / 2;
         }
         result = "1" + result;
      }
      return result;
   }
}
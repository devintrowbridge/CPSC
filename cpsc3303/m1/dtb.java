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
      System.out.print("\nEnter a positive integer: ");
      String input = in.next();
      long myUInt = Long.parseLong(input);
      System.out.println(dec2bin(myUInt));
   }
   
   public static String dec2bin(long input)
   {
      String result = "";
      if (input == 0)
      {
         result = "0";
      }
      else
      {
         while (input > 1)
         {
            result = (input % 2) + result;
            input = input / 2;
         }
         result = "1" + result;
      }
      return result;
   }
}
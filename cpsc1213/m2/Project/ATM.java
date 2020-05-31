import java.util.Scanner;

/**
 * Calculates the minimum number of paper currency denominations in a specified
 * number of dollars.
 *
 * Project 2
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-05-31
 */
public class ATM {

  /**
   * Calculates the minimum number of paper currency denominations in a 
   * specified number of dollars.
   * @param args Command line arguments - not used
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      int inputVal;
      int remainder;
      int twenties;
      int tens;
      int fives;
      int ones;
      
      System.out.print("Enter the amount: $");
      inputVal = userInput.nextInt();
      
      if (inputVal > MAX_DOLLAR_AMOUNT) {
         // Over max amount
         System.out.println("Limit of $" + MAX_DOLLAR_AMOUNT + " exceeded!");
      } else if (inputVal < 0) {
         // Under minumum amount
         System.out.println("Please enter a positive dollar amount.");
      } else {
         // Just right
         System.out.println("Bills by denomination:");
         
         // Find the number of bills via integer division
         // Find the amount leftover after int division with modulo, and pass
         // along to the next bill.
         twenties = inputVal / 20;
         remainder = inputVal % 20;
         System.out.println("\t$20: " + twenties);
         
         tens = remainder / 10;
         remainder %= 10;
         System.out.println("\t$10: " + tens);
         
         fives = remainder / 5;
         remainder %= 5;
         System.out.println("\t$5: " + fives);
         
         ones = remainder;
         System.out.println("\t$1: " + ones);
         
         System.out.println("$" + inputVal + " = (" 
                                + twenties + " * $20) + ("
                                + tens     + " * $10) + ("
                                + fives    + " * $5) + ("
                                + ones     + " * $1)");
      } 
   }
   
   static final int MAX_DOLLAR_AMOUNT = 500;
}
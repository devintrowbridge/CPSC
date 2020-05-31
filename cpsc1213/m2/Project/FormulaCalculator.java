import java.util.Scanner;

/**
 * Calculates the result of the formula: 
 *     (2x - 7.4) (4y + 9.3) (6z - 11.2) / xyz
 * based on user input for x, y, and z.
 *
 * Project 2
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-05-31
 */
public class FormulaCalculator {

  /**
   * Calculates the result of the formula: 
   *     (2x - 7.4) (4y + 9.3) (6z - 11.2) / xyz
   * based on user input for x, y, and z.
   * @param args Command line arguments - not used
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      double x;
      double y;
      double z;
      double result;
      
      // Display the formula and get user input for x, y, and z
      System.out.println("result = (2x - 7.4) (4y + 9.3) (6z - 11.2) / xyz");
      
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble(); 
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble();
      
      // Perform the calculation, making sure to handle the divide by zero case
      if ((x * y * z) == 0) {
         result = 0.0;
      } else {
         result = (2 * x - 7.4) * (4 * y + 9.3) * (6 * z - 11.2) / (x * y * z);
      }
      
      // Display calculation results
      System.out.println("result = " + result); 
   }
}
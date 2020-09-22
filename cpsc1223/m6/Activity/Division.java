/**
* Provides static methods for dividing numbers.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-20
*/
public class Division {

   /**
    * Returns the integer value of a division operation.
    *
    * @param numerator top number
    * @param denominator bottom number
    * @return integer result
    */
   public static int intDivide(int numerator, int denominator) {
      try
      {
         return numerator / denominator;
      }
      catch (ArithmeticException e)
      {
         return 0;
      }
   }
   
   /**
    * Returns the floating point value of a division operation.
    *
    * @param numerator top number
    * @param denominator bottom number
    * @return floating point result
    * @throws IllegalArgumentException if the denominator is zero
    */
   public static double decimalDivide(int numerator, int denominator) 
      throws IllegalArgumentException {
      if (denominator == 0) {
         throw new IllegalArgumentException("The denominator " 
                                            + "cannot be zero");
      }
      return ((double) numerator / denominator);
   }
}
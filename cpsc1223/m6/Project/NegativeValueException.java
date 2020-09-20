/**
* Exception class for negative values.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-19
*/
public class NegativeValueException extends Exception {
  /**
    * Ctor.
    */
   public NegativeValueException() {
      super("Numeric values must be nonnegative");
   }
}
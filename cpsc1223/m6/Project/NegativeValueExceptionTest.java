import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Test class for negative values exception.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-19
*/
public class NegativeValueExceptionTest {


   /** Fixture initialization (common initialization
    *  for all tests). */
   @Before public void setUp() {
   }


   /** Test exception throwing. */
   @Test public void defaultTest() {
      boolean thrown = false;
      try {
         Car car = new Car("Jackson, Bo", 
                              "2012 Toyota Camry", 
                              -25000, 
                              false);
      }
      catch (NegativeValueException e) {
         thrown = true;
      }
      Assert.assertTrue("Expected NegativeValueException to be thrown.",
                           thrown);
   }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for Motorcycle class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class MotorcycleTest {
   private final Motorcycle motorcycle1 
      = new Motorcycle("Brando, Marlon", 
                       "1967 Harley-Davidson Sportster", 
                       14000, 
                       false,
                       750);
                       
   private final Motorcycle motorcycle2 
      = new Motorcycle("Trowbridge, Devin", 
                       "2016 Royal Enfield Himalayan", 
                       5000, 
                       true,
                       411);

   /**
    * Set up for all tests.
    *
    */
   @Before public void setUp() {
   }
   
   /**
    * Test use tax.
    *
    */
   @Test public void useTaxTest() {
      Assert.assertEquals(280.0, motorcycle1.useTax(), .000001);
      Assert.assertEquals(12.5,  motorcycle2.useTax(), .000001);
   }
   
   /**
    * Test toString and hashcode.
    *
    */
   @Test public void toStringTest() {
      String test1 = 
            "Brando, Marlon: Motorcycle 1967 Harley-Davidson Sportster"
            + "\nValue: $14,000.00 Use Tax: $280.00"
            + "\nwith Tax Rate: 0.005 Large Bike Tax Rate: 0.015";
   
      Assert.assertEquals(test1, motorcycle1.toString());
   }
}

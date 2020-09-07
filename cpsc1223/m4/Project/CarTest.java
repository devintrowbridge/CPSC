import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for car class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class CarTest {
   private final Car car1 
      = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
   private final Car car2 
      = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
   private final Car car3 
      = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 110000, false);
   private final Car car4 
      = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe", 110000, true);

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
      Assert.assertEquals(220.0,  car1.useTax(), .000001);
      Assert.assertEquals(110.0,  car2.useTax(), .000001);
      Assert.assertEquals(3300.0, car3.useTax(), .000001);
      Assert.assertEquals(2750.0, car4.useTax(), .000001);
   }
   
   /**
    * Test toString and hashcode.
    *
    */
   @Test public void toStringTest() {
      String test1 = 
            "Jones, Sam: Car 2017 Honda Accord"
            + "\nValue: $22,000.00 Use Tax: $220.00"
            + "\nwith Tax Rate: 0.01";
   
      Assert.assertEquals(test1, car1.toString());
      
      String test2 = 
         "Smith, Jack: Car 2015 Mercedes-Benz Coupe (Alternative Fuel)"
         + "\nValue: $110,000.00 Use Tax: $2,750.00"
         + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02";
         
      Assert.assertEquals(test2, car4.toString());
   }
}

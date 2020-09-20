import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for truck class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class TruckTest {
   private Truck truck1;
   private Truck truck2;

   /**
    * Set up for all tests.
    * @throws NegativeValueException
    */
   @Before public void setUp() throws NegativeValueException {
      truck1 
         = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, false, 1.5);
      truck2 
         = new Truck("Williams, Sam", "2010 Chevy Mack", 40000, true, 2.5);
   }
   
   /**
    * Test use tax.
    *
    */
   @Test public void useTaxTest() {
      Assert.assertEquals(600,  truck1.useTax(), .000001);
      Assert.assertEquals(1600, truck2.useTax(), .000001);
   }
   
   /**
    * Test toString.
    *
    */
   @Test public void toStringTest() {
      String test1 = 
            "Williams, Jo: Truck 2012 Chevy Silverado"
            + "\nValue: $30,000.00 Use Tax: $600.00"
            + "\nwith Tax Rate: 0.02";
   
      Assert.assertEquals(test1, truck1.toString());
      
      String test2 = 
         "Williams, Sam: Truck 2010 Chevy Mack (Alternative Fuel)"
         + "\nValue: $40,000.00 Use Tax: $1,600.00"
         + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03";
         
      Assert.assertEquals(test2, truck2.toString());
   }
   
   /**
    * Test truck setters/getters.
    * @throws NegativeValueException
    */
   @Test public void settersGettersTest() throws NegativeValueException {
      Truck tempTruck = new Truck("TempOwner", "TempCar", 0, true, 0);
      
      Assert.assertNotEquals(truck1.getTons(), tempTruck.getTons(), .000001);
      
      tempTruck.setTons(truck1.getTons());
      Assert.assertEquals(truck1.getTons(), tempTruck.getTons(),  .000001);
   }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for car class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class VehicleTest {
   private final Car car1 
      = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
   private final Car car2 
      = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
   private final Car car3 
      = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 110000, false);
   private final Car car4 
      = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe", 110000, true);

   /** Set up for all tests.  */
   @Before public void setUp() {
   }

   /** Test for equivalence.  */
   @Test public void equalsTest() {
      Assert.assertTrue(car1.equals(car1));
      Assert.assertFalse(car1.equals(car2));
      Assert.assertFalse(car1.equals(new String("Test")));
   }
   
   /** Test vehicle setters/getters. */
   @Test public void settersGettersTest() {
      Car tempCar = new Car("TempOwner", "TempCar", 0, true);
      
      Assert.assertNotEquals(car1, tempCar);
      
      tempCar.setOwner(car1.getOwner());
      tempCar.setYearMakeModel(car1.getYearMakeModel());
      tempCar.setValue(car1.getValue());
      tempCar.setAlternativeFuel(car1.getAlternativeFuel());
      
      Assert.assertEquals(car1, tempCar);
   }
   
   /** Test vehicle count. */
   @Test public void vehicleCountTest() {
      Car.resetVehicleCount();
      Assert.assertEquals(0, Car.getVehicleCount());
     
      Car tempCar1 
         = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car tempCar2 
         = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Truck truck1 
         = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, false, 1.5);
      Truck truck2 
         = new Truck("Williams, Sam", "2010 Chevy Mack", 40000, true, 2.5);
      
      Assert.assertEquals(4, Car.getVehicleCount());
   }
   
   /** Test hash code. */
   @Test public void hashCodeTest() {
      Assert.assertEquals(car1.hashCode(), car2.hashCode());
   }
   
   /** Test compare to code. */
   @Test public void compareToTest() {
      Assert.assertTrue(car4.compareTo(car4) == 0);
      Assert.assertTrue(car4.compareTo(car1)  > 0);
      Assert.assertTrue(car4.compareTo(car3)  < 0);
   }
}

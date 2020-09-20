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
   private Car car1;
   private Car car2;
   private Car car3;
   private Car car4;
   
   /** Set up for all tests.  
   * @throws NegativeValueException
   */
   @Before public void setUp() throws NegativeValueException {
      car1 
         = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car2 
         = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      car3 
         = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 110000, false);
      car4 
         = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe", 110000, true);
   }

   /** Test for equivalence.  */
   @Test public void equalsTest() {
      Assert.assertTrue(car1.equals(car1));
      Assert.assertFalse(car1.equals(car2));
      Assert.assertFalse(car1.equals(new String("Test")));
   }
   
   /** Test vehicle setters/getters. */
   @Test public void settersGettersTest() throws NegativeValueException {
      Car tempCar = new Car("TempOwner", "TempCar", 0, true);
      
      Assert.assertNotEquals(car1, tempCar);
      
      tempCar.setOwner(car1.getOwner());
      tempCar.setYearMakeModel(car1.getYearMakeModel());
      tempCar.setValue(car1.getValue());
      tempCar.setAlternativeFuel(car1.getAlternativeFuel());
      
      Assert.assertEquals(car1, tempCar);
   }
   
   /** Test vehicle count. 
   * @throws NegativeValueException
   */
   @Test public void vehicleCountTest() throws NegativeValueException {
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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for main vehicles app.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-07
*/
public class VehiclesPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). */
   @Before public void setUp() {
   }


   /** Test the main method. */
   @Test public void defaultTest() {
      VehiclesPart1 vp1 = new VehiclesPart1();
      Vehicle.resetVehicleCount();
      VehiclesPart1.main(null);
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   }
}

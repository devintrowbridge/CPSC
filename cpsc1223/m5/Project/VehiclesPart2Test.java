import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
* Test class for VehiclesPart2 class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-13
*/
public class VehiclesPart2Test {


   /** Fixture initialization (common initialization
    *  for all tests). */
   @Before public void setUp() {
   }

   /**
    * Test for main method.
    * @throws FileNotFoundException if passed file name can't be found
    */
   @Test public void mainTest() throws FileNotFoundException {
      VehiclesPart2 vp2 = new VehiclesPart2();
      
      Vehicle.resetVehicleCount();
      
      String[] args = {"vehicles1.txt"};
      VehiclesPart2.main(args);
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
* Test class for main program class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-19
*/
public class VehiclesPart3Test {


   /** Fixture initialization (common initialization
    *  for all tests). */
   @Before public void setUp() {
   }


   /** Tests the vehicle count. */
   @Test public void vehicleCountTest() {
      VehiclesPart3 vp3 = new VehiclesPart3();
      
      Vehicle.resetVehicleCount();
      
      String[] args = {"vehicles2.txt"};
      VehiclesPart3.main(args);
      Assert.assertEquals(9, Vehicle.getVehicleCount());      
   }
   
   /** A test that always fails. 
   * @throws FileNotFoundException 
   */
   @Test public void fileNameTest() throws FileNotFoundException {
      VehiclesPart3 vp3 = new VehiclesPart3();
      
      // Good file name
      Vehicle.resetVehicleCount();  
      VehiclesPart3.main(new String[]{"vehicles2.txt"});
      Assert.assertEquals(9, Vehicle.getVehicleCount());
   
         // Bad file name
      Vehicle.resetVehicleCount();                               
      VehiclesPart3.main(new String[]{"Not a file"});
      Assert.assertEquals(0, Vehicle.getVehicleCount());
       
      // No file name
      Vehicle.resetVehicleCount();                     
      VehiclesPart3.main(new String[]{});
      Assert.assertEquals(0, Vehicle.getVehicleCount());
   }
}

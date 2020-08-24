import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class Exercise3Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals("1000010",Exercise3.decToBin(66));
      Assert.assertEquals("0",Exercise3.decToBin(0));
      Assert.assertEquals("1111",Exercise3.decToBin(15));
      Assert.assertEquals("1111111111111111",Exercise3.decToBin(65535));
      Assert.assertEquals("1010011010110101",Exercise3.decToBin(42677));
   }
}

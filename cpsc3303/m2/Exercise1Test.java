import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Exercise1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals(66,Exercise1.binToDec("01000010"));
      Assert.assertEquals(0,Exercise1.binToDec("00000000"));
      Assert.assertEquals(15,Exercise1.binToDec("1111"));
      Assert.assertEquals(65535,Exercise1.binToDec("1111111111111111"));
      Assert.assertEquals(-1,Exercise1.binToDec("-0100110"));
      Assert.assertEquals(42677,Exercise1.binToDec("1010011010110101"));
   }
}

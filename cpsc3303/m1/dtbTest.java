import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class dtbTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Test for dec2bin **/
   @Test public void defaultTest() {
      Assert.assertEquals("0",dtb.dec2bin(0));
      Assert.assertEquals("11111111111111111111111111111111",dtb.dec2bin(4294967295L));
      Assert.assertEquals("10001100111111100101100000010100",dtb.dec2bin(2365478932L));
      Assert.assertEquals("1000010",dtb.dec2bin(66));
      Assert.assertEquals(null,dtb.dec2bin(-1));
   }
}

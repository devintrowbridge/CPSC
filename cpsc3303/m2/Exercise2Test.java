import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class Exercise2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals(686,   Exercise2.hexToDec("02AE"));
      Assert.assertEquals(0,     Exercise2.hexToDec("0000"));
      Assert.assertEquals(15,    Exercise2.hexToDec("F"));
      Assert.assertEquals(65535, Exercise2.hexToDec("FFFF"));
      Assert.assertEquals(-1,    Exercise2.hexToDec("-0100110"));
      Assert.assertEquals(42677, Exercise2.hexToDec("A6B5"));
   }
}

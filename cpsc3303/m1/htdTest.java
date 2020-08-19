import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class htdTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals(0,htd.hex2dec('0'));
      Assert.assertEquals(15,htd.hex2dec('F'));
      Assert.assertEquals(-1,htd.hex2dec('G'));
      Assert.assertEquals(4,htd.hex2dec('4'));
      Assert.assertEquals(11,htd.hex2dec('B'));
      Assert.assertEquals(14,htd.hex2dec('e'));
   }
}

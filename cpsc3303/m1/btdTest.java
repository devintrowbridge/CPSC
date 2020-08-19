import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class btdTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals(0,btd.bin2dec('0'));
      Assert.assertEquals(1,btd.bin2dec('1'));
      Assert.assertEquals(-1,btd.bin2dec('2'));
   }
}

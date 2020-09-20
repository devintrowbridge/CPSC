import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for sem tractor trailer class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class SemiTractorTrailerTest {
   private SemiTractorTrailer semi1;

   /**
    * Set up for all tests.
    * @throws NegativeValueException
    */
   @Before public void setUp() throws NegativeValueException {
      semi1 = new SemiTractorTrailer("Williams, Pat", 
                                  "2012 International Big Boy", 
                                  45000, 
                                  false, 
                                  5.0, 
                                  4);
   }
   
   /**
    * Test use tax.
    *
    */
   @Test public void useTaxTest() {
      Assert.assertEquals(3150,  semi1.useTax(), .000001);
   }
   
   /**
    * Test toString.
    *
    */
   @Test public void toStringTest() {
      String test1 = 
         "Williams, Pat: SemiTractorTrailer 2012 International Big Boy"
         + "\nValue: $45,000.00 Use Tax: $3,150.00"
         + "\nwith Tax Rate: 0.02 "
         + "Large Truck Tax Rate: 0.03 "
         + "Axle Tax Rate: 0.02";
         
      Assert.assertEquals(test1, semi1.toString());
   }
   
   /**
    * Test semi setters/getters.
    * @throws NegativeValueException
    */
   @Test public void settersGettersTest() throws NegativeValueException {
      SemiTractorTrailer tempSemi 
         = new SemiTractorTrailer("TempOwner", "TempCar", 0, true, 0, 0);
      
      Assert.assertNotEquals(semi1.getAxles(), tempSemi.getAxles());
      
      tempSemi.setAxles(semi1.getAxles());
      Assert.assertEquals(semi1.getAxles(), tempSemi.getAxles());
   }
}

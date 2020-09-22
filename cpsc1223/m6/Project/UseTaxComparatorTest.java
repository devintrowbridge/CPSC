import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Test class for UseTaxComparator class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-13
*/
public class UseTaxComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). */
   @Before public void setUp() {
   }


   /** Test comparison function. 
   * @throws NegativeValueException when value is negative */
   @Test public void compareTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000.0, true);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000.0, true);
      
      UseTaxComparator comparator = new UseTaxComparator();
      
      Assert.assertTrue(0 == comparator.compare(car1, car2));
      
      car1.setValue(1.0);
      Assert.assertTrue(0 > comparator.compare(car1, car2));
      
      car1.setValue(100000.0);         
      Assert.assertTrue(0 < comparator.compare(car1, car2));
   }
}

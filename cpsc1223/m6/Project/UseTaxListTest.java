import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
* Test class for Use Tax List class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-13
*/
public class UseTaxListTest {
   private UseTaxList useTaxList = new UseTaxList();

   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws FileNotFoundException if passed file name can't be found
    */
   @Before public void setUp() throws FileNotFoundException {
      useTaxList.readVehicleFile("vehicles2.txt");
   }

   /** Test to make sure the file was read in correctly. */
   @Test public void readVehicleFileTest() {
      Vehicle[] vList = useTaxList.getVehicleList();
      
      Assert.assertEquals("Car", vList[0].getClass().getName());
      Assert.assertEquals("Jones, Jo", vList[1].getOwner());
      Assert.assertEquals("2015 Mercedes-Benz Coupe", 
                          vList[2].getYearMakeModel());
      Assert.assertEquals(110000, vList[4].getValue(), .000001);
      Assert.assertEquals("SemiTractorTrailer", 
                          vList[7].getClass().getName());   
      
      String[] exRecordsList = useTaxList.getExcludedRecords();
      Assert.assertEquals(8, exRecordsList.length);
   }
   
   /** Test for tax district setters and getters. */
   @Test public void taxDistrictTest() {
      UseTaxList tempUseTaxList = new UseTaxList();
      
      Assert.assertEquals("not yet assigned", tempUseTaxList.getTaxDistrict());
      tempUseTaxList.setTaxDistrict("Test");
      Assert.assertEquals("Test", tempUseTaxList.getTaxDistrict());
   }
   
   /** Test for to string. */
   @Test public void toStringTest() {
      String test = 
           "\nJones, Sam: Car 2014 Honda Accord"
         + "\nValue: $22,000.00 Use Tax: $220.00"
         + "\nwith Tax Rate: 0.01"
         + "\n"
         + "\nJones, Jo: Car 2014 Honda Accord (Alternative Fuel)"
         + "\nValue: $22,000.00 Use Tax: $110.00"
         + "\nwith Tax Rate: 0.005"
         + "\n"
         + "\nSmith, Pat: Car 2015 Mercedes-Benz Coupe"
         + "\nValue: $110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nSmith, Pop: Car 2015 Mercedes-Benz Coupe"
         + "\nValue: $110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nSmith, Jack: Car 2015 Mercedes-Benz Coupe (Alternative Fuel)"
         + "\nValue: $110,000.00 Use Tax: $2,750.00"
         + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Jo: Truck 2012 Chevy Silverado"
         + "\nValue: $30,000.00 Use Tax: $600.00"
         + "\nwith Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Sam: Truck 2010 Chevy Mack (Alternative Fuel)"
         + "\nValue: $40,000.00 Use Tax: $1,600.00"
         + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03"
         + "\n"
         + "\nWilliams, Pat: SemiTractorTrailer 2010 International Big Boy"
         + "\nValue: $45,000.00 Use Tax: $3,150.00"
         + "\nwith Tax Rate: 0.02 " 
                + "Large Truck Tax Rate: 0.03 " 
                + "Axle Tax Rate: 0.02"
         + "\n"
         + "\nBrando, Marlon: Motorcycle 1964 Harley-Davidson Sportster"
         + "\nValue: $14,000.00 Use Tax: $280.00"
         + "\nwith Tax Rate: 0.005 Large Bike Tax Rate: 0.015"
         + "\n";
   
      Assert.assertEquals(test, useTaxList.toString());
   }
   
   /** Test for sorting by owner. */
   @Test public void listByOwnerTest() {
      String test = 
           "------------------------------"
         + "\nVehicles by Owner"
         + "\n------------------------------"
         + "\n"
         + "\nBrando, Marlon: Motorcycle 1964 Harley-Davidson Sportster"
         + "\nValue: $14,000.00 Use Tax: $280.00"
         + "\nwith Tax Rate: 0.005 Large Bike Tax Rate: 0.015"
         + "\n"
         + "\nJones, Jo: Car 2014 Honda Accord (Alternative Fuel)"
         + "\nValue: $22,000.00 Use Tax: $110.00"
         + "\nwith Tax Rate: 0.005"
         + "\n"
         + "\nJones, Sam: Car 2014 Honda Accord"
         + "\nValue: $22,000.00 Use Tax: $220.00"
         + "\nwith Tax Rate: 0.01"
         + "\n"
         + "\nSmith, Jack: Car 2015 Mercedes-Benz Coupe (Alternative Fuel)"
         + "\nValue: $110,000.00 Use Tax: $2,750.00"
         + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nSmith, Pat: Car 2015 Mercedes-Benz Coupe"
         + "\nValue: $110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nSmith, Pop: Car 2015 Mercedes-Benz Coupe"
         + "\nValue: $110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Jo: Truck 2012 Chevy Silverado"
         + "\nValue: $30,000.00 Use Tax: $600.00"
         + "\nwith Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Pat: SemiTractorTrailer 2010 International Big Boy"
         + "\nValue: $45,000.00 Use Tax: $3,150.00"
         + "\nwith Tax Rate: 0.02 "
                + "Large Truck Tax Rate: 0.03 "
                + "Axle Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Sam: Truck 2010 Chevy Mack (Alternative Fuel)"
         + "\nValue: $40,000.00 Use Tax: $1,600.00"
         + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03\n\n";
   
      Assert.assertEquals(test, useTaxList.listByOwner());
   }
   
   /** Test for sorting by use tax. */
   @Test public void listByUseTaxTest() {
      String test = 
           "------------------------------"
         + "\nVehicles by Use Tax"
         + "\n------------------------------"
         + "\n"
         + "\nJones, Jo: Car 2014 Honda Accord (Alternative Fuel)"
         + "\nValue: $22,000.00 Use Tax: $110.00"
         + "\nwith Tax Rate: 0.005"
         + "\n"
         + "\nJones, Sam: Car 2014 Honda Accord"
         + "\nValue: $22,000.00 Use Tax: $220.00"
         + "\nwith Tax Rate: 0.01"
         + "\n"
         + "\nBrando, Marlon: Motorcycle 1964 Harley-Davidson Sportster"
         + "\nValue: $14,000.00 Use Tax: $280.00"
         + "\nwith Tax Rate: 0.005 Large Bike Tax Rate: 0.015"
         + "\n"
         + "\nWilliams, Jo: Truck 2012 Chevy Silverado"
         + "\nValue: $30,000.00 Use Tax: $600.00"
         + "\nwith Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Sam: Truck 2010 Chevy Mack (Alternative Fuel)"
         + "\nValue: $40,000.00 Use Tax: $1,600.00"
         + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03"
         + "\n"
         + "\nSmith, Jack: Car 2015 Mercedes-Benz Coupe (Alternative Fuel)"
         + "\nValue: $110,000.00 Use Tax: $2,750.00"
         + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nWilliams, Pat: SemiTractorTrailer 2010 International Big Boy"
         + "\nValue: $45,000.00 Use Tax: $3,150.00"
         + "\nwith Tax Rate: 0.02 "
                + "Large Truck Tax Rate: 0.03 "
                + "Axle Tax Rate: 0.02"
         + "\n"
         + "\nSmith, Pat: Car 2015 Mercedes-Benz Coupe"
         + "\nValue: $110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02"
         + "\n"
         + "\nSmith, Pop: Car 2015 Mercedes-Benz Coupe"
         + "\nValue: $110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02"
         + "\n\n";
   
      Assert.assertEquals(test, useTaxList.listByUseTax());
   }
   
   /** Test for summary generation. */
   @Test public void sumaryTest() {
      String test = 
              "------------------------------"
            + "\nSummary for Tax District 52"
            + "\n------------------------------"
            + "\nNumber of Vehicles: 9"
            + "\nTotal Value: $503,000.00"
            + "\nTotal Use Tax: $15,310.00"
            + "\n\n";
            
      Assert.assertEquals(test, useTaxList.summary());
   }
}

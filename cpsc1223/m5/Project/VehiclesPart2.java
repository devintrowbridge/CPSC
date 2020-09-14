import java.io.FileNotFoundException;

/**
* Vehicle main application.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-13
*/
public class VehiclesPart2 {

   /**
    * Ctor.
    * @param args pass in the name of the file that contains vehicle data
    * @throws FileNotFoundException if passed file name can't be found
    */
   public static void main(String[] args) throws FileNotFoundException {
      UseTaxList useTaxList = new UseTaxList();
      
      useTaxList.readVehicleFile(args[0]);
      System.out.println(useTaxList.summary());
      System.out.println(useTaxList.listByOwner());
      System.out.println(useTaxList.listByUseTax());
      System.out.println(useTaxList.excludedRecordsList());
   }
}
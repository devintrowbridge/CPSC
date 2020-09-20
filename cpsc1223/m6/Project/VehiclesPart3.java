import java.io.FileNotFoundException;

/**
* Main app for project 6.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-19
*/
public class VehiclesPart3 {
   /**
* Entry point for program.
* @param args not used
*/
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println(
            "*** File name not provided by command line argument.\n" 
            + "Program ending.");
      }
      else {
         UseTaxList useTaxList = new UseTaxList();
         
         try 
         {
            useTaxList.readVehicleFile(args[0]);
            System.out.println(useTaxList.summary());
            System.out.println(useTaxList.listByOwner());
            System.out.println(useTaxList.listByUseTax());
            System.out.println(useTaxList.excludedRecordsList());
         }
         catch (FileNotFoundException e)
         {
            System.out.println("*** File not found.\nProgram ending.");
         }
      }
   }
}
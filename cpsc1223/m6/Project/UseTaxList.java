import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.text.DecimalFormat; 

/**
* Reads data and generates reports about vehicles.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class UseTaxList {
   private String taxDistrict = "not yet assigned";
   private Vehicle[] vehicleList = {};
   private String[] excludedRecords = {};
   
   /** 
    * Ctor.
    */ 
   public UseTaxList() {
      // No action necessary
   }
   
   /** 
    * Reads in a file with formatted vehicle data.
    * @param fileName file to read in
    * @throws FileNotFoundException if passed file name can't be found
    */ 
   public void readVehicleFile(String fileName) throws FileNotFoundException {
      Scanner fileScan = new Scanner(new File(fileName));
      Scanner lineScan;
      
      taxDistrict = fileScan.nextLine();
      
      Vehicle temp = null;
      
      // While there is still data in the file, keep grabbing lines
      while (fileScan.hasNext()) {
         String record = fileScan.nextLine();
         lineScan = new Scanner(record).useDelimiter(";");
         
         try 
         {
            char    type          = (lineScan.next()).trim().charAt(0);
            String  owner         = (lineScan.next()).trim();
            String  yearMakeModel = (lineScan.next()).trim();
            double  value         = Double.parseDouble(lineScan.next());
            boolean altFuel     = Boolean.parseBoolean(lineScan.next().trim());
            
            double  tons = 0.0;
            
            switch (Character.toUpperCase(type)) {   
               case 'C':   // Car  
                  addVehicle(new Car(owner, yearMakeModel, value, altFuel));
                  break;
               case 'T':   // Truck
                  tons = Double.parseDouble(lineScan.next().trim());
                  addVehicle(new Truck(owner, 
                                       yearMakeModel, 
                                       value, 
                                       altFuel, 
                                       tons));
                  break;
               case 'S':   // SemiTractorTrailer
                  tons = Double.parseDouble(lineScan.next().trim());
                  int axles = Integer.parseInt(lineScan.next().trim());
                  addVehicle(new SemiTractorTrailer(owner, 
                                                    yearMakeModel, 
                                                    value, 
                                                    altFuel, 
                                                    tons, 
                                                    axles));
                  break;
               case 'M':   // Motorcycle
                  double engineSize 
                     = Double.parseDouble(lineScan.next().trim());
                  addVehicle(new Motorcycle(owner, 
                                            yearMakeModel, 
                                            value, 
                                            altFuel, 
                                            engineSize));
                  break;
               default:
                  addExcludedRecord("Invalid Vehicle Category in:\n" + record);
                  break;
            }
         } 
         catch (NegativeValueException e)
         {
            addExcludedRecord(e + " in:\n" + record);
         }
         catch (NumberFormatException e)
         {
            addExcludedRecord(e + " in:\n" + record);
         }
         catch (NoSuchElementException e)
         {
            addExcludedRecord(e + " in:\n" + record);
         }
      }
   }
   
   /** 
    * Getter for tax district.
    * @return tax district as string
    */ 
   public String getTaxDistrict() {
      return taxDistrict;
   }
   
   /** 
    * Setter for tax district.
    * @param taxDistrictIn tax district
    */ 
   public void setTaxDistrict(String taxDistrictIn) {
      taxDistrict = taxDistrictIn;
   }
   
   /** 
    * Getter for vehicle list.
    * @return list of vehicles
    */ 
   public Vehicle[] getVehicleList() {
      return vehicleList;
   }
   
   /** 
    * Getter for excluded records.
    * @return list of excluded records
    */ 
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   /** 
    * Add excluded records to list.
    * @param excludedRecord excluded record to add to list
    */ 
   public void addExcludedRecord(String excludedRecord) {
      excludedRecords = Arrays.copyOf(excludedRecords, 
                                      excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = excludedRecord;
   }
   
   /** 
    * Add vehicle to list.
    * @param vehicleIn vehicle to add to list
    */ 
   public void addVehicle(Vehicle vehicleIn) {
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
   }
   
   /** 
    * Generates string representation of UseTaxList.
    * @return string representation of use tax list
    */ 
   public String toString() {
      String result = "";
      for (Vehicle vehicle : vehicleList) {
         result += "\n" + vehicle.toString() + "\n";
      }
      return result;
   }
   
   /** 
    * Sums the use tax of every vehicle in the list.
    * @return total use tax
    */ 
   public double calculateTotalUseTax() {
      double result = 0.0;
      for (Vehicle vehicle : vehicleList) {
         result += vehicle.useTax();
      }
      return result;
   }
   
   /** 
    * Sums the value of every vehicle in the list.
    * @return total value
    */ 
   public double calculateTotalValue() {
      double result = 0.0;
      for (Vehicle vehicle : vehicleList) {
         result += vehicle.getValue();
      }
      return result;
   }
   
   /** 
    * Generates a summary for the vehicle list.
    * @return summary string
    */ 
   public String summary() {
      String result = "";
      DecimalFormat fmt = new DecimalFormat("#,##0.00");
      
      result = 
         "------------------------------\n"
         + "Summary for " + taxDistrict + "\n"
         + "------------------------------\n"
         + "Number of Vehicles: " + vehicleList.length + "\n"
         + "Total Value: $" + fmt.format(calculateTotalValue()) + "\n"
         + "Total Use Tax: $" + fmt.format(calculateTotalUseTax()) + "\n\n";
         
      return result;
   }
   
   /** 
    * Generates a list of vehicles sorted by owner.
    * @return list string
    */  
   public String listByOwner() {
      String result = "";
      
      Arrays.sort(vehicleList);
      
      result = 
           "------------------------------\n"
         + "Vehicles by Owner\n"
         + "------------------------------\n"
         + toString()
         + "\n";
      
      return result;
   }
   
   /** 
    * Generates a list of vehicles sorted by use tax.
    * @return list string
    */  
   public String listByUseTax() {
      String result = "";
      
      Arrays.sort(vehicleList, new UseTaxComparator());
      
      result = 
           "------------------------------\n"
         + "Vehicles by Use Tax\n"
         + "------------------------------\n"
         + toString()
         + "\n";
      
      return result;
   }
   
   /** 
    * Generates a list of excluded records.
    * @return list string
    */  
   public String excludedRecordsList() {
      String result = "";
      
      result = 
           "------------------------------\n"
         + "Excluded Records\n"
         + "------------------------------\n";
       
      for (String record : excludedRecords) {
         result += "\n" + record + "\n";
      }
   
      return result;
   }
}
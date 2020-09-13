import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Double;
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
   
   public UseTaxList() {
      // No action necessary
   }
   
   public void readVehicleFile (String fileName) throws FileNotFoundException {
      Scanner fileScan = new Scanner(new File(fileName));
      Scanner lineScan;
      
      taxDistrict = fileScan.nextLine();
      
      String[] fields = new String[10];
      Vehicle temp = null;
      int i = 0;
      
      // While there is still data in the file, keep grabbing lines
      while (fileScan.hasNext()) {
         String record = fileScan.next();
         lineScan = new Scanner(record).useDelimiter(";");
         
         while (lineScan.hasNext()) {
            fields[i] = (lineScan.next()).trim();
            i++;
         }
         
         double  value   = Double.parseDouble(fields[3]);
         boolean altFuel = Boolean.parseBoolean(fields[4]);
         
         switch (fields[0].charAt(0)) {   
            case 'C':   // Car  
               addVehicle(new Car(fields[1], fields[2], value, altFuel));
               break;
            case 'T':   // Truck
               addVehicle(new Truck(fields[1], 
                                    fields[2], 
                                    value, 
                                    altFuel, 
                                    Double.parseDouble(fields[5])));
               break;
            case 'S':   // SemiTractorTrailer
               addVehicle(new SemiTractorTrailer(
                                  fields[1], 
                                  fields[2], 
                                  value, 
                                  altFuel, 
                                  Double.parseDouble(fields[5]), 
                                  Integer.parseInt(fields[6])));
               break;
            case 'M':   // Motorcycle
               addVehicle(new Motorcycle(fields[1], 
                                         fields[2], 
                                         value, 
                                         altFuel, 
                                         Double.parseDouble(fields[5])));
               break;
            default:
               addExcludedRecord(record);
               break;
         }
         
         fields = new String[10];
      }
   }
   
   public String getTaxDistrict() {
      return taxDistrict;
   }
   
   public void setTaxDistrict(String taxDistrictIn) {
      taxDistrict = taxDistrictIn;
   }
   
   public Vehicle[] getVehicleList() {
      return vehicleList;
   }
   
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   public void addExcludedRecord(String excludedRecord) {
      excludedRecords = Arrays.copyOf(excludedRecords, 
                                      excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = excludedRecord;
   }
   
   public void addVehicle(Vehicle vehicleIn) {
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
   }
   
   public String toString() {
      String result = "";
      for (Vehicle vehicle : vehicleList) {
         result = "\n" + vehicle.toString() + "\n";
      }
      return result;
   }
   
   public double calculateTotalUseTax() {
      double result = 0.0;
      for (Vehicle vehicle : vehicleList) {
         result += vehicle.useTax();
      }
      return result;
   }
   
   public double calculateTotalValue() {
      double result = 0.0;
      for (Vehicle vehicle : vehicleList) {
         result += vehicle.getValue();
      }
      return result;
   }
   
   public String summary() {
      String result = "";
      DecimalFormat fmt = new DecimalFormat("#,##0.00");
      
      result = 
         "------------------------------\n"
         + "Summary for " + taxDistrict + "\n"
         + "------------------------------\n"
         + " Number of vehicles: " + vehicleList.length + "\n"
         + "Total Value: " + fmt.format(calculateTotalValue()) + "\n"
         + "Total Use Tax: " + fmt.format(calculateTotalUseTax()) + "\n"
         + "\n"
         + "\n"
         + listByOwner()
         + "\n"
         + listByUseTax()
         + "\n"
         + excludedRecordsList()
            + "\n";
         
      return result;
   }
   
   public String listByOwner() {
      String result = "";
      
      Arrays.sort(vehicleList);
      
      result = 
           "------------------------------\n"
         + "Vehicles by Owner\n"
         + "------------------------------\n"
         + "\n"
         + toString();
      
      return result;
   }
   
   public String listByUseTax() {
      String result = "";
      
      Arrays.sort(vehicleList, new UseTaxComparator());
      
      result = 
           "------------------------------\n"
         + "Vehicles by Use Tax\n"
         + "------------------------------\n"
         + "\n"
         + toString();
      
      return result;
   }
   
   public String excludedRecordsList() {
      String result = "";
      
      result = 
           "------------------------------\n"
         + "Excluded Records\n"
         + "------------------------------\n"
         + "\n";
       
      for (String record : excludedRecords) {
         result += record + "\n";
      }
   
      return result;
   }
}
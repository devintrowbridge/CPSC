import java.text.DecimalFormat;

/**
* Vehicle class that stores vehicle data and provides methods
* to access the data.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public abstract class Vehicle implements Comparable<Vehicle> {
   protected String owner = "";
   protected String yearMakeModel = "";
   protected double value = 0.0;
   protected boolean altFuel = false;
   protected static int vehicleCount = 0;
      
   /**
    * Ctor.
    *
    * @param ownerIn vehicle owner
    * @param yearMakeModelIn year make and model of the vehicle
    * @param valueIn value of the vehicle
    * @param altFuelIn true if the vehicle is an alternative fuel vehicle
    * @throws NegativeValueException when value is negative
    */
   public Vehicle(String  ownerIn, 
                  String  yearMakeModelIn, 
                  double  valueIn, 
                  boolean altFuelIn) throws NegativeValueException {  
      setOwner(ownerIn);
      setYearMakeModel(yearMakeModelIn);
      setValue(valueIn);
      setAlternativeFuel(altFuelIn);
      vehicleCount++;
   }
   
   /**
    * Override that compares two vehicle objects.
    *
    * @param vic vehicle to compare to
    * @return returns the result of comparing owners
    */ 
   public int compareTo(Vehicle vic) {
      return getOwner().compareTo(vic.getOwner());
   }
   
   /**
    * Override that tests equivalence between two vehicle objects.
    *
    * @param obj object to compare equivalence to
    * @return true if the vehicles are equivalent
    */ 
   public boolean equals(Object obj) {
      if (!(obj instanceof Vehicle)) {
         return false;
      }
      else {
         Vehicle other = (Vehicle) obj;
         return (owner + yearMakeModel + value).equals(other.owner
                                                     + other.yearMakeModel
                                                     + other.value);
      }
   }
   
   /**
    * Abstract method that returns the total amount for the vehicle's use tax.
    *
    * @return the vehicle's use tax
    */ 
   public abstract double useTax();
   
   /**
    * Generates string representation of a vehicle.
    *
    * @return string representation of a vehicle
    */ 
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.00");
      
      String result = 
         getOwner() 
         + ": " + this.getClass().getName() 
         + " " + getYearMakeModel();
         
      if (altFuel) {
         result += " (Alternative Fuel)";
      }
         
      result += "\nValue: $" + fmt.format(getValue()) 
              + " Use Tax: $" + fmt.format(useTax());
         
      return result;
   }
   
   /**
    * Setter for owner.
    *
    * @param ownerIn owner of Vehicle
    */ 
   public void setOwner(String ownerIn) {
      owner = ownerIn;
   }
   
   /**
    * Setter for year, make, model.
    *
    * @param yearMakeModelIn year make and model of vehicle
    */ 
   public void setYearMakeModel(String yearMakeModelIn) {
      yearMakeModel = yearMakeModelIn;
   }
   
   /**
    * Setter for vehicle value.
    *
    * @param valueIn value of vehicle
    * @throws NegativeValueException  when value is negative
    */ 
   public void setValue(double valueIn) throws NegativeValueException {
      if (valueIn < 0) {
         throw new NegativeValueException();
      }
      
      value = valueIn;
   }
   
   /**
    * Setter for alternative fuel.
    *
    * @param altFuelIn boolean for alternative fuel
    */ 
   public void setAlternativeFuel(boolean altFuelIn) {
      altFuel = altFuelIn;
   }
   
   /**
    * Resets Vehicle Count.
    *
    */ 
   public static void resetVehicleCount() {
      vehicleCount = 0;
   }
   
   /**
    * Getter for owner.
    *
    * @return name of owner  
    */ 
   public String getOwner() {
      return owner;
   }
   
   /**
    * Getter for year, make, model.
    *
    * @return year make and model  
    */ 
   public String getYearMakeModel() {
      return yearMakeModel;
   }
   
   /**
    * Getter for vehicle value.
    *
    * @return value of vehicle  
    */ 
   public double getValue() {
      return value;
   }
   
   /**
    * Getter for alternative fuel.
    *
    * @return alternative fuel  
    */ 
   public boolean getAlternativeFuel() {
      return altFuel;
   }
   
   /**
    * Getter for vehicle count.
    *
    * @return number of vehicles instantiated  
    */ 
   public static int getVehicleCount() {
      return vehicleCount;
   }
   
   /** @return 0 */
   public int hashCode() {
      return 0;
   }
}
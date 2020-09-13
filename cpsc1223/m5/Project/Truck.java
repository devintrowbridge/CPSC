/**
* Truck class that stores car data and provides methods
* to access the data.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class Truck extends Vehicle {
  /** Constants. */
      /** Tax rate. */
   public static final double TAX_RATE = 0.02; 

      /** Alt fuel tax rate. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01; 
      
      /** Weight at which additional taxes apply. */
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0; 

   /** Tax rate for large trucks. */
   public static final double LARGE_TRUCK_TAX_RATE = 0.03;
   
   /** Instance Variables. */
   protected double tons = 0.0;
   
   /**
    * Ctor.
    *
    * @param ownerIn vehicle owner
    * @param yearMakeModelIn year make and model of the vehicle
    * @param valueIn value of the vehicle
    * @param altFuelIn true if the vehicle is an alternative fuel vehicle
    * @param tonsIn tonnage of truck
    */
   public Truck(String  ownerIn, 
                String  yearMakeModelIn, 
                double  valueIn, 
                boolean altFuelIn,
                double  tonsIn) {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
      setTons(tonsIn);
   }
   
   /**
    * Returns the total amount for the vehicle's use tax.
    *
    * @return the vehicle's use tax
    */ 
   public double useTax() {
      double tax;
      
      if (altFuel) {
         tax = value * ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         tax = value * TAX_RATE;
      }
      
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         tax += value * LARGE_TRUCK_TAX_RATE;
      }
      
      return tax;
   }
   
   /**
    * Generates the string representation of the truck object.
    *
    * @return string representation of truck.
    */ 
   public String toString() {
      String result = super.toString();
      
      if (altFuel) {
         result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         result += "\nwith Tax Rate: " + TAX_RATE;
      }
         
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         result += " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE;
      }
         
      return result;
   }
   
   /**
    * Setter for tons.
    *
    * @param tonsIn tonnage of truck
    */ 
   public void setTons(double tonsIn) {
      tons = tonsIn;
   }
   
   /**
    * Getter for tons.
    *
    * @return Tonnage of truck  
    */ 
   public double getTons() {
      return tons;
   }
}
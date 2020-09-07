/**
* Motorcycle class that stores car data and provides methods
* to access the data.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class Motorcycle extends Vehicle {
  /** Constants. */
   public static final double TAX_RATE = 0.005; /** */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025; /** */
   public static final double LARGE_BIKE_CC_THRESHHOLD = 499; /** */
   public static final double LARGE_BIKE_TAX_RATE = .015; /** */
   
   /** Instance variables. */
   protected double engineSize = 0.0;
   
   /**
    * Ctor.
    *
    * @param ownerIn vehicle owner
    * @param yearMakeModelIn year make and model of the vehicle
    * @param valueIn value of the vehicle
    * @param altFuelIn true if the vehicle is an alternative fuel vehicle
    * @param engineSizeIn size of engine
    */
   public Motorcycle(String  ownerIn, 
                     String  yearMakeModelIn, 
                     double  valueIn, 
                     boolean altFuelIn,
                     double  engineSizeIn) {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
      setEngineSize(engineSizeIn);
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
      
      if (getEngineSize() > LARGE_BIKE_CC_THRESHHOLD) {
         tax += value * LARGE_BIKE_TAX_RATE;
      }
      
      return tax;
   }
   
   /**
    * Generates the string representation of the car object.
    *
    * @return string representation of car.
    */ 
   public String toString() {
      String result = super.toString();
      
      if (altFuel) {
         result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         result += "\nwith Tax Rate: " + TAX_RATE;
      }
         
      if (getEngineSize() > LARGE_BIKE_CC_THRESHHOLD) {
         result += " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE;
      }
         
      return result;
   }
   
   /**
    * Setter for engine size.
    *
    * @param engineSizeIn engine size of motorcycle
    */ 
   public void setEngineSize(double engineSizeIn) {
      engineSize = engineSizeIn;
   }
   
   /**
    * Getter for engine size.
    *
    * @return engine size of motorcycle
    */ 
   public double getEngineSize() {
      return engineSize;
   }
}
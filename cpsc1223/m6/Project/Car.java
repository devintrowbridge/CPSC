/**
* Car class that stores car data and provides methods
* to access the data.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class Car extends Vehicle {
  /** Constants. */
   public static final double TAX_RATE = 0.01; /** */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005; /** */
   public static final double LUXURY_THRESHOLD = 50000; /** */
   public static final double LUXURY_TAX_RATE = 0.02; /** */
   
   /**
    * Ctor.
    *
    * @param ownerIn vehicle owner
    * @param yearMakeModelIn year make and model of the vehicle
    * @param valueIn value of the vehicle
    * @param altFuelIn true if the vehicle is an alternative fuel vehicle
    * @throws NegativeValueException when value is negative
    */
   public Car(String  ownerIn, 
              String  yearMakeModelIn, 
              double  valueIn, 
              boolean altFuelIn) throws NegativeValueException {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
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
      
      if (value > LUXURY_THRESHOLD) {
         tax += value * LUXURY_TAX_RATE;
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
         
      if (value > LUXURY_THRESHOLD) {
         result += " Luxury Tax Rate: " + LUXURY_TAX_RATE;
      }
         
      return result;
   }
}
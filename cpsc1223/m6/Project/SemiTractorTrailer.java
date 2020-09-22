/**
* Semi Tractor Trailer class that stores car data and provides methods
* to access the data.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class SemiTractorTrailer extends Truck {
   /** Constants. */
   /** Tax rate per axle. */
   public static final double PER_AXLE_TAX_RATE = 0.005; 
   
   /** Instance variables. */
   protected int axles = 0;
   
   /**
    * Ctor.
    *
    * @param ownerIn vehicle owner
    * @param yearMakeModelIn year make and model of the vehicle
    * @param valueIn value of the vehicle
    * @param altFuelIn true if the vehicle is an alternative fuel vehicle
    * @param tonsIn tonnage of truck
    * @param axlesIn number of axles on the truck
    * @throws NegativeValueException when tons/value/axles is negative
    */
   public SemiTractorTrailer(String  ownerIn, 
                             String  yearMakeModelIn, 
                             double  valueIn, 
                             boolean altFuelIn,
                             double  tonsIn,
                             int     axlesIn) throws NegativeValueException {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn, tonsIn);
      if (axlesIn < 0) {
         vehicleCount--;
      }
      setAxles(axlesIn);
   }
   
   /**
    * Returns the total amount for the vehicle's use tax.
    *
    * @return the vehicle's use tax
    */ 
   public double useTax() {
      double tax = super.useTax();
      tax += value * (getAxles() * PER_AXLE_TAX_RATE);
      return tax;
   }
   
   /**
    * Generates the string representation of the truck object.
    *
    * @return string representation of truck.
    */ 
   public String toString() {
      String result = super.toString();
      result += " Axle Tax Rate: " + (PER_AXLE_TAX_RATE * getAxles());
      return result;
   }
   
   /**
    * Setter for axles.
    *
    * @param axlesIn number of axles
    * @throws NegativeValueException when axles is negative
    */ 
   public void setAxles(int axlesIn) throws NegativeValueException {
      if (axlesIn < 0) {
         throw new NegativeValueException();
      }
      axles = axlesIn;
   }
   
   /**
    * Getter for axles.
    *
    * @return Number of axles  
    */ 
   public int getAxles() {
      return axles;
   }
}
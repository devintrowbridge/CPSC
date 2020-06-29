import java.util.ArrayList;

/**
 * Temperatures class that represents a list of temperatures.
 * 
 * Activity 6
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-28
 */   
public class Temperatures {
   private ArrayList<Integer> temperatures 
      = new ArrayList<Integer>();
      
     /**
   * Class constructor.
   * 
   * @param temperaturesIn array of temperatures to work on
   */     
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }

   /**
   * Gets the lowest temp in the array.
   * 
   * @return lowest temp in array
   */ 
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
        
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }

  /**
   * Gets the highest temp in the array.
   * 
   * @return highest temp in the array
   */     
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      
      int high = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) > high) {
            high = temperatures.get(i);
         }
      }
      return high;
   }

  /**
   * Determines if the passed number is lower than the lowest in the array.
   *
   * @param lowIn number to compare to the lowest in the array
   * @return the lower number
   */     
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }

     /**
   * Determines if the passed number is higher than the highest in the array.
   * 
   * @param highIn number to compare to the highest in the array
   * @return the higher number
   */     
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }

   /**
    * Generates a string representation of the temperature
    * object.
    *
    * @return summary of temperature information.
    */   
   public String toString() {
      return "\tTemperatures: " + temperatures
           + "\n\tLow: " + getLowTemp()
           + "\n\tHigh: " + getHighTemp();
   }
}
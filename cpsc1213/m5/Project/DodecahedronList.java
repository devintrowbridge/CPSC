import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Dodecahedron list class that calculates and prints the properties of 
 * an array of Dodecahedron objects.
 *
 * Project 5
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-21
 */
public class DodecahedronList {
   private String mName = "";
   private ArrayList<Dodecahedron> mDodecahedronList 
      = new ArrayList<Dodecahedron>();
   
   /**
    * Class constructor.
    *
    * @param name name of the list
    * @param dodecahedronList array list of dodecahedron objects
    */
   public DodecahedronList(String name, 
                           ArrayList<Dodecahedron> dodecahedronList) {
      mName             = name;
      mDodecahedronList = dodecahedronList;
   }
   
   /**
    * Getter for name member.
    *
    * @return List name
    */
   public String getName() {
      return mName;
   }
   
   /**
    * Get's the number of dodecahedrons in the list.
    *
    * @return number of dodecahedrons.
    */
   public int numberOfDodecahedrons() {
      return mDodecahedronList.size();
   }
   
   /**
    * Sums the surface areas of dodecahedrons in the list.
    *
    * @return sum total surface area of all dodecahedrons in list.
    */
   public double totalSurfaceArea() {
      double output = 0.0;
      int index = 0;
      while (index < numberOfDodecahedrons()) {
         output += mDodecahedronList.get(index).surfaceArea();
         index++;
      }
      return output;
   }
   
   /**
    * Sums the volumes of dodecahedrons in the list.
    *
    * @return sum total volume of all dodecahedrons in list.
    */
   public double totalVolume() {
      double output = 0.0;
      int index = 0;
      while (index < numberOfDodecahedrons()) {
         output += mDodecahedronList.get(index).volume();
         index++;
      }
      return output;
   }
   
   /**
    * Averages the surface areas of dodecahedrons in the list.
    *
    * @return average of the surface areas of all dodecahedrons in list.
    */
   public double averageSurfaceArea() {
      double output = 0.0;
      if (numberOfDodecahedrons() > 0) {
         output = totalSurfaceArea() / numberOfDodecahedrons();
      }
      return output;
   }
   
   /**
    * Averages the volumes of dodecahedrons in the list.
    *
    * @return average of the volumes of all dodecahedrons in list.
    */
   public double averageVolume() {
      double output = 0.0;
      if (numberOfDodecahedrons() > 0) {
         output = totalVolume() / numberOfDodecahedrons();
      }
      return output;
   }
   
   /**
    * Averages the surface to volume ratios of all dodecahedrons in the list.
    *
    * @return average of all surface to volume ratios in list.
    */
   public double averageSurfaceToVolumeRatio() {
      double output = 0.0;
      if (numberOfDodecahedrons() > 0) {
         int index = 0;
         while (index < mDodecahedronList.size()) {
            output += mDodecahedronList.get(index).surfaceToVolumeRatio() 
               / numberOfDodecahedrons();
            index++;
         }
      }
      return output;
   }
   
   /**
    * Generates a string representation of the Dodecahedron list
    * object.
    *
    * @return summary of Dodecahedron list information.
    */
   public String toString() {
      String output = "";
      output += mName + "\n";
      int index = 0;
      while (index < numberOfDodecahedrons()) {
         output += "\n" + mDodecahedronList.get(index).toString() + "\n";
         index++;
      }
      return output;
   }
   
   /**
    * Generates a report of information about the dodecahedron list.
    *
    * @return report of information.
    */
   public String summaryInfo() {
      String output = "";
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      output += "----- Summary for " + mName + " -----";
      output += "\nNumber of Dodecahedrons: " + mDodecahedronList.size();
      output += "\nTotal Surface Area: " + fmt.format(totalSurfaceArea());
      output += "\nTotal Volume: " + fmt.format(totalVolume());
      output += "\nAverage Surface Area: " + fmt.format(averageSurfaceArea());
      output += "\nAverage Volume: " + fmt.format(averageVolume());
      output += "\nAverage Surface/Volume Ratio: " 
                + fmt.format(averageSurfaceToVolumeRatio());
      return output;
   }
}
import java.text.DecimalFormat;

/**
* SpherocylinderList class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-03
*/
public class SpherocylinderList {
   private String mName = "";
   private Spherocylinder[] mList = null;
   private int mLength = 0;

   /**
    * Ctor.
    *
    * @param name list name
    * @param list reference to list to build class off of
    * @param length length of list array
    */
   public SpherocylinderList(String name, Spherocylinder[] list, int length) {
      mName = name;
      mList = list;
      mLength = length;
   }
   
   /**
    * Name getter.
    *
    * @return name of list
    */
   public String getName() {
      return mName;
   }
   
   /**
    * List length getter.
    *
    * @return length of list
    */
   public int numberOfSpherocylinders() {
      return mLength;
   }
   
   /**
    * Calculates the total surface area of all spherocylinders in the list.
    *
    * @return total surface area of all spherocylinders
    */
   public double totalSurfaceArea() {
      double result = 0.0;
      for (int i = 0; i < mLength; i++) {
         result += mList[i].surfaceArea();
      }
      return result;
   }
   
   /**
    * Calculates the total volume of all spherocylinders in the list.
    *
    * @return total volume of all spherocylinders
    */
   public double totalVolume() {
      double result = 0.0;
      for (int i = 0; i < mLength; i++) {
         result += mList[i].volume();
      }
      return result;
   }
   
   /**
    * Calculates the average surface area of all spherocylinders in the list.
    *
    * @return average surface area of all spherocylinders
    */
   public double averageSurfaceArea() {
      double result = 0.0;
      for (int i = 0; i < mLength; i++) {
         result += mList[i].surfaceArea();
      }
      
      // Guard against divide by 0         
      if (mLength != 0) {
         result /= mLength;
      }
      
      return result;
   }
   
   /**
    * Calculates the average volume of all spherocylinders in the list.
    *
    * @return total volume of all spherocylinders
    */
   public double averageVolume() {
      double result = 0.0;
      for (int i = 0; i < mLength; i++) {
         result += mList[i].volume();
      }
      
      // Guard against divide by 0
      if (mLength != 0) {
         result /= mLength;
      }
      
      return result;
   }
   
   /**
    * Generates a string representation of the object.
    *
    * @return string representation of the object
    */
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String result = "----- Summary for " + mName + " -----" 
         + "\nNumber of Spherocylinders: " + mLength
         + "\nTotal Surface Area: " + fmt.format(totalSurfaceArea())
         + "\nTotal Volume: " + fmt.format(totalVolume())
         + "\nAverage Surface Area: " + fmt.format(averageSurfaceArea())
         + "\nAverage Volume: " + fmt.format(averageVolume());
      return result;
   }
   
   /**
    * Gets the list of spherocylinders in the object.
    *
    * @return list of spherocylinders in the object
    */
   public Spherocylinder[] getList() {
      return mList;
   }
   
   /**
    * Adds a spherocylinder to the object.
    *
    * @param label label of spherocylinder
    * @param radius radius of spherocylinder
    * @param cylinderHeight cylinder height of spherocylinder
    */
   public void addSpherocylinder(String label, 
                                 double radius, 
                                 double cylinderHeight) {
      //Create the new object
      Spherocylinder newSC = new Spherocylinder(label, radius, cylinderHeight);
      
      // Find the first null element in the list and add the new object
      int i;
      for (i = 0; i < mList.length; i++) {
         if (mList[i] == null) {
            mList[i] = newSC;
            break;
         }
      }
      
      // If there were no null spots open we need to allocate some more space 
      // for the array to make room for the new object
      if (i == mList.length) {
         // Resize to current size plus 1 times 2.
         Spherocylinder[] newList = new Spherocylinder[(mList.length + 1) * 2];
         
         // Transfer all of the objects from the old list into the new one
         int j;
         for (j = 0; j < mLength; j++) {
            newList[j] = mList[j];
         }
         newList[j] = newSC;
         
         // Point the old list at the new one
         mList = newList;
      }
      
      mLength++; // Remember to increment the object counter
   }
   
   /**
    * Finds a spherocylinder in the list.
    *
    * @param label search key, case insensitive
    * @return the spherocylinder if found, null otherwise
    */
   public Spherocylinder findSpherocylinder(String label) {
      Spherocylinder result = null;
      for (int i = 0; i < mLength; i++) {
         if (label.equalsIgnoreCase(mList[i].getLabel())) {
            result = mList[i];
            break;
         }
      }
      return result;
   }
   
   /**
    * Deletes a spherocylinder in the list.
    *
    * @param label search key
    * @return the spherocylinder if found and deleted, null otherwise
    */
   public Spherocylinder deleteSpherocylinder(String label) {
     // Find the spherocylinder first
      Spherocylinder sc = findSpherocylinder(label);
      
      boolean found = false;
      // If we found it, try to delete it
      if (sc != null) {
         // Find the object in the list and null it
         for (int i = 0; i < mLength; i++) {
            if (sc.equals(mList[i])) {
               found = true;
            }
            if (found) {
               mList[i] = mList[i + 1];
            }
         }
      
         mLength--; // Remember to decrememnt the object counter
         mList[mLength] = null;
      }
      
      return sc;
   }
   
   /**
    * Edits a spherocylinders in the list.
    *
    * @param label search key
    * @param radius new radius
    * @param height new cylinder height
    * @return true if successful, false otherwise
    */
   public boolean editSpherocylinder(String label, 
                                     double radius, 
                                     double height) {
      // Find the spherocylinder first
      Spherocylinder sc = findSpherocylinder(label);
      boolean result = false;
      
      if (sc != null) {
         result = true;
         sc.setRadius(radius);
         sc.setCylinderHeight(height);
      }
      
      return result;
   }
   
   /**
    * Finds the spherocylinder with the largest volume in the list.
    *
    * @return the spherocylinder with the largest volme
    */
   public Spherocylinder findSpherocylinderWithLargestVolume() {
      Spherocylinder result = null;
      double largestVolume;
      
      // Make sure the list has a length
      if (mList.length != 0) {
         result = mList[0];
         
         // Loop over everything in the list
         for (int i = 0; i < mLength; i++) {
            if (mList[i].volume() > result.volume()) {
               result = mList[i];
            }
         }
      }
      
      return result;
   }
}
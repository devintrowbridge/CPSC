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
   
   }
   
   /**
    * Name getter.
    *
    * @return name of list
    */
   public String getName() {
      return "";
   }
   
   /**
    * List length getter.
    *
    * @return length of list
    */
   public int numberOfSpherocylinders() {
      return 0;
   }
   
   /**
    * Calculates the total surface area of all spherocylinders in the list.
    *
    * @return total surface area of all spherocylinders
    */
   public double totalSurfaceArea() {
      return 0.0;
   }
   
   /**
    * Calculates the total volume of all spherocylinders in the list.
    *
    * @return total volume of all spherocylinders
    */
   public double totalVolume() {
      return 0.0;
   }
   
   /**
    * Calculates the average surface area of all spherocylinders in the list.
    *
    * @return average surface area of all spherocylinders
    */
   public double averageSurfaceArea() {
      return 0.0;
   }
   
   /**
    * Calculates the average volume of all spherocylinders in the list.
    *
    * @return total volume of all spherocylinders
    */
   public double averageVolume() {
      return 0.0;
   }
   
   /**
    * Generates a string representation of the object.
    *
    * @return string representation of the object
    */
   public String toString() {
      return null;
   }
   
   /**
    * Gets the list of spherocylinders in the object.
    *
    * @return list of spherocylinders in the object
    */
   public Spherocylinder[] getList() {
      return null;
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
      
   }
   
   /**
    * Finds a spherocylinder in the list.
    *
    * @param label search key, case insensitive
    * @return the spherocylinder if found, null otherwise
    */
   public Spherocylinder findSpherocylinder(String label) {
      return null;
   }
   
   /**
    * Deletes a spherocylinder in the list.
    *
    * @param label search key
    * @return the spherocylinder if found and deleted, null otherwise
    */
   public Spherocylinder deleteSpherocylinder(String label) {
      return null;
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
      return true;
   }
   
   /**
    * Finds the spherocylinder with the largest volume in the list.
    *
    * @return the spherocylinder with the largest volme
    */
   public Spherocylinder findSpherocylinderWithLargestVolume() {
      return null;
   }
}
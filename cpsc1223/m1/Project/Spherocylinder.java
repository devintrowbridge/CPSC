import java.text.DecimalFormat;

/**
* Test class for BankLoan class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-08-18
*/
public class Spherocylinder {
   private String mLabel = "";
   private double mRadius = 0.0;
   private double mCylinderHeight = 0.0;
   
   private static int mCount = 0;
   
 /**
 * Class constructor.
 *
 * @param label label for the object
 * @param radius radius of the spherocylinder's end cap
 * @param cylinderHeight height of the spherocylinder's cylinder
 */
   Spherocylinder(String label, double radius, double cylinderHeight) {
      mCount++;
      setLabel(label);
      setRadius(radius);
      setCylinderHeight(cylinderHeight);
   }
   
   /**
    * Gets the label property.
    *
    * @return label property
    */      
   public String getLabel() {
      return mLabel;
   }
   
   /**
    * Sets the label property.
    *
    * @param label string to set label property to
    * @return true if successful
    */      
   public boolean setLabel(String label) {
      boolean success = false;
      if (label != null) {
         mLabel = label.trim();
         success = true;
      }
      return success;
   }
   
   /**
    * Gets the radius property.
    *
    * @return radius property
    */      
   public double getRadius() {
      return mRadius;
   }
   
   /**
    * Sets the radius property.
    *
    * @param radius radius to set radius property to
    * @return true if successful
    */      
   public boolean setRadius(double radius) {
      boolean success = false;
      if (radius >= 0) {
         mRadius = radius;
         success = true;
      }
      return success;
   }
   
   /**
    * Gets the cylinder height property.
    *
    * @return cylinder height property
    */      
   public double getCylinderHeight() {
      return mCylinderHeight;
   }
   
   /**
    * Sets the cylinder height property.
    *
    * @param cylinderHeight cylinder height to set cylinder height property to
    * @return true if successful
    */      
   public boolean setCylinderHeight(double cylinderHeight) {
      boolean success = false;
      if (cylinderHeight >= 0) {
         mCylinderHeight = cylinderHeight;
         success = true;
      }
      return success;
   }
   
   /**
    * Gets the circumference.
    *
    * @return circumference
    */      
   public double circumference() {
      return 2 * Math.PI * getRadius();
   }
   
   /**
    * Gets the surface area.
    *
    * @return circumference
    */      
   public double surfaceArea() {
      return circumference() * (2 * getRadius() + getCylinderHeight());
   }
   
   /**
    * Gets the surface area.
    *
    * @return circumference
    */      
   public double volume() {
      return Math.PI * getRadius() * getRadius() 
             * (getCylinderHeight() + ((4.0 * getRadius()) / 3.0));
   }
   
   /**
    * Converts object into a string.
    *
    * @return string representation of object
    */      
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return 
         "Spherocylinder \"" + getLabel() 
         + "\" with radius " + fmt.format(getRadius()) 
         + " and cylinder height " + fmt.format(getCylinderHeight()) 
         + " has:\n"
         + "\tcircumference = " + fmt.format(circumference()) + " units\n"
         + "\tsurface area = " + fmt.format(surfaceArea()) + " square units\n"
         + "\tvolume = " + fmt.format(volume()) + " cubic units";   
   } 
   
   /**
    * Gets total count of objects instantiated.
    *
    * @return instantiation total
    */      
   public static int getCount() {
      return mCount;
   }
   
   /**
    * Gets total count of objects instantiated.
    */      
   public static void resetCount() {
      mCount = 0;
   }
   
   /**
    * Equality function to test equivalence of two spherocylinder objects.
    *
    * @param obj object to test equivalence against
    * @return true if equivalent
    */      
   public boolean equals(Object obj) {
      if (!(obj instanceof Spherocylinder)) {
         return false;
      }
      else {
         Spherocylinder d = (Spherocylinder) obj;
         return 
            (mLabel.equalsIgnoreCase(d.getLabel())
            && Math.abs(mRadius - d.getRadius()) < 0.000001
            && Math.abs(mCylinderHeight - d.getCylinderHeight()) < 0.000001);
      }
   }
   
   /**
    * Necessary for checkstyle to function.
    *
    * @return zero
    */      
   public int hashCode() {
      return 0;
   }
}
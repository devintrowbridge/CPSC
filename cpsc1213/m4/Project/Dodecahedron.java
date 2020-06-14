import java.text.DecimalFormat;

/**
 * Class that represents a Dodecahedron.
 *
 * Project 4
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-13
 */
public class Dodecahedron {
   private String mLabel = "";
   private String mColor = "";
   private double mEdge = 0.0;
   
  /**
   * Constructor. Initializes member variables.
   * 
   * @param label Dodecahedron's label.
   * @param color Dodecahedron's color.
   * @param edge  Dodecahedron's edge length.
   */
   public Dodecahedron(String label, String color, double edge) {
      setLabel(label);
      setColor(color);
      setEdge(edge);
   }
   
   /**
    * Get's the Dodecahedron's label.
    * 
    * @return Dodecahedron's label.
    */
   public String getLabel() {
      return mLabel;
   }
   
   /**
    * Set's the Dodecahedron's label.
    * 
    * @param label Dodecahedron's label.
    * @return success or fail.
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
    * Get's the Dodecahedron's color.
    * 
    * @return Dodecahedron's color.
    */
   public String getColor() {
      return mColor;
   }
   
   /**
    * Set's the Dodecahedron's color.
    * 
    * @param color Dodecahedron's color.
    * @return success or fail.
    */
   public boolean setColor(String color) {
      boolean success = false;
      if (color != null) {
         mColor = color.trim();
         success = true;
      }
      return success;
   }
   
   /**
    * Get's the Dodecahedron's edge length.
    * 
    * @return Dodecahedron's edge length.
    */
   public double getEdge() {
      return mEdge;
   }
   
   /**
    * Set's the Dodecahedron's edge length.
    * 
    * @param edge Dodecahedron's edge length.
    * @return success or fail.
    */
   public boolean setEdge(double edge) {
      boolean success = false;
      if (edge > 0) {
         mEdge = edge;
         success = true;
      }
      return success;
   }
   
   /**
    * Get's the Dodecahedron's surface area.
    * 
    * @return Dodecahedron's surface area.
    */
   public double surfaceArea() {
      return mEdge * mEdge * 3 * Math.sqrt(25 + (10 * Math.sqrt(5)));
   }
   
   /**
    * Get's the Dodecahedron's volume.
    *
    * @return Dodecahedron's volume.
    */
   public double volume() {
      return mEdge * mEdge * mEdge * (15 + (7 * Math.sqrt(5))) / 4; 
   }
   
   /**
    * Get's the Dodecahedron's surface to volume ratio.
    *
    * @return Dodecahedron's surface to volume ratio.
    */
   public double surfaceToVolumeRatio() {
      return surfaceArea() / volume();
   }
   
   /**
    * Generates a string representation of the Dodecahedron
    * object.
    *
    * @return summary of Dodecahedron information.
    */
   public String toString() {
      String output = "";
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
   
      output += "Dodecahedron \"";
      output += getLabel() + "\" is \"";
      output += getColor() + "\" with 30 edges of length ";
      output += fmt.format(getEdge()) + " units.\n";
      
      output += "\tsurface area = ";
      output += fmt.format(surfaceArea()) + " square units\n";
      
      output += "\tolume = "; 
      output += fmt.format(volume()) + " cubic units\n";
      
      output += "\tsurface/volume ratio = ";
      output += fmt.format(surfaceToVolumeRatio());
         
      return output;
   }
}
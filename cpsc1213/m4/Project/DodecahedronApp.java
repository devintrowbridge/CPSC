import java.util.Scanner;

/**
 * Dodecahedron application that calculates and prints the properties of a 
 * Dodecahedron with a user given edge length.
 *
 * Project 4
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-13
 */
public class DodecahedronApp {

   /**
    * Calculates and prints the properties of a Dodecahedron with a user 
    * given edge length.
    *
    * @param args Command line arguments - not used
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);  
      Dodecahedron myDodecahedron = new Dodecahedron("", "", 0.0);
   
      // Get user input
      System.out.println("Enter label, color, and edge length for a "
                       + "dodecahedron.");
      System.out.print("\tlabel: ");
      myDodecahedron.setLabel(userInput.nextLine());
      System.out.print("\tcolor: ");
      myDodecahedron.setColor(userInput.nextLine());
      System.out.print("\tedge: ");
      double edge = Double.parseDouble(userInput.nextLine());
      
      // Check to see if we have a valid edge length first
      if (myDodecahedron.setEdge(edge)) {
         // If its greater than 0, print the Dodecahedron.
         System.out.print("\n" + myDodecahedron);
      }
      else {
         System.out.println("Error: edge must be greater than 0.");            
      }
   }
}
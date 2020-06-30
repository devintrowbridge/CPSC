import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Dodecahedron list application that prints the properties of 
 * an array of Dodecahedron objects read from a given file.
 * 
 * Project 5
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-21
 */
public class DodecahedronListMenuApp {
   
  /**
    * Scans a provided plain text file for dodecahedron data and prints a 
    * report about the scanned data.
    *
    * @param args Command line arguments - not used
    * @throws FileNotFoundException if passed file name can't be found
    */
   public static void main(String[] args) throws FileNotFoundException {
     // Initialize variables
      Scanner cliScan = new Scanner(System.in);
      ArrayList<Dodecahedron> dodecahedronArrayList 
         = new ArrayList<Dodecahedron>();
      String listName = "*** no list name assigned ***";
      DodecahedronList myDodecList 
         = new DodecahedronList(listName, dodecahedronArrayList);
      
      // Setup some temp variables
      Dodecahedron tempDodecahedron;
      String label;
      String color;
      double edge;
      char choice;
      
      // Print the system menu
      printSystemMenu();
   
      do {
         // Reset all of the temp variables at the start so we don't carry data
         // from previous loops
         tempDodecahedron = null;
         label = "";
         color = "";
         edge = 0;
         choice = ' ';
      
         // Grab the next command to process
         System.out.print("\nEnter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = cliScan.nextLine().toUpperCase().charAt(0);
         
         // Pick which operation to execute
         switch(choice) {
            case 'R': // Read a file
               System.out.print("\tFile name: ");
               myDodecList = DodecahedronList.readFile(cliScan.nextLine());
               if (myDodecList.getList().size() > 0) {
                  System.out.println(
                     "\tFile read in and Dodecahedron List created");
               } else {
                  System.out.println("\tUnable to read file");
               }
               break;
               
            case 'P': // Print the list
               System.out.print(myDodecList);
               break;
               
            case 'S': // Print the summary
               System.out.println("\n" + myDodecList.summaryInfo());
               break;
                  
            case 'A': // Add a dodecahedron to the list
               System.out.print("\tLabel: ");
               label = cliScan.nextLine();
               System.out.print("\tColor: ");                  
               color = cliScan.nextLine();
               System.out.print("\tEdge: ");                  
               edge  = Double.parseDouble(cliScan.nextLine());
               myDodecList.addDodecahedron(label, color, edge);
               if (myDodecList.findDodecahedron(label) != null) {
                  System.out.println("\t*** Dodecahedron added ***");
               }
               else {
                  System.out.println("\t*** Dodecahedron not added ***");
               }
               break;
               
            case 'D': // Delete a dodecahedron from the list
               System.out.print("\tLabel: ");
               label = cliScan.nextLine();
               if (myDodecList.deleteDodecahedron(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted");
               } 
               else {
                  System.out.println("\t\"" + label + "\" not found");
               }
               break;
               
            case 'F': // Find a dodecahedron in the list
               System.out.print("\tLabel: ");
               label = cliScan.nextLine();
               tempDodecahedron = myDodecList.findDodecahedron(label);
               if (tempDodecahedron != null) {
                  System.out.println(tempDodecahedron);
               } 
               else {
                  System.out.println("\t\"" + label + "\" not found");
               }
               break;
               
            case 'E': // Edit a dodecahedron from the list
               System.out.print("\tLabel: ");
               label = cliScan.nextLine();
               System.out.print("\tColor: ");                  
               color = cliScan.nextLine();
               System.out.print("\tEdge: ");
               edge  = Double.parseDouble(cliScan.nextLine());
               if (myDodecList.editDodecahedron(label, color, edge)) {
                  System.out.println("\t\"" + label + "\" successfully edited");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found");
               }
               break;
               
            case 'Q': // Quit
               break;
            
            default:
               System.out.println("\t*** invalid code ***");
         }
      } while (choice != 'Q');
   }
   
  /**
    * Prints the system menu to system out.
    *
    */      
   public static void printSystemMenu() {
      System.out.print(
           "Dodecahedron List System Menu\n" 
         + "R - Read File and Create Dodecahedron List\n" 
         + "P - Print Dodecahedron List\n" 
         + "S - Print Summary\n" 
         + "A - Add Dodecahedron\n" 
         + "D - Delete Dodecahedron\n" 
         + "F - Find Dodecahedron\n" 
         + "E - Edit Dodecahedron\n" 
         + "Q - Quit");
   }
}

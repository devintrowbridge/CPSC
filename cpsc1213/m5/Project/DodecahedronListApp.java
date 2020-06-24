import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Dodecahedron list application that prints the properties of 
 * an array of Dodecahedron objects read from a given file.
 * 
 * Project 5
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-21
 */
public class DodecahedronListApp {
   
  /**
    * Scans a provided plain text file for dodecahedron data and prints a 
    * report about the scanned data.
    *
    * @param args Command line arguments - not used
    * @throws FileNotFoundException if passed file name can't be found
    */
   public static void main(String[] args) throws FileNotFoundException {
     // Initialize variables
      Scanner cliScan, fileScan;
      ArrayList<Dodecahedron> dodecahedronArrayList 
         = new ArrayList<Dodecahedron>();
      String listName;
      String label, color;
      double edge;
   
      // Get file name from the command line interface
      cliScan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      fileScan = new Scanner(new File(cliScan.nextLine()));
      
      listName = fileScan.nextLine();
      
      // While there is still data in the file, keep grabbing lines
      // WARNING: Undefined behavior when the number of lines after the list 
      // name is not divisible by 3.
      while (fileScan.hasNext()) {
         label = fileScan.nextLine();
         color = fileScan.nextLine();
         edge  = Double.parseDouble(fileScan.nextLine());
         dodecahedronArrayList.add(new Dodecahedron(label, color, edge));
      }
      
      // Stuff it into the dodecahedron list class
      DodecahedronList dodecahedronList 
         = new DodecahedronList(listName, dodecahedronArrayList);
      
      // Print output
      System.out.print("\n" + dodecahedronList);
      System.out.print("\n\n" + dodecahedronList.summaryInfo());
   }
}

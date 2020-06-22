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
    */
   public static void main(String[] args) throws FileNotFoundException {
      Scanner cliScan, fileScan;
      ArrayList<Dodecahedron> dodecahedronArrayList 
         = new ArrayList<Dodecahedron>();
      String listName;
      String label, color;
      double edge;
   
      cliScan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      fileScan = new Scanner(new File(cliScan.nextLine()));
      
      listName = fileScan.nextLine();
      
      while (fileScan.hasNext()) {
         label = fileScan.nextLine();
         color = fileScan.nextLine();
         edge  = Double.parseDouble(fileScan.nextLine());
         dodecahedronArrayList.add(new Dodecahedron(label, color, edge));
      }
      
      DodecahedronList dodecahedronList 
         = new DodecahedronList(listName, dodecahedronArrayList);
      
      
      System.out.print("\n" + dodecahedronList);
      System.out.print("\n\n" + dodecahedronList.summaryInfo());
   }
}

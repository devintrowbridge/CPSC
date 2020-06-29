import java.util.ArrayList;
import java.util.Scanner;

/**
 * Temperature Info list application that prints the properties of 
 * an array of temperatures objects read from user input.
 * 
 * Activity 6 
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-28
 */   
public class TemperatureInfo {

  /**
    * Reads temperatures from the CLI, and presents options to the user
    * for interactive with the array of entered temps.
    *
    * @param args Command line arguments - not used
    */   
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      ArrayList<Integer> tempsList 
         = new ArrayList<Integer>();
   
      // Read in the temperatures
      String tempInput = "";            
      do {
         System.out.print("Enter a temperature (or nothing to end list): ");
         tempInput = userInput.nextLine().trim();
         if (!tempInput.equals("")) {
            tempsList.add(Integer.parseInt(tempInput));
         }
      } while (!tempInput.equals(""));
      
      Temperatures temps = new Temperatures(tempsList);
      
      // Do operations on the temp array
      char choice = 'E';
      do {
         System.out.print("Enter choice - "
            + "[L]ow temp, [H]igh temp, [P]rint, [E]nd: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch(choice) {
            case 'L':
               System.out.println("\tLow is " + temps.getLowTemp());
               break;
               
            case 'H':
               System.out.println("\tHigh is " + temps.getHighTemp());
               break;
               
            case 'P':
               System.out.println(temps);
               break;
               
            case 'E':
               System.out.println("\tDone");
               break;
         
            default:
               System.out.println("\tInvalid choice!");                  
         }
         
      } while (choice != 'E');
   }
}
import java.util.Scanner;

/**
 * Displays someone's name, age, gender, and max heart rate. 
 *
 * Activity 2
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-05-30
 */
public class AgeStatistics {

  /**
   * Gets a user's name, age, and gender and uses that information to 
   * compute age (in minutes and centuires) and max heart rate. 
   * @param args Command line arguments - not used
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageInYears = 0;
      int gender = 0;
      double maxHeartRate = 0;
      
      // Prompt the user for their name:
      System.out.print("Enter your name: ");
      name = userInput.nextLine();
      
      // Prompt the user for their age:
      System.out.print("Enter your age in years: ");
      ageInYears = userInput.nextInt();
      
      // Prompt the user for their gener:
      System.out.print("Enter your gender (1 for female and 0 for male): ");
      gender = userInput.nextInt();
      
      // Convert age
      // Minutes
      System.out.println("\tYour age in minutes is " 
                         + (ageInYears * 525600) + " minutes.");
      // Centuries                            
      System.out.println("\tYour age in centuries is " 
                         + ((double) ageInYears / 100) + " centuries");
                         
      // display max heart rate
      System.out.print("Your max heart rate is ");
      if (gender == FEMALE) { // calculate female MHR
         maxHeartRate = 209 - (0.7 * ageInYears);
      }
      else { // calculate male MHR
         maxHeartRate = 214 - (0.8 * ageInYears);
      }
      System.out.println(maxHeartRate + " beats per minute.");               
   }
   
   static final int FEMALE = 1;
   static final int MALE = 0;
}
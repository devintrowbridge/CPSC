import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

/**
 * Accepts coded space ticket information as input and returns 
 * a description of the decoded ticket information.
 *
 * Project 3
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-07
 */
public class SpaceTicket {
   static final double STUDENT_DISCOUNT = .25;
   static final double CHILD_DISCOUNT = .35;
   static final int    PRIZE_POOL = 999999;
   static final String FIELD_PAD = "   ";
   
  /**
   * Decodes space ticket information.
   * 
   * @param args Command line arguments - not used
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String inStr;
      String rawInStr;
      
      System.out.print("Enter ticket code: ");
      rawInStr = userInput.nextLine();
      inStr = rawInStr.trim();
   
      // If we don't have a valid ticket, skip processing and display
      // an error message.
      if (inStr.length() >= 25) {
         DecimalFormat currencyFmt = new DecimalFormat("#,##0.00");
         DecimalFormat prizeFmt    = new DecimalFormat("000000");
         Random generator = new Random();
         
         double price;
         char category;
         String time;
         String date;
         String seat;
         String description;
         
         // Grab all the data from the input string
         price = Double.parseDouble(inStr.substring(0, 0 + 8)) / 100;
         category = inStr.charAt(8); 
         time = String.format("%s:%s",
                              inStr.substring(9, 9 + 2),
                              inStr.substring(11, 11 + 2));
         date = String.format("%s/%s/%s", 
                              inStr.substring(13, 13 + 2), 
                              inStr.substring(15, 15 + 2), 
                              inStr.substring(17, 17 + 4));
         seat = inStr.substring(21, 21 + 3);
         description = inStr.substring(24);
         
         // Print it 
         System.out.println("Space Ticket: " + description);
         System.out.print("Date: " + date + FIELD_PAD);            
         System.out.print("Time: " + time + FIELD_PAD);            
         System.out.println("Seat: " + seat);
         System.out.print("Price: $" + currencyFmt.format(price) + FIELD_PAD);
         System.out.print("Category: " + category + FIELD_PAD);
      
         // Calculate and print cost
         String costLabel = "Cost: $";
         if (category == 's') {
            System.out.println(costLabel 
               + currencyFmt.format(price * (1 - STUDENT_DISCOUNT)));
         }
         else if (category == 'c') {
            System.out.println(costLabel 
               + currencyFmt.format(price * (1 - CHILD_DISCOUNT)));
         }
         else if (category == 'x') {
            System.out.println(costLabel 
               + currencyFmt.format(price));
         }
         else {
            System.out.println("Cost: Unknown Category, no discount applied");
         }
         
         // Generate a and print a prize number
         int prize = generator.nextInt(PRIZE_POOL);
         System.out.println("Prize Number: " + prizeFmt.format(++prize));
      }
      else { // Invalid ticket code
         System.out.println(" *** Invalid ticket code ***"
            + "\nTicket code must have at least 25 characters.");
      }
   }
}
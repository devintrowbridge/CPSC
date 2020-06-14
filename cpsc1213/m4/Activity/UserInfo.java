/**
 * Class that represents a user's information.
 *
 * Activity 4
 * @author Devin Trowbridge CPSC-1213-AO1
 * @version 2020-06-13
 */
public class UserInfo {
   // instance variables
   private static final int OFFLINE = 0;
   private static final int ONLINE  = 1;      

   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   
   // constructor
  /**
   * Constructor. Initializes member variables.
   * 
   * @param firstNameIn User's first name.
   * @param lastNameIn User's last name.
   */
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName  = lastNameIn;
      
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }
   
   // methods
  /**
   * Returns the string representation of the UserInfo object.
   * 
   * @return Summary of user info.
   */
   public String toString() {
      String output = "Name: " + firstName + " " + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";         
      }
      return output;
   }
   
  /**
   * Sets the location of the User.
   * 
   * @param locationIn location to set to
   */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
  /**
   * Sets the age of the User.
   * 
   * @param ageIn age to set to
   * @return whether the age was set successfully
   */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   
  /**
   * Returns the age of the User.
   * 
   * @return the age of the user.
   */
   public int getAge() {
      return age;
   }
   
  /**
   * Returns the location of the User.
   * 
   * @return the location of the user.
   */
   public String getLocation() {
      return location;
   }
   
  /**
   * Allows a User to log off.
   * 
   */
   public void logOff() {
      status = OFFLINE;
   }
   
  /**
   * Allows a User to log on.
   * 
   */
   public void  logOn() {
      status = ONLINE;
   }
}


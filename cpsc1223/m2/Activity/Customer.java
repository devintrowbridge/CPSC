   /** 
 * Customer class.
 *
 * @author Devin Trowbridge
 * @version 2020-08-20
 */
public class Customer implements Comparable<Customer> {
   private String mName = "";
   private String mLocation = "";
   private double mBalance = 0.0;
   
   /**
    * Constructor.
    *
    * @param name name of the customer
    */
   public Customer(String name) {
      mName = name;
      mLocation = "";
      mBalance = 0.0;
   }
   
   /**
    * Sets the location for the customer.
    *
    * @param location location of the customer
    */
   public void setLocation(String location) {
      mLocation = location;
   }
   
   /**
    * Sets the location for the customer.
    *
    * @param city city the customer lives in
    * @param state state the customer lives in
    */
   public void setLocation(String city, String state) {
      mLocation = city + ", " + state;
   }
   
   /**
    * Add amount to balance.
    *
    * @param amount amount to add (negative value will subtract from balance)
    */
   public void changeBalance(double amount) {
      mBalance += amount;
   }
   
   /**
    * Get customer's location.
    *
    * @return customer's location
    */
   public String getLocation() {
      return mLocation;
   }
   
   /**
    * Get customer's balance.
    *
    * @return customer's balance
    */
   public double getBalance() {
      return mBalance;
   }
   
   /**
    * Converts object into a string.
    *
    * @return string representation of object
    */
   public String toString() {
      return 
         mName + "\n"
         + getLocation() + "\n"
         + "$" + getBalance();
   }
   
   /**
    * Compares balances of two customer objects.
    *
    * @param obj customer object to compare against
    * @return 0 if equal, -1 if less than obj, 1 if greater than obj
    */
   public int compareTo(Customer obj) {
      if (Math.abs(this.mBalance - obj.getBalance()) < 0.000001) {
         return 0;
      }
      else if (this.mBalance < obj.getBalance()) {
         return -1;
      }
      else {
         return 1;
      }
   }
}
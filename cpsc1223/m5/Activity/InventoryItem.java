/**
* Class for representation of an inventory item in a store.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class InventoryItem {
   protected String name = "";
   protected double price = 0.0;
   private static double taxRate = 0.0;
   
   /**
    * Ctor.
    *
    * @param nameIn name of inventory item
    * @param priceIn price of inventory item
    */   
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }
   
   /**
    * Getter for name.
    *
    * @return name of item
    */   
   public String getName() {
      return name;
   }
   
   /**
    * Calculates the total cost of item including tax.
    *
    * @return total cost of item
    */      
   public double calculateCost() {
      return price * (1 + taxRate);
   }
   
   /**
    * Setter for static tax rate member.
    *
    * @param taxRateIn new tax rate
    */   
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }
   
   /**
    * Converts item object to a string.
    *
    * @return string representation of item
    */   
   public String toString() {
      return name + ": $" + calculateCost();
   }
}
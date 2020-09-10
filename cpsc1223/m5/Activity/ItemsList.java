/**
* Class for representing a list of items in an online store.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-09
*/
public class ItemsList {
   private InventoryItem[] inventory = null;
   private int             count     = 0;
   
   
  /**
    * Ctor.
    *
    */
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }
   
   /**
    * Adds item to the items list.
    * @param itemIn item to add to list
    */
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      ++count;
   }
   
   /**
    * Calculates total cost of items in list.
    * @param electronicsSurcharge surcharge for electronics items
    * @return total cost of items in list
    */
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0.0;
      
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            total += inventory[i].calculateCost();
         }
      }
      
      return total;
   }
   
   /**
    * Generates string representation of items list.
    * @return string representation of items list
    */
   public String toString() {
      String output = "All inventory:\n\n";
      
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      }
      
      return output;
   }
}
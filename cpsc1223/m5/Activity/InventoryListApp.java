/**
* Application for inventory list.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-09
*/
public class InventoryListApp {
   /**
    * Entry point for app.
    * @param args not used
    */
   public static void main(String[] args) {
      // Initialize some things
      ItemsList myItems = new ItemsList();
      InventoryItem.setTaxRate(.05);
      
      // Add items to list
      myItems.addItem(new ElectronicsItem("laptop", 1234.56, 10));
      myItems.addItem(new InventoryItem("motor oil", 9.8));
      myItems.addItem(new OnlineBook("All Things Java", 12.3));
      myItems.addItem(new OnlineArticle("Useful Acronyms", 3.4));
      
      System.out.println(myItems);
      System.out.println("Total: " + myItems.calculateTotal(2.0));
   }
}
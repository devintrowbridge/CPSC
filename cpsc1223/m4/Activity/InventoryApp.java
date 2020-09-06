/**
* Inventory application.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class InventoryApp {
   protected String author = "Author Not Listed";
   
   /**
    * Program entry point.
    *
    * @param args not used
    */
   public static void main(String[] args) {
      InventoryItem.setTaxRate(0.05);
      
      InventoryItem   item1 = new InventoryItem("Oil change kit", 39.0);
      ElectronicsItem item2 = new ElectronicsItem("Cordless phone", 80.0, 1.8);
      OnlineArticle   item3 = new OnlineArticle("Java News", 8.5);
      OnlineBook      item4 = new OnlineBook("Java for Noobs", 13.37);
      
      item3.setWordCount(700);
      item4.setAuthor("L. G. Jones");
      
      InventoryItem[] itemArr = {item1, item2, item3, item4};
      for (InventoryItem item : itemArr) {
         System.out.println(item);
      }
   }
}
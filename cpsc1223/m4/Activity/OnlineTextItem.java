/**
* Class for representation of an online text item in a store.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public abstract class OnlineTextItem extends InventoryItem {
   
   /**
    * Ctor.
    *
    * @param nameIn name of item
    * @param priceIn price of item
    */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Calculates the total cost of item including tax and shipping.
    *
    * @return total cost of item
    */ 
   public double calculateCost() {
      return price;
   }
}
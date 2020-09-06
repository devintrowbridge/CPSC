/**
* Class for representation of an electronics item in a store.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class ElectronicsItem extends InventoryItem {
   protected double weight = 0.0;
   protected static final double SHIPPING_COST = 1.5;
   
   /**
    * Ctor.
    *
    * @param nameIn name of item
    * @param priceIn price of item
    * @param weightIn weight of item
    */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }
   
   /**
    * Calculates the total cost of item including tax and shipping.
    *
    * @return total cost of item
    */ 
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}
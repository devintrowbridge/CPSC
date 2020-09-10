/**
* Class for representation of an online book in a store.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class OnlineBook extends OnlineTextItem {
   protected String author = "Author Not Listed";
   
   /**
    * Ctor.
    *
    * @param nameIn name of item
    * @param priceIn price of item
    */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Converts item object to a string.
    *
    * @return string representation of item
    */   
   public String toString() {
      return name + " - " + author + ": $" + super.calculateCost();
   }
   
   /**
    * Author count setter.
    *
    * @param authorIn new author
    */ 
   public void setAuthor(String authorIn) {
      author = authorIn;
   }
}
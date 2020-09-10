/**
* Class for representation of an online article in a store.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-06
*/
public class OnlineArticle extends OnlineTextItem {
   private int wordCount = 0;
   
   /**
    * Ctor.
    *
    * @param nameIn name of item
    * @param priceIn price of item
    */
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Word count setter.
    *
    * @param wordCountIn new word count
    */ 
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}
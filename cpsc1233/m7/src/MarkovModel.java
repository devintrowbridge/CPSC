import java.io.File;
import java.util.*;
import java.io.IOException;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Devin Trowbridge (dkt0003@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-11-30
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...
   private String firstKgram = "";


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      if (K > sourceText.length()) return;

      firstKgram = sourceText.substring(0, K);
      String kgram = "";
      for (int i = 0; i < sourceText.length() - K; ++i) {
         kgram = sourceText.substring(i, i+K);
         String kgramChars = model.get(kgram);

         // If we found the kgram, append character after the kgram to the end
         // Else create a new string using the character after the kgram
         if (kgramChars != null) {
            kgramChars += sourceText.charAt(i+K);
         }
         else {
            kgramChars = String.valueOf(sourceText.charAt(i+K));
         }

         model.put(kgram, kgramChars);
      }

      model.put(sourceText.substring(sourceText.length()-K), "");
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return firstKgram;
   }


   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      Object[] kgrams = getAllKgrams().toArray();
      if (kgrams.length == 0) return "";
      Random rand = new Random();

      int randInt = rand.nextInt(kgrams.length);
      return kgrams[randInt].toString();
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      String charDist = model.get(kgram);
      if (charDist == null || charDist.length() == 0) return '\0';
      Random rand = new Random();

      int randInt = rand.nextInt(charDist.length());
      return charDist.charAt(randInt);
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    @Override
    public String toString() {
      return model.toString();
   }

}

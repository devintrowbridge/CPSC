import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * TextGenerator.java. Creates an order K Markov model of the supplied source
 * text, and then outputs M characters generated according to the model.
 *
 * @author     Devin Trowbridge (dkt0003@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-11-30
 *
 */
public class TextGenerator {

   /** Drives execution. */
   public static void main(String[] args) {

      if (args.length < 3) {
         System.out.println("Usage: java TextGenerator k length input");
         return;
      }

      // No error checking! You may want some, but it's not necessary.
      int K = Integer.parseInt(args[0]);
      int M = Integer.parseInt(args[1]);
      if ((K <= 0) || (M <= 0)) {
         System.out.println("Error: Both K and M must be positive");
         return;
      }

      File text;
      try {
         text = new File(args[2]);
         if (!text.canRead()) {
            throw new Exception();
         }
      }
      catch (Exception e) {
         System.out.println("Error: Could not open " + args[2] + ".");
         return;
      }

      // Instantiate a MarkovModel with the supplied parameters and
      // generate sample output text ...
      StringBuilder output = new StringBuilder();
      MarkovModel model = new MarkovModel(K, text);
      String currentKgram = model.getRandomKgram();
      output.append(currentKgram);

      for (int i = 0; i < M - 1; ++i) {
         // Get the next char, if the current kgram is not found get a random one
         char nextChar = model.getNextChar(currentKgram);
         if (nextChar == '\0') {
            nextChar = model.getNextChar(model.getRandomKgram());
         }

         // Add the char to the output stream
         output.append(nextChar);

         // Generate the new kgram
         currentKgram = currentKgram.substring(1);
         currentKgram += nextChar;
      }

      System.out.println(output);
   }
}
